package common;

public class GPSDegreeHelper {
	// 1 latitude = 111.32 km
	// 1 longitude = cos(latitude) * 111.32km 
	private static Double etalon = 111.11;
	
	public static double GetLatitudeDegreesFromKm(Double kilometers){
		return kilometers / etalon;
	}
	
	public static double GetLongitudeDegreesFromKm(Double kilometers, Double latitude){
		return kilometers / (Math.cos(Math.toRadians(latitude)) * etalon);
	}
}
