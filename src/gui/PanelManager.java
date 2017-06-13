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
	
	private InputPanel inputPanel;
	private MaschinenPanel maschinenPanel;
	private AuswahlPanel auswahlPanel;

	public PanelManager() {
		// TODO init panels
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
		
		// TODO inputPanel auf die linke Seite des Frames einbetten.
		
		// TODO maschinenPanel auf die rechte Seite des Frames einbetten.
		
		// TODO zweites Fenster erstellen und auswahlPanel einbetten
	}

	/**
	 * Diese Methode nimmt ein Produkt (@param produkt) entgegen und
	 * f�gt es der Liste von Produktentw�rfen hinzu.
	 * Falls bereits ein Produkt mit dem Namen vorhanden ist,
	 * wird dieses lediglich ausgetauscht anstatt das neue Produkt hinzuzuf�gen.
	 */
	public void addOrReplaceProduktentwurf(Produkt produkt) {
		inputPanel.updateData();
	}
	
	/**
	 * Identisch zu der addOrReplaceProduktentwurf, lediglich mit der Maschinenliste. 
	 */
	public void addOrReplaceMaschinenentwurf(Maschine maschine) {
		maschinenPanel.updateData();
		maschinenPanel.repaint(); // TODO ueberlegen, ob hier sinnvoll
	}
	
	// ==================================================
	// =	Methoden zur Kommunikation mit der Fabrik	=
	// ==================================================
	
	/**
	 * Diese Methode f�gt den Maschinenentwurf an der Position @param index der Fabrik hinzu.
	 */
	public void addMaschineToFabrik(int index) {
		inputPanel.updateData();
		maschinenPanel.updateData();
		maschinenPanel.repaint(); // TODO ueberlegen, ob hier sinnvoll
		auswahlPanel.updateData();
	}
	
	/**
	 * Entfernt die Maschine an der Position @param index aus der Fabrik
	 * (hier bezieht sich der Index auf die Position in der ArrayList der Fabrik
	 * und nicht die position in den Maschinenentw�rfen). 
	 */
	public void removeMaschineFromFabrik(int index) {
		inputPanel.updateData();
		maschinenPanel.updateData();
		maschinenPanel.repaint(); // TODO ueberlegen, ob hier sinnvoll
		auswahlPanel.updateData();
	}
	
	/**
	 * greift momentan lediglich auf die resetFabrik()-Methode der Fabrik zu.
	 */
	public void resetFabrik() {
		fabrik.resetFabrik();
		auswahlPanel.updateData();
	}
	
	/**
	 * @return: Gibt eine Liste der Maschinen zur�ck, die bereits der Firma hinzugef�gt wurden.
	 */
	public ArrayList<Maschine> getAktiveMaschinen() {
		return fabrik.getMaschine();
	}
	
	/**
	 * @return: Gibt das momentane Testguthaben der Fabrik zur�ck.
	 */
	public double getTestguthaben() {
		return fabrik.getTestguthaben();
	}
}
