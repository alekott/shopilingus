package shopilingus.filtering.stream;

import shopilingus.Shop;
import shopilingus.ShoppingCenter;
import shopilingus.filtering.FilteringParams;
import shopilingus.filtering.FilteringService;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilteringService implements FilteringService {
    @Override
    public List<Shop> filterShops(ShoppingCenter shoppingCenter, FilteringParams params) {
        return shoppingCenter.getALLShops().stream()
                .filter(shop -> shop.getName().contains(params.getShopNamePhrase()))
                .filter(shop -> params.getShopIds().contains(shop.getId()))
                .filter(shop -> !Collections.disjoint(shop.getTypes(), params.getShopTypes()))
                .filter(shop -> params.getFloors().contains(shop.getLocation().getFloor()))
                .collect(Collectors.toList());
    }
}
