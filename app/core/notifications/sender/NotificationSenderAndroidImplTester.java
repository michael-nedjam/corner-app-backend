package core.notifications.sender;

import java.io.IOException;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;
import common.LogHelper;
import common.properties.PropertiesNames;
import common.properties.PropertiesProvider;

import core.notifications.Notification;

public class NotificationSenderAndroidImplTester extends NotificationSenderAndroidImpl {

	@Deprecated
	// test purpose only
	public void Send(String registredIdTerminal, Notification aNotification) throws IOException{
		LogHelper.LogDebug("Sending notification to " + registredIdTerminal);
		
		// message creation
		Message aMessage = this.doCreateMessageFromNotification(aNotification);
	
		// message send
		String gcmAPIkey = PropertiesProvider.GetInstance().getString(PropertiesNames.GCM_API_KEY);
		Sender _sender = new Sender(gcmAPIkey);
		Result resultat = _sender.send(aMessage, registredIdTerminal, 3);
		
		String resultCode = resultat != null ? resultat.getErrorCodeName() : ""; 
		String message = "Notification sent to " + registredIdTerminal + " with error code " + resultCode;
		LogHelper.LogDebug(message);
	}
}
