package entity;


import java.io.Serializable;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class User implements  Serializable {

    private String userName;
    private String passWord;
    private String phone;
    private String role;
    private int idUser;



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", phone='" + phone + '\'' +
                ", role='" + role + '\'' +
                ", idUser=" + idUser +
                '}';
    }

    public void inputInfo(List<User> userList) {
        System.out.println("Nhập userName: ");
        do {
            this.userName = new Scanner(System.in).nextLine();
            boolean isExist = false;
            for (int i = 0; i < userList.size(); i++) {
                if(this.userName.equals(userList.get(i).userName) ){
                    System.out.println("Đã có userName này, vui lòng nhập lại: ");
                    isExist = true;
                    break;
                }
            }
            if(!isExist){
                break;
            }
        }while (true);
        System.out.println("Nhập passWord: ");
        this.passWord = new Scanner(System.in).nextLine();

        Pattern p = Pattern.compile("^(\\+|)84|0[35789]+([0-9]{8})\\b$");
        System.out.println("Nhập sdt: ");
        do {
            this.phone = new Scanner(System.in).nextLine();
            if(p.matcher(this.phone).find()){
                break;
            }
            System.out.println("Nhập sai định dạng, hãy nhập lại: ");
        }while (true);
        this.role= "USER";
    }
}
