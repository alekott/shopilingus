package shopilingus.filtering.chain.filters;

import shopilingus.Shop;
import shopilingus.filtering.FilteringParams;
import shopilingus.filtering.chain.ShopFilter;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ShopTypesFilter implements ShopFilter {
    @Override
    public List<Shop> filter(List<Shop> shopsToFilter, FilteringParams params) {
        return shopsToFilter.stream()
                .filter(shop -> !Collections.disjoint(shop.getTypes(), params.getShopTypes()))
                .collect(Collectors.toList());
    }
}
