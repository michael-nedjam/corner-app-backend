package core.activities;

import core.services.ServiceDAOFactory;

public class ActivityService {

	// methodes
	public Activity Create(String userId, String type){
		// create
		Activity aActivity = new Activity(userId, type);

		// add
		ServiceDAOFactory.getInstance().GetActivityDAOService().Add(aActivity);
		
		return aActivity;
	}
}