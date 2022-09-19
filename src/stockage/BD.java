package stockage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BD{

    private static final BD instance = new BD();
    public static final String URL = "jdbc:mysql://localhost:3306/uadb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String USER = "root";
    public static final String PASSWORD = "ibrahima12";
    public static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";

    //Constructeur privé
    private BD() {
        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * cette methode permet de créer la connexion entre le jdbc et la base de donnée
     **/
    private Connection createConnection() {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to Database.");
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to database", e);
        }
    }

    /**
     *  cette methode permet de recupérer la connexion
     **/
    public static Connection GetConnection() {
        return instance.createConnection();
    }

}

























//package stockage;
//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//
//import autre.ButtonInfo;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.awt.Color;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import javax.swing.JFrame;
//
//
///**
// *
// * @author BLENDER
// */
//public class BD {
//    // éléments de connexion à la base de données
//    static String hostBD;
//    static String userBD;
//    static String mdpBD;
//    static String nameBD;
//    static String portBD;
//
//    public BD() {
//        hostBD = "localhost";
//        userBD = "root";
//        mdpBD = "ibrahima12";
//        nameBD = "uadb";
//        portBD = "3306";
//    }
//
//    public static Connection GetConnection() {
//        String url = "jdbc:mysql://localhost:3306/" + nameBD + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//        // chargement du driver
//        String Driver = "com.mysql.cj.jdbc.Driver";
//
//        try {
//            Class.forName(Driver);
//           Connection conn = DriverManager.getConnection(url, userBD, mdpBD);
//            System.out.println("Le driver JDBC a été chargé avec Succès !!!");
//            return conn;
//        } catch (SQLException | ClassNotFoundException ex) {
//            throw new RuntimeException();
//            System.out.println("Erreur de chargement du driver : " + ex.getLocalizedMessage());
//            ButtonInfo bi = new ButtonInfo(new JFrame(), true);
//            bi.pan.setBackground(Color.red);
//            bi.titre1.setText("Erreur de chargement du Driver JDBC");
//            bi.titre2.setText("Le driver JDBC n'a pas été chargé");
//            bi.titre3.setText("Verifier le nom et le chemin d'accès au Driver dans le projet");
//            bi.setVisible(true);
//        }
//    }
//}
