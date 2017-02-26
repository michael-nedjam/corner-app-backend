package core.registrations;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import play.db.ebean.Model;

@Entity
@SequenceGenerator(name = "Token_generator", sequenceName = "message_id_sequence", allocationSize = 1, initialValue = 1)
public class Registration extends Model {
	
	// fields
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Token_generator")
    public Integer id;
	@Column(name ="registration_id")
	public String registrationId;
	@Column(name ="create_time")
	public Date createTime;
	@Column(name ="device_id")
	public String deviceId;
	@Column(name ="support_type")
	public String supportType;
	
	// constructor
	public Registration(String registrationId, String deviceId, String supportType) {
		super();
		this.registrationId = registrationId;
		this.deviceId = deviceId;
		this.createTime = new Date();
		this.supportType = supportType;
	}
}
