package shopilingus.filtering.chain;

import shopilingus.Shop;
import shopilingus.filtering.FilteringParams;

import java.util.List;

public interface ShopFilter {
    List<Shop> filter(List<Shop> shopsToFilter, FilteringParams params);
}
