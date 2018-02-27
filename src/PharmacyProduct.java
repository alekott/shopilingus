import java.util.LinkedList;
import java.util.List;

public class PharmacyProduct extends Product {

    private double nfzRefund;
    private String latinName;


    public PharmacyProduct(String name, double price, String latinName, double nfzRefund){
        super(name, price, "PharmacyProduct", 0.23);
        this.nfzRefund = nfzRefund;
        this.latinName = latinName;
    }

    public PharmacyProduct(String name, double price, String latinName){
        this(name, price, latinName, 0.7);
    }

    public String getFullName(){
        return this.name + " " + this.latinName;
    }





}
