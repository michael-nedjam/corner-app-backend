package model.user;

public class UserPutDTO {

	//	fields
	public String ShowOffensiveContent;
	
	// constructor
	public UserPutDTO(){}

	public UserPutDTO(String showOffensiveContent) {
		super();
		ShowOffensiveContent = showOffensiveContent;
	}	
}

