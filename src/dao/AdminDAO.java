
package dao;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

import models.Salle;
import stockage.BD;
import autre.ButtonInfo;

/**
 * La class Admin qui prend 8 variables de champs contient les methodes
 * qui permet au administrateur d'effectuer leur tache c'est a dire ajout ,
 * modification et suppression .Il dispose plusieurs constructeurs
 *
 * */
public class AdminDAO {
   private int id;
   private String nom;//nom admin
   private String prenom;//prenom admin
    private String password;//mot de passe admin
    private String tel;
    private String login;//login de connection pour admin
    private String role;//role de admin

    /**
 * Un constructeur qui permet la modification et suppression d'un enregistrement dans
 * la table users d'users ,
 * */
    public AdminDAO(int id,String prenom, String nom,String role, String login, String mdp) {
        this.login = login;
        this.nom = nom;
        this.prenom = prenom;
        this.password = mdp;
        this.role=role;
        this.id=id;
    }
    public AdminDAO(String prenom, String nom,String role, String login,String tel,String mdp) {
        this.login = login;
        this.nom = nom;
        this.prenom = prenom;
        this.password = mdp;
        this.tel = tel;
        this.role=role;
    }
    public AdminDAO(String nom,String prenom,String login,String password){
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
    }

   /**
    * Un constructeur qui permet d'ajouter un nouveau user dans la table des
    * userss
    * */
    public AdminDAO(String prenom, String nom,String role, String login, String mdp) {
        this.login = login;
        this.nom = nom;
        this.prenom = prenom;
        this.password = mdp;
        this.role=role;
    }
    
    /**
     * Un constructeur qui permet de recuperer l'users connecter
     * */
     public AdminDAO(String user) {
         this.login = user;
    }
    /**
     * Un constructeur qui prend un argument de type entier ici 
     * c'est identificateur . 
     * */
     public AdminDAO(int id) {
        this.id = id;
     }

    public AdminDAO() {
    }

    /**
 * On crée  pour chacun des variables de champs un getter et setter
 * */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMdp() {
        return password;
    }

    public void setMdp(String mdp) {
        this.password = mdp;
    }
    /**
     * La méthode ajouter prenant aucun argument permet ajouter un  nouveau
     * enregistrement dans la table users 
     * 
     * */


