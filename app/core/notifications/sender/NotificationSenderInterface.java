package core.notifications.sender;

import java.util.Set;

import core.notifications.Notification;

public interface NotificationSenderInterface {
	public void SendNotification(Set<String> listRegistredIdTerminal, Notification aNotification);
}
