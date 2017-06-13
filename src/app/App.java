package app;

import gui.PanelManager;

/**
 * Anwendung zur Simulation einer Fabrik (Aufbau und Inbetriebnahme).
 * 
 * @author Philipp Schmeier
 * @version v1
 * @since 2017-06-06
 */
public class App {

	/**
	 * Dies ist die Main-Methode, welche eine neue Fabrik erstellt,
	 * dieser Fabrik drei Maschinen hinzufügt und diese anschließend zum laufen bringt.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		PanelManager pm = new PanelManager();
		pm.start();
		
		System.out.println("Hello World");
		// Fabriktest
		
//		// Fabrik
//		Fabrik f = new Fabrik(new Warenspeicher(), 1000.0, "Obst");
//		
//		// Maschinen
//		Erzeuger birnenpfluecker = new Erzeuger("Birnenpfluecker", 500.0, new Produkt("Brine", 0.815, 42.0));
//		Erzeuger apfelpfluecker  = new Erzeuger("Apfelpluecker", 450.0, new Produkt("Apfel", 0.415, 21.0));
//		Verwerter apfelpresse    = new Verwerter("Apfelpresse", 2.500, 2, new Produkt("Apfelsaft", 16.0, 25.0), new Produkt("Apfel", 0.415, 21.0));
//		
//		// Fabrik bestuecken
//		f.fuegeMaschineHinzu(birnenpfluecker);
//		f.fuegeMaschineHinzu(apfelpfluecker);
//		f.fuegeMaschineHinzu(apfelpresse);
//		
//		// Fabrik testen
//		double testguthaben = f.firmaTesten(3);
//		System.out.println("Das aktuelle Guthaben der Fabrik " + f.getName() + " betraegt: " + testguthaben );
	}

}
