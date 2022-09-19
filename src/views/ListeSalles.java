package views;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;
import dao.AdminDAO;
import stockage.BD;
import autre.ButtonDelete;
import autre.ButtonEdit;
import autre.CellCenter;

/**
 * La class ListeSalles herite de la class JPanel n'a aucun variable de champs
 * Cette classe permet d'afficher la liste des salles
 * */
public class ListeSalles extends javax.swing.JPanel {

    /**
     * Il contient une constructeur sans argument .
     * */
    public ListeSalles() {
        initComponents();
        initSalle();
    }
/**
 * La methode InitSalle permet initialiser notre JPanel .
 * */
    /**
     * Les elements du tableau seront centrer en creant notre propre model de column, grace
     * a ces methode getColum qui recupère les column donnée en argument et la méthode setCellRender
     * qui prend en argument un Renderer ici un objet de notre class CellCenter hérité
     * de la class DefaultTableCellRenderer qui nous permet de centrer nos eléments
    */

    public void initSalle() {
        String[] entete = { "ID Salle", "Nom Salle", "Projecteur existant", "Capacite","Occupation","Type","Modifier", "Supprimer" };
        String req = "SELECT * FROM salles ORDER BY id ASC";
        Table table = new Table(entete,entete.length,6,req);
        JTable tab = table.getTable();
        TableColumnModel modele = tab.getColumnModel();
        modele.getColumn(0).setCellRenderer(new CellCenter());
        modele.getColumn(1).setCellRenderer(new CellCenter());
        modele.getColumn(2).setCellRenderer(new CellCenter());
        modele.getColumn(3).setCellRenderer(new CellCenter());
        modele.getColumn(4).setCellRenderer(new CellCenter());
        modele.getColumn(5).setCellRenderer(new CellCenter());
        /**
         * Grace a la méthode setCellRenderer de la class TableColumnModel on a pu
         * ajouter des boutons dans notre tableau . Il prend en argument le button a ajouter
         * qui  doit implementer l'interface TableCellRenderer ici nos deux classes implementant
         * l'interface sont ButtonEdit et ButtonDelete .
         * Pour rendre nos boutons ainsi créé a répondre au évenement la méthode setCellEditor
         * est utilisée elle prend en argument un cellEditor .
         * */
        modele.getColumn(6).setCellRenderer(new ButtonEdit());
        modele.getColumn(6).setCellEditor(new CellEditorEdit(new JCheckBox()));
        modele.getColumn(7).setCellRenderer(new ButtonDelete());
        modele.getColumn(7).setCellEditor(new CellEditorDelete(new JCheckBox()));
        JScrollPane pan = table.getPane(content.getWidth());
        content.removeAll();
        content.setLayout(new BorderLayout());
        content.add(pan);
        content.revalidate();
    }
/**
 * La class CellEditorEdit heriter de la class DefaultCellEditor est un class interne
 * dans la class ListeSalles nous permet de crée un boutton  qui nous permet de modifier
 * les enregistrements sur la table salle . Cette boutton sera ajouter sur chaque ligne
 * de notre Liste des salle pour la modification du ligne conserner . Il contient 6 variables de
 * champs : 
 * 		+ Un variable de type JButton qui sera notre boutton,
 * 		+ Un variable de type String qui represente le label qui se trouve sur notre boutton,
 * 		+ UN variable de type boolean qui vas rendre cliquable ou nom notre boutton,
 * 		+ Deux variables de type int qui reprente index de colonne et de la ligne
 * 		+ Un JTable 
 *  
 * */
    public class CellEditorEdit extends DefaultCellEditor {
        private JButton button;
        private String label;
        private boolean clicked;
        private int row, col;
        private JTable table;
/**
 * Il exite un seul constructeur pour cette class qui prend en argument un JCheckBox
 * */
        public CellEditorEdit(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.setForeground(Color.black);
            button.setBackground(Color.red);
            // button.setIcon(new
            // javax.swing.ImageIcon(getClass().getResource("/images/wn.png")));

            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
                int column) {
            this.table = table;
            this.row = row;
            this.col = column;
            button.setForeground(Color.black);
            button.setBackground(Color.red);
           // button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico-edit.png")));
            label = (value == null) ? "" : value.toString();
            // button.setText(label);
            clicked = true;
            return button;
        }
 /** L'evenement de modification est appelee dans la méthode getCellEditorValue .*/
        public Object getCellEditorValue() {
            if (clicked) {
                // Action au clic de la souris
                edit(Integer.parseInt(table.getValueAt(row, 0).toString()) );
            }
            clicked = false;
            return label;
        }

