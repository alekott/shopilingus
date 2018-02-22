package shopilingus.filtering.chain;

import shopilingus.Shop;
import shopilingus.ShoppingCenter;
import shopilingus.filtering.FilteringParams;
import shopilingus.filtering.FilteringService;
import shopilingus.filtering.chain.filters.FloorFilter;
import shopilingus.filtering.chain.filters.ShopIdsFilter;
import shopilingus.filtering.chain.filters.ShopNamePhraseFilter;
import shopilingus.filtering.chain.filters.ShopTypesFilter;

import java.util.Arrays;
import java.util.List;

public class ChainFilteringService implements FilteringService {

    private static List<ShopFilter> getChainOfFilters() {
        return Arrays.asList(
                new ShopNamePhraseFilter(),
                new ShopIdsFilter(),
                new ShopTypesFilter(),
                new FloorFilter()
        );
    }

    @Override
    public List<Shop> filterShops(ShoppingCenter shoppingCenter, FilteringParams params) {
        List<Shop> shops = shoppingCenter.getALLShops();
        for (ShopFilter filter : getChainOfFilters()) {
            shops = filter.filter(shops, params);
        }
        return shops;
    }
}
