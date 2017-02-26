package model.registration;

import core.registrations.Registration;

public class RegistrationDTO {
	
	//	fields
	public String RegistrationId;
	public String DeviceId;
	public String SupportType;
	
	// constructor
	public RegistrationDTO(Registration aRegistration) {
		this.RegistrationId = aRegistration.registrationId;
		this.DeviceId = aRegistration.deviceId;
		this.SupportType = aRegistration.supportType;
	}	
}
