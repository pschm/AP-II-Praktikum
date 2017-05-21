package app;

import java.util.ArrayList;
import java.util.Iterator;

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
	
	public int anzahlImSpeicher(Produkt gesuchtesProdukt) {
		return this.anzahlImSpeicher(gesuchtesProdukt.getName());
	}
	
	public void entferneProdukt(String unerwuenschtesProdukt) {
		entferneProdukt(unerwuenschtesProdukt, 1);
	}
	
	public void entferneProdukt(String unerwuenschtesProdukt, int anzahl) {
		int n = anzahlImSpeicher(unerwuenschtesProdukt);
		if(n < anzahl) anzahl = n;
		
		Iterator<Produkt> it = produkte.iterator();
		while(it.hasNext() && anzahl > 0) {
			Produkt p = it.next();
			if(p.getName() == unerwuenschtesProdukt) {
				it.remove(); // produkte.remove(p);
				anzahl--;
			}
		}
	}
	
	public void entferneProdukt(Produkt unerwuenschtesProdukt, int anzahl) {
		entferneProdukt(unerwuenschtesProdukt.getName(), anzahl);
	}
	
	public double warenVerkaufen() {
		double summe = 0.0;

		Iterator<Produkt> it = produkte.iterator();
		while(it.hasNext()) {
			Produkt p = it.next();
			summe += p.getVerkaufswert();
			it.remove();
		}
		
		return summe;
	}
	
}
