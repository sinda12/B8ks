package com.esprit.entities;



public class NewsLetter {

    private int id ;
    private User user ;
    private String Description ;

    public NewsLetter(int id, String description) {
        this.id = id;
        Description = description;
    }

    public NewsLetter() {
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
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof NewsLetter))
            return false;
        NewsLetter other = (NewsLetter) obj;
        if (Description == null) {
            if (other.Description != null)
                return false;
        } else if (!Description.equals(other.Description))
            return false;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Newsletter [id=" + id + ", Description=" + Description + "]";
    }




}
