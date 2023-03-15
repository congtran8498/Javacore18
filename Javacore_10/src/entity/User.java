package entity;

import constant.Role;

import java.util.Scanner;

public class User {
    private Role role;

    public User(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public  void  input(){
        int choice = new Scanner(System.in).nextInt();
        if(choice==1){
            this.role = Role.ADMIN;
        }else if(choice==2){
            this.role = Role.USER;
        }
    }
}
