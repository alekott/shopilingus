package shopilingus;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ShoppingCenter {

    private static int nextId = 0;

    private int id;
    private String name;
    private String address;
    private List<Shop> shops;


    public ShoppingCenter(String name, String address) {
        this.id = ShoppingCenter.nextId++;
        this.name = name;
        this.shops = new LinkedList<Shop>();
        this.address = address;
    }

    public List<Shop> getALLShops() {
        return shops;
    }

    /*private void addShop(shopilingus.Shop shop){
        for(int i = 0; i < this.shops.size(); i++){
            if(shops.get(i).name.equals(shop.name)){
                return;
            }
        }
        shops.add(shop);
    }
    */

    public void addShop(Shop shop) {
        shops.add(shop);
    }

    /*
    public shopilingus.Shop getShop(int shopId){
        for( shopilingus.Shop shop : shops){
            if(shop.id == shopId){
                return shop;
            }
        }
        return null;
    }
    */

    public void updateShop(int shopId, Shop modifiedShop) {
        deleteShop(shopId);
        modifiedShop.setId(shopId);
        addShop(modifiedShop);
    }

    public void deleteShop(int shopId) {
        shops.remove(getShop(shopId));
    }

    /*
    public List<shopilingus.Shop> findShopsByName(String name){
        List<shopilingus.Shop> list = new LinkedList<shopilingus.Shop>();
        for (shopilingus.Shop shop : shops){
            if(shop.name.equals(name)){
                list.add(shop);
            }
        }
        return list;
    }
    */
    public List<Shop> findShopsByName(final String name) {
        return shops.stream()
                .filter(shop -> shop.getName().equals(name))
                .collect(Collectors.toList());
    }

    public Shop getShop(int shopId) {
        return shops.stream()
                .filter(shop -> shop.getId() == shopId)
                .findAny()
                .orElse(null);
    }

    public List<Product> getAllProducts() {
        List<Product> list = new LinkedList<>();
        for (Shop shop : shops) {
            for (ProductDetails productDetails : shop.getProducts()) {
                list.add(productDetails.getProduct());
            }
        }
        return list;
    }


    public List<Service> getAllServices() {
        List<Service> list = new LinkedList<>();
        for (Shop shop : shops) {
            for (Service service : shop.getServices()) {
                if (!list.contains(service)) {
                    list.add(service);
                }
            }
        }
        return list;
    }

    public List<ShopType> getAllShopTypes() {
        List<ShopType> list = new LinkedList<>();
        for (Shop shop : shops) {
            for (ShopType type : shop.getTypes()) {
                list.add(type);
            }
        }
        return list;
    }

    public Set<ProductType> getAllProductTypes() {
        List<Product> list = getAllProducts();
        Set<ProductType> typesList = new HashSet<>();
        for (Product product : list) {
            typesList.add(product.getType());
        }
        return typesList;
    }

    public Set<ProductType> getAllProductTypes2() {
        return getAllProducts().stream()
                .map(product -> product.getType())
                .collect(Collectors.toSet());
    }


}
