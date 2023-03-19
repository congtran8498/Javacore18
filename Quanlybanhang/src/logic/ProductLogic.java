package logic;

import entity.Category;
import entity.Product;
import entity.Storage;
import util.FileUtil;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ProductLogic {
    private List<Product> products;
    private CategoryLogic categoryLogic;


    public ProductLogic(List<Product> products, CategoryLogic categoryLogic) {
        this.products = products;
        this.categoryLogic = categoryLogic;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void inputProduct(){
        System.out.println("Nhập số lượng sản phẩm: ");
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
            System.out.println("Nhập mã loại sản phẩm: ");
            Category category = categoryLogic.findCategory();
            product.setCategory(category);
            product.setId(++max);
            products.add(product);
        }
        FileUtil<Product> productFileUtil = new FileUtil<>();
        productFileUtil.writeDataToFile("Product.dat", products);
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

    public void showProduct(){
        if(products.size() == 0){
            System.out.println("Danh sách trống");
            return;
        }
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
    public void updateProduct(){
        System.out.println("Nhập mã của sản phẩm muốn sửa: ");
        Product product = findProduct();
        product.inputInfo();
        Category category = categoryLogic.findCategory();
        product.setCategory(category);
        FileUtil<Product> productFileUtil = new FileUtil<>();
        productFileUtil.writeDataToFile("Product.dat", products);

    }
    public void deleteProduct(){
        System.out.println("Nhập mã của sản phẩm muốn xóa: ");
        Product product = findProduct();
        products.remove(product);
        FileUtil<Product> productFileUtil = new FileUtil<>();
        productFileUtil.writeDataToFile("Product.dat", products);
    }
}
