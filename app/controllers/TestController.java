package controllers;

import java.io.IOException;

import java.util.Date;
import java.util.Map;

import play.mvc.Controller;
import play.mvc.Result;
import common.HttpHelper;
import core.notifications.Notification;
import core.notifications.sender.NotificationSenderAndroidImplTester;
import core.services.ServiceFactory;

public class TestController extends Controller {

	public static Result sendNotification() {
		Result aResult = null;
		
		// retrieve params from query string
		Map<String, String> listParam = HttpHelper.GetListQueryParams(request());
		String registredIdTerminal = listParam.get("registredIdTerminal");
		
		Notification aNotification = new Notification("myId", "Ceci est le titre de ma notification", "Ceci est le text de ma notification", new Date());
		
		try {
			new NotificationSenderAndroidImplTester().Send(registredIdTerminal, aNotification);
			aResult = ok();
		} catch (IOException e) {
			aResult = internalServerError(e.getStackTrace().toString());
		}
		return aResult;
    }
}
