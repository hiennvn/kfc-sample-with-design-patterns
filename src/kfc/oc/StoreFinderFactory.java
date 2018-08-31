package kfc.oc;

import java.util.List;
import kfc.shared.communication.Store;

/**
 *
 * @author hien
 */

enum FindingCriteria {
    LOCATION
}

class StoreFinderFactory {
    
    static StoreFinderStrategy createStrategy(FindingCriteria criteria, List<Store> stores) {
        switch (criteria) {
            case LOCATION:
                return new StoreFinderByLocation(stores);
        }
        return null;
    }
}
