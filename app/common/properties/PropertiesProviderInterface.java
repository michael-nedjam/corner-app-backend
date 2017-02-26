package common.properties;

public interface PropertiesProviderInterface {
	public String getString(String propertyName);
	public Boolean getBoolean(String propertyName);
	public Double getDouble(String propertyName);
}
