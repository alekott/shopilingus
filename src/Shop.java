import java.util.LinkedList;
import java.util.List;

public class Shop {

    private static int nextId = 0;

    public int id;
    public String name;
    private Location location;
    private List<ProductDetails> products;
    private List<String> types;
    private List<Service> services;
    private List<Employee> employees;



    public Shop(String name, int floor, int box, List<String> types) {
        this.id = Shop.nextId++;
        this.name = name;
        this.location = new Location(floor, box);
        this.types = new LinkedList<String>();
        this.products = new LinkedList<ProductDetails>();
        this.services = new LinkedList<Service>();
        this.employees = new LinkedList<Employee>();
    }

    public Shop(String name, int floor, int box) {                  //method overloading - przeladowanie metody
        this(name, floor, box, new LinkedList<String>());
    }


    public void hire(List<Employee> potentialEmployees) {
        for (Employee employee : potentialEmployees){
            this.hire(employee);
        }
    }

    public void hire(Employee potentialEmployee) {
        employees.add(potentialEmployee);
    }

    public void fireEmployee(Employee potentialEmployee) {
        employees.remove(potentialEmployee);
    }



    /*void addProduct(Product productToAdd, double quantityToAdd) {
        boolean contains = false;
        for(ProductDetails productDetails : products) {
            if (productDetails.product.equals(productToAdd)) {
                productDetails.quantity += quantityToAdd;
                contains = true;
            }
        }
        if(contains){
            ProductDetails newProductDetails = new ProductDetails(productToAdd, quantityToAdd);
            products.add(newProductDetails);
        }
    }
    */

    public ProductDetails findProductDetailsByProduct(Product productToFind) {
        ProductDetails searchedProductDetails = null;
        for (ProductDetails productDetails : products) {
            if (productDetails.product.equals(productToFind)) {
                searchedProductDetails = productDetails;
            }
        }
        return searchedProductDetails;
    }

    public void addProduct(Product productToAdd, double quantityToAdd) {
        ProductDetails findByProduct = findProductDetailsByProduct(productToAdd);
        if (findByProduct == null) {
            ProductDetails newProductDetails = new ProductDetails(productToAdd, quantityToAdd);
            products.add(newProductDetails);
        } else {
            findByProduct.quantity += quantityToAdd;
        }
    }

}
