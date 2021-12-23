package hw_0;

public enum BurgerIngredients {

    MEAT_BALL("meatball", 30,  1),
    CHEESE("cheese", 20,  2),
    SAUCE("sauce", 10,  3);

    private final String ingredient;
    private final int price;
    private final int id;

    BurgerIngredients(String ingredient, int price, int id) {
        this.ingredient = ingredient;
        this.price = price;
        this.id = id;
    }

    public String getIngredient() {
        return ingredient;
    }

    public int getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

}
