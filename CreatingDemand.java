package org.matsim.project;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.io.WKTReader;
import org.matsim.api.core.v01.Coord;
import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.Scenario;
import org.matsim.api.core.v01.network.Link;
import org.matsim.api.core.v01.network.Network;
import org.matsim.api.core.v01.population.Activity;
import org.matsim.api.core.v01.population.Leg;
import org.matsim.api.core.v01.population.Person;
import org.matsim.api.core.v01.population.Plan;
import org.matsim.api.core.v01.population.PopulationWriter;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.gbl.MatsimRandom;
import org.matsim.core.network.NetworkUtils;
import org.matsim.core.network.algorithms.NetworkCleaner;
import org.matsim.core.network.algorithms.NetworkSimplifier;
import org.matsim.core.network.io.MatsimNetworkReader;
import org.matsim.core.population.PersonUtils;
import org.matsim.core.scenario.ScenarioUtils;
import org.matsim.core.utils.geometry.CoordUtils;
import org.matsim.core.utils.geometry.CoordinateTransformation;
import org.matsim.core.utils.geometry.geotools.MGC;
import org.matsim.core.utils.geometry.transformations.GeotoolsTransformation;
import org.matsim.core.utils.gis.ShapeFileReader;
import org.matsim.core.utils.io.tabularFileParser.TabularFileHandler;
import org.matsim.core.utils.io.tabularFileParser.TabularFileParser;
import org.matsim.core.utils.io.tabularFileParser.TabularFileParserConfig;
import org.opengis.feature.simple.SimpleFeature;

import com.jogamp.nativewindow.util.Point;
import com.sun.el.parser.ParseException;

import scala.util.Random;

public class CreatingDemand {
	
//	private static final String CONFIG = "Z:\\jalyschko\\BSCommuters\\basic_config.xml";
//	static Properties props = LoadProps.loadprops(CONFIG);

	private static final String NETWORKFILE = "Z:\\jalyschko\\BSCommuters\\network_simplified2.xml"; // Netzwerk muss wieder erstellt werden
	private static final String KREISE = "Z:\\jalyschko\\BSCommuters\\Gemeindegrenzen_2016_mit_Einwohnerzahl-shp_utm32\\Gemeindegrenzen_2016_ew_utm32n.shp";
	
	private static final String PLANSFILEOUTPUT = "Z:\\jalyschko\\BSCommuters\\population2.xml"; 
	
	private Scenario scenario;					// Anlegen von Scenario-Container
	public static Map<String, Geometry> shapeMap = null;
	public static double SCALEFACTOR = 0.01;
	public String key;
	public int value;
	
	CreatingDemand(){
		this.scenario = ScenarioUtils.createScenario(ConfigUtils.createConfig());
		new MatsimNetworkReader(scenario.getNetwork()).readFile(NETWORKFILE);	
		
				
	}
	
	public void run() {
		try {
			this.shapeMap = readShapeFile(KREISE, "GEN");	// lesen der File 'KREISE' und der Spalte 'GEN' und ablegen im ShapeMap-Container
		} catch (org.locationtech.jts.io.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); } 
		
		Map<String, Integer> CommuterMap = new CSVReader().read("Z:\\jalyschko\\BSCommuters\\Pendlerzahlen.csv");
		
		
		for (Map.Entry<String, Integer> entry : CommuterMap.entrySet()) {
			key = entry.getKey();
			value = entry.getValue();
			double commuters = value * SCALEFACTOR;
			
			Geometry home = null; 
			Geometry work = null;
			
			SetterCommute c = new SetterCommute(); 	// Durchlaufen der Commuter-Methode
			c.setHomeandWork(key, value);
			
			home = c.getHome();
			work = c.getWork();
			 
			for (int i = 0; i<= commuters; i++) {
				String mode = "car";
				Coord homec = Utils.drawRandomPointFromGeometry(home);
				Coord workc = Utils.drawRandomPointFromGeometry(work);
				Coord kindergartenc = Utils.drawRandomPointFromGeometry(home); // Kindergarten da, wo Menschen wohnen
				Coord shoppingc = Utils.drawRandomPointFromGeometry(work); // Einkaufen etc. da, wo Menschen arbeiten
				createOnePerson(i, homec, workc, kindergartenc, shoppingc, mode, key);
				
				}}
			
		PopulationWriter pw = new PopulationWriter(scenario.getPopulation(),scenario.getNetwork());
	
