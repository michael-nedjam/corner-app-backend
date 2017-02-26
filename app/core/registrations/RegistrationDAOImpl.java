package core.registrations;

import java.util.List;

import play.db.ebean.Model.Finder;

public class RegistrationDAOImpl implements RegistrationDAO {

	// fields
	public Finder<Long, Registration> find = new Finder<Long, Registration>(Long.class, Registration.class);
	
	// methods
	public void Add(Registration aRegistration) {
		aRegistration.save();
	}
	
	public Registration FindByDeviceId(String deviceId){
		return find.where().eq("device_id", deviceId).findUnique();
	}
	
	public void Update(Registration aRegistration) {
		aRegistration.save();
	}
	
	public List<Registration> FindAll(){
		return find.all();
	}
}
