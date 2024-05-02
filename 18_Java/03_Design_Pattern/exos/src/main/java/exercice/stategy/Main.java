package exercice.stategy;

import exercice.stategy.entity.*;

public class Main {
    public static void main(String[] args) {
        NavigationSystem navigationSystem = NavigationSystem.builder().destination("Paris").navigationStrategy(new RoadStrategy()).build();
        navigationSystem.navigate();
        navigationSystem.changeStrategy(new EconomicStrategy());
        navigationSystem.navigate();
        navigationSystem.changeStrategy(new OffroadStrategy());
        navigationSystem.navigate();
    }
}
