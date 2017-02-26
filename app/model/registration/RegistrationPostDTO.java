package model.registration;

public class RegistrationPostDTO {
	
	// const
	public static final String RegistrationIdField = "RegistrationId";
	public static final String DeviceIdField = "DeviceId";
	public static final String SupportTypeField = "SupportType";
	
	
	//	fields
	
	public String RegistrationId;
	public String DeviceId;
	public String SupportType; // ANDROID or IOS
	
	// constructor
	public RegistrationPostDTO(){}
	
	public RegistrationPostDTO(String aRegistrationId, String aDeviceId) {
		super();
		this.RegistrationId = aRegistrationId;
		this.DeviceId = aDeviceId;
		this.SupportType = null;
	}
	
	public void setSupportType(String supportType) {
		SupportType = supportType;
	}
}
