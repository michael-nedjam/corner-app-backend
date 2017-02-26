package core.oauth.token;

import play.db.ebean.Model.Finder;

public class TokenDAOImpl implements TokenDAO {
	
	// fields 
	public Finder<Long, Token> find = new Finder<Long, Token>(Long.class, Token.class);
	
	// methodes
	public Token FindBy(String aAccessToken) {
		return find.where().eq(DataBaseNames.access_token, aAccessToken).findUnique();
	}
	
	public Token FindByUserId(Integer userId) {
		return find.where().eq(DataBaseNames.user_profile_id, userId).orderBy(DataBaseNames.creation_date).setMaxRows(1).findUnique();
	}
	
	public void Add(Token aToken) {
		aToken.save();		
	}
}