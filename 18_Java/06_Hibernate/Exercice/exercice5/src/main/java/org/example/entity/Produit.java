package org.example.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String marque;

    private String reference;

    private double prix;

    private int stock;

    @Temporal(TemporalType.DATE)
    private Date dateAchat;

    @OneToMany(mappedBy = "produit")
    private List<Image> images = new ArrayList<>();

    @OneToMany(mappedBy = "produit")
    private final List<Commentaire> commentaires = new ArrayList<>();
    public Produit() {
    }

    public Produit(String marque, String reference, double prix, int stock, Date dateAchat) {
        this.marque = marque;
        this.reference = reference;
        this.prix = prix;
        this.stock = stock;
        this.dateAchat = dateAchat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", marque='" + marque + '\'' +
                ", reference='" + reference + '\'' +
                ", prix=" + prix +
                ", stock=" + stock +
                ", dateAchat=" + dateAchat +
                '}';
    }
}
