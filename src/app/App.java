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
		System.out.println("Hellor World");
		
		// Fabrik
		Fabrik f = new Fabrik();
		
		// Produkte
		Produkt birne        = new Produkt("Brine", 0.815, 42.0);
		Produkt apfel        = new Produkt("Apfel", 0.415, 21.0);
		Produkt erdbeere     = new Produkt("Erdbeere", 3.2, 10.0);
		Produkt apfelsaft    = new Produkt("Apfelsaft", 16.0, 25.0);
		Produkt erdbeermouse = new Produkt("Erdbeermouse", 4.6, 12.0);

		// Maschinen
		Erzeuger birnenpfluecker = new Erzeuger("Birnenpfluecker", 500.0, birne);
		Erzeuger apfelpfluecker  = new Erzeuger("Apfelpluecker", 450.0, apfel);
		Verwerter erdbeermousse  = new Verwerter("Erdbeermousse", 650.0, 5, erdbeermouse, erdbeere);
		Verwerter apfelpresse    = new Verwerter("Apfelpresse", 2.500, 20, apfelsaft, apfel);
		
		f.fuegeMaschineHinzu(birnenpfluecker);
		f.fuegeMaschineHinzu(apfelpfluecker);
		f.fuegeMaschineHinzu(erdbeermousse);
		f.fuegeMaschineHinzu(apfelpresse);
	}

}
