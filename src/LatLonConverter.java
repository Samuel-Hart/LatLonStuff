
public class LatLonConverter {
	
	public static String ConvertFromDecimalDegreestoDMS(double decimalLat, double decimalLon)
	{
		
		//Get Hemispheres
		String LatHemi = decimalLat < 0 ? "S" : "N";
		String LonHemi = decimalLon < 0 ? "W" : "E";
		
		//Absolute Values so we don't mess stuff up 
		double lat = Math.abs(decimalLat);
		double lon = Math.abs(decimalLon);
				
		//Degrees
		int latDeg = GetWholeNumber(lat);
		int lonDeg = GetWholeNumber(lon);
		
		String LatDeg = String.format("%02d", latDeg);
		String LonDeg = String.format("%03d", lonDeg);
		
		//Minutes
		double latMin = GetMinSec(GetFractionalPart(decimalLat));
		double lonMin = GetMinSec(GetFractionalPart(decimalLon));
				
		String LatMin = String.format("%02d",GetWholeNumber(latMin));
		String LonMin = String.format("%02d",GetWholeNumber(lonMin));
		
		//Seconds
		double latSec = GetMinSec(GetFractionalPart(latMin));
		double lonSec = GetMinSec(GetFractionalPart(lonMin));
		
		String LatSec = String.format("%.5f",latSec);
		String LonSec = String.format("%.5f",lonSec);
		
		return  LatDeg + ':' + LatMin + ':' + LatSec + " " + LatHemi
				+ "  " + LonDeg + ':' + LonMin + ':' + LonSec + " " + LonHemi;
		
	}
	
	
	private static int GetWholeNumber(double decimalNumber) 
	{
		return (int)Math.floor(Math.abs(decimalNumber));
	}
	
	private static double GetMinSec(double fractionalNumber)
	{
		return fractionalNumber*60;
	}
	
	private static double GetFractionalPart(double val)
	{
		double v = Math.abs(val);
		
		return v - Math.floor(v);
	}

}
