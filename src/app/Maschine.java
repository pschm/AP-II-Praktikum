package app;

public class Maschine {
	protected String name;
	protected double kosten;
	protected Fabrik fabrik;
	
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
