package org.matsim.project;

import java.util.HashMap;
import java.util.Map;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.io.WKTReader;
import org.matsim.core.population.PersonUtils;
import org.matsim.core.utils.gis.ShapeFileReader;
import org.opengis.feature.simple.SimpleFeature;

public class SetterCommute {

	Geometry home = null;
	Geometry work = null;

	public void setHomeandWork(String key, int value) {

		if (key.contains("BS-BS")) {
			home = CreatingDemand.shapeMap.get("Braunschweig");
			work = CreatingDemand.shapeMap.get("Braunschweig");
		}

		else if (key.contains("BS-WOB")) {
			home = CreatingDemand.shapeMap.get("Braunschweig");
			work = CreatingDemand.shapeMap.get("Wolfsburg");
		}

		else if (key.contains("BS-SZ")) {
			home = CreatingDemand.shapeMap.get("Braunschweig");
			work = CreatingDemand.shapeMap.get("Salzgitter");
		}

		else if (key.contains("BS-WF")) {
			home = CreatingDemand.shapeMap.get("Braunschweig");
			work = CreatingDemand.shapeMap.get("Wolfenbuettel");
		}

		else if (key.contains("BS-GF")) {
			home = CreatingDemand.shapeMap.get("Braunschweig");
			work = CreatingDemand.shapeMap.get("Gifhorn");
		}

		else if (key.contains("BS-PE")) {
			home = CreatingDemand.shapeMap.get("Braunschweig");
			work = CreatingDemand.shapeMap.get("Peine");
		}

		else if (key.contains("BS-HE")) {
			home = CreatingDemand.shapeMap.get("Braunschweig");
			work = CreatingDemand.shapeMap.get("Helmstedt");
		}

		else if (key.contains("BS-HI")) {
			home = CreatingDemand.shapeMap.get("Braunschweig");
			work = CreatingDemand.shapeMap.get("Hildesheim");
		}

		else if (key.contains("BS-GS")) {
			home = CreatingDemand.shapeMap.get("Braunschweig");
			work = CreatingDemand.shapeMap.get("Goslar");
		}

		else if (key.contains("BS-HH")) {
			home = CreatingDemand.shapeMap.get("Braunschweig");
			work = CreatingDemand.shapeMap.get("Hamburg");
		}

		else if (key.contains("BS-H")) {
			home = CreatingDemand.shapeMap.get("Braunschweig");
			work = CreatingDemand.shapeMap.get("Hannover");
		}

		else if (key.contains("WF-BS")) {
			home = CreatingDemand.shapeMap.get("Wolfenbuettel");
			work = CreatingDemand.shapeMap.get("Braunschweig");
		}

		else if (key.contains("PE-BS")) {
			home = CreatingDemand.shapeMap.get("Peine");
			work = CreatingDemand.shapeMap.get("Braunschweig");
		}

		else if (key.contains("GF-BS")) {
			home = CreatingDemand.shapeMap.get("Gifhorn");
			work = CreatingDemand.shapeMap.get("Braunschweig");
		}

		else if (key.contains("SZ-BS")) {
			home = CreatingDemand.shapeMap.get("Salzgitter");
			work = CreatingDemand.shapeMap.get("Braunschweig");
		}

		else if (key.contains("HE-BS")) {
			home = CreatingDemand.shapeMap.get("Helmstedt");
			work = CreatingDemand.shapeMap.get("Braunschweig");
		}

		else if (key.contains("HI-BS")) {
			home = CreatingDemand.shapeMap.get("Hildesheim");
			work = CreatingDemand.shapeMap.get("Braunschweig");
		}

		else if (key.contains("WOB-BS")) {
			home = CreatingDemand.shapeMap.get("Wolfsburg");
			work = CreatingDemand.shapeMap.get("Braunschweig");
		}

		else if (key.contains("GS-BS")) {
			home = CreatingDemand.shapeMap.get("Goslar");
			work = CreatingDemand.shapeMap.get("Braunschweig");
		}

		else if (key.contains("HK-BS")) {
			home = CreatingDemand.shapeMap.get("Ilsenburg (Harz)");
			work = CreatingDemand.shapeMap.get("Braunschweig");
		}

		else {
			home = CreatingDemand.shapeMap.get("Hannover");
			work = CreatingDemand.shapeMap.get("Braunschweig");
		}
	}

	public Geometry getHome() { // Getter-Methode
		return home;
	}

	public Geometry getWork() {
		return work;
	}

}
