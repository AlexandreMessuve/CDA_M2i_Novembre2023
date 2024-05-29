package exercice.tp.fiscStrategy;

import exercice.tp.fiscStrategy.entity.TVAStrategy;
import exercice.tp.fiscStrategy.entity.TaxPlanStrategy;
import exercice.tp.fiscStrategy.entity.TaxProgressStrategy;
import exercice.tp.fiscStrategy.entity.User;

public class Main {
    public static void main(String[] args) {
        User user = User.builder().income(37000).build();
        TVAStrategy tvaStrategy = new TVAStrategy(30);
        TaxProgressStrategy taxProgressStrategy = new TaxProgressStrategy();
        TaxPlanStrategy taxPlanStrategy = new TaxPlanStrategy(15);

        tvaStrategy.calculateTax(user.getIncome());
        taxPlanStrategy.calculateTax(user.getIncome());
        taxProgressStrategy.calculateTax(user.getIncome());
    }
}
