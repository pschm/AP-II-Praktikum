package app;

/**
 * Die Klasse Erzeuger bildet die Grundstruktur einer produzierenden Maschine,
 * genauer eines erzeugers ab. Diese Maschine kann Produkte erzeugen ohne dabei
 * andere zu verbrauchen.
 */
public class Erzeuger extends Maschine {
	protected Produkt erzeugnis;
	
	public Erzeuger(String name, double kosten, Produkt erzeugnis) {
		super(name, kosten);
		this.erzeugnis = erzeugnis;
		this.typ	   = typen[1]; // Erzeuger
	}
	
	public Produkt getErzeugnis() {
		return erzeugnis;
	}
	
	/**
	 * Diese Methode prüft ob genügend Guthaben für die Produktion des Produkt vorhanden ist,
	 * ist dies der Fall, wird ein Produkt produziert und dem Warenspeicher der Fabrik hinzugefügt.
	 */
	public void produktErzeugen() {
		// Testguthaben ueberpruefen
		if(fabrik.getTestguthaben() < erzeugnis.getKosten()) {
			System.out.println("Der Erzeuger: "+ this.name + " konnte keine "
						+ erzeugnis.getName() + " herstellen, da das Guthaben nicht ausreicht.");
			return;
		}
		
		// erzeugnis dem Warenspeicher der Fabrik hinzufuegen
		fabrik.getWarenspeicher().fuegeProduktHinzu(erzeugnis);
		
		// guthaben verringern
		fabrik.testguthabenReduzieren(erzeugnis.getKosten());
	}
	
	@Override
	public void maschineStarten() {
		super.maschineStarten();
		this.produktErzeugen();
		System.out.println(erzeugnis.getName() + " wurde produziert.");
	}
	
}
