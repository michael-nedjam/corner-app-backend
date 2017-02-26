package core.users;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import play.db.ebean.Model;

@Entity
@SequenceGenerator(name = "Token_generator", sequenceName = "userprofile_id_sequence", allocationSize = 1, initialValue = 1)
public class Userprofile extends Model {
	
	// fields
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Token_generator")
	public Integer id;
	@Column(name ="email", nullable=false)
	public String email;
	@Column(name ="first_name")
	public String firstName;
	@Column(name ="last_name")
	public String lastName;
	@Column(name ="passwordHashed", nullable=false)
	public String passwordHashed;
	@Column(name ="creation_date")
	public Date creationDate;
	@Column(name ="show_offensive_content")
	public Boolean showOffensiveContent;
	
	// constructor
	public Userprofile(String email, String firstName, String lastName, String passwordHashed, Date creationDate, Boolean showOffensiveContent) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.passwordHashed = passwordHashed;
		this.creationDate = creationDate;
		this.showOffensiveContent = showOffensiveContent;
	}	
}
