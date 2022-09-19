package models;

import java.awt.*;

public class Salle {
    private int id;
    private String nom;
    private String haveProjector;
    private int capacity;
    private String isBusy;
    private String accesHandicap;
    private String type;

    public Salle() {
    }

    public Salle(String nom, int capacity, String haveProjector,String isBusy,String type) {
        this.nom = nom;
        this.haveProjector = haveProjector;
        this.capacity = capacity;
        this.type = type;
        this.isBusy = isBusy;
    }

    public Salle(int id,String projecteur,String isBusy, String accesHandicap){
        this.id = id;
        this.haveProjector = projecteur;
        this.isBusy = isBusy;
        this.accesHandicap = accesHandicap;
    }
    public Salle(int id,String nom,int capacity,String projecteur,String type){
        this.id = id;
        this.nom = nom;
        this.capacity = capacity;
        this.haveProjector = projecteur;
        this.type = type;
    }

    public Salle(int id){
        this.id = id;
    }
    public Salle(int id, String nom, String haveProjector, int capacity, String isBusy,String accesHandicap, String type) {
        this.id = id;
        this.nom = nom;
        this.haveProjector = haveProjector;
        this.capacity = capacity;
        this.isBusy = isBusy;
        this.accesHandicap = accesHandicap;
        this.type = type;
    }

    public Salle(int id, String nom, String haveProjector, int capacity, String isBusy, String type) {
        this.id = id;
        this.nom = nom;
        this.haveProjector = haveProjector;
        this.capacity = capacity;
        this.isBusy = isBusy;
        this.type = type;
    }

    public Salle(String nom, int capacity, String projecteur) {
        this.nom = nom;
        this.capacity = capacity;
        this.haveProjector = projecteur;
    }

    public Salle(String nom, int capacity, String projecteur, String type) {
        this.nom = nom;
        this.capacity = capacity;
        this.haveProjector = projecteur;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String isHaveProjector() {
        return haveProjector;
    }

    public void setHaveProjector(String haveProjector) {
        this.haveProjector = haveProjector;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String isBusy() {
        return isBusy;
    }

    public void setBusy(String busy) {
        isBusy = busy;
    }

    public String getAccesHandicap() {
        return accesHandicap;
    }

    public void setAccesHandicap(String accesHandicap) {
        this.accesHandicap = accesHandicap;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
