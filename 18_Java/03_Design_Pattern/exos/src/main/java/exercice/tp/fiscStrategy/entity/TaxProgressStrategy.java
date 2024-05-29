package exercice.tp.fiscStrategy.entity;

public class TaxProgressStrategy implements TaxStrategy{
    private double tax;
    @Override
    public void calculateTax(double income) {
        if(income > 11294) {
            if (income >= 11295 && income <= 28797) {
                tax = income * 0.11;
            }
            if (income >= 28798 && income <= 82341) {
                tax = income * 0.3;
            }
            if (income >= 82342 && income <= 177106) {
                tax = income * 0.41;
            }
            if (income >= 177106) {
                tax = income * 0.45;
            }
            System.out.println("Vous allez payer "+tax+" € d'impots sur le revenu");
        }else{
            System.out.println("Vous n'avez aucune taxe à payer");
        }
    }
}
