package core.activities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import play.db.ebean.Model;

@Entity
@SequenceGenerator(name = "Token_generator", sequenceName = "activity_id_sequence", allocationSize = 1, initialValue = 1)
public class Activity extends Model {
	
	// fields
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Token_generator")
	public Integer id;
	@Column(name ="user_id", nullable=false)
	public String userId;
	@Column(name ="type")
	public String type;
	@Column(name ="creation_date")
	public Date creationDate;
	
	// constructor
	public Activity(String userId, String type) {
		super();
		this.userId = userId;
		this.type = type;
		this.creationDate = new Date();
	}	
}
