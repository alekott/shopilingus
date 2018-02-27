package shopilingus.filtering.chain.filters;

import shopilingus.Shop;
import shopilingus.filtering.FilteringParams;
import shopilingus.filtering.chain.ShopFilter;

import java.util.List;
import java.util.stream.Collectors;

public class ShopNamePhraseFilter implements ShopFilter {
    @Override
    public List<Shop> filter(List<Shop> shopsToFilter, FilteringParams params) {
        return shopsToFilter.stream()
                .filter(shop -> shop.getName().contains(params.getShopNamePhrase()))
                .collect(Collectors.toList());
    }
}
