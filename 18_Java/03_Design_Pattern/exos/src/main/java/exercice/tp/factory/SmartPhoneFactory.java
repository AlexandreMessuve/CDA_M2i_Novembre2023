package exercice.tp.factory;

import exercice.tp.entity.AbstractProductBuilder;
import exercice.tp.entity.Product;

public class SmartPhoneFactory extends ProductFactory{
    @Override
    public Product createProduct(AbstractProductBuilder smartPhoneBuilder) {
        return smartPhoneBuilder.build();
    }
}
