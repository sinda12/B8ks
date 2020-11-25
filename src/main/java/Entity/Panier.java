/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author sinda
 */
public class Panier {
    
    private int id;
    private int produit_id;
    private int client_id;
    private int quantite;

    public Panier() {
    }

    public Panier(int id, int produit_id, int client_id, int quantite) {
        this.id = id;
        this.produit_id = produit_id;
        this.client_id = client_id;
        this.quantite = quantite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduit_id() {
        return produit_id;
    }

    public void setProduit_id(int produit_id) {
        this.produit_id = produit_id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Panier{" + "id=" + id + ", produit_id=" + produit_id + ", client_id=" + client_id + ", quantite=" + quantite + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.id;
        hash = 67 * hash + this.produit_id;
        hash = 67 * hash + this.client_id;
        hash = 67 * hash + this.quantite;
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
        final Panier other = (Panier) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.produit_id != other.produit_id) {
            return false;
        }
        if (this.client_id != other.client_id) {
            return false;
        }
        if (this.quantite != other.quantite) {
            return false;
        }
        return true;
    }
    
    
    
    
}
