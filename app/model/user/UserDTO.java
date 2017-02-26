package model.user;

import common.JsonHelper;

import core.users.Userprofile;

public class UserDTO {
	
	// Fields
	public String Id;
	public String Email;
	public String FirstName;
	public String LastName;
	public String ShowOffensiveContent;
	
	// Constructor
	public UserDTO(Userprofile aUser) {
		super();
		this.Id = aUser.id.toString();
		this.Email = aUser.email;
		this.FirstName = aUser.firstName;
		this.LastName = aUser.lastName;
		this.ShowOffensiveContent = aUser.showOffensiveContent.toString();
	}	
}
