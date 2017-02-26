package core.users;

public interface UserDAO {
	public void Add(Userprofile aUser);
	public void Update(Userprofile aUser);	
	public Userprofile FindByEmail(String email);
	public Userprofile FindByFirstName(String firstName);
	public Userprofile FindById(Integer id);
}
