package exercice.tp.fiscStrategy.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class TVAStrategy implements TaxStrategy{
    private double rate;
    public TVAStrategy(double rate) {
        this.rate = rate;
    }
    @Override
    public void calculateTax(double income) {
        double tva = income * (rate/100);
        System.out.println("Vous devez payer " + tva + " € de TVA 20%");
    }
}
