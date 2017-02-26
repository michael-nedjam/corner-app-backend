package core.users;

import play.db.ebean.Model.Finder;

public class UserDAOImpl implements UserDAO {
	
	// fields
	public Finder<Long, Userprofile> find = new Finder<Long, Userprofile>(Long.class, Userprofile.class);
	
	//methodes
	public Userprofile FindByEmail(String email) {
		return find.where().eq("email", email).findUnique();
	}
	
	public Userprofile FindByFirstName(String firstName) {
		return find.where().eq("first_name", firstName).findUnique();
	}
	
	public Userprofile FindById(Integer id) {
		return find.where().eq("id", id).findUnique();
	}
	
	public void Add(Userprofile aUser) {
		aUser.save();		
	}
	
	public void Update(Userprofile aUser) {
		aUser.save();		
	}
}
