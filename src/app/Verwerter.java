package app;

/**
 * Diese Klasse biltet die Grundstruktur f�r einen Verwerter,
 * eine Maschine, die zur Verarbeitung von Produkten dient und
 * somit neue Produkte erstellt (aus �pfeln wird Apfelsaft).
 */
public class Verwerter extends Erzeuger {
	private Produkt abhaenigkeit;
	private int anzahl;
	
	public Verwerter(String name, double kosten, int anzahl, Produkt erzeugnis, Produkt abhaenigkeit) {
		super(name, kosten, erzeugnis);
		this.anzahl       = anzahl;
		this.abhaenigkeit = abhaenigkeit;
		this.typ          = typen[2];
	}
	
	public Produkt getAbhaenigkeit() {
		return abhaenigkeit;
	}
	
	public int getAnzahl() {
		return anzahl;
	}
	
	@Override
	public String toString() {
		return "ich bin ein verwerter";
	}
	
	/**
	 * Diese Methode pr�ft, ob gen�gend Produkte f�r die
	 * Verarbeitung vorhanden sind und gibt das Ergebnis zur�ck (@return)
	 */
	public boolean checkAbhaengigkeit() {
		return anzahl <= fabrik.getWarenspeicher().anzahlImSpeicher(abhaenigkeit);
	}
	
	/**
	 * Diese Methode zur Erzeugung von Produkten pr�ft erst, ob gen�gend Produkte
	 * f�r die Weiterverarbeitung im Warenspeicher vorhanden sind und das Guthaben
	 * zur erzeugung des neuen Produkt ausreicht.
	 * Ist dies der Fall, wird ein neues Produkt erzeugt und dem Warenspeicher hinzugef�gt.
	 * Des Weiteren werden die Produktionskosten vom Guthaben abgezoegen.
	 */
	@Override
	public void produktErzeugen() {
		if(!this.checkAbhaengigkeit()) {
			System.out.println("Es sind nicht genuegend " + abhaenigkeit.getName() + " im Speicher vorhanden.");
			System.out.println(erzeugnis.getName() + " konnte nicht hergestellt werden.");
			return;
		}
		
		fabrik.getWarenspeicher().entferneProdukt(abhaenigkeit, anzahl); 
		
		// guthaben verringern
		fabrik.testguthabenReduzieren(erzeugnis.getKosten());
		
		super.produktErzeugen();
	}
}
