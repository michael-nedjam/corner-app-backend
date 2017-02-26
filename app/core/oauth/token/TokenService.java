package core.oauth.token;

import java.util.UUID;

import core.services.ServiceDAOFactory;

public class TokenService {

	// methodes
	public Token CreateAccessToken(Integer userProfileId, String deviceId){
		
		// create
		String accessToken = UUID.randomUUID().toString();
		Token aToken = new Token(userProfileId, accessToken, deviceId);
		
		// add
		ServiceDAOFactory.getInstance().GetTokensDAOService().Add(aToken);
		
		return aToken;
	}
	
	public Token FindBy(String aAccessToken){
		return ServiceDAOFactory.getInstance().GetTokensDAOService().FindBy(aAccessToken);
	}
}
