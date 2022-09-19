package views;

import autre.ButtonInfo;
import dao.DirecteurDAO;
import models.EDT;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * cette classe permet la creation d'emplois du temps (EDT)
 */
public class CreateEDTPage extends javax.swing.JPanel {

    /**
     * cette methode permet d'initialiser les composants
     */
    public CreateEDTPage() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void initComponents() {

        JPanel jPanel1 = new JPanel();
        JPanel jPanel2 = new JPanel();
        JPanel jPanel4 = new JPanel();
        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel();
        JLabel jLabel4 = new JLabel();
        JLabel jLabel5 = new JLabel();
        JLabel jLabel6 = new JLabel();
        JLabel jLabel7 = new JLabel();
        JLabel jLabel8 = new JLabel();
        JLabel jLabel9 = new JLabel();
        JLabel jLabel10 = new JLabel();
        titre = new JTextField();
        String[] dayList={"Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi"};
        salle = new JComboBox<>();
        salle.removeAll();
        DirecteurDAO dr = new DirecteurDAO();
        dr.getListSalles().forEach((salle1)->{
            salle.addItem(salle1);
        });

        jour = new JComboBox<>(dayList);
        jour.setBackground(new Color(255, 255, 255));
        heure_debut = new JTextField();
        heure_fin = new JTextField();
        duree = new JTextField();
        type = new JTextField();
        classe = new JTextField();
        prof = new JTextField();
        // Variables declaration - do not modify//GEN-BEGIN:variables
        JButton jButton1 = new JButton();
        JButton jButton2 = new JButton();

        jPanel1.setBackground(new Color(0, 102, 204));

        jLabel1.setFont(new Font("Tahoma", Font.PLAIN, 24)); // NOI18N
        jLabel1.setForeground(new Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("Ajouter un emploi du temps");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new Color(255, 255, 255));
        jPanel2.setBorder(BorderFactory.createTitledBorder(null, "Informations Planning", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 0, 18))); // NOI18N

        jPanel4.setBackground(new Color(153, 204, 255));

        jLabel2.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Jour");

        jour.setFont(new Font("Tahoma", 0, 18)); // NOI18N

        jLabel3.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Heure de debut");

        heure_debut.setFont(new Font("Tahoma", 0, 18)); // NOI18N

        jLabel4.setFont(new Font("Tahoma",0,18));
        jLabel4.setText("Heure de fin");

        heure_fin.setFont(new Font("Tahoma",0,18));

        jLabel5.setFont(new Font("Tahoma",0,18));
        jLabel5.setText("Titre Seance");

        titre.setFont(new Font("Tahoma",0,18));

        jLabel6.setFont(new Font("Tahoma",0,18));
        jLabel6.setText("Duree");

        duree.setFont(new Font("Tahoma",0,18));

        jLabel7.setFont(new Font("Tahoma",0,18));
        jLabel7.setText("Type de seance");

        type.setFont(new Font("Tahoma",0,18));

        jLabel8.setFont(new Font("Tahoma",0,18));
        jLabel8.setText("Salle");

        salle.setFont(new Font("Tahoma",0,18));

        jLabel9.setFont(new Font("Tahoma",0,18));
        jLabel9.setText("Professeur");

        prof.setFont(new Font("Tahoma",0,18));

        jLabel10.setFont(new Font("Tahoma",0,18));
        jLabel10.setText("Classe");

        classe.setFont(new Font("Tahoma",0,18));

        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel9, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jour)
                                        .addComponent(heure_debut)
                                        .addComponent(heure_fin)
                                        .addComponent(titre)
                                        .addComponent(duree)
                                        .addComponent(type)
                                        .addComponent(salle)
                                        .addComponent(prof)
                                        .addComponent(classe))
                                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(heure_debut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(heure_fin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(titre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(duree, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(type, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(salle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(prof, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel10)
                                        .addComponent(classe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jButton1.setBackground(new Color(0, 102, 204));
        jButton1.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setForeground(new Color(255, 255, 255));
        jButton1.setText("Valider");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new Color(0, 153, 204));
        jButton2.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setForeground(new Color(255, 255, 255));
        jButton2.setText("Effacer");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        salle.addActionListener(this::button1ActionPerformed);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 271, Short.MAX_VALUE)
                                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
                                .addContainerGap())
        );
    }

    private void jButton1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(heure_debut.getText().equals("") || heure_fin.getText().equals("") || titre.getText().equals("") || duree.getText().equals("") || type.getText().equals("") || prof.getText().equals("") || classe.getText().equals("")){
            ButtonInfo bi = new ButtonInfo(new JFrame(), true);
            bi.pan.setBackground(Color.red);
            bi.titre1.setText("Erreur de champs vides");
            bi.titre2.setText("Tous les champs doivent être remplis");
            bi.titre3.setText("");
            bi.setVisible(true);
        }else{
            EDT edt = new EDT(titre.getText(),duree.getText(), Objects.requireNonNull(jour.getSelectedItem()).toString(),Objects.requireNonNull(salle.getSelectedItem()).toString(),classe.getText(),heure_debut.getText(),heure_fin.getText(),prof.getText(),type.getText());
            DirecteurDAO directeur = new DirecteurDAO();
            directeur.ajouterEDT(edt);
            titre.setText("");
            duree.setText("");
            classe.setText("");
            heure_debut.setText("");
            heure_fin.setText("");
            prof.setText("");
            type.setText("");
        }
    }
    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add handling code here:
    }

    private void jButton2ActionPerformed(ActionEvent evt) {
        heure_debut.setText("");
        heure_fin.setText("");
        titre.setText("");
        duree.setText("");
        classe.setText("");
        prof.setText("");
        type.setText("");
    }


    private javax.swing.JTextField heure_fin;
    private javax.swing.JTextField heure_debut;
    private JComboBox<String> jour;
    private javax.swing.JTextField titre;
    private javax.swing.JTextField type;
    private javax.swing.JTextField duree;
    private JComboBox<Object> salle;
    private javax.swing.JTextField prof;
    private javax.swing.JTextField classe;

}