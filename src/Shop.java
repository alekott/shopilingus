import java.util.List;

public class Shop {

    private String name;
    private String address;
    private List<ProductDetails> products;
    private String[] type;
    private List<Service> services;
    private List<Employee> employees;

    public Shop(String name, String address, String[] type) {

        this.name = name;
        this.address = address;
        this.type = type;
    }

    public void hireEmployee(Employee potentialEmployee) {
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

    public void addProduct(Product productToAdd, double quantityToAdd){
        ProductDetails findByProduct = findProductDetailsByProduct(productToAdd);
        if(findByProduct == null){
            ProductDetails newProductDetails = new ProductDetails(productToAdd, quantityToAdd);
            products.add(newProductDetails);
        } else {
            findByProduct.quantity += quantityToAdd;
        }
    }
    
}
