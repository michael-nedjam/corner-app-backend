package core.registrations;

import java.util.List;

public interface RegistrationDAO {
	public void Add(Registration aRegistration);
	public List<Registration> FindAll();
	public Registration FindByDeviceId(String deviceId);
	public void Update(Registration aRegistration);
}
