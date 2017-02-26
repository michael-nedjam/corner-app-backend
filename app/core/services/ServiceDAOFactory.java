package core.services;

import core.activities.ActivityDAO;
import core.activities.ActivityDAOImpl;
import core.messages.MessageDAO;
import core.messages.MessageDAOImpl;
import core.oauth.token.TokenDAO;
import core.oauth.token.TokenDAOImpl;
import core.registrations.RegistrationDAO;
import core.registrations.RegistrationDAOImpl;
import core.users.UserDAO;
import core.users.UserDAOImpl;

public class ServiceDAOFactory {
		
	// fields
	private static ServiceDAOFactory INSTANCE = new ServiceDAOFactory();
	private MessageDAO _MessageDAO = null;
	private UserDAO _UserDAO = null;
	private TokenDAO _TokenDAO = null;
	private RegistrationDAO _RegistrationDAO = null;
	private ActivityDAO _ActivityDAO = null;
	
	// constructor
	private ServiceDAOFactory(){
		_MessageDAO = new MessageDAOImpl();
		_UserDAO = new UserDAOImpl();
		_TokenDAO = new TokenDAOImpl();
		_RegistrationDAO = new RegistrationDAOImpl();
		_ActivityDAO = new ActivityDAOImpl();
	}
	
	public static ServiceDAOFactory getInstance()	
	{	
		return INSTANCE;
	}
	
	// methods	
	public MessageDAO GetMessagesDAOService(){
		return _MessageDAO;
	}	
	
	public UserDAO GetUsersDAOService(){
		return _UserDAO;
	}
	
	public TokenDAO GetTokensDAOService(){
		return _TokenDAO;
	}

	public RegistrationDAO GetRegistrationDAOService(){
		return _RegistrationDAO;
	}
	
	public ActivityDAO GetActivityDAOService(){
		return _ActivityDAO;
	}
}
