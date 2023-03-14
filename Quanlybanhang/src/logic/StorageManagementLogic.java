package logic;

import entity.Product;
import entity.Storage;
import entity.StorageManagement;
import util.FileUtil;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StorageManagementLogic {
    private StorageLogic storageLogic;
    private List<StorageManagement> storageManagements;


    public StorageManagementLogic(StorageLogic storageLogic, List<StorageManagement> storageManagements) {
        this.storageLogic = storageLogic;
        this.storageManagements = storageManagements;
    }

    public void inputProductToStorage() {
        System.out.println("Muốn nhập hàng cho mấy kho hàng: ");
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

        for (int i = 0; i < storageNumber; i++) {
            System.out.println("Nhập mã của kho hàng thứ " + (i + 1));
            Storage storage = inputStorage();
//            List<Product> products = new ArrayList<>();
            for (int k = 0; k < storageManagements.size(); k++) {
                if (storage.getIdStorage() == storageManagements.get(k).getStorage().getIdStorage()) {
                    System.out.println("Nhập bao nhiêu loại sản phẩm cho kho hàng: ");
                    int productNumber;
                    do {
                        try {
                            productNumber = new Scanner(System.in).nextInt();
                            if (productNumber > 0) {
                                break;
                            }
                            System.out.println("Lựa chọn phải dương, vui lòng chọn lại");
                        } catch (InputMismatchException e) {
                            System.out.println("Nhập sai định dạng, hãy nhập lại: ");
                        }
                    } while (true);




//                    int max = storageManagements.get(k).getProducts().size();
                    int max = 0;
                    for (int h = 0; h < storageManagements.get(k).getProducts().size(); h++) {
                        if (max < storageManagements.get(k).getProducts().get(h).getId()){
                            max = storageManagements.get(k).getProducts().get(h).getId();
                        }
                    }
                    for (int j = 0; j < productNumber; j++) {
                        Product product = new Product();
                        product.inputInfo();
                        product.setId(++max);
                        storageManagements.get(k).getProducts().add(product);
                    }
                    return;
                }
            }
            System.out.println("Nhập bao nhiêu loại sản phẩm cho kho hàng: ");
            int productNumber;
            do {
                try {
                    productNumber = new Scanner(System.in).nextInt();
                    if (productNumber > 0) {
                        break;
                    }
                    System.out.println("Lựa chọn phải dương, vui lòng chọn lại");
                } catch (InputMismatchException e) {
                    System.out.println("Nhập sai định dạng, hãy nhập lại: ");
                }
            } while (true);
            int max = 0;
            for (int j = 0; j < productNumber; j++) {
                Product product = new Product();
                product.inputInfo();
                product.setId(++max);
                products.add(product);
            }
            StorageManagement storageManagement = new StorageManagement(storage, products);
            storageManagements.add(storageManagement);
        }
        FileUtil<StorageManagement> storageManagementFileUtil = new FileUtil<>();
        storageManagementFileUtil.writeDataToFile("StorageManagement.dat", storageManagements);
    }

    public void showStorageManagement() {
        for (StorageManagement sm : storageManagements) {
            System.out.println(sm);
        }
    }

    private Storage inputStorage() {
        Storage storage;
        int idStorage;
        do {
            try {
                idStorage = new Scanner(System.in).nextInt();
                if (idStorage <= 0) {
                    System.out.println("Mã kho hàng phải dương, vui lòng nhập lại: ");
                    continue;
                }
                storage = storageLogic.searchById(idStorage);
                if (storage != null) {
                    break;
                }
                System.out.println("Không tìm thấy kho hàng có mã " + (idStorage) + ", vui lòng nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.println("Nhập sai định dạng, hãy nhập lại: ");
            }
        } while (true);
        return storage;
    }

    public void updateStorage() {
        showStorageManagement();
        System.out.println("Nhập mã kho muốn sửa: ");
        StorageManagement storageManagement = null;
        int idStorage;
        do {
            try {
                idStorage = new Scanner(System.in).nextInt();
                if (idStorage <= 0) {
                    System.out.println("Mã kho hàng phải dương, vui lòng nhập lại: ");
                    continue;
                }
                for (int i = 0; i < storageManagements.size(); i++) {
                    if (storageManagements.get(i).getStorage().getIdStorage() == idStorage) {
                        storageManagement = storageManagements.get(i);
                        break;
                    }
                }
                if (storageManagement != null) {
                    break;
                }
                System.out.println("Không tìm thấy kho hàng có mã " + (idStorage) + ", vui lòng nhập lại: ");
            } catch (InputMismatchException e) {
                System.out.println("Nhập sai định dạng, hãy nhập lại: ");
            }
        } while (true);
        System.out.println("Nhập số loại sản phẩm muốn thay đổi: ");
        int productNumber;
        do {
            try {
                productNumber = new Scanner(System.in).nextInt();
                if (productNumber > 0 && productNumber <= storageManagement.getProducts().size()) {
                    break;
                }
                System.out.println("số lượng phải dương và nhỏ hơn số loai sản phẩm trong kho, vui lòng nhập lại: ");
            } catch (InputMismatchException e) {
                System.out.println("Nhập sai định dạng, vui lòng nhập lại: ");
            }
        } while (true);
        for (int i = 0; i < productNumber; i++) {
            System.out.println("Nhập mã của sản phẩm thứ " + (i + 1) + " là: ");
            int productId;
            Product product = null;
            do {
                try {
                    productId = new Scanner(System.in).nextInt();
                    if (productId <= 0) {
                        System.out.println("mã sản phẩm phải dương,vui lòng nhập lại: ");
                        continue;
                    }
                    for (int j = 0; j < storageManagement.getProducts().size(); j++) {
                        if (storageManagement.getProducts().get(j).getId() == productId) {
                            product = storageManagement.getProducts().get(j);
                            break;
                        }
                    }
                    if (product != null) {
                        break;
                    }
                    System.out.println("Không tìm thấy sản phẩm có mã " + productId + ", vui lòng nhập lại: ");
                } catch (InputMismatchException e) {
                    System.out.println("Nhập sai định dạng, vui lòng nhập lại: ");
                }
            } while (true);
            product.inputInfo();
        }
    }
}
