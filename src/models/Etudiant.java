package models;

public class Etudiant extends User {
    private String classe;
    public Etudiant(long id, String nom, String prenom, String login, String role, String password,String classe) {
        super(id, nom, prenom, login, role, password);
        this.classe = classe;
    }

}