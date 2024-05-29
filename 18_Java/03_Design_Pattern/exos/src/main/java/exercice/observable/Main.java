package exercice.observable;

import exercice.observable.entity.StockManager;
import exercice.observable.entity.Supplier;
import exercice.observable.entity.Warehouse;

public class Main {
    public static void main(String[] args) {
        StockManager stockManager = new StockManager();
        Supplier supplier = new Supplier();
        Warehouse warehouse = new Warehouse();
        warehouse.registerObserver(stockManager);
        warehouse.registerObserver(supplier);
        warehouse.notifyObserver();
        warehouse.removeObserver(stockManager);
        warehouse.notifyObserver();
    }
}