        public boolean stopCellEditing() {
            clicked = false;
            return super.stopCellEditing();
        }

        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }
/**
 * Il a n'est de meme pour la class CellEditorDelete
 * */
    public class CellEditorDelete extends DefaultCellEditor {
        private final JButton button;
        private String label;
        private boolean clicked;
        private int row, col;
        private JTable table;

        public CellEditorDelete(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.setForeground(Color.black);
            button.setBackground(Color.red);
            // button.setIcon(new
            // javax.swing.ImageIcon(getClass().getResource("/images/wn.png")));
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
                int column) {
            this.table = table;
            this.row = row;
            this.col = column;
            button.setForeground(Color.black);
            button.setBackground(Color.red);
           // button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ico-delete.png")));
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            clicked = true;
            return button;
        }
/**
 * L'evenement de suppression est appelée dans la méthode getCellEditorValue .
 * */
        public Object getCellEditorValue() {
            if (clicked) {
                // Action au clic de la souris
                delete(Integer.parseInt(table.getValueAt(row, 0).toString()) );
            }
            clicked = false;
            return new String(label);
        }

        public boolean stopCellEditing() {
            clicked = false;
            return super.stopCellEditing();
        }

        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }
/**
 * La methode Edit qui prend en argument un entier permet de modifier les informations 
 * un enregistrement . Il est appelé lors du clic sur la boutton édit .
 * 
 * */
    public void edit(int str) {
        // traitements
        SalleEdit ae = new SalleEdit(new JFrame(), true, str, this);
        ae.setVisible(true);
    }
/**
 * La methode qui prend en argument un entier permet de supprimer un enregistrement
 * dont son identificateur est donné en paramettre .Cette method est appeler lors du clic
 * sur le boutton delete .
 * */
    	public void delete(int idSalle) {
    		Connection conn = BD.GetConnection();
    		try {
    			Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
    			ResultSet rs = stm.executeQuery("SELECT * FROM salles WHERE id = \"" + idSalle
    			+ "\"");
    			rs.first();
     			String nom = rs.getString("nom");
     			int capacite = rs.getInt("capacity");
     			UI ui = new UI();
     			ui.SetRed();
     			int valid = JOptionPane.showOptionDialog(
    		 	null,
     			new Object[] {
    		 		"Voulez-vous vraiment supprimer cette salle ?",
     				nom + " " + capacite,
     				"____________________________________________________",
     				"Cette opération est irreversible",
     				"____________________________________________________",
     				"Cliquez sur \"OUI\" pour valider ou sur \"NON\" pour annuler"
     			},
     			"Suppression de la salle " + nom + " " + capacite,
     			JOptionPane.YES_NO_OPTION,
     			JOptionPane.WARNING_MESSAGE,
     			null,
     			null,
    		 	"OK");
     			ui.ResetUI();
     			if (valid == JOptionPane.OK_OPTION) {
    	 			AdminDAO ad = new AdminDAO(idSalle);
     				ad.supprimerSalle(idSalle);
     				this.initSalle();
     			}
    		} catch (SQLException ex) {
    			Logger.getLogger(ListeSalles.class.getName()).log(Level.SEVERE, null, ex);
     	}
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed"desc="GeneratedCode">//
    // GEN-BEGIN:initComponents
    /**
     * La methode initComponents qui n'a pas argument permet d'initialiser notre JPanl
     * */

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel1.setForeground(new Color(255, 255, 255));
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        content = new javax.swing.JPanel();

        jPanel1.setBackground(new Color(0, 0, 128));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Liste des Salles de cours et TD/TP");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 675,
                                        Short.MAX_VALUE)
                                .addContainerGap()));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                jPanel1Layout.createSequentialGroup()
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1)
                                        .addContainerGap()));

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
                contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE));
        contentLayout.setVerticalGroup(
                contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 393, Short.MAX_VALUE));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap()));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap()));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel content;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

}
