package shopilingus;

import java.util.LinkedList;
import java.util.List;

public class Shop {

    private static int nextId = 0;

    private int id;
    private String name;
    private Location location;
    private List<ProductDetails> products;
    private List<ShopType> types;
    private List<Service> services;
    private List<Employee> employees;


    public Shop(String name, int floor, int box, List<ShopType> types) {
        this.id = Shop.nextId++;
        this.name = name;
        this.location = new Location(floor, box);
        this.types = types;
        this.products = new LinkedList<ProductDetails>();
        this.services = new LinkedList<Service>();
        this.employees = new LinkedList<Employee>();
    }

    public Shop(String name, int floor, int box) {                  //method overloading - przeladowanie metody
        this(name, floor, box, new LinkedList<ShopType>());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductDetails> getProducts() {
        return products;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public List<ShopType> getTypes() {
        return types;
    }

    public void setTypes(List<ShopType> types) {
        this.types = types;
    }

    public void hireEmployee(List<Employee> potentialEmployees) {
        for (Employee employee : potentialEmployees) {
            this.hireEmployee(employee);
        }
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void hireEmployee(Employee potentialEmployee) {
        employees.add(potentialEmployee);
    }

    public void fireEmployee(Employee potentialEmployee) {
        employees.remove(potentialEmployee);
    }

    public void updateEmployee(Employee employeeToUpdate, Employee modifiedEmployee) {
        employeeToUpdate.setName(modifiedEmployee.getName());
        employeeToUpdate.setSkills(modifiedEmployee.getSkills());
    }

    public int getNumberOfEmployees() {
        return employees.size();
    }



    /*void addProduct(shopilingus.Product productToAdd, double quantityToAdd) {
        boolean contains = false;
        for(shopilingus.ProductDetails productDetails : products) {
            if (productDetails.product.equals(productToAdd)) {
                productDetails.quantity += quantityToAdd;
                contains = true;
            }
        }
        if(contains){
            shopilingus.ProductDetails newProductDetails = new shopilingus.ProductDetails(productToAdd, quantityToAdd);
            products.add(newProductDetails);
        }
    }
    */

    public ProductDetails findProductDetailsByProduct(Product productToFind) {
        ProductDetails searchedProductDetails = null;
        for (ProductDetails productDetails : products) {
            if (productDetails.getProduct().equals(productToFind)) {
                searchedProductDetails = productDetails;
            }
        }
        return searchedProductDetails;
    }

    public void addProduct(Product productToAdd, double quantityToAdd) {
        ProductDetails productDetails = findProductDetailsByProduct(productToAdd);
        if (productDetails == null) {
            ProductDetails newProductDetails = new ProductDetails(productToAdd, quantityToAdd);
            products.add(newProductDetails);
        } else {
            productDetails.addQuantity(quantityToAdd);
        }
    }

    public Product getProduct(int productId) {
        for (ProductDetails productDetails : products) {
            if (productDetails.getProduct().getId() == productId) {
                return productDetails.getProduct();
            }
        }
        return null;
    }



    /*public void removeProduct(int productId, double quantity){
        shopilingus.Product searchedProduct = getProduct(productId);
        shopilingus.ProductDetails findByProduct = findProductDetailsByProduct(searchedProduct);
        findByProduct.quantity -= quantity;
        if (findByProduct.quantity == 0){
            products.remove(findByProduct);
        }
    }
    */

    public void deleteProduct(int productId) {
        for (ProductDetails productDetails : products) {
            if (productDetails.getProduct().getId() == productId) {
                this.products.remove(productDetails);
            }
        }
    }

    public void updateProduct(int productId, Product modifiedProduct) {
        ProductDetails productDetails = findProductDetailsByProduct(getProduct(productId));
        deleteProduct(productId);
        modifiedProduct.setId(productId);
        addProduct(modifiedProduct, productDetails.getQuantity());
    }

    public void addService(Service service) {
        this.services.add(service);
    }

    public void deleteService(int serviceId) {
        this.services.remove(getServiceById(serviceId));
    }

    public Service getServiceById(int serviceId) {
        for (Service service : services) {
            if (service.getId() == serviceId) {
                return service;
            }
        }
        return null;
    }

    public void updateService(int serviceId, Service modifiedService) {
        deleteService(serviceId);
        modifiedService.setId(serviceId);
        addService(modifiedService);
    }

}
