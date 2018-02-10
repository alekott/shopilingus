public class ClothingProduct extends Product {

    String size;

    public ClothingProduct(String name, double price, String size){
        super(name, price, "ClothingProduct", 0.23);
        this.size = size;
    }

    public String getFullName(){
        return this.name + " " + this.size;
    }


}
