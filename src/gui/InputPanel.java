package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import app.Erzeuger;
import app.Maschine;
import app.Produkt;
import app.Verwerter;

@SuppressWarnings("serial") // TODO
public class InputPanel extends JPanel {

	private PanelManager panelManager;
	
	// JLabel
	private JLabel l_produktName              = new JLabel("Name:");
	private JLabel l_produktKosten            = new JLabel("Produktionskosten:");
	private JLabel l_produktVerkaufswert      = new JLabel("Verkaufswert:");
	private JLabel l_maschinenName            = new JLabel("Name:");
	private JLabel l_maschinenKosten          = new JLabel("Kosten:");
	private JLabel l_maschinenErzeugnis       = new JLabel("Erzeugnis:");
	private JLabel l_anzahlBedingungen        = new JLabel("Anzahl:");
	private JLabel l_testguthaben             = new JLabel("0.0 €");
	private JLabel l_testguthabenBeschreibung = new JLabel("Testguthaben: ");
	private JLabel l_anzahlTestrunden		  = new JLabel("Anzahl der Runden:");
	
	// JLabel (headers)
	private JLabel l_ueberschriftProdukte    = new JLabel("Produkt");
	private JLabel l_ueberschriftMaschine    = new JLabel("Maschine");
	private JLabel l_ueberschriftFabriktests = new JLabel("Fabriktests");
	
	// JTextfield
	private JTextField tf_produktName         = new JTextField("");
	private JTextField tf_produktKosten       = new JTextField("");
	private JTextField tf_produktVerkaufswert = new JTextField("");
	private JTextField tf_maschinenName       = new JTextField("");
	private JTextField tf_maschinenKosten     = new JTextField("");
	private JTextField tf_anzahlBedingungen   = new JTextField("");
	private JTextField tf_anzahlTestrunden    = new JTextField("1");
	
	// JComboBox
	private JComboBox <String> cb_erzeugnisliste  = new JComboBox<String>();
	private JComboBox <String> cb_bedingungsliste = new JComboBox<String>();
	
	// JCheckBox
	private JCheckBox chb_abhaengigkeit = new JCheckBox("Bedingung?");
	
	// JButton
	private JButton btn_produkt     = new JButton("Produkt anlegen");
	private JButton btn_maschine    = new JButton("Maschine anlegen");
	private JButton btn_fabrikStart = new JButton("Test starten");
	private JButton btn_fabrikReset = new JButton("Fabrik zurücksetzen");
	
	
	public InputPanel(PanelManager panelManager) {
		this.panelManager = panelManager;
		
		buildGui();
	}
	
