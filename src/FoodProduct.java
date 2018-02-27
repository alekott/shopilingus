import java.util.Arrays;
import java.util.List;

public class FoodProduct extends Product{

    private List<String> ingredients;

    public FoodProduct(String name, double price, List<String> ingredients){
        super(name, price, "FoodProduct", 0.07);
    }

    public FoodProduct(String name, double price, String... ingredients){
        this(name, price, Arrays.asList(ingredients));
    }

    public String getFullName(){
        return this.name + " " + ingredients;
    }
}
