package gui;

import java.util.ArrayList;

import javax.swing.JFrame;

import app.Fabrik;
import app.Maschine;
import app.Produkt;

public class PanelManager {
	private ArrayList <Produkt> produktEntwuerfe;
	private ArrayList <Maschine> maschinenEntwuerfe;
	private Fabrik fabrik;
	
	// zum Testen der GUI
	private InputPanel inputPanel;

	public PanelManager() {
		// TODO
	}
	
	public ArrayList<Produkt> getProduktEntwuerfe() {
		return produktEntwuerfe;
	}

	public ArrayList<Maschine> getMaschinenEntwuerfe() {
		return maschinenEntwuerfe;
	}
	
	/**
	 * Diese Methode erzeugt ein JFrame und bettet das InputPanel
	 * auf der linken Seite ein.
	 */
	public void start() {
		JFrame f = new JFrame();
		f.setSize(1000, 500);
		f.setVisible(true);
		
		// TODO InputPanel auf die linke Seite des Frames einbetten.
	}

	/**
	 * Diese Methode nimmt ein Produkt (@param produkt) entgegen und
	 * fügt es der Liste von Produktentwürfen hinzu.
	 * Falls bereits ein Produkt mit dem Namen vorhanden ist,
	 * wird dieses lediglich ausgetauscht anstatt das neue Produkt hinzuzufügen.
	 */
	public void addOrReplaceProduktentwurf(Produkt produkt) {
		inputPanel.updateData();
	}
	
	/**
	 * Identisch zu der addOrReplaceProduktentwurf, lediglich mit der Maschinenliste. 
	 */
	public void addOrReplaceMaschinenentwurf(Maschine maschine) {
		
	}
	
	// ==================================================
	// =	Methoden zur Kommunikation mit der Fabrik	=
	// ==================================================
	
	/**
	 * Diese Methode fügt den Maschinenentwurf an der Position @param index der Fabrik hinzu.
	 */
	public void addMaschineToFabrik(int index) {
		inputPanel.updateData();
	}
	
	/**
	 * Entfernt die Maschine an der Position @param index aus der Fabrik
	 * (hier bezieht sich der Index auf die Position in der ArrayList der Fabrik
	 * und nicht die position in den Maschinenentwürfen). 
	 */
	public void removeMaschineFromFabrik(int index) {
		inputPanel.updateData();
	}
	
	/**
	 * greift momentan lediglich auf die resetFabrik()-Methode der Fabrik zu.
	 */
	public void resetFabrik() {
		fabrik.resetFabrik();
	}
	
	/**
	 * @return: Gibt eine Liste der Maschinen zurück, die bereits der Firma hinzugefügt wurden.
	 */
	public ArrayList<Maschine> getAktiveMaschinen() {
		return fabrik.getMaschine();
	}
	
	/**
	 * @return: Gibt das momentane Testguthaben der Fabrik zurück.
	 */
	public double getTestguthaben() {
		return fabrik.getTestguthaben();
	}
}
