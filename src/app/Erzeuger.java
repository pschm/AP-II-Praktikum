package app;

public class Erzeuger extends Maschine {
	protected Produkt erzeugnis;
	
	public Erzeuger(String name, double kosten, Produkt erzeugnis) {
		super(name, kosten);
		this.erzeugnis = erzeugnis;
	}
	
	// Diese Methode überprüft zunächst, ob das Testguthaben
	// der Fabrik für die Herstellung des Produkts ausreichend ist.
	// Ist das der Fall, so wird das erzeugnis dem Warenspeicher der
	// Fabrik hinzugefügt. Andernfalls wird eine Fehlermeldung auf
	// der Konsole ausgegeben.
	// Bsp. Ausgabe: "Apel konnte aufrung fehlenden Guthabens nicht
	// erzeugt werden."
	public void produktErzeugen() {
		//
	}
	
	public void maschineStarten() {
		super.maschineStarten();
		erzeugnis = new Produkt("Apfel", 0.815, 42.0);
		// TODO arbeitArbeit
		System.out.println(erzeugnis.getName() + " wurde produziert.");
	}
	
}
