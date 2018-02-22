package shopilingus;

public class ClothingProduct extends Product {

    private Size size;

    public ClothingProduct(String name, double price, Size size) {
        super(name, price, ProductType.CLOTHES, 0.23);
        this.size = size;
    }

    public String getFullName() {
        return this.getName() + " " + this.size;
    }


}
