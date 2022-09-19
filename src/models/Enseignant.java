package models;

public class Enseignant extends User{
    public Enseignant(long id, String nom, String prenom, String login, String role, String password) {
        super(id, nom, prenom, login, role, password);
    }
}
