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
import models.Admin;
import stockage.BD;
import autre.ButtonDelete;
import autre.ButtonEdit;
import autre.CellCenter;

/**
 * cette classe permet d'afficher la liste des utilisateurs et les modifier
 */
public class ListUser extends javax.swing.JPanel {

    /**
     * Creates new form AdminList
     */
    public ListUser() {
        initComponents();
        InitAdmin();
    }

    public void InitAdmin() {
        String[] entete = { "ID", "Nom", "Prénom","Login","Role","Telephone","Mot de Passe", "Modifier", "Supprimer" };
        String req = "SELECT * FROM users ORDER BY id ASC";
        Table table = new Table(entete, entete.length, 7, req);

        JTable tab = table.getTable();
        TableColumnModel modele = tab.getColumnModel();
        modele.getColumn(0).setCellRenderer(new CellCenter());
        modele.getColumn(1).setCellRenderer(new CellCenter());
        modele.getColumn(2).setCellRenderer(new CellCenter());
        modele.getColumn(3).setCellRenderer(new CellCenter());
        modele.getColumn(4).setCellRenderer(new CellCenter());
        modele.getColumn(5).setCellRenderer(new CellCenter());
        modele.getColumn(6).setCellRenderer(new CellCenter());

        modele.getColumn(7).setCellRenderer(new ButtonEdit());
        modele.getColumn(7).setCellEditor(new CellEditorEdit(new JCheckBox()));
        modele.getColumn(8).setCellRenderer(new ButtonDelete());
        modele.getColumn(8).setCellEditor(new CellEditorDelete(new JCheckBox()));
        JScrollPane pan = table.getPane(content.getWidth());
        content.removeAll();
        content.setLayout(new BorderLayout());
        content.add(pan);
        content.revalidate();
    }

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

    public class CellEditorDelete extends DefaultCellEditor {
        private JButton button;
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

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
                int column) {
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
                delete(Integer.parseInt(table.getValueAt(row, 0).toString()) );
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
        AdminEdit ae = new AdminEdit(new JFrame(), true, str, this);
        ae.setVisible(true);
    }

    public void delete(int id) {
        Connection conn = BD.GetConnection();
        try {
            Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stm.executeQuery("SELECT * FROM users WHERE id = \"" + id +"\"");
            rs.first();
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            String role=rs.getString("login");
            String  login=rs.getString("role");
            String  tel=rs.getString("telephone");
            String mdp=rs.getString("password");
            UI ui = new UI();
            ui.SetRed();
            int valid = JOptionPane.showOptionDialog(
                    null,
                    new Object[] {
                            "Voulez-vous vraiment supprimer cet utilisateur ?",
                            nom + " " + prenom,
                            "____________________________________________________",
                            "Cette opération est irreversible",
                            "____________________________________________________",
                            "Cliquez sur \"OUI\" pour valider ou sur \"NON\" pour annuler"
                    },
                    "Suppression de l'utilisateur " + nom + " " + prenom,
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null,
                    null,
                    "OK");
            ui.ResetUI();
            if (valid == JOptionPane.OK_OPTION) {
                AdminDAO ad = new AdminDAO(id,prenom,nom,role,login,mdp);
                ad.supprimerUser(id);
                this.InitAdmin();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListUser.class.getName()).log(Level.SEVERE, null, ex);
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

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        content = new javax.swing.JPanel();

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Liste des Utilisateurs");

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
