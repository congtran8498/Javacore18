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

    public List<StorageManagement> getStorageManagements() {
        return storageManagements;
    }

    public void setStorageManagements(List<StorageManagement> storageManagements) {
        this.storageManagements = storageManagements;
    }

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
                if (storageNumber > 0 && storageNumber<= storageLogic.getStorages().size()) {
                    break;
                }
                System.out.println("Lựa chọn phải dương và nhỏ hơn hoặc bằng số lượng kho đã có, vui lòng chọn lại");
            } catch (InputMismatchException e) {
                System.out.println("Nhập sai định dạng, hãy nhập lại: ");
            }
        } while (true);

        for (int i = 0; i < storageNumber; i++) {
            System.out.println("Nhập mã của kho hàng thứ " + (i + 1));
            Storage storage = storageLogic.findStorage();
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
                            if (productNumber > 0 && productNumber <= productLogic.getProducts().size()) {
                                break;
                            }
                            System.out.println("Lựa chọn phải dương và phải nhỏ hơn số lượng sản phẩm đã có, vui lòng chọn lại");
                        } catch (InputMismatchException e) {
                            System.out.println("Nhập sai định dạng, hãy nhập lại: ");
                        }
                    } while (true);
                    for (int k = 0; k < productNumber; k++) {
                        System.out.println("Nhập mã sản phẩm thứ " + (k + 1));
                        Product product = productLogic.findProduct();
                        boolean isExist1=false;
                        for (int l = 0; l < danhSachSanPham.size(); l++) {
                            if (danhSachSanPham.get(l).getProduct().getId() == product.getId()) {
                                System.out.println("Nhập số lượng sản phẩm: ");
                                int quantity;
                                do {
                                    try {
                                        quantity = new Scanner(System.in).nextInt();
                                            break;
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
                                break;
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
                    if (productNumber > 0 && productNumber <= productLogic.getProducts().size()) {
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
            Product product = productLogic.findProduct();
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


    public void showStorageManagement() {
        if(storageManagements.size() == 0){
            System.out.println("Danh sách trống");
            return;
        }
        for (StorageManagement sm : storageManagements) {
            System.out.println(sm);
        }
    }
    private StorageManagement findStorage(){
        StorageManagement storageManagement;
        int idStorage;
        do {
            try {
                idStorage = new Scanner(System.in).nextInt();
                if(idStorage <0){
                    System.out.println("Mã kho hàng phải dương, vui lòng nhập lại: ");
                    continue;
                }
                storageManagement = searchById(idStorage);
                if(storageManagement != null){
                    break;
                }
                System.out.println("Không tìm thấy kho hàng mã "+idStorage+", vui lòng nhập lại: ");
            }catch (InputMismatchException e){
                System.out.println("Nhập sai định dạng, hãy nhập lại: ");
            }
        }while (true);
        return storageManagement;
    }

    private StorageManagement searchById(int idStorage) {
        StorageManagement storageManagement = null;
        for (int i = 0; i < storageManagements.size(); i++) {
            if(storageManagements.get(i).getStorage().getIdStorage() == idStorage){
                storageManagement = storageManagements.get(i);
                break;
            }
        }
        return storageManagement;
    }
    public void deleteStorage(){
        System.out.println("Nhập mã kho muốn xóa");
        StorageManagement storageManagement = findStorage();
        storageManagements.remove(storageManagement);
        FileUtil<StorageManagement> storageManagementFileUtil = new FileUtil<>();
        storageManagementFileUtil.writeDataToFile("StorageManagement.dat", storageManagements);
    }
    public void deleteProductFromStorage(){
        System.out.println("Nhập mã kho hàng muốn xóa sản phẩm: ");
        StorageManagement storageManagement = findStorage();
        List<StorageManagementDetail> storageManagementDetails = storageManagement.getStorageManagementDetails();
        StorageManagementDetail storageManagementDetail = null;
        int idProduct;
        System.out.println("Nhập mã sản phẩm muốn xóa: ");
        do {
            try {
                idProduct = new Scanner(System.in).nextInt();
                if(idProduct<=0){
                    System.out.println("Mã sản phẩm phải dương, vui lòng nhập lại: ");
                    continue;
                }
                for (int i = 0; i < storageManagementDetails.size(); i++) {
                    if(storageManagementDetails.get(i).getProduct().getId() == idProduct){
                        storageManagementDetail = storageManagementDetails.get(i);
                        break;
                    }
                }
                if(storageManagementDetail!= null){
                    break;
                }
                System.out.println("Không tìm thấy sản phẩm có mã "+idProduct+", vui lòng nhập lại: ");
            }catch (InputMismatchException e){
                System.out.println("Nhập sai định dạng, hãy nhập lại: ");
            }
        }while (true);
        storageManagementDetails.remove(storageManagementDetail);
        FileUtil<StorageManagement> storageManagementFileUtil = new FileUtil<>();
        storageManagementFileUtil.writeDataToFile("StorageManagement.dat", storageManagements);
    }

}
