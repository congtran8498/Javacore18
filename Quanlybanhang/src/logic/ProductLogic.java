package logic;

import entity.Product;
import entity.Storage;
import util.FileUtil;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ProductLogic {
    private List<Product> products;

    public ProductLogic(List<Product> products) {
        this.products = products;
    }
    public void inputProduct(){
        System.out.println("Nhập số loại sản phẩm: ");
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
        for (int i = 0; i < products.size(); i++) {
            max = products.get(products.size()-1).getId();
        }
        for (int i = 0; i < productNumber; i++) {
            System.out.println("Nhập thông tin cho sản phẩm thứ " + (i + 1));
            Product product = new Product();
            product.inputInfo();
            product.setId(++max);
            products.add(product);
        }
        FileUtil<Product> productFileUtil = new FileUtil<>();
        productFileUtil.writeDataToFile("Product.dat", products);
    }
    public void showProduct(){
        for (Product p: products) {
            System.out.println(p);
        }
    }
    public Product searchById(int idProduct) {
       Product product = null;
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getId() == idProduct){
                product = products.get(i);
                break;
            }
        }
        return product;
    }
}
