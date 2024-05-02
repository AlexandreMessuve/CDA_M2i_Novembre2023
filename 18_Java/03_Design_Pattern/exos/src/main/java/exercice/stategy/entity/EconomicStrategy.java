package exercice.stategy.entity;

public class EconomicStrategy implements NavigationStrategy{

    @Override
    public void navigate(String destination) {
        System.out.println("Voyage économique vers "+destination);
    }
}
