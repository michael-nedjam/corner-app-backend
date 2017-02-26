package core.oauth;

import core.oauth.token.Token;

public class OAuthReponse {
	
	// fields
	public Token token;
	public String message;
	public String userId;
	
	// constructor
	public OAuthReponse(Token aToken, String message, String aUserId) {
		super();
		this.token = aToken;
		this.message = message;
		this.userId = aUserId;
	}
}
