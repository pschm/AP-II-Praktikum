package app;

/**
 * Diese Klasse bildet die Grundstruktur eines alle Maschinen ab
 */
public class Maschine {
	protected String name;
	protected double kosten;
	protected Fabrik fabrik;

	protected String typ;
	
	public static String [] typen = {"Standard", "Erzeuger", "Verwerter"};
	
	/**
	 * Der Konstruktor setzt @param name und @param kosten für die Maschine
	 * und initialisiert weiterhin die Eigenschaft fabrik mit null, da zu diesem Zeitpunkt
	 * noch nicht unbedingt klar sein kann, in welche Fabrik die Maschine hinzugefügt wird.
	 */
	public Maschine(String name, double kosten) {
		this.name   = name;
		this.kosten = kosten;
		typ			= typen[0];
		fabrik      = null;
	}
	
	@Override
	public String toString() {
		return "ich bin nur eine Maschien";
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
	
	public String getTyp() {
		return typ;
	}

	public void maschineStarten() {
		System.out.println(name + " hat die Arbeit aufgenommen.");
	}
}
