package exercice.tp.fiscStrategy.entity;

import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TaxPlanStrategy implements TaxStrategy{
    private double plan;
    @Override
    public void calculateTax(double income) {
        double tax = income * (plan/100);
        System.out.println("Vous allez payer "+tax+" € d'impots forfaitaire");
    }
}
