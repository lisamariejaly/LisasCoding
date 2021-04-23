package org.matsim.project;

import org.locationtech.jts.geom.Geometry;
import org.matsim.api.core.v01.Coord;
import org.matsim.core.gbl.MatsimRandom;
import org.matsim.core.utils.geometry.geotools.MGC;

public class Utils {

	public static double setDepartureTime(double tmin, double tmax) {
		java.util.Random rnd = MatsimRandom.getRandom();
		double t = tmin + rnd.nextDouble() * (tmax - tmin);
		return t;
		}
	
	
	 public static Coord drawRandomPointFromGeometry(Geometry g) { // Erstellung der Methode um zufällige Koordinaten zu generieren
		java.util.Random rnd = MatsimRandom.getLocalInstance();
		org.locationtech.jts.geom.Point p;
		double x, y;
		do {
		 x = g.getEnvelopeInternal().getMinX() +  rnd.nextDouble() * (g.getEnvelopeInternal().getMaxX() - g.getEnvelopeInternal().getMinX());
		 y = g.getEnvelopeInternal().getMinY() + rnd.nextDouble() * (g.getEnvelopeInternal().getMaxY() - g.getEnvelopeInternal().getMinY());
		 p = MGC.xy2Point(x, y);
		 } while (!g.contains(p));
		 Coord coord = new Coord(p.getX(), p.getY());
		 return coord;
		 }  
	}


