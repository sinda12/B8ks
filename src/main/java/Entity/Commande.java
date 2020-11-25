/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Objects;

/**
 *
 * @author sinda
 */
public class Commande {
    private int id;
    private int addresse_id;
    private int client_id;
    private String etat;
    private double prixtotal;

    public Commande() {
    }

    public Commande(int id, int addresse_id, int client_id, String etat, double prixtotal) {
        this.id = id;
        this.addresse_id = addresse_id;
        this.client_id = client_id;
        this.etat = etat;
        this.prixtotal = prixtotal;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.id;
        hash = 53 * hash + this.addresse_id;
        hash = 53 * hash + this.client_id;
        hash = 53 * hash + Objects.hashCode(this.etat);
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.prixtotal) ^ (Double.doubleToLongBits(this.prixtotal) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Commande other = (Commande) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.addresse_id != other.addresse_id) {
            return false;
        }
        if (this.client_id != other.client_id) {
            return false;
        }
        if (Double.doubleToLongBits(this.prixtotal) != Double.doubleToLongBits(other.prixtotal)) {
            return false;
        }
        if (!Objects.equals(this.etat, other.etat)) {
            return false;
        }
        return true;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAddresse_id() {
        return addresse_id;
    }

    public void setAddresse_id(int addresse_id) {
        this.addresse_id = addresse_id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public double getPrixtotal() {
        return prixtotal;
    }

    public void setPrixtotal(double prixtotal) {
        this.prixtotal = prixtotal;
    }
    
    
    
}
