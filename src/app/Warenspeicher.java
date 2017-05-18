package app;

import java.util.ArrayList;

public class Warenspeicher {
	ArrayList<Produkt> produkte;
	
	public Warenspeicher() {
		produkte = new ArrayList<Produkt>();
	}
	
	public void fuegeProduktHinzu(Produkt produkt) {
		produkte.add(produkt);
	}
	
	public int anzahlImSpeicher(String gesuchtesProdukt) {
		int anzahl = 0;
		for(Produkt p : produkte) {
			if(p.getName() == gesuchtesProdukt) anzahl++;
		}
		return anzahl;
	}
	
	public void entferneProdukt(String unerwuenschtesProdukt) {
		for(Produkt p : produkte) {
			if(p.getName() == unerwuenschtesProdukt) {
				produkte.remove(p);
				return;
			}
		}
	}
	
	public void entferneProdukt(String unerwuenschtesProdukt, int anzahl) {
		int n = anzahlImSpeicher(unerwuenschtesProdukt);
		if(n < anzahl) anzahl = n;
		
		for(Produkt p : produkte) {
			// ggf. Anzahl > 0 in eigene Abfrage um redundante durchläufe zu vermeiden
			if(p.getName() == unerwuenschtesProdukt && anzahl > 0) {
				produkte.remove(p);
				anzahl--;
			}
		}
	}
	
	public double warenVerkaufen() {
		double summe = 0.0;
		for(Produkt p : produkte) {
			summe += p.getVerkaufswert();
			produkte.remove(p);
		}
		return summe;
	}
	
}
