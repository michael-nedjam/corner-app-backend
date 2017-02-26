package security;

import core.services.ServiceFactory;
import core.users.Userprofile;
import play.mvc.Http.Context;
import play.mvc.Result;
import play.mvc.Security;


public class Secured extends Security.Authenticator {
	
	public final static String AUTH_TOKEN_HEADER = "X-Auth-Token";
    public static final String AUTH_TOKEN = "authToken";
    private static final String CONTEXT_KEY_USER = "user";
    
	@Override
	public String getUsername(Context ctx) {
		Userprofile user = null;
		String[] authTokenHeaderValues = ctx.request().headers().get(AUTH_TOKEN_HEADER);
		
//		// debug
//		Map<String , String[]> list = ctx.request().headers();
//		for (Map.Entry<String, String[]> entry : list.entrySet())
//		{
//		    System.out.println("Header received :" + entry.getKey() + "/" + Arrays.toString(entry.getValue()));
//		}
//		// debug
		
		if ((authTokenHeaderValues != null) && (authTokenHeaderValues.length == 1) && (authTokenHeaderValues[0] != null)) {
			user = ServiceFactory.getInstance().GetOAuthService().verifyAccessToken(authTokenHeaderValues[0]);
			if (user != null) {
				
				ctx.args.put(CONTEXT_KEY_USER, user);
				return user.email;
			}
		}
		return null;
	}
	
	public static Userprofile getUser(Context ctx) {
		if(ctx.args.containsKey(CONTEXT_KEY_USER)){
			return  (Userprofile) ctx.args.get(CONTEXT_KEY_USER);
		}
		
		return null;
	}
	
	@Override
	public Result onUnauthorized(Context ctx) {
		return unauthorized(); // todo return default unauthorize message 
	}
}
