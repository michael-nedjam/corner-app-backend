package core.registrations;

import core.services.ServiceDAOFactory;

public class RegistrationService {
	public Registration AddNewRegistrationIdForDevice(String registrationId, String deviceId, String supportType){
		Registration result = null;
		
		// seach for already registred device
		Registration oldRegistration = ServiceDAOFactory.getInstance().GetRegistrationDAOService().FindByDeviceId(deviceId);
		
		if(oldRegistration == null){
			// create
			Registration newRegistration = new Registration(registrationId, deviceId, supportType);
			
			// add
			ServiceDAOFactory.getInstance().GetRegistrationDAOService().Add(newRegistration);
			result = newRegistration;
		} else {
			oldRegistration.registrationId = registrationId;
			ServiceDAOFactory.getInstance().GetRegistrationDAOService().Update(oldRegistration);
			result = oldRegistration;
		}
		
		return result;
	}
}
