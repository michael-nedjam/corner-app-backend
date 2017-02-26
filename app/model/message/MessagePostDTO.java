package model.message;


public class MessagePostDTO {
	
	// const
	
	public static final String AuthorIdField = "AuthorId";
	public static final String LocalisationLatitudeField = "LocalisationLatitude";
	public static final String LocalisationLongitudeField = "LocalisationLongitute";
	public static final String TextField = "Text";
	
	//	fields
	
	public String AuthorId;
	public String LocalisationLatitude;
	public String LocalisationLongitute;
	public String Text;
	
	// constructor
	public MessagePostDTO(){}
	
	public MessagePostDTO(String AuthorId, String localisationLatitude, String localisationLongitude, String text) {
		super();
		this.AuthorId = AuthorId;
		this.LocalisationLatitude = localisationLatitude;
		this.LocalisationLongitute = localisationLongitude;
		this.Text = text;
	}	
}
