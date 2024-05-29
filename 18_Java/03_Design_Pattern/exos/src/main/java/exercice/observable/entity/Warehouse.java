package exercice.observable.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Warehouse implements Subject{
    private List<Observer> observers;
    private Random random;
    public Warehouse() {
        observers = new ArrayList<>();
        random = new Random();
    }


    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        observers.forEach(o -> o.update(Product.builder().stockLevel(random.nextInt(0,100)).build()));
    }
}
