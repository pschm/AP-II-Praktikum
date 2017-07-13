package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.NoSuchElementException;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import app.Erzeuger;
import app.Maschine;
import app.Produkt;
import app.Verwerter;

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
		
		buildGui();
	}
	
	/**
	 * Hier sollten zunächst alle Elemente innerhalb des MaschinenPanels
	 * entfernt werden.
	 */
	public void updateData() {
		this.removeAll();
		buildGui();
	}
	
	public void buildGui() {
		JPanel outerPanel = new JPanel();
		outerPanel.setLayout(new GridLayout(0, 1));
		
		JPanel headerPanel = new JPanel();
		headerPanel.setLayout(new GridLayout(1, 3));
		headerPanel.add(new JLabel("Maschine"));
		headerPanel.add(new JLabel("Erzeugnis:"));
		headerPanel.add(new JLabel("Abhaenigkeit:"));
		
		outerPanel.add(headerPanel);
		
		for(int i = 0; i < panelManager.getMaschinenEntwuerfe().size(); i++) {
			Erzeuger e = null;
			Maschine m = null;
			
			//System.out.println("Groesse: " + panelManager.getMaschinenEntwuerfe().size());
			m = panelManager.getMaschinenEntwuerfe().get(i);
			//System.out.println(m.toString() + " (MaschinenPanel)");
			
			try {
				e = (Erzeuger) m;
			} catch (NoSuchElementException ex) {
				return;
			}
			
			// e = (Verwerter) m;
			
			// innerPanel
			JPanel maschinenPanel = new JPanel();

			// itemPanels erzeugen
			JPanel maschinenDaten      = new JPanel();
			JPanel erzeugnisDaten      = new JPanel();
			JPanel abhaengigkeitsDaten = new JPanel();
			
			// itemPannels fuellen
			maschinenDaten.setLayout(new GridLayout(3, 1));
			maschinenDaten.add(new JLabel("Typ: "    + e.getTyp()));
			maschinenDaten.add(new JLabel("Name: "   + e.getName()));
			maschinenDaten.add(new JLabel("Kosten: " + e.getKosten()));
			maschinenDaten.setBackground(Color.YELLOW);
			
			erzeugnisDaten.setLayout(new GridLayout(3, 1));
			erzeugnisDaten.add(new JLabel("Name: "               + e.getErzeugnis().getName()));
			erzeugnisDaten.add(new JLabel("Herstellungskosten: " + e.getErzeugnis().getKosten()));
			erzeugnisDaten.add(new JLabel("Verkaufswert: "       + e.getErzeugnis().getVerkaufswert()));
			erzeugnisDaten.setBackground(Color.YELLOW);
			
			abhaengigkeitsDaten.setBackground(Color.YELLOW);
			
			if(e instanceof Verwerter) {
				abhaengigkeitsDaten.setBackground(Color.ORANGE);
				maschinenDaten.setBackground(Color.ORANGE);
				erzeugnisDaten.setBackground(Color.ORANGE);
				
				Produkt p = ((Verwerter) e).getAbhaenigkeit();
				abhaengigkeitsDaten.setLayout(new GridLayout(4, 1));
				abhaengigkeitsDaten.add(new JLabel("Name: " + p.getName()));
				abhaengigkeitsDaten.add(new JLabel("Herstellungskosten: " + p.getKosten()));
				abhaengigkeitsDaten.add(new JLabel("Verkaufswert: " + p.getVerkaufswert()));
				abhaengigkeitsDaten.add(new JLabel("Anzahl: " + ((Verwerter)e).getAnzahl()));
			}
			
			
			
			// Layout festlegen
			maschinenPanel.setLayout(new GridLayout(1, 3));
			
			// itemPanels hinzufuegen
			maschinenPanel.add(maschinenDaten);
			maschinenPanel.add(erzeugnisDaten);
			maschinenPanel.add(abhaengigkeitsDaten);
			
			final int index = i; // sonst meckert der Mouse listener
			
			maschinenPanel.addMouseListener( new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					panelManager.addMaschineToFabrik(index);
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					maschinenPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
					//maschinenDaten.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					//maschinenDaten.setBorder(BorderFactory.createLineBorder(Color.RED));
					maschinenPanel.setBorder(BorderFactory.createLineBorder(Color.RED));
				}
			});
			
			
			outerPanel.add(maschinenPanel);
			
		} // END - for(MaschinenEntwuerfe)
		
		this.add(outerPanel);
		revalidate();
	}

}
