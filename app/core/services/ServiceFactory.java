package core.services;


import common.properties.PropertiesProvider;
import common.properties.PropertiesProviderInterface;
import core.activities.ActivityService;
import core.messages.MessagesService;
import core.notifications.NotificationService;
import core.oauth.OAuthService;
import core.oauth.token.TokenService;
import core.registrations.RegistrationService;
import core.users.UsersService;

public class ServiceFactory {
	
	// fields
	private static ServiceFactory INSTANCE = new ServiceFactory();
	private MessagesService _MessagesService = null;
	private UsersService _UsersService = null;
	private TokenService _TokenService = null;
	private OAuthService _OAuthService = null;
	private NotificationService _NotificationService = null;
	private ActivityService _ActivityService = null;
	private RegistrationService _RegistrationService = null;
	
	// constructor
	private ServiceFactory(){
		_MessagesService = new MessagesService();
		_UsersService = new UsersService();
		_TokenService = new TokenService();
		_OAuthService = new OAuthService();
		_NotificationService = new NotificationService();
		_ActivityService = new ActivityService();
		_RegistrationService = new RegistrationService();
	}
	
	public static ServiceFactory getInstance()	
	{	
		Object a = PropertiesProvider.GetInstance();
		return INSTANCE;
	}
	
	// methods	
	public MessagesService GetMessagesService(){
		return _MessagesService;
	}
	
	public UsersService GetUsersService(){
		return _UsersService;
	}
	
	public TokenService GetTokenService(){
		return _TokenService;
	}

	public OAuthService GetOAuthService(){
		return _OAuthService;
	}

	public NotificationService GetNotificationService(){
		return _NotificationService;
	}
	
	public ActivityService GetActivityService(){
		return _ActivityService;
	}

	public RegistrationService GetRegistrationService() {
		return _RegistrationService;
	}
}
