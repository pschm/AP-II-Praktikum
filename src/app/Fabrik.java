package app;

import java.util.ArrayList;

/**
 * Diese Klasse bildet die Grundstruktur für jede Fabrik.
 */
public class Fabrik {
	private Warenspeicher warenspeicher;
	private double guthaben;
	private double testguthaben;
	private String name;
	private ArrayList<Maschine> maschine;
	
	/**
	 * Der Konstruktor für die Fabrik legt fest, dass jedes neue Objekt einen @param warenspeicher,
	 * @param guthaben, @param testguthaben, sowie einen @param name erhält
	 * Des Weiteren wird die Eigenschaft maschine initialisiert. Bei Erstellung befinden sich keine Maschinen in der Fabrik.
	 */
	public Fabrik(Warenspeicher warenspeicher, double guthaben, double testguthaben,
			String name) {
		this.maschine      = new ArrayList<Maschine>();
		this.warenspeicher = warenspeicher;
		this.guthaben      = guthaben;
		this.testguthaben  = testguthaben;
		this.name          = name;
	}
	
	public Warenspeicher getWarenspeicher() {
		return warenspeicher;
	}

	public double getTestguthaben() {
		return testguthaben;
	}

	public String getName() {
		return name;
	}

	/**
	 * Diese Methode fügt der Fabrik eine Maschine (@param maschine) hinzu
	 */
	public void fuegeMaschineHinzu(Maschine maschine) {
		maschine.setFabrik(this);
		this.maschine.add(maschine);
	}
	
	/**
	 * Diese Methode entfernt eine Maschine am gegebenem @param index aus der Fabrik
	 */
	public void entferneMaschine(int index) {
		if(maschine.size() - 1 < index) return; // Abfragen, existiert der Index?
		maschine.remove(index);
	}
	
	public void testguthabenReduzieren(double kosten) {
		testguthaben -= kosten;
	}
	
	/**
	 * Die Methode firmaTesten simuliert die Produktion der Fabik
	 * über eine gegebene @param rundenanzahl.
	 * Das erwirtschaftete Guthaben wird zurückgegeben: @return testguthaben.
	 */
	public double firmaTesten(int rundenanzahl) {
		testguthaben = guthaben;
		
		for(Maschine m : maschine)
			testguthaben -= m.getKosten();
		
		// Produktionsprozess
		for(int i = 0; i < rundenanzahl; i++) {
			for(Maschine m : maschine) {
				m.maschineStarten();
			}
		}
		
		// Verkauf der Waren und Gutschreibung auf das Testguthaben
		testguthaben += warenspeicher.warenVerkaufen();
		
		// Rueckgabe des neuen Guthabens
		return testguthaben;
	}
}
