package app;

import java.util.ArrayList;

public class Fabrik {
	private Warenspeicher warenspeicher;
	private double guthaben;
	private double testguthaben;
	private String name;
	private ArrayList<Maschine> maschine;
	
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

	public void fuegeMaschineHinzu(Maschine maschine) {
		maschine.setFabrik(this);
		this.maschine.add(maschine);
	}
	
	public void entferneMaschine(int index) {
		if(maschine.size() < index) return; // Abfragen, ob dieser Index überhaupt existiert?
		maschine.remove(index);
	}
	
	public void testguthabenReduzieren(double kosten) {
		testguthaben -= kosten;
	}
	
	public double firmaTesten(int rundenanzahl) {
		testguthaben = guthaben;
		
		for(Maschine m : maschine) {
			testguthaben -= m.getKosten();
		}
		
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
