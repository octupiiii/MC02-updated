package Model;
import java.util.ArrayList;

public class CustomizableProduct extends Item{
    private ArrayList<ArrayList<Item>> ingredients;
    private ArrayList<Item> scoops = new ArrayList<Item>();;
    private ArrayList<Item> syrups = new ArrayList<Item>();;
    private ArrayList<Item> toppings = new ArrayList<Item>();;
    private Item icHolder = null;
    /*
     *  Item One - Ice Cream Flavor <ArrayList>
        Item Two - Pumps of Syrups <ArrayList>
        Item Three - Toppings <ArrayList>
        Item Three - Cup / Cone / Waffle Cone / Waffle <Item>
     */

    public CustomizableProduct() {
        super(null, 0, 0);
        this.ingredients = new ArrayList<ArrayList<Item>>();
        this.scoops = new ArrayList<Item>();
        this.syrups = new ArrayList<Item>();
        this.toppings = new ArrayList<Item>();
    }

    public CustomizableProduct(String name, ArrayList<Item> scoops, ArrayList<Item> syrups, ArrayList<Item> toppings, Item icHolder) {
        super(name, 0, 0);
        this.scoops = scoops;
        this.syrups = syrups;
        this.toppings = toppings;
        addIngredients();

        this.icHolder = icHolder;
    }

    public void addIngredients() {
        this.ingredients.add(scoops);
        this.ingredients.add(syrups);
        this.ingredients.add(toppings);
    }

    public String getName() {
        return this.getName();
    }

    public void setName(String name) {
        this.setName(name);
    }

    public String createName() {
        String tempName = "Special " + icHolder.getName() + " Ice Cream";
        return tempName;
    }

    // add scoop to scoops list
    public void addScoop(Item scoop) {
        this.scoops.add(scoop);
    }

    // add syrup to syrups list
    public void addSyrup(Item syrup) {
        this.syrups.add(syrup);
    }

    public void addTopping(Item topping) {
        this.toppings.add(topping);
    }

    public void setICHolder(Item icHolder) {
        this.icHolder = icHolder;
    }

    public void computePrice() {
        double price = 0;
        for (Item temp : scoops) {
            price += temp.getPrice();
        }
        for (Item temp : syrups) {
            price += temp.getPrice();
        }
        for (Item temp : toppings) {
            price += temp.getPrice();
        }
        price += this.icHolder.getPrice();
        this.setPrice(price);
    }

    public void computeCalories() {
        double calories = 0;
        for (Item temp : scoops) {
            calories += temp.getCalories();
        }
        for (Item temp : scoops) {
            calories += temp.getCalories();
        }
        for (Item temp : scoops) {
            calories += temp.getCalories();
        }
        calories += this.icHolder.getCalories();
        this.setCalories(calories);
    }

    private void updateInfo() {
        computeCalories();
        computePrice();
    }

}
