package logic;

import entity.*;
import util.FileUtil;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuManagement {
    private AccountLogic accountLogic;
    private StorageLogic storageLogic;
    private ProductLogic productLogic;
    private CategoryLogic categoryLogic;
    private BuyLogic buyLogic;
    private IncomeLogic incomeLogic;


    private StorageManagementLogic storageManagementLogic;

    public MenuManagement() {
        FileUtil<User> userFileUtil = new FileUtil<>();
        List userList = userFileUtil.readDataFromFile("User.dat");
        List<User> users = userList == null ? new ArrayList<>() : (List<User>) userList;
        accountLogic = new AccountLogic(users);
        if (users.size() == 0) {
            accountLogic.adminAccount();
        }

        FileUtil<Category> categoryFileUtil = new FileUtil<>();
        List categoryList = categoryFileUtil.readDataFromFile("Category.dat");
        List<Category> categories = categoryList == null ? new ArrayList<>() : (List<Category>) categoryList;
        categoryLogic = new CategoryLogic(categories);

        FileUtil<Storage> storageFileUtil = new FileUtil<>();
        List storageList = storageFileUtil.readDataFromFile("Storage.dat");
        List<Storage> storages = storageList == null ? new ArrayList<>() : (List<Storage>) storageList;
        storageLogic = new StorageLogic(storages);

        FileUtil<Product> productFileUtil = new FileUtil<>();
        List productList = productFileUtil.readDataFromFile("Product.dat");
        List<Product> products = productList == null ? new ArrayList<>() : (List<Product>) productList;
        productLogic = new ProductLogic(products, categoryLogic);

        FileUtil<StorageManagement> storageManagementFileUtil = new FileUtil<>();
        List storageManagementList = storageManagementFileUtil.readDataFromFile("StorageManagement.dat");
        List<StorageManagement> storageManagements = storageManagementList == null ? new ArrayList<>() : (List<StorageManagement>) storageManagementList;
        storageManagementLogic = new StorageManagementLogic(storageManagements, storageLogic, productLogic);
        FileUtil<Buy> buyFileUtil = new FileUtil<>();

        List buyList = buyFileUtil.readDataFromFile("BuyHistory.dat");
        List<BuyHistory> buys = buyList == null ? new ArrayList<>() : (List<BuyHistory>) buyList;
        buyLogic = new BuyLogic(categoryLogic, productLogic, storageLogic, storageManagementLogic, buys, accountLogic);

        incomeLogic = new IncomeLogic(buyLogic);
    }

    public void menu() {
        while (true) {
            printMenu();
            int choice = choice();
            if (choice == 1) {
                accountLogic.register();
            } else if (choice == 2) {
                String role = accountLogic.login();
                if (role.equals("ADMIN")) {
                    adminPrintMenu();
                } else if (role.equals("USER")) {
                    userPrintMenu();
                } else {
                    System.out.println("Nhập sai userName hoặc passWord.");
                }
            } else {
                return;
            }
        }
    }

    private void userPrintMenu() {
        while (true) {
            System.out.println("1. Thông tin cá nhân");
            System.out.println("2. Mua hàng");
            System.out.println("3. Xem lịch sử mua hàng");
            System.out.println("4. Thoát");
            int choice;
            do {
                try {
                    choice = new Scanner(System.in).nextInt();
                    if (choice > 0 && choice <= 4) {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Nhập sai định dạng, vui lòng nhập lại: ");
                }
            } while (true);
            switch (choice) {
                case 1:
                    accountLogic.updateAccount();
                    break;
                case 2:
                    buyLogic.buyProduct();
                    break;
                case 3:
                    buyLogic.showBuyList();
                    break;
                case 4:
                    return;
            }
        }
    }

    private int choice() {
        int choice;
        do {
            try {
                choice = new Scanner(System.in).nextInt();
                if (choice > 0 && choice <= 3) {
                    break;
                }
                System.out.println("Lựa chọn sai, vui lòng chọn lại");
            } catch (InputMismatchException e) {
                System.out.println("Nhập sai định dạng, hãy nhập lại: ");
            }
        } while (true);
        return choice;
    }

    private void printMenu() {
        System.out.println("============== Phần Mềm Quản Lý Bán Hàng ==============");
        System.out.println("1. Đăng kí");
        System.out.println("2. Đăng nhập");
        System.out.println("3. Thoát");
    }

    private int adminChoice() {
        System.out.println("Mời lựa chọn: ");
        int choice;
        do {
            try {
                choice = new Scanner(System.in).nextInt();
                if (choice > 0 && choice <= 8) {
                    break;
                }
                System.out.println("Lựa chọn sai, vui lòng chọn lại");
            } catch (InputMismatchException e) {
                System.out.println("Nhập sai định dạng, hãy nhập lại: ");
            }
        } while (true);
        return choice;
    }

    private void adminPrintMenu() {
        while (true) {
            System.out.println("============== Phần Mềm Quản Lý Bán Hàng ==============");
            System.out.println("1. Thông tin cá nhân");
            System.out.println("2. Quản lý user");
            System.out.println("3. Quản lý loại sản phẩm");
            System.out.println("4. Quản lý sản phẩm");
            System.out.println("5. Quản lý kho hàng");
            System.out.println("6. Quản lý kho hàng và sản phẩm");
            System.out.println("7. Kiểm tra doanh thu");
            System.out.println("8. Thoát");
            int choice = adminChoice();
            switch (choice) {
                case 1:
                    accountLogic.updateAccount();
                    break;
                case 2:
                    menuUser();
                    break;
                case 3:
                    menuCategory();
                    break;
                case 4:
                    menuProduct();
                    break;
                case 5:
                    menuStorage();
                    break;
                case 6:
                    menuStorageAndProduct();
                    break;
                case 7:
                    incomeLogic.income();
                    break;
                case 8:
                    return;
            }
        }
    }

    private void menuStorageAndProduct() {
        System.out.println("1. Thêm sản phẩm vào kho");
        System.out.println("2. Xóa kho hàng");
        System.out.println("3. Xóa sản phẩm trong kho");
        System.out.println("4. Danh sách tồn kho");
        System.out.println("5. Quay lại");
        int choice;
        do {
            try {
                choice = new Scanner(System.in).nextInt();
                if (choice > 0 && choice <= 5) {
                    break;
                }
                System.out.println("Lựa chọn sai, hãy chọn lại: ");
            } catch (InputMismatchException e) {
                System.out.println("Nhập sai định dạng, vui lòng nhập lại: ");
            }
        } while (true);
        switch (choice) {
            case 1:
                storageManagementLogic.inputProductToStorage();
                menuStorageAndProduct();
                break;
            case 2:
                storageManagementLogic.deleteStorage();
                menuStorageAndProduct();
                break;
            case 3:
                storageManagementLogic.deleteProductFromStorage();
                menuStorageAndProduct();
                break;
            case 4:
                storageManagementLogic.showStorageManagement();
                menuStorageAndProduct();
                break;
        }
    }

    public void menuUser() {
        System.out.println("1. Danh sách user");
        System.out.println("2. Xóa user");
        System.out.println("3. Quay lại");
        int choice;
        do {
            try {
                choice = new Scanner(System.in).nextInt();
                if (choice > 0 && choice <= 3) {
                    break;
                }
                System.out.println("Lựa chọn sai, hãy chọn lại: ");
            } catch (InputMismatchException e) {
                System.out.println("Nhập sai định dạng, vui lòng nhập lại: ");
            }
        } while (true);
        if (choice == 1) {
            accountLogic.showRegister();
            menuUser();
        } else if (choice == 2) {
            accountLogic.deleteUser();
            menuUser();
        }
    }

    public void menuCategory() {
        System.out.println("1. Thêm loại sản phẩm");
        System.out.println("2. Sửa loại sản phẩm");
        System.out.println("3. Xóa loại sản phẩm");
        System.out.println("4. Danh sách loại sản phẩm");
        System.out.println("5. Quay lại");
        int choice;
        do {
            try {
                choice = new Scanner(System.in).nextInt();
                if (choice > 0 && choice <= 5) {
                    break;
                }
                System.out.println("Lựa chọn sai, hãy chọn lại: ");
            } catch (InputMismatchException e) {
                System.out.println("Nhập sai định dạng, vui lòng nhập lại: ");
            }
        } while (true);
        switch (choice) {
            case 1:
                categoryLogic.inputCategory();
                menuCategory();
                break;
            case 2:
                categoryLogic.updateCategory();
                menuCategory();
                break;
            case 3:
                categoryLogic.deleteCategory();
                menuCategory();
                break;
            case 4:
                categoryLogic.showCategory();
                menuCategory();
                break;
        }
    }

    public void menuProduct() {
        System.out.println("1. Thêm sản phẩm");
        System.out.println("2. Sửa sản phẩm");
        System.out.println("3. Xóa sản phẩm");
        System.out.println("4. Danh sách sản phẩm");
        System.out.println("5. Quay lại");
        int choice;
        do {
            try {
                choice = new Scanner(System.in).nextInt();
                if (choice > 0 && choice <= 5) {
                    break;
                }
                System.out.println("Lựa chọn sai, hãy chọn lại: ");
            } catch (InputMismatchException e) {
                System.out.println("Nhập sai định dạng, vui lòng nhập lại: ");
            }
        } while (true);
        switch (choice) {
            case 1:
                productLogic.inputProduct();
                menuProduct();
                break;
            case 2:
                productLogic.updateProduct();
                menuProduct();
                break;
            case 3:
                productLogic.deleteProduct();
                menuProduct();
                break;
            case 4:
                productLogic.showProduct();
                menuProduct();
                break;
        }
    }

    public void menuStorage() {
        System.out.println("1. Thêm kho hàng");
        System.out.println("2. Sửa kho hàng");
        System.out.println("3. Xóa kho hàng");
        System.out.println("4. Danh sách kho hàng");
        System.out.println("5. Quay lại");
        int choice;
        do {
            try {
                choice = new Scanner(System.in).nextInt();
                if (choice > 0 && choice <= 5) {
                    break;
                }
                System.out.println("Lựa chọn sai, hãy chọn lại: ");
            } catch (InputMismatchException e) {
                System.out.println("Nhập sai định dạng, vui lòng nhập lại: ");
            }
        } while (true);
        switch (choice) {
            case 1:
                storageLogic.inputStorage();
                menuStorage();
                break;
            case 2:
                storageLogic.updateStorage();
                menuStorage();
                break;
            case 3:
                storageLogic.deleteStorage();
                menuStorage();
                break;
            case 4:
                storageLogic.showStorage();
                menuStorage();
                break;
        }
    }
}
