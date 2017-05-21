package app;

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
