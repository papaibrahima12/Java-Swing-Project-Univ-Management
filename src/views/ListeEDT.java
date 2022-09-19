package views;

import autre.*;
import dao.AdminDAO;
import dao.DirecteurDAO;
import models.EDT;
import stockage.BD;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Cette classe permet d'afficher la liste des EDT avec possibilité de modifier
 * */
public class ListeEDT extends javax.swing.JPanel{
    /**
     * Il contient une constructeur sans argument .
     * */
    public ListeEDT() {
        initComponents();
        InitEDT();
    }
/**
 * La methode InitSalle permet initialiser notre JPanel .
 * */
    /**
     * Les elemenents du tableau sera centrer a creant notre propre model de column, grace
     * a ces methode getColum qui recupère les column donnée en argument et la méthode setCellRender
     * qui prend en argument un Renderer ici un objet de notre class CellCenter hérité
     * de la class DefaultTableCellRenderer qui nous permet de centrer nos eléments
     */

    public void InitEDT() {
        String[] entete = { "ID", "Cours", "Duree","Jour","Salle", "Classe","Heure Debut","Heure Fin","Prof","Type","Modifier","Supprimer" };
        String req = "SELECT * FROM seances ORDER BY id ASC";
        Table table = new Table(entete,entete.length,10,req);
        JTable tab = table.getTable();
        TableColumnModel modele = tab.getColumnModel();
        modele.getColumn(0).setCellRenderer(new CellCenter());
        modele.getColumn(1).setCellRenderer(new CellCenter());
        modele.getColumn(2).setCellRenderer(new CellCenter());
        modele.getColumn(3).setCellRenderer(new CellCenter());
        modele.getColumn(4).setCellRenderer(new CellCenter());
        modele.getColumn(5).setCellRenderer(new CellCenter());
        modele.getColumn(6).setCellRenderer(new CellCenter());
        modele.getColumn(7).setCellRenderer(new CellCenter());
        modele.getColumn(8).setCellRenderer(new CellCenter());
        modele.getColumn(9).setCellRenderer(new CellCenter());

        modele.getColumn(10).setCellRenderer(new ButtonEdit());
        modele.getColumn(10).setCellEditor(new ListeEDT.CellEditorEdit(new JCheckBox()));
        modele.getColumn(11).setCellRenderer(new ButtonDelete());
        modele.getColumn(11).setCellEditor(new ListeEDT.CellEditorDelete(new JCheckBox()));
        /**
         * Grace a la méthode setCellRenderer de la class TableColumnModel on a pu
         * ajouter des boutons dans notre tableau . Il prend en argument le bouton à ajouter
         * qui  doit implementer l'interface TableCellRenderer ici not deux classes implementant
         * l'interface sont ButtonEdit et ButtonDelete .
         * Pour rendre nos boutons ainsi crées à répondre au évenement la méthode setCellEditor
         * est utilisée il prend en argument un cellEditor .
         * */
        JScrollPane pan = table.getPane(content.getWidth());
        content.removeAll();
        content.setLayout(new BorderLayout());
        content.add(pan);
        content.revalidate();
    }
    /**
     * La class CellEditorEdit herite de la class DefaultCellEditor est une class interne
     * dans la class ListeEDT nous permet de crée un bouton  qui nous permet de modifier
     * les enregistrements sur la table seances . Ce bouton sera ajouté sur chaque ligne
     * de notre Liste des edt pour la modification de la ligne concernée . Il contient 6 variables de
     * champs :
     * 		+ Un variable de type JButton qui sera notre bouton,
     * 		+ Un variable de type String qui represente le label qui se trouve sur notre bouton,
     * 		+ UN variable de type boolean qui vas rendre cliquable ou non notre bouton,
     * 		+ Deux variables de type int qui representent les index de colonne et de la ligne
     * 		+ Un JTable
     *
     * */
    public class CellEditorEdit extends DefaultCellEditor {
        private JButton button;
        private String label;
        private boolean clicked;
        private int row;
        private JTable table;

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
            button.setForeground(Color.black);
            button.setBackground(Color.red);
            // button.setIcon(new
            // javax.swing.ImageIcon(getClass().getResource("/img/ico-edit.png")));
            label = (value == null) ? "" : value.toString();
            // button.setText(label);
            clicked = true;
            return button;
        }

        public Object getCellEditorValue() {
            if (clicked) {
                // Action au clic de la souris
                edit(Integer.parseInt(table.getValueAt(row, 0).toString()));
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

    public class CellEditorDelete extends DefaultCellEditor {
        private final JButton button;
        private String label;
        private boolean clicked;
        private int row;
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

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            this.table = table;
            this.row = row;
            button.setForeground(Color.black);
            button.setBackground(Color.red);
            // button.setIcon(new
            // javax.swing.ImageIcon(getClass().getResource("/images/ico-delete.png")));
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            clicked = true;
            return button;
        }

        public Object getCellEditorValue() {
            if (clicked) {
                // Action au clic de la souris
                deleteEDT(Integer.parseInt(table.getValueAt(row, 0).toString()) );
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

    public void edit(int str) {
        // traitements
        EDTedit ae = new EDTedit(new JFrame(), true, str, this);
        ae.setVisible(true);
    }
    public void deleteEDT(int id) {
        Connection conn = BD.GetConnection();
        try {
            Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stm.executeQuery("SELECT * FROM seances WHERE id = \"" + id +"\"");
            rs.first();
            String cours = rs.getString("titreCours");
            String duree = rs.getString("duree");
            String jour=rs.getString("jour");
            String  salle=rs.getString("salle");
            String  classe=rs.getString("classe");
            String heure_debut=rs.getString("heureDebut");
            String heure_fin=rs.getString("heureFin");
            String prof=rs.getString("prof");
            String type=rs.getString("type");
            UI ui = new UI();
            ui.SetRed();
            int valid = JOptionPane.showOptionDialog(
                    null,
                    new Object[] {
                            "Voulez-vous vraiment supprimer l'emploi du temps ?",
                            id + " du " + jour,
                            "____________________________________________________",
                            "Cette opération est irreversible",
                            "____________________________________________________",
                            "Cliquez sur \"OUI\" pour valider ou sur \"NON\" pour annuler"
                    },
                    "Suppression de l'EDT " + id + " du " + jour,
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null,
                    null,
                    "OK");
            ui.ResetUI();
            if (valid == JOptionPane.OK_OPTION) {
                EDT edt = new EDT(id,cours,duree,jour,salle,classe,heure_debut,heure_fin,prof,type);
                DirecteurDAO directeur = new DirecteurDAO();
                directeur.supprimerEDT(edt);
                this.InitEDT();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }




    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed"desc="GeneratedCode">//
    // GEN-BEGIN:initComponents
    /**
     * La methode initComponents qui n'a pas d'argument permet d'initialiser notre JPanel
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
        jLabel1.setText("Liste des emplois du temps");

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
