package app;

import java.util.Comparator;
import java.util.Iterator;

public class Maschinenliste implements Iterable {
	Node first = null;
	Node last  = null; // nicht gefordert, ggf. trotzdem einbinden
	int currentSize = 0;
	
	public Maschinenliste() {
		// TODO
	}
	
	/**
	 * @return true, wenn die Liste leer ist.
	 */
	public boolean isEmpty() {
		return currentSize == 0;
	}
	
	/**
	 * erstellt einen neuen Knoten(Node) und fügt diesen am Anfang
	 * @param maschine - Daten des neuen Knoten
	 */
	public void addFirst(Maschine maschine) {
		first = new Node(maschine, first);
		currentSize++;
		
		if(currentSize == 1) last = first;
	}
	
	/**
	 * erstellt einen neuen Knoten (Node) und fügt diesen am Ende der Liste ein
	 * @param maschine - Daten des neuen Knoten
	 */
	public void addLast(Maschine maschine) {
		if(isEmpty()) addFirst(maschine);
		else {
			Node tmp = last;
			last = new Node(maschine, null);
			tmp.next = last;
			currentSize++;
		}
	}
	
	/**
	 * @return Anzahl der Elemente in der Liste.
	 */
	public int size() {
		return currentSize;
	}
	
	/**
	 * durchsucht die gesamte Liste nach dem Knoten mit der angegebenen @param maschine und gibt deren @return Index aus.
	 * Wird kein Knoten mit der entsprechenden Maschine gefunden, so soll der Wert -1 ausgegeben werden.
	 */
	public int indexOf(Maschine maschine) {
		return -1;
	}
	
	/**
	 * @return Maschine des Knoten an der Stelle @param index zurück.
	 * Ist die Maschinenliste leer, so soll eine NoSuchElementException geworfen werden.
	 * Ist der Wert von index nicht innerhalb des möglichen Bereiches (größer als die Länge der Liste oder kleiner als 0),
	 * so soll eine IndexOutOfBoundsException geworfen werden.
	 */
	public Maschine get(int index) {
		return new Maschine("Baum", 50.0);
	}
	
	/**
	 * @return Maschine des ersten Knotens zurück
	 */
	public Maschine getFirst() {
		return new Maschine("Baum", 50.0);
	}
	
	/**
	 * ermittelt den Knoten an der Stelle @param index und tauscht dort den Inhalt mit der neuen @param maschine aus.
	 * Ist die Maschinenliste leer, so soll eine NoSuchElementException geworfen werden.
	 * Ist der Wert von index nicht innerhalb des möglichen Bereiches (größer als die Länge der Liste oder kleiner als 0),
	 * so soll eine IndexOutOfBoundsException geworfen werden.
	 */
	public void set(int index, Maschine maschine) {
		
	}
	
	/**
	 * Entfernt den Knoten an der Stelle @param index aus der Liste.
	 * Ist die Maschinenliste leer, so soll eine NoSuchElementException geworfen werden.
	 * Ist der Wert von index nicht innerhalb des möglichen Bereiches, so soll eine IndexOutOfBoundsException geworfen werden.
	 */
	public void remove(int index) {
		
	}
	
	/**
	 * Entfernt alle Knoten aus der Liste
	 */
	public void clear() {
		
	}
	
	/**
	 * fügt die @param neueMaschine in die Liste ein. Dabei soll das Ergebnis des @param comp für die Sortierung genutzt werden.
	 * (Schauen Sie sich hierzu das Beispiel im Skript an). Zu verwendende Comparator werden in dem nächsten Aufgabenteil erstellt.
	 */
	public void addSorted(Maschine neueMaschine, Comparator<Maschine> comp) {
		
	}
	
	/**
	 * sortiert die Liste anhand des Comparators @param comp. Überlegen Sie besonders hier,
	 * welche Methoden Sie bereits erstellt haben und wiederverwenden können.
	 */
	public void sort(Comparator<Maschine> comp) {
		
	}
	
	private class Node {
		private Maschine maschine;
		private Node next = null;
		
		private Node(Maschine m, Node next) {
			this.maschine = m;
			this.next     = next;
		}
	}

	/**
	 * In dieser Methode müssen Sie ein neues Iterator<Maschine>-Objekt anlegen und zurückgeben.
	 * Dieses Objekt benötigt zunächst einen Startknoten, welcher auf den Startknoten der Liste gesetzt wird.
	 * Anschließend müssen in diesem Objekt zwei weitere Funktionen definiert werden...
	 */
	@Override
	public Iterator<Maschine> iterator() {
		Iterator<Maschine> it = new Iterator<Maschine>() {

			/**
			 * @return true, wenn sich noch weitere Elemente in der Liste befinden (ansonsten false)
			 */
			@Override
			public boolean hasNext() {
				return false;
			}

			@Override
			/**
			 * @return die Maschine des Knotens und setzt den aktuellen auf den nächsten Knoten.
			 * Ist der aktuelle Knoten leer, so soll eine NoSuchElementException geworfen werden.
			 */
			public Maschine next() {
				//if(hasNext()) return next; // TODO
				return null;
			}
			
		};
		
		return null;
	}
}
