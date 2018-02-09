import java.util.LinkedList;
import java.util.List;

public class Shop {

    private static int nextId = 0;

    public int id;
    public String name;
    private Location location;
    public List<ProductDetails> products;
    public List<String> types;
    public List<Service> services;
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


    public void hireEmployee(List<Employee> potentialEmployees) {
        for (Employee employee : potentialEmployees){
            this.hireEmployee(employee);
        }
    }

    public void hireEmployee(Employee potentialEmployee) {
        employees.add(potentialEmployee);
    }

    public void fireEmployee(Employee potentialEmployee) {
        employees.remove(potentialEmployee);
    }

    public void updateEmployee(Employee employeeToUpdate, Employee modifiedEmployee){
        employeeToUpdate.name = modifiedEmployee.name;
        employeeToUpdate.skills = modifiedEmployee.skills;
    }

    public int getNumberOfEmployees(){
        return employees.size();
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

    public Product getProduct(int productId){
        for (ProductDetails productDetails : products) {
            if ( productDetails.product.id == productId){
                return productDetails.product;
            }
        }
        return null;
    }

    /*public void removeProduct(int productId, double quantity){
        Product searchedProduct = getProduct(productId);
        ProductDetails findByProduct = findProductDetailsByProduct(searchedProduct);
        findByProduct.quantity -= quantity;
        if (findByProduct.quantity == 0){
            products.remove(findByProduct);
        }
    }
    */

    public void deleteProduct(int productId) {
        for (ProductDetails productDetails : products) {
            if (productDetails.product.id == productId) {
                this.products.remove(productDetails);
            }
        }
    }

    public void updateProduct(int productId, Product modifiedProduct) {
        ProductDetails productDetails = findProductDetailsByProduct(getProduct(productId));
        deleteProduct(productId);
        modifiedProduct.id = productId;
        addProduct(modifiedProduct, productDetails.quantity);
    }

    public void addService(Service service) {
        this.services.add(service);
    }

    public void deleteService(Service serviceToDelete) {
        this.services.remove(serviceToDelete);
    }

    public Service getServiceById(int serviceId){
        for ( Service service : services){
            if (service.id == serviceId){
                return service;
            }
        }
        return null;
    }

    public void updateService(int serviceId, Service modifiedService){
        Service serviceToUpdate = getServiceById(serviceId);
        deleteService(serviceToUpdate);
        modifiedService.id = serviceId;
        addService(modifiedService);
    }

}
