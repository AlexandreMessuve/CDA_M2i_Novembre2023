package exercice.tp.factory;

import exercice.tp.entity.AbstractProductBuilder;
import exercice.tp.entity.Product;

public abstract class ProductFactory {
    public abstract Product createProduct(AbstractProductBuilder abstractProductBuilder);
}