		pw.write(PLANSFILEOUTPUT); } // Erzeugung eines Objekts der Klasse PopulationWriter
	
	public String getRelation() {
		return key;
	}
		
	public void createOnePerson(int i, Coord coord, Coord coordWork, Coord coordKindergarten, Coord coordShopping, String mode, String toFromPrefix) { // 'Container' für Personen und Tagespläne, for-Schleife oben füllt diese
		Id<Person> personId = Id.createPersonId(toFromPrefix+"_"+i);
		Person person = scenario.getPopulation().getFactory().createPerson(personId);
		
		SetterAge as = new SetterAge(); 	// Altersverteilung in eigener Klasse
		as.calculateAge(person);
			
		SetterSex sexs = new SetterSex();  // Geschlechtsverteilung in eigener Klasse
		sexs.calculateSex(key, person);
		
		SetterIncome is = new SetterIncome(); // Einkommensverteilung in eigener Klasse
		is.calculateIncome(person);
		
 
		Plan plan = scenario.getPopulation().getFactory().createPlan();
		Network network = scenario.getNetwork();
 
	Activity home = scenario.getPopulation().getFactory().createActivityFromCoord("home", coord);
//		System.out.println(coord); // Test für Koordinaten
		Link nearestLink = NetworkUtils.getNearestLink(network, coord);
		home.setLinkId(nearestLink.getId());
//		System.out.println(nearestLink);
		
		home.setEndTime(Utils.setDepartureTime(6*3600, 9*3600));
		plan.addActivity(home);
 
		double randomKindergarten = Math.random();    // Rumgespiele für 30% Kindergarten
		if (randomKindergarten <= 0.3) {
			
	Leg kindergartenhinweg = (Leg) scenario.getPopulation().getFactory().createLeg(mode);
		plan.addLeg((org.matsim.api.core.v01.population.Leg) kindergartenhinweg);
		
	Activity kindergarten = scenario.getPopulation().getFactory().createActivityFromCoord("kindergarten", coordKindergarten); 
		kindergarten.setMaximumDuration(10*60); // 10min für Kita-Activity
		plan.addActivity(kindergarten); }
		
	Leg hinweg = (Leg) scenario.getPopulation().getFactory().createLeg(mode);
		plan.addLeg((org.matsim.api.core.v01.population.Leg) hinweg);
		
	Activity work = scenario.getPopulation().getFactory().createActivityFromCoord("work", coordWork);
		work.setEndTime(Utils.setDepartureTime(14*3600, 17*3600));
		plan.addActivity(work);
		
		if (randomKindergarten <= 0.3) {
	Leg kindergartenrueckweg = (Leg) scenario.getPopulation().getFactory().createLeg(mode);
		plan.addLeg(kindergartenrueckweg);
		
	Activity kindergarten2 = scenario.getPopulation().getFactory().createActivityFromCoord("kindergarten", coordKindergarten);
		kindergarten2.setMaximumDuration(10*60);
		plan.addActivity(kindergarten2); }
			
		double randomShopping = Math.random();
		if (randomShopping <= 0.5) {
		
	Leg shoppingweg = (Leg) scenario.getPopulation().getFactory().createLeg(mode);
		plan.addLeg(shoppingweg);
		
	Activity shopping = scenario.getPopulation().getFactory().createActivityFromCoord("shopping", coordShopping);
		shopping.setMaximumDuration(60*60);
		plan.addActivity(shopping); }
		
	Leg rueckweg = (Leg) scenario.getPopulation().getFactory().createLeg(mode);
		plan.addLeg((org.matsim.api.core.v01.population.Leg) rueckweg);
 
	Activity home2 = scenario.getPopulation().getFactory().createActivityFromCoord("home", coord);
		plan.addActivity(home2);
 
		person.addPlan(plan);
		scenario.getPopulation().addPerson(person);
	}
	
	
	public static void main(String[] args) {

		CreatingDemand cd = new CreatingDemand();
		cd.run();
	}
	
	
	public Map<String,Geometry> readShapeFile(String KREISE, String Ort) throws org.locationtech.jts.io.ParseException { // GEN - Gemeindename 
		
		Map<String,Geometry> shapeMap = new HashMap<String, Geometry>(); // Instanzierung des Objekts shapeMap der Klasse HashMap
		
		for (SimpleFeature ft : ShapeFileReader.getAllFeatures(KREISE)) { 

				GeometryFactory geometryFactory= new GeometryFactory();
				WKTReader wktReader = new WKTReader(geometryFactory);
				Geometry geometry;
				
				geometry = wktReader.read((ft.getAttribute("the_geom")).toString());
				shapeMap.put(ft.getAttribute(Ort).toString(), geometry);

		}
		return shapeMap;
	}

	public static Map<String, Geometry> getShapeMap() {
		return shapeMap;
	}}
	
