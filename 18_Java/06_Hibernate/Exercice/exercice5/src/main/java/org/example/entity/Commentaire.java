package org.example.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String contenu;

    @Temporal(TemporalType.DATE)
    private Date date;

    private int note;

    @ManyToOne
    @JoinColumn(name = "id_produit")
    private Produit produit;

    public Commentaire() {
    }

    public int getId() {
        return id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    @Override
    public String toString() {
        return "Commentaire{" +
                "id=" + id +
                "produit= marque= " +
                produit.getMarque()+ " , ref= "+
                produit.getReference()+
                ", contenu='" + contenu + '\'' +
                ", date=" + date.toString() +
                ", note=" + note +
                '}';
    }
}
