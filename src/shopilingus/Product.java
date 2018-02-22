package shopilingus;

public class Product {

    private static int nextId = 0;

    private int id;
    private ProductType type;
    private String name;
    private double price;
    private double tax;


    public Product(String name, double price, ProductType type, double tax) {
        this.id = Product.nextId++;
        this.name = name;
        this.price = price;
        this.type = type;
        this.tax = tax;
    }

    public String getFullName() {
        return this.name;
    }

    public void print() {
        System.out.println(getFullName());
    }

    public double getNettoPrice() {
        return price;
    }

    public double getBruttoPrice() {
        return price + price * tax;
    }

    public ProductType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
