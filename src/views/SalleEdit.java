package views;

import java.awt.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import dao.AdminDAO;
import models.Salle;
import stockage.BD;
import autre.ButtonInfo;

import java.awt.event.ActionEvent;

/**
 * La class SalleEdit hérite de la classe JDialog , est une classe qui permet de modifier un salle
 * */
public class SalleEdit extends javax.swing.JDialog {

    int id;
    ListeSalles liste;
    String [] types = {"Conference","Cours","TD","TP"};

    /**
 * Son contructeur contient 4 arguments : une frame qui sera la fenetre ouvourira notre 
 * boite de dialogue
 * , un variable boolean , un entier qui
 * correspond à l'id de la salle et la liste des salles .
 * */
    public SalleEdit(Frame parent, boolean modal, int str, ListeSalles liste1) {
        super(parent, modal);
        this.id = str;
        this.liste = liste1;
        
        initComponents();
        initSalle();
        this.setResizable(false);
        // this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/GE-logo.png")));
        this.setLocationRelativeTo(null);
    }

    /**
 * la méthode initSalle() permet de recuperer les valeurs avant modifications de l'enregistrement concerné
 * et de les affiche dans la boite de dialogue salleEdit
 * */
    public void initSalle() {
        Connection conn = BD.GetConnection();//connexion a la basse de donnée
        try {
        	//creation du statement
            Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //excution de la requette selection
            ResultSet rs = stm.executeQuery("SELECT * FROM salles WHERE id = \""+ id +"\"");
            rs.first();
            titre.setText("Modification de Salle " + rs.getString("nom") );
            nom.setText(rs.getString("nom"));
            capacite.setText(rs.getString("capacity"));
           
        } catch (SQLException ex) {
            Logger.getLogger(SalleEdit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    
    /**
     * La methode initComponents permet dinitialiser notre fenetre , il ne prend aucun 
     * argument
     * 
     * */
    private void initComponents() {

        JPanel jPanel1 = new JPanel();
        titre = new JLabel();
        JPanel jPanel2 = new JPanel();
        JLabel jLabel2 = new JLabel();
        nom = new JTextField();
        JLabel jLabel3 = new JLabel();
        capacite = new JTextField();
        JLabel jLabel4 = new JLabel();
        JLabel jLabel5 = new JLabel();
        /**
         * @param args the command line arguments
         */
        // Variables declaration - do not modify//GEN-BEGIN:variables
        JButton jButton1 = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));

        titre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        titre.setForeground(new java.awt.Color(255, 255, 255));
        titre.setText("Utilisateur");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(titre, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap()));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(titre)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Nom de salle");

        nom.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("capacite");

        capacite.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("projecteur");

        String [] isExist = {"OUI","NON"};
        projecteur = new JComboBox<>(isExist);
        projecteur.addActionListener(this::jcomboActionPerformed);
        projecteur.setFont(new Font("Tahoma", Font.BOLD, 15));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Type");

        type = new JComboBox<>(types);
        type.setFont(new Font("Tahoma", 0, 18)); // NOI18N

        jButton1.setBackground(new java.awt.Color(0, 102, 204));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Modifier");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });


        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(nom, 364, 364, 364))
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(capacite, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE))
        				.addGroup(Alignment.LEADING, jPanel2Layout.createSequentialGroup()
        					.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(projecteur))
                        .addGroup(Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(ComponentPlacement.UNRELATED)
                            .addComponent(type))
        				.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel2)
        				.addComponent(nom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel3)
        				.addComponent(capacite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel4)
        				.addComponent(projecteur))
                    .addGap(18)
                    .addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(type))
        			.addPreferredGap(ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
        			.addComponent(jButton1)
        			.addContainerGap())
        );
        jPanel2.setLayout(jPanel2Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
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

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
 * La méthode  jButton1ActionPerformed qui prend en argument un evenement de type
 * ActionEvent est appellé lorsqu'on fait une clic sur la boutton modifier . Ce qui veut
 * dire que cette méthode permet de faire l'opperation de modification d'un salle .Il
 * fait appelle a la méthode modifierSalle qui se trouve dans la class Admin . 
 * 
 * */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if ( nom.getText().equals("") ||capacite.getText().equals("")) {
            ButtonInfo bi = new ButtonInfo(new JFrame(), true);
            bi.pan.setBackground(Color.red);
            bi.titre1.setText("Erreur");
            bi.titre2.setText("Tous les champs doivent être remplis");
            bi.titre3.setText("");
            bi.setVisible(true);
        } else {
            Salle salle = new Salle(id,nom.getText(),Integer.parseInt(capacite.getText()), Objects.requireNonNull(projecteur.getSelectedItem()).toString(), Objects.requireNonNull(type.getSelectedItem()).toString());
            AdminDAO ad = new AdminDAO();
            ad.modifierSalle(salle);
            this.dispose();
            liste.initSalle();
        }
    }// GEN-LAST:event_jButton1ActionPerformed
/**
 * La méthode jcomboActionPerformed qui prend en argument une variable de type ActionEvent
 * est appellé sur l'action du jcomboButton.
 * */
    public void jcomboActionPerformed(ActionEvent e) {

	}

    private javax.swing.JTextField nom;
    private javax.swing.JTextField capacite;
    private JComboBox type;
    private JComboBox<String> projecteur;
    private javax.swing.JLabel titre;
}
