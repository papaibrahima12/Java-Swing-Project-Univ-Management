package dao;

import autre.ButtonInfo;
import models.Directeur;
import models.EDT;
import models.Salle;
import stockage.BD;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DirecteurDAO extends Directeur {

    public void ajouterEDT(EDT edt) {
        Connection conn = BD.GetConnection();//connexion a la base de doonée
        try {
            String sql="SELECT * FROM seances WHERE id=?";
            //creation du statement
            PreparedStatement stm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stm.setInt(1, edt.getId());
            //excution de la requette selection
            ResultSet rs = stm.executeQuery();
            /***
             * On test si l' utilisateur ajouté existe deja dans la base de données en se référant sur son login
             * si c'est le cas l'ajout sera rejeté dans le cas contraire l'ajout va reussir
             * */

            if (rs.next()) {
                System.out.println("Cette salle existe dans la base de données. Impossible de l'ajouter");
                //creation d'une objet de notre boite de dialloge
                ButtonInfo bi = new ButtonInfo(new JFrame(), true);
                //on donnne une coleur de font a notre boite de diallogue
                bi.pan.setBackground(Color.red);
                //on ecrit les text suivant sur notre boite de dialogue en cas d'echec  de l'opperation
                bi.titre1.setText("Echec d'enregistrement");
                bi.titre2.setText("Cette salle existe dans la base de donnees. Impossible de l'ajouter");
                bi.titre3.setText("");
                //on rend visible notre boite de dialogue
                bi.setVisible(true);
            } else {
                sql="INSERT INTO seances(id,titreCours,duree,jour,salle,classe,heureDebut,heureFin,prof,type) VALUES(?,?,?,?,?,?,?,?,?,?) ";
                stm = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                stm.setInt(1, edt.getId());
                stm.setString(2, edt.getTitreCours());
                stm.setString(3, edt.getDuree());
                stm.setString(4, edt.getJour());
                stm.setObject(5, edt.getSalle());
                stm.setString(6, edt.getClasse());
                stm.setString(7, edt.getHeure_debut());
                stm.setString(8, edt.getHeure_fin());
                stm.setString(9, edt.getProf());
                stm.setString(  10, edt.getType());
                // insertion
                //excution de la requette insertion
                stm.executeUpdate();
                System.out.println("Emploi du temps ajouté avec Succés ...");
                //creation d'une objet de notre boite de dialloge
                ButtonInfo bi = new ButtonInfo(new JFrame(), true);
                //on donnne une coleur de font a notre boite de diallogue
                bi.pan.setBackground(new Color(47, 149, 116));
                //on ecrit les text suivant sur notre boite de dialogue en cas de reussi  de l'opperation
                bi.titre1.setText("Succés !!");
                bi.titre2.setText("EDT ajouté avec succés ...");
                bi.titre3.setText("");
                //on rend visible notre boite de dialogue
                bi.setVisible(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DirecteurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void supprimerEDT(EDT edt) {
        Connection conn = BD.GetConnection();//connexion a la base de donné
        try {
            String sql="DELETE FROM seances WHERE id = ?";
            //creation du statement
            PreparedStatement stm = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stm.setInt(1,edt.getId());
            //excution du requuette Delete
            stm.executeUpdate();
            System.out.println("EDT supprimé avec Succès ...");
            //creation d'une objet de notre boite de dialloge
            ButtonInfo bi = new ButtonInfo(new JFrame(), true);
            //on donnne une coleur de font a notre boite de diallogue
            bi.pan.setBackground(new Color(47, 149, 116));
            //on ecrit les text suivant sur notre boite de dialogue en cas de reussi  de l'opperation
            bi.titre1.setText("Succés !!");
            bi.titre2.setText("EDT Supprimée avec Succès ..");
            bi.titre3.setText("");
            //on rend visible notre boite de dialogue
            bi.setVisible(true);

        } catch (SQLException ex) {
            Logger.getLogger(DirecteurDAO.class.getName()).log(Level.SEVERE, null, ex);
            //creation d'une objet de notre boite de dialloge
            ButtonInfo bi = new ButtonInfo(new JFrame(), true);
            //on donne une couleur de font a notre boite de dialogue
            bi.pan.setBackground(new Color(47, 149, 116));
            //on ecrit les text suivant sur notre boite de dialogue en cas d'echec  de l'operation
            bi.titre1.setText("Succés !!");
            bi.titre2.setText("EDT inséré avec Succés ...");
            bi.titre3.setText("");
            //on rend visible notre boite de dialogue
            bi.setVisible(true);
        }
    }
    public void modifierEDT(EDT edt){
        Connection conn = BD.GetConnection();
        //connexion a la base de donnée
        try {
            String sql= "UPDATE seances SET titreCours = ?,duree = ?,jour=?,salle=?,classe=?,heureDebut=?,heureFin=? WHERE id =  ?";
            //creation du preparer statement
            PreparedStatement stm = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stm.setString(1, edt.getTitreCours());
            stm.setString(2, edt.getDuree());
            stm.setString(3, edt.getJour());
            stm.setString(4, edt.getSalle());
            stm.setString(5, edt.getClasse());
            stm.setString(6, edt.getHeure_debut());
            stm.setString(7, edt.getHeure_fin());
            stm.setInt(8, edt.getId());
            //execution de la requete update
            stm.executeUpdate();

            System.out.println("EDT modifié avec Succés ...");
            //creation d'un objet de notre boite de dialogue
            ButtonInfo bi = new ButtonInfo(new JFrame(), true);
            //on donnne une couleur de font a notre boite de dialogue
            bi.pan.setBackground(new Color(47, 149, 116));
            //on ecrit les text suivant sur notre boite de dialogue en cas de reussi  de l'opperation
            bi.titre1.setText("Succés !!");
            bi.titre2.setText("EDT modifiée avec Succés ...");
            bi.titre3.setText("");
            //on rend visible notre boite de dialogue
            bi.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
            //creation d'une objet de notre boite de dialloge
            ButtonInfo bi = new ButtonInfo(new JFrame(), true);
            //on donnne une coleur de font a notre boite de diallogue
            bi.pan.setBackground(Color.red);
            //on ecrit les text suivant sur notre boite de dialogue en cas d'echec  de l'opperation
            bi.titre1.setText("Echec !!");
            bi.titre2.setText("Modification non reussie");
            bi.titre3.setText("");
            //on rend visible notre boite de dialogue
            bi.setVisible(true);
        }
    }
    public void modifierSalleOptions(Salle salle) {
        Connection conn = BD.GetConnection();//connexion a la base de donnée
        try {
            String sql= "UPDATE salles SET haveProjector=?,isBusy=?,accesHandic=? WHERE id =  ? ";
            //creation du preparer statement
            PreparedStatement stm = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            //renseignement des valeurs mise en point introgation
            stm.setString(1, salle.isHaveProjector());
            stm.setString(2, salle.isBusy());
            stm.setString(3, salle.getAccesHandicap());
            stm.setInt(4, salle.getId());
            //execution de la requete update
            stm.executeUpdate();

            System.out.println("Salle modifiée avec Succés ...");
            //creation d'une objet de notre boite de dialloge
            ButtonInfo bi = new ButtonInfo(new JFrame(), true);
            //on donnne une coleur de font a notre boite de diallogue
            bi.pan.setBackground(new Color(47, 149, 116));
            //on écrit les texte suivant sur notre boite de dialogue en cas de reussi  de l'opperation
            bi.titre1.setText("Succés !!");
            bi.titre2.setText("Salle modifiée avec Succés ...");
            bi.titre3.setText("");
            //on rend visible notre boite de dialogue
            bi.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
            //creation d'une objet de notre boite de dialloge
            ButtonInfo bi = new ButtonInfo(new JFrame(), true);
            //on donnne une coleur de font a notre boite de diallogue
            bi.pan.setBackground(Color.red);
            //on ecrit les text suivant sur notre boite de dialogue en cas d'echec  de l'opperation
            bi.titre1.setText("Echec !!");
            bi.titre2.setText("Modification non reussie");
            bi.titre3.setText("");
            //on rend visible notre boite de dialogue
            bi.setVisible(true);
        }
    }
    public List<String> getListSalles(){
            List<String> list = new ArrayList<>();
        Connection conn = BD.GetConnection();
        try {
            String query = "SELECT nom FROM salles";
            PreparedStatement stmt =  conn.prepareStatement(query);
            ResultSet results = stmt.executeQuery(query);
            while (results.next()) {
                list.add(results.getString("nom"));
            }
        } catch (Exception e) {
            System.out.println("Exception = " + e);
        }
        return list;
    }
}
