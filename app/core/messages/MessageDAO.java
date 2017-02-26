package core.messages;

import java.util.Collection;

public interface MessageDAO {
	public Collection<Message> GetListMessageInSquare(Double maxLatitude, Double minLatitude, Double maxLongitude, Double minLongitude, Boolean showOffensiveContent);
	public void Add(Message aMessage);
	public Message report(Integer id);
}