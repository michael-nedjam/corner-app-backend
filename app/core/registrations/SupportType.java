package core.registrations;

public enum SupportType {
	ANDROID,
	IOS,
	UNKNOW;
	
	public static SupportType GetSupportType(String value){
		SupportType supportType = null; 
		
		try{
			if(value != null){
				supportType = SupportType.valueOf(value);
			} else {
				supportType = SupportType.UNKNOW;
			}
		} catch (IllegalArgumentException iae){
			supportType = SupportType.UNKNOW;
		}
		
		return supportType;
	}
}
