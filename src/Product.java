public class Product {

    private static  int nextId = 0;

    public int id;
    private String name;
    private double price;
    public String type;
    private String size;
    private double weight;
    private double tax;


    public Product(String name, double price, String type, double tax) {
        this.id = Product.nextId++;
        this.name = name;
        this.price = price;
        this.type = type;
        this.tax = tax;
    }

}
