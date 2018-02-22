package shopilingus.filtering;

import shopilingus.ShopType;

import java.util.List;
import java.util.Set;

public class FilteringParams {
    private String shopNamePhrase;
    private Set<ShopType> shopTypes;
    private Set<Integer> shopIds;
    private double minPrice;
    private double maxPrice;
    private Set<Integer> floors;

    public Set<Integer> getShopIds() {
        return shopIds;
    }

    public void setShopIds(Set<Integer> shopIds) {
        this.shopIds = shopIds;
    }

    public String getShopNamePhrase() {
        return shopNamePhrase;
    }

    public void setShopNamePhrase(String shopNamePhrase) {
        this.shopNamePhrase = shopNamePhrase;
    }

    public Set<Integer> getFloors() {
        return floors;
    }

    public void setFloors(Set<Integer> floors) {
        this.floors = floors;
    }

    public Set<ShopType> getShopTypes() {
        return shopTypes;
    }

    public void setShopTypes(Set<ShopType> shopTypes) {
        this.shopTypes = shopTypes;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }
}

