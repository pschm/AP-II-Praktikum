package app;

public class Erzeuger extends Maschine {
	protected Produkt erzeugnis;
	
	public Erzeuger(String name, double kosten, Produkt erzeugnis) {
		super(name, kosten);
		this.erzeugnis = erzeugnis;
	}
	
	public void produktErzeugen() {
		// Testguthaben ueberpruefen
		if(fabrik.getTestguthaben() < erzeugnis.getKosten()) {
			System.out.println("Der Erzeuger: "+ this.name + " konnte keine "
						+ erzeugnis.getName() + " herstellen, da das Guthaben nicht ausreicht.");
			return;
		}
		
		// erzeugnis dem Warenspeicher der Fabrik hinzufuegen
		fabrik.getWarenspeicher().fuegeProduktHinzu(erzeugnis);
	}
	
	public void maschineStarten() {
		super.maschineStarten();
		this.produktErzeugen();
		System.out.println(erzeugnis.getName() + " wurde produziert.");
	}
	
}
