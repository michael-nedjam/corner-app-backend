package model.message;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import core.messages.Message;

public class MessageDTO {
	
	// fields
	
	public String Id;
	public String AuthorId;
	public String AuthorName;
	public Date CreateTime;
	public String LocalisationLongitude;
	public String LocalisationLatitude;
	public String Text;
	public String NbTimesReported;
	
	// constructor
	
	public MessageDTO(Message aMessage) {
		super();
		this.Id = aMessage.id.toString();
		this.AuthorId = aMessage.authorId;
		this.AuthorName = aMessage.authorName;
		this.CreateTime = aMessage.createTime;
		this.LocalisationLatitude = aMessage.localisationLatitude.toString();
		this.LocalisationLongitude = aMessage.localisationLongitude.toString();
		this.Text = aMessage.Text;
		this.NbTimesReported = aMessage.nbTimesReported.toString();
	}	
	
	// method
	
	public static Collection<MessageDTO> Convert(Collection<Message> listMessage){
		Collection<MessageDTO> result = null;
		
		if(listMessage != null){
			result = new ArrayList<MessageDTO>();
			for (Message message : listMessage) {
				if(message != null)
					result.add(new MessageDTO(message));
			}
		}
		
		return result;				
	}
}
