package app;

import java.util.Comparator;

/**
 * Objekte dieser Klasse ermöglichen den Vergleich zweier Maschinen und
 * können später der addSorted()- und der sort()-Methode einer Maschinenliste übergeben werden.
 */
public class NameComparator implements Comparator<Maschine>{

	@Override
	/**
	 * Sind die Namen identisch, so soll @return 0 zurückgegeben werden.
	 * Ist der Name der ersten Maschine logisch hinter dem der zweiten Maschine einzuordnen,
	 * so soll ein Wert @return >0 ausgegeben werden (z.B. Bohrer > Apfelpresse, da B im Alphabet nach A kommt).
	 * Andernfalls soll ein Wert @return kleiner als 0 ausgegeben werden (auch hier wieder der Verweis zum Skript und
	 * der compareTo()-Methode).
	 */
	public int compare(Maschine o1, Maschine o2) {
		return o1.getName().compareTo(o1.getName());
	}

}
