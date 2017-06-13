package gui;

import javax.swing.JPanel;

/**
 * Erstellen Sie eine Datenstruktur MaschinenPanel,
 * welche von JPanel erbt und f�r die Auflistung der Maschinenentw�rfe zust�ndig ist (Abbildungen 1, 2, 3 - rechte Seite).
 * In dieser Klasse werden Sie vermehrt in Kontakt mit der Verschachtelung von JPanel-Objekten kommen.
 * Orientieren Sie sich an Abbildung 3 und w�hlen Sie f�r jedes Panel ein geeignetes Layout. 
 */
@SuppressWarnings("serial")
public class MaschinenPanel extends JPanel {

	private PanelManager panelManager;
	
	public MaschinenPanel(PanelManager panelManager) {
		this.panelManager = panelManager;
	}
	
	/**
	 * Hier sollten zun�chst alle Elemente innerhalb des MaschinenPanels
	 * entfernt werden.
	 */
	public void updateData() {
		// TODO
	}
	
	// TODO Legen Sie nun das outerPanel (siehe Abbildung 3) an,
	//      welches f�r die Sammlung der einzelnen itemPanel zust�ndig ist.
	//	  # Holen Sie sich die Liste der Maschinenentw�rfe und iterieren Sie �ber diese. F�r
	//		jeden Maschinenentwurf m�ssen die folgenden drei JPanel zur Visualisierung der
	//		Maschineninformationen angelegt werden (in Abbildung 3 als InnerPanels
	//		bezeichnet):
	//	    � Maschinendaten (Typ, Name, Kosten),
	//		� Erzeugnisdaten (Name, Herstellungskosten, Verkaufswert) und
	//		� Abhaengigkeitsdaten (Name, Herstellungskosten, Verkaufswert, Anzahl).
	//		Achtung: Abh�ngigkeitsdaten werden nur gef�llt, wenn die Maschine vom
	//		Typ des Verwerters ist.
	//	  # Erstellen Sie ein weiteres Panel, in welchem Sie die drei innerPanel einbetten
	//		(in Abbildung 3 als itemPanels bezeichnet). F�gen Sie diesem itemPanel zudem
	//		einen MouseListener hinzu, welcher nach einem Mausklick den momentanen
	//		Maschinenentwurf der Fabrik hinzuf�gt. F�gen Sie dieses itemPanel dem
	//		outerPanel hinzu.
	//	  # Nachdem f�r jeden Maschinenentwurf ein itemPanel angelegt und dem
	//		outerPanel hinzugef�gt wurde, kann dieses outerPanel im Norden des
	//		MaschinenPanels hinzugef�gt werden.
	//		Rufen Sie aus anschlie�end die Methode revalidate() des MaschinenPanels
	//		auf, um die Darstellung durch Swing zu aktualisieren.
	//		Optional kann noch ein Tabellenkopf hinzugef�gt werden.
}
