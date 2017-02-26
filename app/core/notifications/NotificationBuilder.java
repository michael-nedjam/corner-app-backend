package core.notifications;

import java.util.Date;

public class NotificationBuilder {
	
	private static String notification_id_new_message = "0001";
	
	public static Notification BuildNewMessageNotification(String userName, String texte, Double latitude, Double longitude){
		Notification aNotification = new Notification(notification_id_new_message, userName, texte, new Date());
		aNotification.raizable_zone_latitude = latitude;
		aNotification.raizable_zone_longitude = longitude;
		
		return aNotification;
	}
}
