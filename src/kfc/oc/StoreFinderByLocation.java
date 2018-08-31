package kfc.oc;

import java.util.ArrayList;
import java.util.List;
import kfc.shared.communication.Store;

/**
 *
 * @author hien
 */
class StoreFinderByLocation implements StoreFinderStrategy {
    
    private final List<Store> stores;
    private int lastStoreIndex = 0;

    public StoreFinderByLocation(List<Store> stores) {
        this.stores = new ArrayList<>();
        stores.forEach((store) -> {
            this.stores.add(store);
        });
        
        stores.sort((Store o1, Store o2) -> o1.hashCode() - o2.hashCode());
    }
    
    @Override
    public Store getNextStore() {
        if (lastStoreIndex <= stores.size())
            throw new IndexOutOfBoundsException("No more store");
        
        return stores.get(lastStoreIndex++);
    }
    
}
