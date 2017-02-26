package core.notifications;

import java.util.Date;

public class Notification {
	
	// fields
	public String id;
	public String title;
	public String texte;
	public Date creationDate;
	public Double raizable_zone_latitude;
	public Double raizable_zone_longitude;
	public Integer version;
	
	// contructor
	public Notification(String id, String title, String texte, Date creationDate) {
		super();
		this.id = id;
		this.title = title;
		this.texte = texte;
		this.creationDate = creationDate;
		this.raizable_zone_latitude = null;
		this.raizable_zone_longitude = null;
		this.version = null;
	}
	
	// getter setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Double getRaizable_zone_latitude() {
		return raizable_zone_latitude;
	}

	public void setRaizable_zone_latitude(Double raizable_zone_latitude) {
		this.raizable_zone_latitude = raizable_zone_latitude;
	}

	public Double getRaizable_zone_longitude() {
		return raizable_zone_longitude;
	}

	public void setRaizable_zone_longitude(Double raizable_zone_longitude) {
		this.raizable_zone_longitude = raizable_zone_longitude;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
}
