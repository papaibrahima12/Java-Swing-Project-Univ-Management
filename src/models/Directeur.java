package models;

import autre.ButtonInfo;
import dao.AdminDAO;
import stockage.BD;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Directeur extends User{
    public Directeur(long id, String nom, String prenom, String login, String role, String password) {
        super(id, nom, prenom, login, role, password);
    }

    public Directeur() {
        super();
    }
}
