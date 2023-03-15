package logic;

import entity.User;
import util.FileUtil;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AccountLogic {
    private List<User> users;

    public AccountLogic(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    public void register(){
        User user = new User();
        user.inputInfo(users);
        int max = 0;
        for (int i = 0; i < users.size(); i++) {
            max = users.get(users.size()-1).getIdUser();
        }
        user.setIdUser(++max);
        users.add(user);
        FileUtil<User> userFileUtil = new FileUtil<>();
        userFileUtil.writeDataToFile("User.dat", users);
    }
    public void adminAccount(){
        User user = new User();
        user.setUserName("admin");
        user.setPassWord("123123");
        user.setRole("ADMIN");
        user.setPhone("0123456789");
        users.add(user);
        FileUtil<User> userFileUtil = new FileUtil<>();
        userFileUtil.writeDataToFile("User.dat", users);
    }
    public String login(){
        String role = "";
        System.out.println("Nhập userName: ");
        String userName = new Scanner(System.in).nextLine();
        System.out.println("Nhập passWord: ");
        String passWord = new Scanner(System.in).nextLine();
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getUserName().equals(userName) && users.get(i).getPassWord().equals(passWord)){
                role = users.get(i).getRole();
            }
        }
        return role;
    }
    public void showRegister(){
        for (User u:users) {
            System.out.println(u);
        }
    }
    public void deleteUser(){
        showRegister();
        System.out.println("Nhập mã user muốn xóa: ");
        int userId;
        User user = null;
        do {
            try {
                userId = new Scanner(System.in).nextInt();
                for (int i = 0; i < users.size(); i++) {
                    if(users.get(i).getIdUser() == userId){
                        user = users.get(i);
                        break;
                    }
                }if(user != null){
                    break;
                }
                System.out.println("Không có user nào có mã "+ userId+", vui lòng nhập lại: ");
            }catch (InputMismatchException e){
                System.out.println("Nhập sai định dạng, vui lòng nhập lại: ");
            }
        }while (true);
        users.remove(user);
        FileUtil<User> userFileUtil = new FileUtil<>();
        userFileUtil.writeDataToFile("User.dat", users);
    }
    
}
