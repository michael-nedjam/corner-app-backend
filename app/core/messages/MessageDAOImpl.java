package core.messages;

import java.util.Collection;

import com.avaje.ebean.ExpressionList;

import play.db.ebean.Model.Finder;

public class MessageDAOImpl implements MessageDAO {
	
	// fields
	public Finder<Long, Message> find = new Finder<Long, Message>(Long.class, Message.class);
	
	// methods
	
	public Collection<Message> GetListMessageInSquare(Double maxLatitude, Double minLatitude, Double maxLongitude, Double minLongitude, Boolean showOffensiveContent) {
		
		//setup
		ExpressionList<Message> expressionList = find.where()
				.between("localisation_longitude", minLongitude, maxLongitude)
				.between("localisation_latitude", minLatitude, maxLatitude);
		
		if(!showOffensiveContent){
			expressionList = expressionList.eq(DataBaseNames.nb_times_reported, 0);
		}
		
		//execute
		Collection<Message> result = expressionList.orderBy("create_time desc").findList();
				//.findPagingList(25).getPage(1)
		
		return result;
	}
	
	public void Add(Message aMessage) {
		aMessage.save();
	}
	
	public Message report(Integer id){
		
		// find the message
		Message aMessage = find.byId(id.longValue());
		
		// update value
		aMessage.nbTimesReported++;
		aMessage.update();
		
		return aMessage;
	}
}
