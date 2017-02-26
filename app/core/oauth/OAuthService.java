package core.oauth;

import core.oauth.token.Token;
import core.services.ServiceFactory;
import core.users.Userprofile;

public class OAuthService {
	
    public OAuthReponse AccessTokenForPasswordGrantViaLoginPassword(GrantType grantType, String login, String password, String scope, String clientID, String clientSecret, String deviceId)
    {	
        OAuthReponse result = null;
        
        // 1. Control response_type
        if (grantType == GrantType.PASSWORD)
        {
        	if (doAuthenticateClient(clientID, clientSecret))
            {
        		if (login != null && password != null){
        			Userprofile aUserprofile = ServiceFactory.getInstance().GetUsersService().FindByEmail(login);
        			
        			if(aUserprofile == null){
        				aUserprofile = ServiceFactory.getInstance().GetUsersService().FindByFirstName(login);	
        			}
        			
        			if(aUserprofile != null){
        				String email = aUserprofile.email;
        				// vérify password
        				boolean isUserCredentialOk = ServiceFactory.getInstance().GetUsersService().IsUserCredentialOK(email, password);
        				if (isUserCredentialOk)
                        {
        					// Create a token
        					Token aToken = ServiceFactory.getInstance().GetTokenService().CreateAccessToken(aUserprofile.id, deviceId);
        					
        					result = new OAuthReponse(aToken, null, aUserprofile.id.toString());
                        }
                        else
                        {
                            // warning : The login failed
                        }
        			} else {
        				// warning : this User doesn't exist
        			}
        		} else {
        			// Error : wrong params
        		}
            } else {
            	// Error : cannot authenticate client
            }
        } else {
        	// Error : response type not supported
        }
        
        return result;
    }
    
    public Userprofile verifyAccessToken(String aAccessToken){
    	Userprofile result = null;
    	
    	if(aAccessToken != null){
    		Token aToken = ServiceFactory.getInstance().GetTokenService().FindBy(aAccessToken);
    		if(aToken != null && aToken.userProfileId != null){
    			result = ServiceFactory.getInstance().GetUsersService().FindById(aToken.userProfileId);	
    		}
    	}
    	
    	return result;
    }

	private static boolean doAuthenticateClient(String clientID, String clientSecret){
		return true; // all client are ok for now
	}	
}
