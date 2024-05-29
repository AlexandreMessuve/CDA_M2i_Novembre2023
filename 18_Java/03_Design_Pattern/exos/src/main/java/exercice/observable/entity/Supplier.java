package exercice.observable.entity;

public class Supplier implements Observer{
    @Override
    public void update(Product product) {
        System.out.println("Nouveau stock du produit"+product.getStockLevel());
    }
}
