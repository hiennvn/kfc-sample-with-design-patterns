package kfc.oc;

import kfc.shared.communication.Store;

/**
 *
 * @author hien
 */
interface StoreFinderStrategy {
    public Store getNextStore();
}