    public void ajouterUser() {
        Connection conn = BD.GetConnection();//connexion a la base de doonée
        try {
        	String sql="SELECT * FROM users WHERE login=?";
        	//creation du statement
            PreparedStatement stm = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stm.setString(1, login);
            //excution de la requette selection
            ResultSet rs = stm.executeQuery();
            /***
             * On test si l'utilisateur ajouté exit deja dans la base de donne en se reférant sur son login
             * si c'est le cas l'ajout sera rejeté dans le cas contraire l'ajout pourrait reussir
             * */
     
            if (rs.next()) {
                System.out.println("Cet user existe dans la base de données. Impossible de l'ajouter");
                //creation d'une objet de notre boite de dialloge
                ButtonInfo bi = new ButtonInfo(new JFrame(), true);
              //on donnne une coleur de font a notre boite de diallogue
                bi.pan.setBackground(Color.red);
              //on ecrit les text suivant sur notre boite de dialogue en cas d'echec  de l'opperation
                bi.titre1.setText("Echec d'enregistrement");
                bi.titre2.setText("Cet login users existe dans la base de donn�es. Impossible de l'ajouter");
                bi.titre3.setText("");
              //on rend visible notre boite de dialogue
                bi.setVisible(true);
            } else {
            	sql="INSERT INTO users(prenom,nom,login,role,telephone,password) VALUES(?,?,?,?,?,?) ";
            	stm = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            	stm.setString(1, prenom);
            	stm.setString(2, nom);
            	stm.setString(3, login);
            	stm.setString(4, role);
            	stm.setString(5, tel);
            	stm.setString(6, password);
                // insertion
            	//excution de la requete insertion
                stm.executeUpdate();
                System.out.println("User ajouté avec succés...");
                //creation d'un objet de notre boite de dialogue
                ButtonInfo bi = new ButtonInfo(new JFrame(), true);
              //on donnne une coleur de font a notre boite de diallogue
                bi.pan.setBackground(new Color(47, 149, 116));
              //on ecrit les text suivant sur notre boite de dialogue en cas de reussite  de l'operation
                bi.titre1.setText("Succés !!");
                bi.titre2.setText("user inséré avec succés...");
                bi.titre3.setText("");
                bi.setVisible(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * La méthode modifier qui préne aucun argument permet modifier un 
     * enregistrement dans la table users 
     * 
     * */


    public void modifierUser(int id) {
        Connection conn = BD.GetConnection();//connexion a la base de donnée
        try {
        	String sql="UPDATE users SET prenom =?,nom =?,login=?,password=? WHERE id = ?";
        	//creation du statement
            PreparedStatement stm = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
           stm.setString(1, prenom);
           stm.setString(2, nom);
           stm.setString(3, login);
           stm.setString(4, password);
           stm.setInt(5, id);
            //excution de la requette update
            stm.executeUpdate();
            
            System.out.println("user modifié avec Succés ...");
          //creation d'une objet de notre boite de dialloge
            ButtonInfo bi = new ButtonInfo(new JFrame(), true);
          //on donnne une coleur de font a notre boite de diallogue
            bi.pan.setBackground(new Color(47, 149, 116));
          //on ecrit les text suivant sur notre boite de dialogue en cas de reussi  de l'opperation
            bi.titre1.setText("Succ�s !!");
            bi.titre2.setText("users modifi� avec Succ�s ...");
            bi.titre3.setText("");
          //on rend visible notre boite de dialogue
            bi.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * La méthode supprimer qui préne aucun argument permet supprimer un 
     * enregistrement dans la table users 
     * 
     * */
    public void supprimerUser(int id) {
        Connection conn = BD.GetConnection();//connexion a la base de donné
        try {
        	String sql="DELETE FROM users WHERE id = ?";
        	//creation du statement 
            PreparedStatement stm = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
           stm.setInt(1, id);
            //excution du requuette Delete
            stm.executeUpdate();
            System.out.println("user Supprimé avec Succès ...");
          //creation d'une objet de notre boite de dialloge
            ButtonInfo bi = new ButtonInfo(new JFrame(), true);
          //on donnne une coleur de font a notre boite de diallogue
            bi.pan.setBackground(new Color(47, 149, 116));
          //on ecrit les text suivant sur notre boite de dialogue en cas de reussi  de l'opperation
            bi.titre1.setText("Succés !!");
            bi.titre2.setText("users Supprimé avec Succès ..");
            bi.titre3.setText("");
          //on rend visible notre boite de dialogue
            bi.setVisible(true);

        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
          //creation d'une objet de notre boite de dialloge
            ButtonInfo bi = new ButtonInfo(new JFrame(), true);
          //on donnne une coleur de font a notre boite de diallogue
            bi.pan.setBackground(new Color(47, 149, 116));
          //on ecrit les text suivant sur notre boite de dialogue en cas d'echec  de l'opperation
            bi.titre1.setText("Succés !!");
            bi.titre2.setText("Salle insérée avec Succés ...");
            bi.titre3.setText("");
          //on rend visible notre boite de dialogue
            bi.setVisible(true);

        }
    }


/**
 * La méthode ajouterSalle qui préne aucun argument permet ajouter un nouveau  dans la table Salle 
 * 
 * */


public void ajouterSalle(Salle salle) {
    Connection conn = BD.GetConnection();//connexion a la basse de donnée
    try {
    	String sql="SELECT * FROM salles WHERE id = ?";
    	//creation du statement
        PreparedStatement stm = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        //excution de la requette selection
        stm.setInt(1, salle.getId());
        ResultSet rs = stm.executeQuery();
        /***
         * On test si la salle ajouter exit d'eja dans la basse de donne a se reférant sur son nom
         * si c'est le cas l'ajout sera rejeter dans le cas contraire l'ajout pourait reussie
         * */
        if (rs.next()) {
            System.out.println("Cet Salle existe dans la base de données. Impossible de l'ajouter");
          //creation d'une objet de notre boite de dialloge
            ButtonInfo bi = new ButtonInfo(new JFrame(), true);
          //on donnne une coleur de font a notre boite de diallogue
            bi.pan.setBackground(Color.red);
          //on ecrit les text suivant sur notre boite de dialogue en cas d'echec  de l'opperation
            bi.titre1.setText("Echec d'enregistrement");
            bi.titre2.setText("Cet nom salle existe dans la base de donn�es. Impossible de l'ajouter");
            bi.titre3.setText("");
          //on rend visible notre boite de dialogue
            bi.setVisible(true);
        } else {
        	//Requette insertion 
        	sql="INSERT INTO salles(nom, capacity,haveProjector,isBusy,type) VALUES(?,?,?,?,?)";
        	//requete insertion preparer
        	stm = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //rengnegnement des valeurs
        	stm.setString(1, salle.getNom());
            stm.setInt(2, salle.getCapacity());
            stm.setString(3, salle.isHaveProjector());
            stm.setString(4, salle.isBusy());
            stm.setString(5, salle.getType());
        	// insertion
        	//excution de la requette insertion
            stm.executeUpdate();
            System.out.println("Salle ajoutée avec Succés ...");
          //creation d'une objet de notre boite de dialloge
            ButtonInfo bi = new ButtonInfo(new JFrame(), true);
          //on donnne une coleur de font a notre boite de diallogue
            bi.pan.setBackground(new Color(47, 149, 116));
          //on ecrit les text suivant sur notre boite de dialogue en cas de reussi  de l'opperation
            bi.titre1.setText("Succés !!");
            bi.titre2.setText("Salle insérée avec Succés ...");
            bi.titre3.setText("");
          //on rend visible notre boite de dialogue
            bi.setVisible(true);
        }
    } catch (SQLException ex) {
        Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
}

/**
 * La méthode modifierSalle qui préne aucun argument permet de modifier les informations 
 * d'une salle dans la table Salle 
 * 
 * */
public void modifierSalle(Salle salle) {
    Connection conn = BD.GetConnection();//connexion a la base de donnée
    try {
    	String sql= "UPDATE salles SET nom = ?,capacity = ?,haveProjector=?,type=? WHERE id =  ? ";
    	//creation du preparer statement
        PreparedStatement stm = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

       //renseignement des valeurs mise en point introgation 
        stm.setString(1, salle.getNom());
        stm.setInt(2, salle.getCapacity());
        stm.setString(3, salle.isHaveProjector());
        stm.setString(4, salle.getType());
        stm.setInt(5, salle.getId());
      //excution de la requette update
        stm.executeUpdate();
        
        System.out.println("Salle modifiée avec Succés ...");
        //creation d'une objet de notre boite de dialloge
        ButtonInfo bi = new ButtonInfo(new JFrame(), true);
      //on donnne une coleur de font a notre boite de diallogue
        bi.pan.setBackground(new Color(47, 149, 116));
      //on ecrit les text suivant sur notre boite de dialogue en cas de reussi  de l'opperation
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

/**
 * La méthode supprimerSalle prenant aucun argument permet supprimer  dans la table Salle 
 * 
 * */
public void supprimerSalle(int idSalle) {
    Connection conn = BD.GetConnection();//connexion a la base de donnee
    try {
    	String sql="DELETE FROM salles WHERE id = ?";
    	//creation du statement
        PreparedStatement stm = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        stm.setInt(1, idSalle);
        //excution du requete Delete 
        stm.executeUpdate();
        System.out.println("Salle Supprimée avec Succès ...");
        //creation d'une objet de notre boite de dialogue
        ButtonInfo bi = new ButtonInfo(new JFrame(), true);
        //on donnne une couleur de font a notre boite de diallogue
        bi.pan.setBackground(new Color(47, 149, 116));
        //on écrit les text suivant sur notre boite de dialogue en cas de reussi  de l'operation
        bi.titre1.setText("Succés !!");
        bi.titre2.setText("Salle Supprimée avec Succés ..");
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
        bi.titre2.setText("Suppresion non reussie");
        bi.titre3.setText("");
        //on rend visible notre boite de dialogue
        bi.setVisible(true);
    }
}

}

