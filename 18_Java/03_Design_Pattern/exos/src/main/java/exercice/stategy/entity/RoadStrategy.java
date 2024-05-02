package exercice.stategy.entity;

public class RoadStrategy implements NavigationStrategy{

    @Override
    public void navigate(String destination) {
        System.out.println("Voyage vers "+destination);
    }
}
