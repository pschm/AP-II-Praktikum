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
	
	// TODO Kopieren Sie zunächst den Code aus dem MaschinenPanel und bauen Sie folgende
	//		Veränderungen ein:
	//		o Anstatt die Liste der Maschinenentwürfe abzufragen wird hier die Liste der (in der
	//		  Fabrik) aktiven Maschinen benötigt.
	//		o Es wird lediglich ein innerPanel benötigt für die Maschineninformationen (Typ,
	//		  Name, Kosten).
	//		o Der MouseListener des itemPanels wird ausgetauscht durch folgende
	//		  Funktionalität: Wird auf das JPanel gedrückt, so soll die entsprechende Maschine
	//		  entfernt werden.
}
