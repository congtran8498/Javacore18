package logic;

import entity.Product;
import entity.Storage;
import entity.StorageManagement;
import entity.StorageManagementDetail;
import util.FileUtil;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StorageManagementLogic {
    private List<StorageManagement> storageManagements;
    private StorageLogic storageLogic;
    private ProductLogic productLogic;

    public StorageManagementLogic(List<StorageManagement> storageManagements, StorageLogic storageLogic, ProductLogic productLogic) {
        this.storageManagements = storageManagements;
        this.storageLogic = storageLogic;
        this.productLogic = productLogic;
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
            boolean isExist = false;
            for (int j = 0; j < storageManagements.size(); j++) {
                if (storageManagements.get(j).getStorage().getIdStorage() == storage.getIdStorage()) {
                    StorageManagement danhSachKho = storageManagements.get(j);
                    List<StorageManagementDetail> danhSachSanPham = danhSachKho.getStorageManagementDetails();
                    System.out.println("Nhập bao nhiêu loại sản phẩm: ");
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
                    for (int k = 0; k < productNumber; k++) {
                        System.out.println("Nhập mã sản phẩm thứ " + (k + 1));
                        Product product = inputProduct();
                        boolean isExist1=false;
                        for (int l = 0; l < danhSachSanPham.size(); l++) {
                            if (danhSachSanPham.get(l).getProduct().getId() == product.getId()) {
                                System.out.println("Nhập số lượng sản phẩm: ");
                                int quantity;
                                do {
                                    try {
                                        quantity = new Scanner(System.in).nextInt();
                                        if (quantity > 0) {
                                            break;
                                        }
                                        System.out.println("Số lượng phải dương, vui lòng nhập lại: ");
                                    } catch (InputMismatchException e) {
                                        System.out.println("Nhập sai định dạng, vui lòng nhập lại: ");
                                    }
                                } while (true);
                                danhSachSanPham.get(l).setQuantity(quantity + danhSachSanPham.get(l).getQuantity());
                                isExist1=true;
                                break;
                            }
                        }
                        if(isExist1){
                            continue;
                        }
                        System.out.println("Nhập số lượng sản phẩm: ");
                        int quantity;
                        do {
                            try {
                                quantity = new Scanner(System.in).nextInt();
                                if (quantity > 0) {
                                    break;
                                }
                                System.out.println("số lượng phải dương, vui lòng nhập lại: ");
                            } catch (InputMismatchException e) {
                                System.out.println("Nhập sai định dạng, vui lòng nhập lại: ");
                            }
                        } while (true);
                        StorageManagementDetail storageManagementDetail = new StorageManagementDetail(product, quantity);
                        danhSachSanPham.add(storageManagementDetail);
                    }
                    isExist = true;
                    break;
                }
            }
            if (isExist) {
                continue;
            }
            System.out.println("Nhập bao nhiêu loại sản phẩm: ");
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
            List<StorageManagementDetail> storageManagementDetails = nhapDanhSachSanPham(productNumber);
            StorageManagement storageManagement = new StorageManagement(storage, storageManagementDetails);
            storageManagements.add(storageManagement);
        }
        FileUtil<StorageManagement> storageManagementFileUtil = new FileUtil<>();
        storageManagementFileUtil.writeDataToFile("StorageManagement.dat", storageManagements);
    }

    private List<StorageManagementDetail> nhapDanhSachSanPham(int productNumber) {
        List<StorageManagementDetail> storageManagementDetails = new ArrayList<>();
        for (int i = 0; i < productNumber; i++) {
            System.out.println("Nhập mã của sản phẩm thứ " + (i + 1) + " là: ");
            Product product = inputProduct();
            System.out.println("Nhập số lượng sản phẩm: ");
            int quantity;
            do {
                try {
                    quantity = new Scanner(System.in).nextInt();
                    if (quantity > 0) {
                        break;
                    }
                    System.out.println("số lượng phải dương, vui lòng nhập lại: ");
                } catch (InputMismatchException e) {
                    System.out.println("Nhập sai định dạng, vui lòng nhập lại: ");
                }
            } while (true);
            StorageManagementDetail storageManagementDetail = new StorageManagementDetail(product, quantity);
            storageManagementDetails.add(storageManagementDetail);
        }
        return storageManagementDetails;
    }

    private Product inputProduct() {
        Product product;
        int idProduct;
        do {
            try {
                idProduct = new Scanner(System.in).nextInt();
                if (idProduct <= 0) {
                    System.out.println("Mã sản phẩm phải dương, vui lòng nhập lại: ");
                    continue;
                }
                product = productLogic.searchById(idProduct);
                if (product != null) {
                    break;
                }
                System.out.println("Không tìm thấy sản phẩm có mã " + idProduct + ",vui lòng nhập lại: ");
            } catch (InputMismatchException e) {
                System.out.println("Nhập sai định dạng, hãy nhập lại: ");
            }
        } while (true);
        return product;
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

}
