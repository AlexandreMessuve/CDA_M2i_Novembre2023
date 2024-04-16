package org.plante;

public class Plante {
    protected String nome;
    protected int height;
    protected String colorLeaf;

    public Plante(String nome, int height, String colorLeaf) {
        this.nome = nome;
        this.height = height;
        this.colorLeaf = colorLeaf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getColorLeaf() {
        return colorLeaf;
    }

    public void setColorLeaf(String colorLeaf) {
        this.colorLeaf = colorLeaf;
    }

    @Override
    public String toString() {
        return super.getClass().getSimpleName()+" Nom: " + nome + ", Hauteur: " + height + ", Couleur des feuilles: " + colorLeaf + " ";
    }
}
