package core.messages;

import java.util.Collection;
import java.util.Date;

import common.GPSDegreeHelper;
import common.properties.PropertiesNames;
import common.properties.PropertiesProvider;

import core.services.ServiceDAOFactory;
import core.services.ServiceFactory;
import core.users.Userprofile;

public class MessagesService {
		
	//	methodes
	public Message CreateMessage(String userId, Double localisationLatitude, Double localisationLongitude, String messageText){
		
		// find user
		Userprofile aUserprofile = ServiceFactory.getInstance().GetUsersService().FindById(Integer.decode(userId));
		
		// create
		Message aMessage = new Message(aUserprofile.firstName, aUserprofile.id.toString(), new Date(), localisationLatitude, localisationLongitude, messageText, 0);
		
		// add
		ServiceDAOFactory.getInstance().GetMessagesDAOService().Add(aMessage);
		
		// Notify user
		ServiceFactory.getInstance().GetNotificationService().BroadcastNewMessageNotificationInZone(aUserprofile, messageText, localisationLatitude, localisationLongitude);
		
		return aMessage;
	}
	
	public Collection<Message> GetListMessageLocalized(Double latitude, Double longitude, Boolean showOffensiveContent){
		
		// V1 message must be in a square
		Double gpsRadiusKm = PropertiesProvider.GetInstance().getDouble(PropertiesNames.GPS_RADIUS_KM);
		Double longitudeDegree = GPSDegreeHelper.GetLongitudeDegreesFromKm(gpsRadiusKm, latitude);
		Double latitudeDegree = GPSDegreeHelper.GetLatitudeDegreesFromKm(gpsRadiusKm);
		Double maxLongitude = longitude + longitudeDegree;
		Double minLongitude = longitude - longitudeDegree;
		Double maxLatitude = latitude + latitudeDegree;
		Double minLatitude = latitude - latitudeDegree;
		
		return ServiceDAOFactory.getInstance().GetMessagesDAOService().GetListMessageInSquare(maxLatitude, minLatitude, maxLongitude, minLongitude, showOffensiveContent);
	}
	
	public Message reportOffensiveContent(Integer id){
		return ServiceDAOFactory.getInstance().GetMessagesDAOService().report(id);
	}
}
