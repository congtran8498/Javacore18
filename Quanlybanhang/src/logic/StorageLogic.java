package logic;

import entity.Product;
import entity.Storage;
import util.FileUtil;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StorageLogic {
    private List<Storage> storages;

    public StorageLogic(List<Storage> storages) {
        this.storages = storages;
    }

    public List<Storage> getStorages() {
        return storages;
    }

    public void setStorages(List<Storage> storages) {
        this.storages = storages;
    }

    public void inputStorage() {
        System.out.println("Nhập số lượng kho hàng: ");
        int storageNumber;
        do {
            try {
                storageNumber = new Scanner(System.in).nextInt();
                if (storageNumber > 0) {
                    break;
                }
                System.out.println("Lựa chọn phải dương, vui lòng chọn lại");
            } catch (InputMismatchException e) {
                System.out.println("Nhập sai định dạng, hãy nhập lại: ");
            }
        } while (true);
        int max = 0;
        for (int i = 0; i < storages.size(); i++) {
            max = storages.get(storages.size()-1).getIdStorage();
        }
        for (int i = 0; i < storageNumber; i++) {
            System.out.println("Nhập thông tin kho thứ " + (i + 1));
            Storage storage = new Storage();
            storage.inputInfo();
            storage.setIdStorage(++max);
            saveStorage(storage);
        }
        FileUtil<Storage> storageFileUtil = new FileUtil<>();
        storageFileUtil.writeDataToFile("Storage.dat", storages);
    }

    private void saveStorage(Storage storage) {
        storages.add(storage);
    }

    public void showStorage() {
        if(storages.size() == 0){
            System.out.println("Danh sách trống");
            return;
        }
        for (Storage s : storages) {
            System.out.println(s);
        }
    }

    public Storage searchById(int idStorage) {
        Storage storage = null;
        for (int i = 0; i < storages.size(); i++) {
            if(storages.get(i).getIdStorage() == idStorage){
                storage = storages.get(i);
                break;
            }
        }
        return storage;
    }
    public Storage findStorage() {
        Storage storage;
        int idStorage;
        do {
            try {
                idStorage = new Scanner(System.in).nextInt();
                if (idStorage <= 0) {
                    System.out.println("Mã kho phải dương, vui lòng nhập lại: ");
                    continue;
                }
                storage = searchById(idStorage);
                if (storage != null) {
                    break;
                }
                System.out.println("Không tìm thấy kho có mã " + idStorage + ",vui lòng nhập lại: ");
            } catch (InputMismatchException e) {
                System.out.println("Nhập sai định dạng, hãy nhập lại: ");
            }
        } while (true);
        return storage;
    }
    public void updateStorage(){
        System.out.println("Nhập mã kho muốn sửa: ");
        Storage storage = findStorage();
        storage.inputInfo();
        FileUtil<Storage> storageFileUtil = new FileUtil<>();
        storageFileUtil.writeDataToFile("Storage.dat", storages);
    }
    public void deleteStorage(){
        System.out.println("Nhập mã kho muốn xóa: ");
        Storage storage = findStorage();
        storages.remove(storage);
        FileUtil<Storage> storageFileUtil = new FileUtil<>();
        storageFileUtil.writeDataToFile("Storage.dat", storages);
    }
}
