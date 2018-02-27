package shopilingus.filtering.classic;

import shopilingus.Shop;
import shopilingus.ShoppingCenter;
import shopilingus.filtering.FilteringParams;
import shopilingus.filtering.FilteringService;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ClassicFilteringService implements FilteringService {
    @Override
    public List<Shop> filterShops(ShoppingCenter shoppingCenter, FilteringParams params) {
        List<Shop> shops = shoppingCenter.getALLShops();
        shops = filterByShopNamePhrase(shops, params);
        shops = filterByShopIds(shops, params);
        shops = filterByShopTypes(shops, params);
        shops = filterByFloor(shops, params);
        return shops;
    }

    private List<Shop> filterByShopNamePhrase(List<Shop> shops, FilteringParams params) {
        return shops.stream()
                .filter(shop -> shop.getName().contains(params.getShopNamePhrase()))
                .collect(Collectors.toList());
    }

    private List<Shop> filterByShopIds(List<Shop> shops, FilteringParams params) {
        List<Shop> result = new LinkedList<>();
        Set<Integer> expectedShopIds = params.getShopIds();
        for (Shop shop : shops) {
            if (expectedShopIds.contains(shop.getId())) {
                result.add(shop);
            }
        }
        return result;
    }

    private List<Shop> filterByShopTypes(List<Shop> shops, FilteringParams params) {
        return shops.stream()
                .filter(shop -> !Collections.disjoint(shop.getTypes(), params.getShopTypes()))
                .collect(Collectors.toList());
    }

    private List<Shop> filterByFloor(List<Shop> shops, FilteringParams params) {
        List<Shop> result = new LinkedList<>();
        Set<Integer> expectedFloors = params.getFloors();
        for (Shop shop : shops) {
            if (expectedFloors.contains(shop.getLocation().getFloor())) {
                result.add(shop);
            }
        }
        return result;
    }


}
