package app;

import java.util.Comparator;

/**
 * Objekte dieser Klasse ermöglichen den Vergleich zweier Maschinen und
 * können später der addSorted()- und der sort()-Methode einer Maschinenliste übergeben werden.
 */
public class AblaufComparator implements Comparator<Maschine> {

	@Override
	/**
	 * In der Klasse AblaufComparator sollen die Maschinen so verglichen werden,
	 * dass eine logische Abfolge realisiert werden kann. Wird dieser Comparator der sort()-Methode der Maschinenliste übergeben,
	 * so soll später (soweit möglich) jede Maschine ausführbar sein
	 * (also im Falle eines Verwerters alle Abhängigkeiten vorhanden sein).
	 * Bedenken Sie hierbei die unterschiedlichen Typen der Maschinen sowie deren Erzeugnisse und Abhängigkeiten.
	 * Folgende Bilder zeigen ein mögliches Ergebnis dieses Sortiervorganges:
	 */
	public int compare(Maschine o1, Maschine o2) {
		// TODO Auto-generated method stub
		return 0;
	}
}
