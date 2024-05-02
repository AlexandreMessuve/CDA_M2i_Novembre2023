package exercice.stategy.entity;

public class OffroadStrategy implements NavigationStrategy{

    @Override
    public void navigate(String destination) {
        System.out.println("Voyage hors route vers "+destination);
    }
}
