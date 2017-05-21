package app;

// Verwerter ist eine Maschine, die zur Verarbeitung von Produkten
// dient, um so neue Produkte zu erstellen. (z.B. aus Äpfeln wird Apfelsaft)
public class Verwerter extends Erzeuger {
	private Produkt abhaenigkeit;
	private int anzahl;
	
	public Verwerter(String name, double kosten, int anzahl, Produkt erzeugnis, Produkt abhaenigkeit) {
		super(name, kosten, erzeugnis);
		this.anzahl = anzahl;
		this.abhaenigkeit = abhaenigkeit;
	}
	
	// Diese Methode prüft, ob genügend Produkte für die
	// Verarbeitung vorhanden sind.
	public boolean checkAbhaengigkeit() {
		return anzahl >= fabrik.getWarenspeicher().anzahlImSpeicher(erzeugnis);
	}
	
	// Diese Methode zur Erzeugung von Produkten soll so erweitert werden, dass die zu
	// verarbeitenden Produkte aus dem Warenspeicher entnommen werden. Achtung: Es
	// müssen genügend erzeugte Produkte vorhanden sein, bevor sie verarbeitet werden
	// können. Außerdem benötigen Sie genügend Guthaben, um die Verarbeitung
	// auszuführen.
	// Bsp. Ausgabe: "Apfelpresse hat die Arbeit aufgenommen."
	// "Apfelsaft wurde produziert."
	public void produktErzeugen() {
		if(!this.checkAbhaengigkeit()) {
			System.out.println("Es sind nicht genuegend " + abhaenigkeit.getName() + " im Speicher vorhanden.");
			System.out.println(erzeugnis.getName() + " konnte nicht hergestellt werden.");
			return;
		}
		
		fabrik.getWarenspeicher().entferneProdukt(abhaenigkeit, anzahl); 
		
		super.produktErzeugen();
	}
}
