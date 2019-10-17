package no.hvl.dat100ptc.oppgave3;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import static java.lang.Math.*;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min;

		// TODO - START

		min = da[0];
		
		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}
		
		return min;
		
		// TODO - SLUT

	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		// TODO - START
		
		double [] tab = new double[gpspoints.length];
		
		for (int i = 0; i < gpspoints.length; i ++) {
			tab[i] = gpspoints[i].getLatitude();			
		}
		
		return tab;
		// TODO - SLUTT
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		// TODO - START

		double [] tab = new double[gpspoints.length];
		
		for (int i = 0; i < gpspoints.length; i ++) {
			tab[i] = gpspoints[i].getLongitude();			
		}
		
		return tab;
		
		// TODO - SLUTT

	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		double latitude1, longitude1, latitude2, longitude2;
		
		// TODO - START

		latitude1 = Math.toRadians(gpspoint1.getLatitude());
		latitude2 = Math.toRadians(gpspoint2.getLatitude());
		longitude1 = Math.toRadians(gpspoint1.getLongitude());
		longitude2 = Math.toRadians(gpspoint2.getLongitude());
		double dlatitude = latitude2 - latitude1;
		double dlongitude = longitude2 - longitude1;
		double a = pow((sin(dlatitude/2)), 2) + cos(latitude1)*cos(latitude2)*pow(sin(dlongitude/2), 2);
		double c = 2 * atan2(sqrt(a), sqrt(1-a));
		d = R * c; 
		
		return d;
		// TODO - SLUTT

	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;

		// TODO - START

		secs = gpspoint2.getTime() - gpspoint1.getTime();
		speed = (distance(gpspoint1, gpspoint2)/secs)*3.6;
		
		return speed;

		// TODO - SLUTT

	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";

		// TODO - START

		int ss = secs % 60;
		int hh = secs / 60;
		int mm = hh % 60;
		hh = hh / 60;
		
		timestr = String.format("  %02d%s%02d%s%02d", hh, TIMESEP, mm, TIMESEP, ss);
		
		return timestr;
		// TODO - SLUTT

	}
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str;
		// TODO - START
		
		d = ((int)(d*100+0.5))/100.0;
		// String str = "      1.35";
		// System.out.println("double : " + d);
        // System.out.println("double : " + String.format("%.2f", d));
        // System.out.format("double : %.2f", d);
        
		str = String.format("%1$.2f", d);
		
		return String.format("%" + TEXTWIDTH + "s", str).replace(',', '.');
        
		
		// TODO - SLUTT
		
	}
}
