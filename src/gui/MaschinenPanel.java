package gui;

import javax.swing.JPanel;

/**
 * Erstellen Sie eine Datenstruktur MaschinenPanel,
 * welche von JPanel erbt und für die Auflistung der Maschinenentwürfe zuständig ist (Abbildungen 1, 2, 3 - rechte Seite).
 * In dieser Klasse werden Sie vermehrt in Kontakt mit der Verschachtelung von JPanel-Objekten kommen.
 * Orientieren Sie sich an Abbildung 3 und wählen Sie für jedes Panel ein geeignetes Layout. 
 */
@SuppressWarnings("serial")
public class MaschinenPanel extends JPanel {

	private PanelManager panelManager;
	
	public MaschinenPanel(PanelManager panelManager) {
		this.panelManager = panelManager;
	}
	
	/**
	 * Hier sollten zunächst alle Elemente innerhalb des MaschinenPanels
	 * entfernt werden.
	 */
	public void updateData() {
		// TODO
	}
	
	// TODO Legen Sie nun das outerPanel (siehe Abbildung 3) an,
	//      welches für die Sammlung der einzelnen itemPanel zuständig ist.
	//	  # Holen Sie sich die Liste der Maschinenentwürfe und iterieren Sie über diese. Für
	//		jeden Maschinenentwurf müssen die folgenden drei JPanel zur Visualisierung der
	//		Maschineninformationen angelegt werden (in Abbildung 3 als InnerPanels
	//		bezeichnet):
	//	    • Maschinendaten (Typ, Name, Kosten),
	//		• Erzeugnisdaten (Name, Herstellungskosten, Verkaufswert) und
	//		• Abhaengigkeitsdaten (Name, Herstellungskosten, Verkaufswert, Anzahl).
	//		Achtung: Abhängigkeitsdaten werden nur gefüllt, wenn die Maschine vom
	//		Typ des Verwerters ist.
	//	  # Erstellen Sie ein weiteres Panel, in welchem Sie die drei innerPanel einbetten
	//		(in Abbildung 3 als itemPanels bezeichnet). Fügen Sie diesem itemPanel zudem
	//		einen MouseListener hinzu, welcher nach einem Mausklick den momentanen
	//		Maschinenentwurf der Fabrik hinzufügt. Fügen Sie dieses itemPanel dem
	//		outerPanel hinzu.
	//	  # Nachdem für jeden Maschinenentwurf ein itemPanel angelegt und dem
	//		outerPanel hinzugefügt wurde, kann dieses outerPanel im Norden des
	//		MaschinenPanels hinzugefügt werden.
	//		Rufen Sie aus anschließend die Methode revalidate() des MaschinenPanels
	//		auf, um die Darstellung durch Swing zu aktualisieren.
	//		Optional kann noch ein Tabellenkopf hinzugefügt werden.
}
