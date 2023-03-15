import constant.Role;
import entity.User;
import logic.MenuManagementLogic;

public class Main {
    public static void main(String[] args) {
//        MenuManagementLogic menuManagementLogic = new MenuManagementLogic();
//        menuManagementLogic.menu();
        User  user = new User(Role.USER);
        System.out.println(user.getRole().equals(Role.USER));
    }
}
