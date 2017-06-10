package app;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Die Klasse Warenspeicher verwaltet den Warenspeicher einer Fabrik und listet 
 * mit hilfe der Eigenschaft produkte alle Erzeugnisse der Fabrik auf
 */
public class Warenspeicher {
	ArrayList<Produkt> produkte;
	
	public Warenspeicher() {
		produkte = new ArrayList<Produkt>();
	}
	
	/**
	 * @param produkt welches dem Warenspeicher hinzugefügt wird
	 */
	public void fuegeProduktHinzu(Produkt produkt) {
		produkte.add(produkt);
	}
	
	/**
	 * @param gesuchtesProdukt : Name des gesuchten Produkts
	 * @return int : gibt die Anzahl der im Speicher vorhandenen Produkte zurück
	 */
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
	
	
	/**
	 * Diese Methode durchsucht den Warenspeicher nach einem gegebenen Produkt
	 * und löscht der Anzahl entsprechend aus dem Speicher.
	 * 
	 * @param unerwuenschtesProdukt : Name des zu entfernenden Produkts
	 * @param anzahl : Menge des zu entfernenden Produkts
	 */
	public void entferneProdukt(String unerwuenschtesProdukt, int anzahl) {
		// ggf. abfragen ob genügend Produkte im Speicher sind
		Iterator<Produkt> it = produkte.iterator();
		while(it.hasNext() && anzahl > 0) {
			Produkt p = it.next();
			if(p.getName() == unerwuenschtesProdukt) {
				it.remove(); // produkte.remove(p);
				anzahl--;
			}
		}
	}
	
	public void entferneProdukt(String unerwuenschtesProdukt) {
		entferneProdukt(unerwuenschtesProdukt, 1);
	}
	
	public void entferneProdukt(Produkt unerwuenschtesProdukt, int anzahl) {
		entferneProdukt(unerwuenschtesProdukt.getName(), anzahl);
	}
	
	/**
	 * Diese Methode leert den gesamten Warenspeicher und berechnet den 
	 * Verkaufswert der Waren, welcher auch zurückgegeben wird.
	 * @return summe : Gesamter Verkaufswert aller Waren des Warenspeichers 
	 */
	public double warenVerkaufen() {
		double summe = 0.0;

		System.out.println("\nWarenkorb vor dem Verkauf: ");
		
		// Produkte aufsummieren
		for(Produkt p : produkte) {
			double netto = p.getVerkaufswert() * 0.81;
			double mwst  = p.getVerkaufswert() * 0.19;
			
			System.out.println("Produkt: " + p.getName());
			System.out.println("Brutto:  " + p.getVerkaufswert());
			System.out.println("Netto:   " + netto);
			System.out.println("MwSt:    " + mwst);
			System.out.println("-----");
			
			summe += netto;
		}
		
		// ArrayList leeren
		produkte.clear();
		
		return summe;
	}
	
}