	/**
	 * Methode zur erstellung der GUI
	 */
	private void buildGui() {

		// --- Layout ---
		setLayout(new GridLayout(16, 2));
		
		// Produkt
		add(l_ueberschriftProdukte);
		add(new JLabel(" ")); // empty TODO bessere Loesung?
		add(l_produktName);
		add(tf_produktName);
		add(l_produktKosten);
		add(tf_produktKosten);
		add(l_produktVerkaufswert);
		add(tf_produktVerkaufswert);
		add(new JLabel(" "));
		add(btn_produkt);
		
		// Maschine
		add(l_ueberschriftMaschine);
		add(new JLabel(" "));
		add(l_maschinenName);
		add(tf_maschinenName);
		add(l_maschinenKosten);
		add(tf_maschinenKosten);
		add(l_maschinenErzeugnis);
		add(cb_erzeugnisliste);
		add(chb_abhaengigkeit);
		add(cb_bedingungsliste);
		add(l_anzahlBedingungen);
		add(tf_anzahlBedingungen);
		add(new JLabel(" "));
		add(btn_maschine);
		
		// Fabriktests
		add(l_ueberschriftFabriktests);
		add(new JLabel(" "));
		add(l_testguthabenBeschreibung);
		add(l_testguthaben);
		add(l_anzahlTestrunden);
		add(tf_anzahlTestrunden);
		add(btn_fabrikReset);
		add(btn_fabrikStart);
		
		
		// --- ActionListener für alle Buttons ---
		/**
		 * Fügen Sie dem JButton zum Anlegen eines Produkts einen ActionListener hinzu.
		 * Wird auf diesen gedrückt, so soll mithilfe der Textfeldeingaben
		 * (Produktname, Produktkosten, Verkaufskosten des Produkts) ein neues Produkt erstellt,
		 * sowie der Liste mit Produktentwürfen (im PanelManager) hinzugefügt werden.
		 */	
		btn_produkt.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelManager.addOrReplaceProduktentwurf(
						new Produkt(tf_produktName.getText(),
							Double.parseDouble(tf_produktKosten.getText()),
							Double.parseDouble(tf_produktVerkaufswert.getText()))
				);
//				tf_produktName.setText("");
//				tf_produktKosten.setText("");
//				tf_produktVerkaufswert.setText("");
			}
		});
		
		/**
		 * Unterscheiden Sie dabei zwei Fälle:
		 * - CheckBox ausgewählt: ein Verwerter wird erstellt
		 * - CheckBox NICHT ausgewählt: ein Erzeuger wird erstellt.
		 * Für die Erstellung benötigte Eigenschaften können aus den jeweiligen Textfeldern entnommen werden.
		 * Die benötigten Produkte können anhand des aktiven Items der JComboBoxen
		 * (der Index des aktiven Items) aus der Produktentwurfs-Liste des PanelManagers entnommen werden.
		 * Nachdem eine neue Instanz der jeweiligen Maschine erstellt wurde,
		 * muss diese der Maschinenentwurfs-Liste des PanelManagers hinzugefügt werden.
		 */
		btn_maschine.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Maschine m;
				if(chb_abhaengigkeit.isSelected()) {
					// Verwerter
					m = new Verwerter(tf_maschinenName.getText(),
							Double.parseDouble(tf_maschinenKosten.getText()),
							Integer.parseInt(tf_anzahlBedingungen.getText()),
							panelManager.getProduktEntwuerfe().get(cb_erzeugnisliste.getSelectedIndex()),
							panelManager.getProduktEntwuerfe().get(cb_bedingungsliste.getSelectedIndex())
					);
				} else {
					// Erzeuger
					m = new Erzeuger(tf_maschinenName.getText(),
							Double.parseDouble(tf_maschinenKosten.getText()),
							panelManager.getProduktEntwuerfe().get(cb_erzeugnisliste.getSelectedIndex())
					);
				}
				
				panelManager.addOrReplaceMaschinenentwurf(m);
			}
		});
		
		/**
		 * Beachten Sie im Falle des Teststarts,
		 * dass die Anzahl der Testrunden aus dem dafür
		 * vorgesehenen Textfeld entnommen werden muss. 
		 */
		btn_fabrikStart.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelManager.startFabrik(Integer.parseInt(tf_anzahlTestrunden.getText()));
			}
		});
		
		btn_fabrikReset.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelManager.resetFabrik();
			}
		});
		
	}
	
	/**
	 * Hier müssen die JComboBoxen entleert und mit den Namen aller Produktentwürfe neu befüllt werden.
	 * Nutzen Sie dafür die Methode addItem(String item). Anschließend soll das JLabel für den Betrag
	 * des Testguthabens auf das aktuelle Testguthaben gesetzt werden.
	 */
	public void updateData() {
		// ComboBoxen leeren
		cb_bedingungsliste.removeAllItems();
		cb_erzeugnisliste.removeAllItems();
		
		// ComboBoxen neu fuellen
		for(Produkt p : panelManager.getProduktEntwuerfe()) {
			cb_bedingungsliste.addItem(p.getName());
			cb_erzeugnisliste.addItem(p.getName());
		}
		
		// Testguthaben setzen
		l_testguthaben.setText(panelManager.getTestguthaben() + " €");
	}
	
	
}
