package shopilingus.filtering.chain.filters;

import shopilingus.Shop;
import shopilingus.filtering.FilteringParams;
import shopilingus.filtering.chain.ShopFilter;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ShopIdsFilter implements ShopFilter {
    @Override
    public List<Shop> filter(List<Shop> shopsToFilter, FilteringParams params) {
        List<Shop> result = new LinkedList<>();
        Set<Integer> expectedIds = params.getShopIds();
        for (Shop shop : shopsToFilter) {
            if (expectedIds.contains(shop.getId())) {
                result.add(shop);
            }
        }
        return result;
    }
}
