package model.access;

public class AccessPostDTO {

	// fields
	public String Email;
	public String Password;
	public String DeviceId;
	
	// constructor
	public AccessPostDTO(){}
	
	public AccessPostDTO(String email, String password, String deviceId) {
		super();
		this.Email = email;
		this.Password = password;
		this.DeviceId = deviceId;
	}		
}
