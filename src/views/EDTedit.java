package views;

import dao.DirecteurDAO;
import models.EDT;
import stockage.BD;
import autre.ButtonInfo;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Cette classe permet de modifier un EDT precis
 */
/**
 * La class SalleEdit héhiter de la classe JDialog , est un class qui permet de modifier un salle
 * grace a ces variables de champs , methode et constructeur .
 * */
public class EDTedit extends javax.swing.JDialog {

    /**
     * Creates new form AdminEdit
     */
    int id;//identificateur
    ListeEDT liste;//liste des edt ou sera effectuée les modifications
    /**
     * Son contructeur contient 4 arguments : une frame qui sera la fenetre ouvourira notre
     * boite de dialogue
     * , un variable boolean , un entier qui
     * correspond au identificateur du salle et la liste des salles .
     * */
    public EDTedit(Frame parent, boolean modal, int str, ListeEDT liste) {
        super(parent, modal);
        this.id = str;
        this.liste = liste;

        initComponents();
        InitEDT();
        this.setResizable(false);
        // this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/GE-logo.png")));
        this.setLocationRelativeTo(null);
    }
    /**
     * la méthode InitSalle permet de recuperer les valeurs avant modifications de l'enregistrement
     * conserner par la modificateur  et de les afficher dans la boite de dialogue salleEdit
     * */
    public void InitEDT() {
        //connexion a la basse de donnée
        try {
            Connection conn = BD.GetConnection();
            //creation du statement
            Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //excution de la requette selection
           ResultSet rs = stm.executeQuery("SELECT * FROM seances WHERE id =  \"" + id + "\"");
            rs.first();
            titre.setText("Modification de l'emploi du temps " + rs.getString("id") );
            jour.setText(rs.getString("jour"));
            matiere.setText(rs.getString("titreCours"));
            duree.setText(rs.getString("duree"));
            heure_debut.setText(rs.getString("heureDebut"));
            heure_fin.setText(rs.getString("heureFin"));
            salle.setText(rs.getString("salle"));
            classe.setText(rs.getString("classe"));

        } catch (SQLException ex) {
            Logger.getLogger(EDTedit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initComponents() {

        JPanel jPanel1 = new JPanel();
        JPanel jPanel2 = new JPanel();
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel();
        JLabel jLabel4 = new JLabel();
        JLabel jLabel5 = new JLabel();
        JLabel jLabel6 = new JLabel();
        JLabel jLabel7 = new JLabel();
        JLabel jLabel8 = new JLabel();
        titre = new javax.swing.JLabel();
        jour = new javax.swing.JTextField();
        matiere = new javax.swing.JTextField();
        duree = new javax.swing.JTextField();
        heure_debut = new JTextField();
        heure_fin = new JTextField();
        salle = new JTextField();
        classe = new JTextField();

        JButton jButton1 = new JButton();
        /**
         * La méthode jradioActionPerformed qui prend en argument un variable de type ActionEvent
         * est appellé sur l'action du jRadioButton pour determiner la valeur du variable de champ
         * choix de type boolean .
         * */
        /**
         * @param args the command line arguments
         */
        // Variables declaration - do not modify//GEN-BEGIN:variables

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));

        titre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        titre.setForeground(new java.awt.Color(255, 255, 255));
        titre.setText("EDT");

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
        jLabel2.setText("Jour");

        jour.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("TitreCours");

        matiere.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Duree");

        duree.setFont(new Font("Tahoma",0,18));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Heure de debut");

        heure_debut.setFont(new Font("Tahoma",0,18));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Heure de fin");

        heure_fin.setFont(new Font("Tahoma",0,18));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Salle");

        salle.setFont(new Font("Tahoma",0,18));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Classe");

        classe.setFont(new Font("Tahoma",0,18));

        jButton1.setBackground(new java.awt.Color(0, 102, 204));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Modifier");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(jour, 364, 364, 364))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(matiere, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(duree, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(heure_debut, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(heure_fin, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(salle, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(classe, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE))
                                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(matiere, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(duree, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(heure_debut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(heure_fin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(salle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(classe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addContainerGap())
        );
        jPanel2.setLayout(jPanel2Layout);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    }
    /**
     * La méthode  jButton1ActionPerformed qui prend en argument un evenement de type
     * ActionEvent est appellé lorsqu'on fait une clic sur la boutton modifier . Ce qui veut
     * dire que cette méthode permet de faire l'opperation de modification d'un EDT .Il
     * fait appelle a la méthode modifierEDT qui se trouve dans la class DirecteurDAO .
     *
     * */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if ( jour.getText().equals("") ||matiere.getText().equals("") || duree.getText().equals("")) {
            ButtonInfo bi = new ButtonInfo(new JFrame(), true);
            bi.pan.setBackground(Color.red);
            bi.titre1.setText("Erreur");
            bi.titre2.setText("Tous les champs doivent être remplis");
            bi.titre3.setText("");
            bi.setVisible(true);
        } else {
            EDT edt = new EDT(id,matiere.getText(),duree.getText(),jour.getText(),heure_debut.getText(),heure_fin.getText(),salle.getText(),classe.getText());
            DirecteurDAO directeur = new DirecteurDAO();
            directeur.modifierEDT(edt);
            this.dispose();
            liste.InitEDT();
        }
    }

    private JTextField jour;
    private JTextField matiere;
    private JTextField duree;
    private JTextField salle;
    private JTextField classe;
    private JTextField heure_debut;
    private JTextField heure_fin;
    private JLabel titre;
}
