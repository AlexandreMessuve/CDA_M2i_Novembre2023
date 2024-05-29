package exercice.observable.entity;

public class StockManager implements Observer {

    @Override
    public void update(Product product) {
        System.out.println("Actualisation du stock du produit "+product.getStockLevel());
    }
}
