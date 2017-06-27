package app;

import java.util.Comparator;

/**
 * Objekte dieser Klasse erm�glichen den Vergleich zweier Maschinen und
 * k�nnen sp�ter der addSorted()- und der sort()-Methode einer Maschinenliste �bergeben werden.
 */
public class AblaufComparator implements Comparator<Maschine> {

	@Override
	/**
	 * In der Klasse AblaufComparator sollen die Maschinen so verglichen werden,
	 * dass eine logische Abfolge realisiert werden kann. Wird dieser Comparator der sort()-Methode der Maschinenliste �bergeben,
	 * so soll sp�ter (soweit m�glich) jede Maschine ausf�hrbar sein
	 * (also im Falle eines Verwerters alle Abh�ngigkeiten vorhanden sein).
	 * Bedenken Sie hierbei die unterschiedlichen Typen der Maschinen sowie deren Erzeugnisse und Abh�ngigkeiten.
	 * Folgende Bilder zeigen ein m�gliches Ergebnis dieses Sortiervorganges:
	 */
	public int compare(Maschine o1, Maschine o2) {
		// TODO Auto-generated method stub
		return 0;
	}
}
