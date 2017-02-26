package core.notifications.sender;

import java.util.Collection;
import java.util.Set;

import com.notnoop.apns.APNS;
import com.notnoop.apns.ApnsNotification;
import com.notnoop.apns.ApnsService;
import com.notnoop.apns.ApnsServiceBuilder;
import common.LogHelper;
import common.properties.PropertiesNames;
import common.properties.PropertiesProvider;

import core.notifications.Notification;

public class NotificationSenderIOSImpl implements NotificationSenderInterface {

	/***
	 * Send a notification for a list of device token
	 */
	public void SendNotification(Set<String> listDeviceToken, Notification aNotification) {
		LogHelper.LogDebug(String.format("[start] NotificationSenderIOS - SendNotification"));
		
		// init service
		String apnCertificatLocalPath = PropertiesProvider.GetInstance().getString(PropertiesNames.APN_CERTIFICAT_LOCAL_PATH);
		String apnCertificatPassword = PropertiesProvider.GetInstance().getString(PropertiesNames.APN_CERTIFICAT_PASSWORD);
		ApnsService aApnsService = new ApnsServiceBuilder().withCert(apnCertificatLocalPath, apnCertificatPassword)
				.withSandboxDestination().build();
		
		// create message
		String aMessage = this.doCreateMessageFromNotification(aNotification);
		
		// send notification
		Collection<? extends ApnsNotification> listApnsNotification = aApnsService.push(listDeviceToken, aMessage);

		for (ApnsNotification apnsNotification : listApnsNotification) {
			LogHelper.LogDebug(apnsNotification.toString());
		}
		
		LogHelper.LogDebug(String.format("[end] NotificationSenderIOS - SendNotification"));
	}
	
	/**
	 * Format message form a notification
	 * @param aNotification
	 * @return
	 */
	protected String doCreateMessageFromNotification(Notification aNotification) {
		
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
		
		String message = APNS.newPayload()
			.forNewsstand() // notification is silent
			.badge(1)
			// add data
			.customField("id", aNotification.getId())
			.customField("dateCreation", Long.toString(aNotification.getCreationDate().getTime()))
			.customField("title", aNotification.getTitle())
			.customField("message", aNotification.getTexte())
			.customField("is_zone_restriction", isZoneRestriction.toString())
			.customField("raizable_zone_latitude", raizable_zone_latitude)
			.customField("raizable_zone_longitude", raizable_zone_longitude)
			.customField("version_app_minimum", version_app_minimum)
			.customField("version_app_maximum", version_app_maximum)
			.build();
		
		return message;
	}
	
	private String doDefineMinimunVersion(Notification aNotification){
		return "";
	}
	
	private String doDefineMaximunVersion(Notification aNotification){
		return "";
	}	
}