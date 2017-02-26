package common;

import java.util.logging.*;

public class LogHelper {
	private static final Logger log = Logger.getLogger( LogHelper.class.getName() );
	
	public static void LogError(Exception e){
		e.printStackTrace();
	}

	public static void LogInfo(String message){
		System.out.println(message);
	}
	
	public static void LogDebug(String message){
		System.out.println(message);
	}
	
	public static void LogDebugTitle(String message){
		LogDebug("-----------------------------------------------------");
		LogDebug("-- " + message);
		LogDebug("-----------------------------------------------------");
	}
}