package shopilingus.filtering.chain.filters;

import shopilingus.Shop;
import shopilingus.filtering.FilteringParams;
import shopilingus.filtering.chain.ShopFilter;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FloorFilter implements ShopFilter {
    @Override
    public List<Shop> filter(List<Shop> shopsToFilter, FilteringParams params) {
        List<Shop> result = new LinkedList<>();
        Set<Integer> expectedFloors = params.getFloors();
        for (Shop shop : shopsToFilter) {
            if (expectedFloors.contains(shop.getLocation().getFloor())) {
                result.add(shop);
            }
        }
        return result;
    }
}
