import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCenter {

    private String name;
    private String address;
    private List<Shop> shops;


    public ShoppingCenter(String name, String address){
        this.name = name;
        this.address = address;
    }

    /*private void addShop(Shop shop){
        for(int i = 0; i < this.shops.size(); i++){
            if(shops.get(i).name.equals(shop.name)){
                return;
            }
        }
        shops.add(shop);
    }
    */

    public void addShop(Shop shop){
        shops.add(shop);
    }

    /*
    public Shop getShop(int shopId){
        for( Shop shop : shops){
            if(shop.id == shopId){
                return shop;
            }
        }
        return null;
    }
    */

    public void updateShop(int shopId, Shop modifiedShop){
        deleteShop(shopId);
        modifiedShop.id = shopId;
        addShop(modifiedShop);
    }

    public void deleteShop (int shopId){
        shops.remove(getShop(shopId));
    }

    /*
    public List<Shop> findShopsByName(String name){
        List<Shop> list = new LinkedList<Shop>();
        for (Shop shop : shops){
            if(shop.name.equals(name)){
                list.add(shop);
            }
        }
        return list;
    }
    */
    public List<Shop> findShopsByName(final String name){
        return shops.stream()
                .filter(shop -> shop.name.equals(name))
                .collect(Collectors.toList());
    }

    public Shop getShop(int shopId){
        return shops.stream()
                .filter(shop -> shop.id == shopId)
                .findAny()
                .orElse(null);
    }

    
}
