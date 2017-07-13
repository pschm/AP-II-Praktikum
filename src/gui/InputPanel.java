package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.DoubleConsumer;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import app.AblaufComparator;
import app.Erzeuger;
import app.Maschine;
import app.NameComparator;
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
	private JLabel l_testguthaben             = new JLabel("0.0 �");
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
	private JButton btn_sortName    = new JButton("Fabrik sortieren (Namen)");
	private JButton btn_sortAblauf  = new JButton("Fabrik sortieren (Ablauf)");
	private JButton btn_fabrikStart = new JButton("Test starten");
	private JButton btn_fabrikReset = new JButton("Fabrik zur�cksetzen");
	//private JButton btn_removeerz1	= new JButton("Remove erz1");

	public InputPanel(PanelManager panelManager) {
		this.panelManager = panelManager;
		buildGui();
	}

	/**
	 * Methode zur erstellung der GUI
	 */
	private void buildGui() {

		// --- Layout ---
		setLayout(new GridLayout(18, 2));

		// Produkt
		add(l_ueberschriftProdukte);
		add(new JLabel(" "));
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
		//add(btn_removeerz1);
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
		add(btn_sortName);
		add(btn_sortAblauf);
		add(btn_fabrikReset);
		add(btn_fabrikStart);


		// --- ActionListener f�r alle Buttons ---
		/**
		 * F�gen Sie dem JButton zum Anlegen eines Produkts einen ActionListener hinzu.
		 * Wird auf diesen gedr�ckt, so soll mithilfe der Textfeldeingaben
		 * (Produktname, Produktkosten, Verkaufskosten des Produkts) ein neues Produkt erstellt,
		 * sowie der Liste mit Produktentw�rfen (im PanelManager) hinzugef�gt werden.
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

				if(m instanceof Erzeuger) System.out.println("Ein Erzeuger wurde ERSTELLT !!");
				if(m instanceof Verwerter) System.out.println("Ein Verwerter wurde ERSTELLT !!");
				System.out.println(m.toString() + " (InputPanel)");

				panelManager.addOrReplaceMaschinenentwurf(m);
				//System.out.println(panelManager.getMaschinenEntwuerfe().get(0).toString() + " (Inputpanel 2)");
			}
		});

		btn_sortName.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelManager.sort(new NameComparator());
			}
		});

		btn_sortAblauf.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelManager.sort(new AblaufComparator());
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
				panelManager.startFabrik(Integer.parseInt(tf_anzahlTestrunden.getText()));
			}
		});

		btn_fabrikReset.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelManager.resetFabrik();
			}
		});

		//		btn_removeerz1.addActionListener( new ActionListener() {
		//			@Override
		//			public void actionPerformed(ActionEvent e) {
		//				panelManager.getAktiveMaschinen().remove(new Erzeuger("erz1", 10.0, new Produkt("t1", 1, 10)));
		//			}
		//		});

		
//		tf_produktName.getDocument().addDocumentListener(new MyDocumentListener());
		
		// ActionListener (DocumentListener)
	}
	
//	class MyDocumentListener implements DocumentListener {
//	    String newline = "\n";
//
//		@Override
//		public void insertUpdate(DocumentEvent e) {
//			// wir aufgerufen, wenn das Textfeld ge�ndert wird.
//			Document d = e.getDocument();
//			//JTextField tf = d.getClass();
//			//JTextField tf = (JTextField) e.getDocument();
//			//tf.setBackground(Color.LIGHT_GRAY);
//		}
//
//		@Override
//		public void removeUpdate(DocumentEvent e) {
//			// TODO Auto-generated method stub
//		}
//
//		@Override
//		public void changedUpdate(DocumentEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//	}

	/**
	 * Hier m�ssen die JComboBoxen entleert und mit den Namen aller Produktentw�rfe neu bef�llt werden.
	 * Nutzen Sie daf�r die Methode addItem(String item). Anschlie�end soll das JLabel f�r den Betrag
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
		l_testguthaben.setText(panelManager.getTestguthaben() + " �");
	}


}
