package programmingelements;

public class VolumeOfEarth {
    public static void main (String [] args) {
    	int radius = 6378;
    	double volumeInKm = (4/3) * 3.14 * radius * radius * radius;
    	double volumeInMiles = volumeInKm *  0.621371;
    	System.out.print("The volume of earth in kilometers is "+ volumeInKm + " km^3 and in miles is " + volumeInMiles);
    }
}
