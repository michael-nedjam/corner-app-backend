package core.oauth.token;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import play.db.ebean.Model;

@Entity
@SequenceGenerator(name = "Token_generator", sequenceName = "token_id_sequence", allocationSize = 1, initialValue = 1)
public class Token extends Model{

	// fields
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Token_generator")
	public Integer id;
	@Column(name ="user_profile_id", nullable=false)
	public Integer userProfileId;
	@Column(name ="access_token")
	public String accessToken;
	@Column(name ="creation_date")
	public Date creationDate;
	@Column(name ="device_id")
	public String deviceId;
	
	// contructor
	public Token(Integer userProfileId, String accessToken, String deviceId) {
		super();
		this.userProfileId = userProfileId;
		this.accessToken = accessToken;
		this.creationDate = new Date();
		this.deviceId = deviceId;
	}	
}
