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
	
	// JLabel (�berschriften)
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
		 * F�gen Sie dem JButton zum Anlegen eines Produkts einen ActionListener hinzu.
		 * Wird auf diesen gedr�ckt, so soll mithilfe der Textfeldeingaben
		 * (Produktname, Produktkosten, Verkaufskosten des Produkts) ein neues Produkt erstellt,
		 * sowie der Liste mit Produktentw�rfen (im PanelManager) hinzugef�gt werden.
		 */	
		btn_produkt.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 
			}
		});
		
		/**
		 * Unterscheiden Sie dabei zwei F�lle:
		 * - CheckBox ausgew�hlt: ein Verwerter wird erstellt
		 * - CheckBox NICHT ausgew�hlt: ein Erzeuger wird erstellt.
		 * F�r die Erstellung ben�tigte Eigenschaften k�nnen aus den jeweiligen Textfeldern entnommen werden.
		 * Die ben�tigten Produkte k�nnen anhand des aktiven Items der JComboBoxen
		 * (der Index des aktiven Items) aus der Produktentwurfs-Liste des PanelManagers entnommen werden.
		 * Nachdem eine neue Instanz der jeweiligen Maschine erstellt wurde,
		 * muss diese der Maschinenentwurfs-Liste des PanelManagers hinzugef�gt werden.
		 */
		btn_maschine.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO
			}
		});
		
		/**
		 * Beachten Sie im Falle des Teststarts,
		 * dass die Anzahl der Testrunden aus dem daf�r
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
	 * Hier m�ssen die JComboBoxen entleert und mit den Namen aller Produktentw�rfe neu bef�llt werden.
	 * Nutzen Sie daf�r die Methode addItem(String item). Anschlie�end soll das JLabel f�r den Betrag
	 * des Testguthabens auf das aktuelle Testguthaben gesetzt werden.
	 */
	public void updateData() {
		// TODO
	}
	
	
}
