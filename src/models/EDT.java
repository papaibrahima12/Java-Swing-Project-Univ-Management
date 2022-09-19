package models;

public class EDT {
    private int id;
    private String titreCours;
    private String duree;
    private String jour;

    private String salle;

    private String classe;

    private String heure_debut;
    private String heure_fin;

    private String prof;
    private String type;
    public EDT(){

    }

    public EDT(String titreCours,String duree,String jour,String salle,String classe, String heure_debut,String heure_fin,String prof,String type) {
        this.titreCours = titreCours;
        this.duree = duree;
        this.jour = jour;
        this.salle = salle;
        this.classe = classe;
        this.heure_debut = heure_debut;
        this.heure_fin = heure_fin;
        this.prof = prof;
        this.type = type;
    }

    public EDT(int id, String cours, String duree, String jour, String salle, String classe, String heure_debut, String heure_fin, String prof, String type) {
        this.id = id;
        this.titreCours = cours;
        this.duree = duree;
        this.jour = jour;
        this.salle = salle;
        this.classe = classe;
        this.heure_debut = heure_debut;
        this.heure_fin = heure_fin;
        this.prof = prof;
        this.type = type;
    }

    public EDT(int id,String cours, String duree, String jour, String heure_debut,String heure_fin,String salle, String classe) {
        this.id = id;
        this.titreCours = cours;
        this.duree = duree;
        this.jour = jour;
        this.heure_debut = heure_debut;
        this.heure_fin = heure_fin;
        this.salle = salle;
        this.classe = classe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getTitreCours() {
        return titreCours;
    }

    public void setTitreCours(String titreCours) {
        this.titreCours = titreCours;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getJour() {
        return jour;
    }
    public void setJour(String jour) {
        this.jour = jour;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = String.valueOf(salle);
    }

    public String getHeure_debut() {
        return heure_debut;
    }

    public void setHeure_debut(String heure_debut) {
        this.heure_debut = heure_debut;
    }

    public String getHeure_fin() {
        return heure_fin;
    }

    public void setHeure_fin(String heure_fin) {
        this.heure_fin = heure_fin;
    }

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
