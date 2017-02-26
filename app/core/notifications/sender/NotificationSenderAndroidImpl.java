package core.notifications.sender;

import java.io.IOException;
import java.util.Set;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;
import common.LogHelper;
import common.properties.PropertiesNames;
import common.properties.PropertiesProvider;

import core.notifications.Notification;

public class NotificationSenderAndroidImpl implements NotificationSenderInterface {

	public void SendNotification(Set<String> listRegistredIdTerminal, Notification aNotification) {
		LogHelper.LogDebug(String.format("Sending notification to liste user id"));
		
		// message creation
		Message aMessage = doCreateMessageFromNotification(aNotification);
			
		// message send
		String gcmAPIkey = PropertiesProvider.GetInstance().getString(PropertiesNames.GCM_API_KEY);
		Sender _sender = new Sender(gcmAPIkey);
		
		for (String aRegistredIdTerminal : listRegistredIdTerminal) {
			// send message
			Result resultat;
			try {
				resultat = _sender.send(aMessage, aRegistredIdTerminal, 3);
				String resultCode = resultat != null ? resultat.getErrorCodeName() : ""; 
				String message = "Notification[android] sent to " + aRegistredIdTerminal + " with error code " + resultCode;
				LogHelper.LogDebug(message);
			} catch (IOException e) {
				LogHelper.LogError(e);
			}
		}
		
		LogHelper.LogDebug(String.format("Notification list sent"));
	}
	
	/**
	 * Create a message for a notification
	 * @param aNotification
	 * @return
	 */
	protected Message doCreateMessageFromNotification(Notification aNotification) {
		
		// isZoneRestriction = notification will be display to the user only if he is in the zone
		Boolean isZoneRestriction = false;
		if(aNotification.getRaizable_zone_latitude() != null && aNotification.getRaizable_zone_longitude() != null){
			isZoneRestriction = true;
		}
		
		// zone
		String raizable_zone_latitude = aNotification.getRaizable_zone_latitude() != null ? aNotification.getRaizable_zone_latitude().toString() : ""; 
		String raizable_zone_longitude = aNotification.getRaizable_zone_longitude() != null ? aNotification.getRaizable_zone_longitude().toString() : "";
		
		// version
		String version_app_minimum = this.doDefineMinimunVersion(aNotification); 
		String version_app_maximum = this.doDefineMaximunVersion(aNotification);
		
		Message aMessage = new Message.Builder().timeToLive(5)
			.addData("id", aNotification.getId())
			.addData("dateCreation", Long.toString(aNotification.getCreationDate().getTime()))
			.addData("title", aNotification.getTitle())
			.addData("message", aNotification.getTexte())
			.addData("is_zone_restriction", isZoneRestriction.toString())
			.addData("raizable_zone_latitude", raizable_zone_latitude)
			.addData("raizable_zone_longitude", raizable_zone_longitude)
			.addData("version_app_minimum", version_app_minimum)
			.addData("version_app_maximum", version_app_maximum)
			.build();
		return aMessage;
	}
	
	private String doDefineMinimunVersion(Notification aNotification){
		return aNotification.version != null ? aNotification.version.toString() : "";
	}
	
	private String doDefineMaximunVersion(Notification aNotification){
		return ""; // for now last version can handle all notification
	}
}
