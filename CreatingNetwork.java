package org.matsim.project;


import org.matsim.api.core.v01.network.Network;
import org.matsim.core.network.NetworkUtils;
import org.matsim.core.network.algorithms.NetworkCleaner;
import org.matsim.core.network.algorithms.NetworkSimplifier;
import org.matsim.core.network.io.NetworkWriter;
import org.matsim.core.utils.geometry.CoordinateTransformation;
import org.matsim.core.utils.geometry.transformations.TransformationFactory;
import org.matsim.core.utils.io.OsmNetworkReader;

public class CreatingNetwork {

	public static void main(String[] args) {
		
	CoordinateTransformation wgs84_utm32N = TransformationFactory.getCoordinateTransformation("EPSG:4326", "EPSG:25832");
	Network network = NetworkUtils.createNetwork();
	
	OsmNetworkReader reader = new OsmNetworkReader(network, wgs84_utm32N); // Container für Netzwerk und Reader
	
	reader.setHierarchyLayer(52.5555, 9.6680, 51.8383, 11.4944, 3); // 3 = primary roads
	reader.setHierarchyLayer(52.3435, 10.3110, 52.1645, 10.7676, 8); // 8 = residential roads
	
	reader.setKeepPaths(true); // true -> realistische Weggeführung, false -> eckiger, kantiger
	reader.setMemoryOptimization(true);
	
	reader.parse("Z:\\jalyschko\\BSCommuters\\niedersachsen-latest.osm_01.osm"); // path zur osm-datei einfügen
	new NetworkSimplifier().run(network); // fasst links zusammen, wenn alle Attribute überein stimmen
	new NetworkCleaner().run(network); // entfernt zusammenhangslose nodes und links
	
	
	
	new NetworkWriter(network).write("Z:\\jalyschko\\BSCommuters\\network_simplified.xml"); 
	// Zielort einfügen, Dateiname mit angeben!
	
	}

}




