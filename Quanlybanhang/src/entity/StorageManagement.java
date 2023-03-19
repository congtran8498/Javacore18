package entity;

import java.io.Serializable;
import java.util.List;

public class StorageManagement implements Serializable {
    private Storage storage;
    private List<StorageManagementDetail> storageManagementDetails;

    public StorageManagement(Storage storage, List<StorageManagementDetail> storageManagementDetails) {
        this.storage = storage;
        this.storageManagementDetails = storageManagementDetails;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public List<StorageManagementDetail> getStorageManagementDetails() {
        return storageManagementDetails;
    }

    public void setStorageManagementDetails(List<StorageManagementDetail> storageManagementDetails) {
        this.storageManagementDetails = storageManagementDetails;
    }

    @Override
    public String toString() {
        return "StorageManagement{" +
                "storage=" + storage +
                ", storageManagementDetails=" + storageManagementDetails +
                '}';
    }

}
