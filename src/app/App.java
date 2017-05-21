/**
 * 
 */
package app;

/**
 * @author Philipp Schmeier
 * @version v0.1
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Fabrik
		Fabrik f = new Fabrik(new Warenspeicher(), 1000.0, 1000.0, "PC-MasterRace");
		
		// Maschinen
		Erzeuger birnenpfluecker = new Erzeuger("Birnenpfluecker", 500.0, new Produkt("Brine", 0.815, 42.0));
		Erzeuger apfelpfluecker  = new Erzeuger("Apfelpluecker", 450.0, new Produkt("Apfel", 0.415, 21.0));
		Verwerter apfelpresse    = new Verwerter("Apfelpresse", 2.500, 20, new Produkt("Apfelsaft", 16.0, 25.0), new Produkt("Apfel", 0.415, 21.0));
		
		// Fabrik bestuecken
		f.fuegeMaschineHinzu(birnenpfluecker);
		f.fuegeMaschineHinzu(apfelpfluecker);
		f.fuegeMaschineHinzu(apfelpresse);
		
		// Fabrik testen
		double testguthaben = f.firmaTesten(1);
		System.out.println("Das aktuelle Guthaben der Fabrik " + f.getName() + " betraegt: " + testguthaben );
	}

}
