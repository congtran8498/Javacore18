package logic;

import entity.Product;
import entity.Storage;
import entity.StorageManagement;
import entity.User;
import util.FileUtil;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuManagement {
    private AccountLogic accountLogic;
    private StorageLogic storageLogic;
    private ProductLogic productLogic;


    private StorageManagementLogic storageManagementLogic;
    public MenuManagement(){
        FileUtil<User> userFileUtil = new FileUtil<>();
        List userList = userFileUtil.readDataFromFile("User.dat");
        List<User> users = userList == null ? new ArrayList<>() : (List<User>)userList;
        accountLogic = new AccountLogic(users);
        if(users.size() == 0){
            accountLogic.adminAccount();
        }

        FileUtil<Storage> storageFileUtil = new FileUtil<>();
        List storageList = storageFileUtil.readDataFromFile("Storage.dat");
        List<Storage> storages = storageList == null ? new ArrayList<>() : (List<Storage>)storageList;
        storageLogic = new StorageLogic(storages);

        FileUtil<Product> productFileUtil = new FileUtil<>();
        List productList = productFileUtil.readDataFromFile("Product.dat");
        List<Product> products = productList == null ? new ArrayList<>() : (List<Product>)productList;
        productLogic = new ProductLogic(products);

        FileUtil<StorageManagement> storageManagementFileUtil = new FileUtil<>();
        List storageManagementList = storageManagementFileUtil.readDataFromFile("StorageManagement.dat");
        List<StorageManagement> storageManagements = storageManagementList == null ? new ArrayList<>() : (List<StorageManagement>)storageManagementList;
        storageManagementLogic = new StorageManagementLogic(storageLogic,storageManagements);
    }
    public void menu(){
        while (true){
            printMenu();
            int choice = choice();
            if(choice == 1){
                accountLogic.register();
            }else if(choice == 2){
                String role = accountLogic.login();
                if(role.equals("ADMIN")){
                    adminPrintMenu();
                }else if(role.equals("USER")){
                    userPrintMenu();
                }else{
                    System.out.println("Nh???p sai userName ho???c passWord.");
                }
            }else {
                return;
            }
        }
    }

    private void userPrintMenu() {
       while (true){
           System.out.println("============== Ph???n M???m Qu???n L?? B??n H??ng ==============");
           System.out.println("1. Mua h??ng");
           System.out.println("2. Xem l???ch s??? mua h??ng");
           System.out.println("3. Tho??t");
           int choice = choice();
           switch (choice){
               case 1:
                   break;
               case 2:
                   break;
               case 3:
                   return;
           }
       }
    }

    private int choice() {
        int choice;
        do {
            try{
                choice = new Scanner(System.in).nextInt();
                if(choice>0 && choice<=3){
                    break;
                }
                System.out.println("L???a ch???n sai, vui l??ng ch???n l???i");
            }catch (InputMismatchException e){
                System.out.println("Nh???p sai ?????nh d???ng, h??y nh???p l???i: ");
            }
        }while (true);
        return choice;
    }

    private void printMenu(){
        System.out.println("============== Ph???n M???m Qu???n L?? B??n H??ng ==============");
        System.out.println("1. ????ng k??");
        System.out.println("2. ????ng nh???p");
        System.out.println("3. Tho??t");
    }

    private int adminChoice() {
        System.out.println("M???i l???a ch???n: ");
        int choice;
        do {
            try{
                choice = new Scanner(System.in).nextInt();
                if(choice>0 && choice<=8){
                    break;
                }
                System.out.println("L???a ch???n sai, vui l??ng ch???n l???i");
            }catch (InputMismatchException e){
                System.out.println("Nh???p sai ?????nh d???ng, h??y nh???p l???i: ");
            }
        }while (true);
        return choice;
    }

    private void adminPrintMenu() {
       while (true){
           System.out.println("============== Ph???n M???m Qu???n L?? B??n H??ng ==============");
           System.out.println("1. In danh s??ch user");
           System.out.println("2. X??a user");
           System.out.println("3. T???o kho h??ng");
           System.out.println("4. In danh s??ch kho h??ng");
           System.out.println("5. T???o s???n ph???m");
           System.out.println("6. In s???n ph???m");
           System.out.println("7. Nh???p s???n ph???m v??o kho h??ng");
           System.out.println("8. In danh s??ch kho h??ng");
           System.out.println("9. S???a danh s??ch kho h??ng");
           System.out.println("10. Ki???m tra doanh thu");
           System.out.println("11. Tho??t");
           int choice = adminChoice();
           switch (choice){
               case 1:
                   accountLogic.showRegister();
                   break;
               case 2:
                   accountLogic.deleteUser();
                   break;
               case 3:
                   storageLogic.inputStorage();
                   break;
               case 4:
                   storageLogic.showStorage();
                   break;
               case 5:
                   productLogic.inputProduct();
                   break;
               case 6:
                   productLogic.showProduct();
                   break;
               case 7:
                   storageManagementLogic.inputProductToStorage();
                   break;
               case 8:
                   storageManagementLogic.showStorageManagement();
                   break;
               case 9:
                   storageManagementLogic.updateStorage();
                   break;
               case 10:
                   break;
               case 11:
                   return;
           }
       }
    }
}
