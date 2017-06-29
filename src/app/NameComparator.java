package app;

import java.util.Comparator;

/**
 * Objekte dieser Klasse erm�glichen den Vergleich zweier Maschinen und
 * k�nnen sp�ter der addSorted()- und der sort()-Methode einer Maschinenliste �bergeben werden.
 */
public class NameComparator implements Comparator<Maschine>{

	@Override
	/**
	 * Sind die Namen identisch, so soll @return 0 zur�ckgegeben werden.
	 * Ist der Name der ersten Maschine logisch hinter dem der zweiten Maschine einzuordnen,
	 * so soll ein Wert @return >0 ausgegeben werden (z.B. Bohrer > Apfelpresse, da B im Alphabet nach A kommt).
	 * Andernfalls soll ein Wert @return kleiner als 0 ausgegeben werden (auch hier wieder der Verweis zum Skript und
	 * der compareTo()-Methode).
	 */
	public int compare(Maschine o1, Maschine o2) {
		return o1.getName().compareTo(o1.getName());
	}

}
