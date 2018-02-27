public class Product {

    private static  int nextId = 0;

    public int id;
    public String type;
    public String name;
    private double price;
    private double tax;


    public Product(String name, double price, String type, double tax) {
        this.id = Product.nextId++;
        this.name = name;
        this.price = price;
        this.type = type;
        this.tax = tax;
    }

    public String getFullName(){
        return this.name;
    }
}
