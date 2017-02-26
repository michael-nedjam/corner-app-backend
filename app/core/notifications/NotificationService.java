package core.notifications;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import common.LogHelper;
import core.notifications.sender.NotificationSenderAndroidImpl;
import core.notifications.sender.NotificationSenderIOSImpl;
import core.notifications.sender.NotificationSenderInterface;
import core.oauth.token.Token;
import core.registrations.Registration;
import core.services.ServiceDAOFactory;
import core.users.Userprofile;
import core.registrations.SupportType;

public class NotificationService {
	
	// fields
	private HashMap<SupportType, NotificationSenderInterface> listSenderBySupport = new HashMap<SupportType, NotificationSenderInterface>();
	
	// construct
	public NotificationService() {
		// configure sender
		listSenderBySupport.put(SupportType.ANDROID, new NotificationSenderAndroidImpl());
		listSenderBySupport.put(SupportType.IOS, new NotificationSenderIOSImpl());
	}
	
	/**
	 * Sent a Notification that alert user of new message
	 * the notification is raise only if the user is in the area
	 * @param latitude
	 * @param longitude
	 */
	public void BroadcastNewMessageNotificationInZone(Userprofile aUserprofile, String texte, Double latitude, Double longitude){
		LogHelper.LogDebug(String.format("Broadcast new message notification in zone"));
		
		// get all device
		List<Registration> listRegistration = ServiceDAOFactory.getInstance().GetRegistrationDAOService().FindAll();
		
		// create new message notification
		Notification aNotification = NotificationBuilder.BuildNewMessageNotification(aUserprofile.firstName, texte, latitude, longitude);
		
		// version restriction for android only
		aNotification.setVersion(8);
		
		// notify them all except the author
		Token aToken = ServiceDAOFactory.getInstance().GetTokensDAOService().FindByUserId(aUserprofile.id);
		String deviceIdWhereTheAuthorIsLog = aToken.deviceId;
		
		LogHelper.LogDebugTitle("Notification start");
		
		// send notification for each Support type
		Set<SupportType> listTypeSendable = listSenderBySupport.keySet();
		HashMap<SupportType, List<String>> listRegistredIdTerminalToNotifyBySupport = new HashMap<SupportType, List<String>>();
		for (SupportType supportType : listTypeSendable) {
			listRegistredIdTerminalToNotifyBySupport.put(supportType, new ArrayList<String>());
		}
		
		// Dispatch list by support
		List<String> listDeviceIdToNotify = new ArrayList<String>();
		for (Registration registration : listRegistration) {
			if(registration.deviceId.compareTo(deviceIdWhereTheAuthorIsLog)!=0){ // we don't notify the author
				if(!listDeviceIdToNotify.contains(registration.deviceId)){ // we don't notify the author
					LogHelper.LogDebug(String.format("registrationID = " + registration.deviceId));
					SupportType aSupportType = SupportType.GetSupportType(registration.supportType);
					if(registration.supportType != null && listRegistredIdTerminalToNotifyBySupport.containsKey(aSupportType)){
						List<String> listRegistredIdTerminalToNotify = listRegistredIdTerminalToNotifyBySupport.get(aSupportType);
						listRegistredIdTerminalToNotify.add(registration.registrationId);	
						listDeviceIdToNotify.add(registration.deviceId);	
					} else {
						LogHelper.LogDebug("Error while notify, can't notify this support type : " + aSupportType);
					}
				}
			}
		}
		
		
		// notify each support type
		for (SupportType supportType : listTypeSendable) {
			List<String> listRegistredIdTerminal = listRegistredIdTerminalToNotifyBySupport.get(supportType);
			NotificationSenderInterface aNotificationSenderInterface = listSenderBySupport.get(supportType);
			
			// remove doublon
			Set<String> uniqueListRegistredIdTerminal = new HashSet<String>(listRegistredIdTerminal);
			
			// notify all device for a support type
			aNotificationSenderInterface.SendNotification(uniqueListRegistredIdTerminal, aNotification);
		}
			
		LogHelper.LogDebugTitle("Notification end");
	}
}