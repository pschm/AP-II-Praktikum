package app;

/**
 * Diese Klasse bildet die Grundstruktur eines alle Maschinen ab
 */
public class Maschine {
	protected String name;
	protected double kosten;
	protected Fabrik fabrik;
	
	/**
	 * Der Konstruktor setzt @param name und @param kosten für die Maschine
	 * und initialisiert weiterhin die Eigenschaft fabrik mit null, da zu diesem Zeitpunkt
	 * noch nicht unbedingt klar sein kann, in welche Fabrik die Maschine hinzugefügt wird.
	 */
	public Maschine(String name, double kosten) {
		this.name   = name;
		this.kosten = kosten;
		fabrik      = null;
	}

	public String getName() {
		return name;
	}

	public double getKosten() {
		return kosten;
	}

	public void setFabrik(Fabrik fabrik) {
		this.fabrik = fabrik;
	}

	public void maschineStarten() {
		System.out.println(name + " hat die Arbeit aufgenommen.");
	}
}
