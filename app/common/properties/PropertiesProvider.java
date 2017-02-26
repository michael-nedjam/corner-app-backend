package common.properties;

import common.LogHelper;

public class PropertiesProvider {
	
	//fields
	private static PropertiesProvider instance = null;
	private PropertiesProviderInterface provider = null;
	
	// construct
	private PropertiesProvider(){
		this.provider = new PropertiesProviderSDKImpl();
		LogHelper.LogInfo("PropertiesProvider init with : " + this.provider.getClass().toString());
	}
	
	public static PropertiesProviderInterface GetInstance() {
		if(instance == null){
			synchronized (PropertiesProvider.class.getName()) {
				if(instance == null){
					instance = new PropertiesProvider();
				}
			} 
		}
		return instance.provider;
	}
}
