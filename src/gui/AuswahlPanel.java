package gui;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import app.Erzeuger;

@SuppressWarnings("serial")
public class AuswahlPanel extends JPanel {
	private PanelManager panelManager;
	
	public AuswahlPanel(PanelManager panelManager) {
		this.panelManager = panelManager;
		
		buildGui();
	}
	
	public void updateData() {
		// TODO
	}

	public void buildGui() {
		JPanel outerPanel = new JPanel();
		outerPanel.setLayout(new GridLayout(0, 1));

		try {
			panelManager.getAktiveMaschinen().isEmpty();
		} catch (Exception e) {
			System.out.println("Sachen gibts -.-(AuswahlPanel)");
			return;
		}
		
		for(int i = 0; i < panelManager.getAktiveMaschinen().size(); i++) {
			Erzeuger e = (Erzeuger) panelManager.getAktiveMaschinen().get(i);
			
			// innerPannel erzeugen
			JPanel maschinenDaten = new JPanel();
			
			// innerPannel fuellen
			maschinenDaten.setLayout(new GridLayout(3, 1));
			maschinenDaten.add(new JLabel("Typ: "    + e.getTyp()));
			maschinenDaten.add(new JLabel("Name: "   + e.getName()));
			maschinenDaten.add(new JLabel("Kosten: " + e.getKosten()));
			
			final int index = i; // sonst meckert der Mouse listener
			maschinenDaten.addMouseListener( new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					panelManager.removeMaschineFromFabrik(index);
				}
			});
			
			
			outerPanel.add(maschinenDaten); // in MouseListener??????
			
			
		} // Ende for (MaschinenEntwuerfe)
		
		this.add(outerPanel);
		revalidate();
	}
}
