package model.access;

import core.oauth.OAuthReponse;

public class AccessDTO {
	// fields
	public String AccessToken;
	public String Message;
	public String UserId;
	
	// constructor
	public AccessDTO(String aAccessToken, String aMessage, String aUserId) {
		super();
		AccessToken = aAccessToken;
		Message = aMessage;
		UserId = aUserId;
	}		
	
	public AccessDTO(OAuthReponse aOAuthReponse) {
		super();
		if(aOAuthReponse != null){
			Message = aOAuthReponse.message;
			if(aOAuthReponse.token != null){
				AccessToken = aOAuthReponse.token.accessToken;	
			}	
			UserId = aOAuthReponse.userId;
		}
	}		
}
