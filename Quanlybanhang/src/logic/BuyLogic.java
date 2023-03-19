package logic;

import entity.*;
import util.FileUtil;

import java.text.SimpleDateFormat;
import java.util.*;

public class BuyLogic {
    private CategoryLogic categoryLogic;
    private ProductLogic productLogic;
    private StorageLogic storageLogic;
    private StorageManagementLogic storageManagementLogic;
    private List<BuyHistory> buyListHistory;
    private AccountLogic accountLogic;
    private List<Product> productList;
    private List<Buy> buyList;
    private List<Buy> buyListSuccess;
    private double total;

    public List<BuyHistory> getBuyListHistory() {
        return buyListHistory;
    }

    public void setBuyListHistory(List<BuyHistory> buyListHistory) {
        this.buyListHistory = buyListHistory;
    }

    public BuyLogic(CategoryLogic categoryLogic, ProductLogic productLogic, StorageLogic storageLogic, StorageManagementLogic storageManagementLogic, List<BuyHistory> buyListHistory, AccountLogic accountLogic) {
        this.categoryLogic = categoryLogic;
        this.productLogic = productLogic;
        this.storageLogic = storageLogic;
        this.storageManagementLogic = storageManagementLogic;
        this.buyListHistory = buyListHistory;
        this.accountLogic = accountLogic;
    }

    public void buyProduct() {
        buyList = new ArrayList<>();
        buyListSuccess = new ArrayList<>();
        while (true) {
            categoryLogic.showCategory();
            System.out.println("Nhập mã loại sản phẩm muốn xem");
            Category category = categoryLogic.findCategory();
            productList = new ArrayList<>();
            for (int i = 0; i < productLogic.getProducts().size(); i++) {
                if (productLogic.getProducts().get(i).getCategory().getId() == category.getId()) {
                    System.out.println(productLogic.getProducts().get(i));
                    productList.add(productLogic.getProducts().get(i));
                }
            }
            System.out.println("Nhập mã sản phẩm muốn thêm vào giỏ hàng: ");
            Product product = findProduct();
            System.out.println("Nhập số lượng muốn mua: ");
            int quantity;
            double price;
            do {
                try {
                    quantity = new Scanner(System.in).nextInt();
                    if (quantity > 0) {
                        break;
                    }
                    System.out.println("Số lượng phải dương, vui lòng nhập lại: ");
                } catch (InputMismatchException e) {
                    System.out.println("Nhập sai định dạng, vui long nhập lại: ");
                }
            } while (true);
            Date now = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/YYYY hh:mm:ss");
            String date = simpleDateFormat.format(now);
            if (product.getDiscountToDate() == null && product.getDiscountFromDate() == null) {
                price = quantity * product.getPrice();
            } else {
                if (now.after(product.getDiscountFromDate()) && now.before(product.getDiscountToDate())) {
                    price = quantity * product.getPrice() * (100 - product.getDiscount()) / 100;
                } else {
                    price = quantity * product.getPrice();
                }
            }
            total += price;
            Buy buy = new Buy(product, quantity, price, date);
            buyList.add(buy);
            System.out.println("Mời chọn: ");
            System.out.println("1. Mua tiếp");
            System.out.println("2. Thanh toán");
            int choice;
            do {
                try {
                    choice = new Scanner(System.in).nextInt();
                    if (choice > 0 && choice <= 2) {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Nhập sai định dạng, hãy nhập lại: ");
                }
            } while (true);
            if (choice == 2) {
                break;
            }
        }
        System.out.println("Tổng tiền: " + total);
        storageLogic.showStorage();
        System.out.println("Chọn mã kho bạn muốn lấy hàng: ");
        StorageManagement storageManagement = null;
        do {
            Storage storage = storageLogic.findStorage();
            for (int i = 0; i < storageManagementLogic.getStorageManagements().size(); i++) {
                if (storage.getIdStorage() == storageManagementLogic.getStorageManagements().get(i).getStorage().getIdStorage()) {
                    storageManagement = storageManagementLogic.getStorageManagements().get(i);
                    break;
                }
            }
            if (storageManagement != null) {
                break;
            }
            System.out.println("Kho này chưa hoạt động");
        } while (true);

        for (int i = 0; i < buyList.size(); i++) {
            boolean isExist=false;
            Buy buy = buyList.get(i);
            for (int j = 0; j < storageManagement.getStorageManagementDetails().size(); j++) {
                if (buyList.get(i).getProduct().getId() == storageManagement.getStorageManagementDetails().get(j).getProduct().getId()) {
                    isExist = true;
                    if (storageManagement.getStorageManagementDetails().get(j).getQuantity() < buyList.get(i).getQuantity()) {
                        System.out.println("Kho hàng không đủ số lượng của mặt hàng " + buyList.get(i).getProduct() + ", vui lòng đợi 1 vài hôm để nhập hàng.");
                        break;
                    } else {
                        storageManagement.getStorageManagementDetails().get(j).setQuantity(storageManagement.getStorageManagementDetails().get(j).getQuantity() - buyList.get(i).getQuantity());
                        buyListSuccess.add(buyList.get(i));
                        System.out.println("Mua sản phẩm " + buyList.get(i) + " thành công");
                    }
                }
            }
            if(!isExist){
                System.out.println("Kho hàng không có mặt hàng này"+buy);
            }
        }
        BuyHistory buyHistory = new BuyHistory(accountLogic.getUser(), buyListSuccess);
        buyListHistory.add(buyHistory);
        FileUtil<BuyHistory> buyHistoryFileUtil = new FileUtil<>();
        buyHistoryFileUtil.writeDataToFile("BuyHistory.dat", buyListHistory);

        FileUtil<StorageManagement> storageManagementFileUtil = new FileUtil<>();
        storageManagementFileUtil.writeDataToFile("StorageManagement.dat", storageManagementLogic.getStorageManagements());
    }


    public void showBuyList() {
        for (int i = 0; i < buyListHistory.size(); i++) {
            if (accountLogic.getUser().getIdUser() == buyListHistory.get(i).getUser().getIdUser()) {
                System.out.println(buyListHistory.get(i).getBuyList());
            }
        }
    }

    public Product findProduct() {
        Product product;
        int idProduct;
        do {
            try {
                idProduct = new Scanner(System.in).nextInt();
                if (idProduct <= 0) {
                    System.out.println("Mã sản phẩm phải dương, vui lòng nhập lại: ");
                    continue;
                }
                product = searchById(idProduct);
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

    public Product searchById(int idProduct) {
        Product product = null;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == idProduct) {
                product = productList.get(i);
                break;
            }
        }
        return product;
    }
}
