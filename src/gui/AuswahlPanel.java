package gui;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class AuswahlPanel extends JPanel {
	private PanelManager panelManager;
	
	public AuswahlPanel(PanelManager panelManager) {
		this.panelManager = panelManager;
	}
	
	public void updateData() {
		// TODO
	}
	
	// TODO Kopieren Sie zun�chst den Code aus dem MaschinenPanel und bauen Sie folgende
	//		Ver�nderungen ein:
	//		o Anstatt die Liste der Maschinenentw�rfe abzufragen wird hier die Liste der (in der
	//		  Fabrik) aktiven Maschinen ben�tigt.
	//		o Es wird lediglich ein innerPanel ben�tigt f�r die Maschineninformationen (Typ,
	//		  Name, Kosten).
	//		o Der MouseListener des itemPanels wird ausgetauscht durch folgende
	//		  Funktionalit�t: Wird auf das JPanel gedr�ckt, so soll die entsprechende Maschine
	//		  entfernt werden.
}
