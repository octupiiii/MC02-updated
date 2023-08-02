package Model;

/**
 * Class representing an item object in the Vending Machine.
 */
public class Item {
    private String name;
    private double price;
    private double calories;

    /**
     * Constructs an item with the given name, price, and calories.
     *
     * @param name     The name of the item.
     * @param price    The price of the item.
     * @param calories The calorie content of the item.
     */
    public Item(String name, double price, double calories) {
        this.name = name;
        this.price = price;
        this.calories = calories;
    }

    /**
     * Retrieves the name of the item.
     *
     * @return The name of the item.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Retrieves the price of the item.
     *
     * @return The price of the item.
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Retrieves the calorie content of the item.
     *
     * @return The calorie content of the item.
     */
    public double getCalories() {
        return this.calories;
    }

    /**
     * Sets the price of the item to the specified value.
     *
     * @param newPrice The new price to set for the item.
     */
    public void setPrice(float newPrice) {
        this.price = newPrice;
    }

}
