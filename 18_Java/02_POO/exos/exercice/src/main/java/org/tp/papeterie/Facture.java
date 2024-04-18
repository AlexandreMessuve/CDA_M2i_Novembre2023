package org.tp.papeterie;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.UUID;

public class Facture {
        private final UUID numeroFacture;
        private String client;
        private LocalDate purchaseDate;
        private Line[] lines;

        public Facture(String client) {
                this.numeroFacture = UUID.randomUUID();
                this.client = client;
                this.purchaseDate = LocalDate.now();
        }

        public String  getNumeroFacture() {
                return numeroFacture.toString();
        }

        public LocalDate getPurchaseDate() {
                return purchaseDate;
        }

        public void setPurchaseDate(LocalDate purchaseDate) {
                this.purchaseDate = purchaseDate;
        }

        public String getClient() {
                return client;
        }

        public void setClient(String client) {
                this.client = client;
        }

        public boolean addLine(UUID refArticle, int quantity){
                if(lines.length < 10){
                        Article article = BDD.getArticle(refArticle);
                        Line[] newLines = new Line[lines.length + 1];
                        Line line = new Line(article.getRef(), quantity);
                        for (int i = 0; i < lines.length ; i++) {
                                newLines[i] = lines[i];
                        }
                        newLines[lines.length+1] = line;
                        lines = newLines;
                        return true;
                }else {
                        return false;
                }
        }

        public double getTotalPrice(){
                double total = 0;
                for(Line line : lines){
                        total += line.getTotalPrice();
                }
                return total;
        }

        @Override
        public String toString() {
                return  "numeroFacture=" + numeroFacture + "\n"+
                        ", client='" + client + '\n' +
                        ", purchaseDate=" + purchaseDate.toString() + "\n"+
                        ", lines=" + Arrays.toString(lines) + "\n"+
                        "prix total=" + getTotalPrice() + "€";
        }
}
