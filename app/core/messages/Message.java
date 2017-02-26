package core.messages;

import java.util.Date;

import javax.persistence.*;

import play.db.ebean.Model;

@Entity
@SequenceGenerator(name = "Token_generator", sequenceName = "message_id_sequence", allocationSize = 1, initialValue = 1)
public class Message extends Model {
		
	// fields
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Token_generator")
    public Integer id;
	@Column(name ="author_id")
	public String authorId;
	@Column(name ="author_name")
	public String authorName;
	@Column(name ="create_time")
	public Date createTime;
	@Column(name ="localisation_longitude", nullable=false)
	public Double localisationLongitude;
	@Column(name ="localisation_latitude", nullable=false)
	public Double localisationLatitude;
	public String Text;
	@Column(name ="nb_times_reported", nullable=false)
	public Integer nbTimesReported;
	
	
	// constructor
	
	public Message(String authorName, String authorId, Date createTime, Double localisationLatitude, Double localisationLongitude, String text, Integer nbTimesReported) {
		super();
		this.authorName = authorName;
		this.authorId = authorId;
		this.createTime = createTime;
		this.localisationLongitude = localisationLongitude;
		this.localisationLatitude = localisationLatitude;
		this.Text = text;
		this.nbTimesReported = nbTimesReported;
	}
}
