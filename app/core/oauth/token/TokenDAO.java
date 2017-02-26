package core.oauth.token;

public interface TokenDAO {
	public void Add(Token aToken);
	public Token FindBy(String aAccessToken);
	public Token FindByUserId(Integer userId);	
}
