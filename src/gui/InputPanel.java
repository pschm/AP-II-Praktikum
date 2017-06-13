package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial") // TODO Why?
public class InputPanel extends JPanel {

	private PanelManager panelManager;
	
	// JLabel
	private JLabel l_produktName;
	private JLabel l_produktKosten;
	private JLabel l_produktVerkaufswert;
	private JLabel l_maschinenName;
	private JLabel l_maschinenKosten;
	private JLabel l_maschinenErzeugnis;
	private JLabel l_anzahlBedingungen;
	private JLabel l_testguthaben;
	private JLabel l_testguthabenBeschreibung;
	private JLabel l_anzahlTestrunden;
	
	// JLabel (Überschriften)
	private JLabel l_ueberschriftProdukte    = new JLabel("Produkt");
	private JLabel l_ueberschriftMaschine    = new JLabel("Maschine");
	private JLabel l_ueberschriftFabriktests = new JLabel("Fabriktests");
	
	// JTextfield
	private JTextField tf_produktName;
	private JTextField tf_produktKosten;
	private JTextField tf_produktVerkaufswert;
	private JTextField tf_maschinenName;
	private JTextField tf_maschinenKosten;
	private JTextField tf_anzahlBedingungen;
	private JTextField tf_anzahlTestrunden;
	
	// JComboBox
	private JComboBox <String> cb_erzeugnisliste;
	private JComboBox <String> cb_bedingungsliste;
	
	// JCheckBox
	private JCheckBox chb_abhaengigkeit;
	
	// JButton
	private JButton btn_produkt  = new JButton("Produkt anlegen");
	private JButton btn_maschine = new JButton("Maschine anlegen");
	private JButton btn_fabrikStart;
	private JButton btn_fabrikReset;
	
	
	public InputPanel(PanelManager panelManager) {
		this.panelManager = panelManager;
		
		buildGui();
	}
	
	/**
	 * Methode zur erstellung der GUI
	 */
	private void buildGui() {
		/**
		 * Fügen Sie dem JButton zum Anlegen eines Produkts einen ActionListener hinzu.
		 * Wird auf diesen gedrückt, so soll mithilfe der Textfeldeingaben
		 * (Produktname, Produktkosten, Verkaufskosten des Produkts) ein neues Produkt erstellt,
		 * sowie der Liste mit Produktentwürfen (im PanelManager) hinzugefügt werden.
		 */	
		btn_produkt.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 
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
				// TODO
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
				panelManager.start();	
				// TODO s.o.
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
		// TODO
	}
	
	
}
