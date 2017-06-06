package app;

/**
 * Diese Klasse bildet die Grundstruktur eines Produkts ab
 * und verwaltet dafür die Eigenschaften <h2>name</h2>, <h2>kosten</h2>, <h2>verkaufswert</h2>
 */
public class Produkt {
	private String name;
	private double kosten;
	private double verkaufswert;

	public Produkt(String name, double kosten, double verkaufswert) {
		this.name         = name;
		this.kosten       = kosten;
		this.verkaufswert = verkaufswert;
	}
	
	public String getName() {
		return name;
	}

	public double getKosten() {
		return kosten;
	}

	public double getVerkaufswert() {
		return verkaufswert;
	}

}
