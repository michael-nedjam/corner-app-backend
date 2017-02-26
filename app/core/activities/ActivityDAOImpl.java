package core.activities;

import play.db.ebean.Model.Finder;

public class ActivityDAOImpl implements ActivityDAO {
	
	// fields
	public Finder<Long, Activity> find = new Finder<Long, Activity>(Long.class, Activity.class);
	
	//methodes
	public void Add(Activity aActivity) {
		aActivity.save();		
	}
}