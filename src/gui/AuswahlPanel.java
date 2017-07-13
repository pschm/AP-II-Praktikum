package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import app.Erzeuger;
import app.Verwerter;

@SuppressWarnings("serial")
public class AuswahlPanel extends JPanel {
	private PanelManager panelManager;
	
	public AuswahlPanel(PanelManager panelManager) {
		this.panelManager = panelManager;
		
		buildGui();
	}
	
	public void updateData() {
		this.removeAll();
		buildGui();
	}

	public void buildGui() {
		JPanel outerPanel = new JPanel();
		outerPanel.setLayout(new GridLayout(0, 1));
		
		outerPanel.add(new JLabel("Deine Auswahl:"));

		// panelManager.getAktiveMaschinen().isEmpty();
		try {
			panelManager.getAktiveMaschinen().isEmpty();
		} catch (Exception e) {
			System.out.println("Noch keine Maschinen in der Fabrik");
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
			
			if(e instanceof Verwerter) {
				maschinenDaten.setBackground(Color.ORANGE);
			} else {
				maschinenDaten.setBackground(Color.YELLOW);
			}
			
			final int index = i; // sonst meckert der Mouse listener
			maschinenDaten.addMouseListener( new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					panelManager.removeMaschineFromFabrik(index);
					repaint();
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					maschinenDaten.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
					//maschinenDaten.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					//maschinenDaten.setBorder(BorderFactory.createLineBorder(Color.RED));
					maschinenDaten.setBorder(BorderFactory.createLineBorder(Color.RED));
				}
			});
			
			
			outerPanel.add(maschinenDaten);
			
			
		} // Ende for (MaschinenEntwuerfe)
		
		this.add(outerPanel);
		revalidate();
	}
}
