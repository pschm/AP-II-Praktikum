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
	 */
	public int compare(Maschine o1, Maschine o2) {
		
		// Erzeuger vor verwerter, wenn gleich, namen pruefen
		if(o1.getTyp() == "Erzeuger") {
			if(o2.getTyp() == "Erzeuger") {
				NameComparator nc = new NameComparator();
				return nc.compare(o1, o2);
			}
			return -1; // Erzeuger vor Verwerter
		} else {
			// o1 ist Verwerter
			if(o2.getTyp() == "Erzeuger") {
				return 1; // Erzeuger vor Verwerter
			}
			
			// o1 und o2 sind Verwerter
			Verwerter v1 = (Verwerter) o1;
			Verwerter v2 = (Verwerter) o2;

			if(v1.getAbhaenigkeit().equals(v2.getErzeugnis())) {
				return 1;  // o1 ist von o2 Abhaengig
			} else if(v2.getAbhaenigkeit().equals(v1.getErzeugnis())) {
				return -1; // o2 ist von o1 Abhaengig
			}
		}
		
		// Beide sind Verwerter und nicht voneinander Abhaengig
		// dann Namesreihenfolge pruefen
		NameComparator nc = new NameComparator();
		return nc.compare(o1, o2);
	}
}
