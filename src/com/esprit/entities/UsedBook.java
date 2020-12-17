package com.esprit.entities;

import java.util.ArrayList;
import java.util.List;

public class UsedBook {
    private int id;
    private String titre;
    private double prix;
    private String auteur;
    private String description;
    private String datepub;

    private List<Category> lk = new ArrayList<Category>();




    public UsedBook(int id, String titre, double prix, String auteur, String description, String datepub) {
        // TODO Auto-generated constructor stub

        this.id = id;
        this.titre = titre;
        this.prix = prix;
        this.auteur = auteur;
        this.description = description;
        this.datepub = datepub;
    }

    public UsedBook(String titre, double prix, String auteur, String description, String datepub) {
        super();
        this.titre = titre;
        this.prix = prix;
        this.auteur = auteur;
        this.description = description;
        this.datepub = datepub;
    }


    public UsedBook() {
        super();
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    public String getAuteur() {
        return auteur;
    }
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
    public double getPrix() {
        return prix;
    }
    public void setPrix(double d) {
        this.prix = d;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((auteur == null) ? 0 : auteur.hashCode());
        result = prime * result + ((datepub == null) ? 0 : datepub.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + id;
        result = prime * result + ((lk == null) ? 0 : lk.hashCode());
        long temp;
        temp = Double.doubleToLongBits(prix);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((titre == null) ? 0 : titre.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UsedBook other = (UsedBook) obj;
        if (auteur == null) {
            if (other.auteur != null)
                return false;
        } else if (!auteur.equals(other.auteur))
            return false;
        if (datepub == null) {
            if (other.datepub != null)
                return false;
        } else if (!datepub.equals(other.datepub))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (id != other.id)
            return false;
        if (lk == null) {
            if (other.lk != null)
                return false;
        } else if (!lk.equals(other.lk))
            return false;
        if (Double.doubleToLongBits(prix) != Double.doubleToLongBits(other.prix))
            return false;
        if (titre == null) {
            if (other.titre != null)
                return false;
        } else if (!titre.equals(other.titre))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "usedbook [id=" + id + ", titre=" + titre + ", auteur=" + auteur + ", description=" + description
                + ", datepub=" + datepub + ", lk=" + lk + "]";
    }
    public List <Category> getLc() {
        return lk;
    }
    public void setLc(List <Category> lk) {
        this.lk = lk;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDatepub() {
        return datepub;
    }
    public void setDatepub(String datepub) {
        this.datepub = datepub;
    }

}
