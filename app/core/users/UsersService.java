package core.users;
import java.util.Date;

import common.LogHelper;
import common.security.PasswordHash;
import core.services.ServiceDAOFactory;

public class UsersService {

	// methodes
	public Userprofile Create(String email, String firstName, String lastName, String password){
		// create
		Date creationDate = new Date();
		String passwordHashed = null;
		try {
			passwordHashed = PasswordHash.createHash(password);
		} catch (Exception e) {
			LogHelper.LogError(e);
		} 
		
		Userprofile aUser = new Userprofile(email, firstName, lastName, passwordHashed, creationDate, false);

		// add
		ServiceDAOFactory.getInstance().GetUsersDAOService().Add(aUser);
		
		return aUser;
	}
	
	public boolean IsUserCredentialOK(String email, String password){
		boolean isOk = false;
		
		// find user
		Userprofile aUserprofile = this.FindByEmail(email);
		
		// verify password
		try {
			isOk = PasswordHash.validatePassword(password, aUserprofile.passwordHashed);
		} catch (Exception e) {
			LogHelper.LogError(e);
		}
		
		return isOk; 	
	}
	
	public Userprofile FindByEmail(String email){
		return ServiceDAOFactory.getInstance().GetUsersDAOService().FindByEmail(email);
	}
	
	public Userprofile FindByFirstName(String firstName){
		return ServiceDAOFactory.getInstance().GetUsersDAOService().FindByFirstName(firstName);
	}
	
	public Userprofile FindById(Integer id){
		return ServiceDAOFactory.getInstance().GetUsersDAOService().FindById(id);
	}
	
	public Userprofile Update(Integer id, Boolean showOffensiveContent){
		//find the user
		Userprofile aUserprofile = ServiceDAOFactory.getInstance().GetUsersDAOService().FindById(id);
		
		//update values
		aUserprofile.showOffensiveContent = showOffensiveContent;
		ServiceDAOFactory.getInstance().GetUsersDAOService().Update(aUserprofile);
		
		return aUserprofile;
	}
}
