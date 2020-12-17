package com.esprit.entities;

public class Claim {
    private int id ;
    private User user;
    private String Description ;

    public Claim(int id, String description) {
        this.id = id;
        Description = description;
    }

    public Claim() {
    }

    public Claim(String Description) {
        this.Description = Description;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((Description == null) ? 0 : Description.hashCode());
        result = prime * result + id;
        result = prime * result + ((user == null) ? 0 : user.hashCode());
        return result;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Claim))
            return false;
        Claim other = (Claim) obj;
        if (Description == null) {
            if (other.Description != null)
                return false;
        } else if (!Description.equals(other.Description))
            return false;
        if (id != other.id)
            return false;
        if (user == null) {
            if (other.user != null)
                return false;
        } else if (!user.equals(other.user))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Claim [id=" + id + ", Description=" + Description + "]";
    }



}
