package app;

import java.util.Comparator;

//import java.util.ArrayList;

/**
 * Diese Klasse bildet die Grundstruktur für jede Fabrik.
 */
public class Fabrik {
	private Warenspeicher warenspeicher;
	private double guthaben;
	private double testguthaben;
	private String name;
	//private ArrayList<Maschine> maschine;
	private Maschinenliste maschine;
	
	/**
	 * Der Konstruktor für die Fabrik legt fest, dass jedes neue Objekt einen @param warenspeicher,
	 * @param guthaben, @param testguthaben, sowie einen @param name erhält
	 * Des Weiteren wird die Eigenschaft maschine initialisiert. Bei Erstellung befinden sich keine Maschinen in der Fabrik.
	 */
	public Fabrik(Warenspeicher warenspeicher, double guthaben, String name) {
		//this.maschine      = new ArrayList<Maschine>();
		this.maschine      = new Maschinenliste();
		this.warenspeicher = warenspeicher;
		this.guthaben      = guthaben;
		this.name          = name;
		testguthaben       = guthaben;		
	}
	
//	public ArrayList<Maschine> getMaschine() {
//		return maschine;
//	}
	
	public Maschinenliste getMaschine() {
		return maschine;
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
	 * Testguthaben zurücksetzten und Maschinen leeren
	 */
	public void resetFabrik() {
		testguthaben = guthaben;
		maschine.clear();
	}

	/**
	 * Diese Methode fügt der Fabrik eine Maschine (@param maschine) hinzu
	 * und reduziert das guthaben entsprechend der Kosten
	 */
	public void fuegeMaschineHinzu(Maschine maschine) {
		maschine.setFabrik(this);
		testguthaben -= maschine.getKosten();
		//this.maschine.add(maschine);
		this.maschine.addLast(maschine);
	}
	
	/**
	 * Diese Methode entfernt eine Maschine am gegebenem @param index aus der Fabrik
	 * und erhöht das Guthaben entsprechend der Kosten
	 */
	public void entferneMaschine(int index) {
		if(maschine.size() - 1 < index) return; // TODO: try Catch einbauen
		
		testguthaben += maschine.get(index).getKosten();
		maschine.remove(index);
	}
	
	public void testguthabenReduzieren(double kosten) {
		testguthaben -= kosten;
	}
	
	public void sort(Comparator<Maschine> comp) {
		//maschine.sort(comp);
		maschine.quickSort(comp);
	}
	
	/**
	 * Die Methode firmaTesten simuliert die Produktion der Fabik
	 * über eine gegebene @param rundenanzahl.
	 * Das erwirtschaftete Guthaben wird zurückgegeben: @return testguthaben.
	 */
	public double firmaTesten(int rundenanzahl) {
		
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
