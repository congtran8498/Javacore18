package logic;

import entity.Category;

import entity.Product;
import util.FileUtil;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CategoryLogic {
    private List<Category> categories;

    public CategoryLogic(List<Category> categories) {
        this.categories = categories;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
    public void inputCategory(){
        System.out.println("Nhập số loại sản phẩm: ");
        int categoryNumber;
        do {
            try {
                categoryNumber = new Scanner(System.in).nextInt();
                if (categoryNumber > 0) {
                    break;
                }
                System.out.println("Lựa chọn phải dương, vui lòng chọn lại");
            } catch (InputMismatchException e) {
                System.out.println("Nhập sai định dạng, hãy nhập lại: ");
            }
        } while (true);
        int max = 0;
        for (int i = 0; i < categories.size(); i++) {
            max = categories.get(categories.size()-1).getId();
        }
        for (int i = 0; i < categoryNumber; i++) {
            Category category = new Category();
            category.inputInfo();
            category.setId(++max);
            categories.add(category);
        }
        FileUtil<Category> categoryFileUtil = new FileUtil<>();
        categoryFileUtil.writeDataToFile("Category.dat", categories);
    }
    public Category searchById(int idCategory) {
        Category category = null;
        for (int i = 0; i < categories.size(); i++) {
            if(categories.get(i).getId() == idCategory){
                category = categories.get(i);
                break;
            }
        }
        return category;
    }
    public Category findCategory(){
        Category category;
        int idCategory;
        do {
            try {
                idCategory = new Scanner(System.in).nextInt();
                if (idCategory <= 0) {
                    System.out.println("Mã loại sản phẩm phải dương, vui lòng nhập lại: ");
                    continue;
                }
                category = searchById(idCategory);
                if (category != null) {
                    break;
                }
                System.out.println("Không tìm thấy loại sản phẩm có mã " + idCategory + ",vui lòng nhập lại: ");
            } catch (InputMismatchException e) {
                System.out.println("Nhập sai định dạng, hãy nhập lại: ");
            }
        } while (true);
        return category;
    }
    public void updateCategory(){
        System.out.println("Nhập mã loại sản phẩm muốn sửa: ");
        Category category = findCategory();
        category.inputInfo();
        FileUtil<Category> categoryFileUtil = new FileUtil<>();
        categoryFileUtil.writeDataToFile("Category.dat", categories);
    }
    public void deleteCategory(){
        System.out.println("Nhập mã loại sản phẩm muốn xóa: ");
        Category category = findCategory();
        categories.remove(category);
        FileUtil<Category> categoryFileUtil = new FileUtil<>();
        categoryFileUtil.writeDataToFile("Category.dat", categories);
    }
    public void showCategory(){
        if(categories.size() == 0){
            System.out.println("Danh sách trống");
            return;
        }
        for (Category c: categories) {
            System.out.println(c);
        }
    }
}
