package models;

public class Admin extends User{
    public Admin(long id, String nom, String prenom, String login, String role, String password) {
        super(id, nom, prenom, login, role, password);
    }
}
