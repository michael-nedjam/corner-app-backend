package model.user;

public class UserPostDTO {

	// const

	public static final String EmailField = "Email";
	public static final String FirstNameField = "FirstName";
	public static final String LastNameField = "LastName";
	public static final String PasswordField = "Password";
	
	//	fields
	
	public String Email;
	public String FirstName;
	public String LastName;
	public String Password;
	
	// constructor
	public UserPostDTO(){}

	public UserPostDTO(String email, String firstName, String lastName, String password) {
		super();
		Email = email;
		FirstName = firstName;
		LastName = lastName;
		Password = password;
	}	
}
