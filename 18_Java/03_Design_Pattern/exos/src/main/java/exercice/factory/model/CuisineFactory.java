package exercice.factory.model;

public abstract class CuisineFactory {
    public abstract Ingredient createIngredient();
    public abstract CookingUtensil createCookingUtensil();
    public abstract Dish createDish();
}
