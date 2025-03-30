package test;

import Com.company.fashiondesktop.dao.UserDAO;
import Com.company.fashiondesktop.entity.User;

public class Test {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        // Tạo user mới (Mật khẩu sẽ được mã hóa trước khi lưu vào DB)
        String username = "admin";
        String pass = "123456";

        User newUser = new User(username, pass);
        userDAO.save(newUser);  // Gọi phương thức save để lưu vào DB
        System.out.println("User mới đã được tạo thành công!");

        // Test đăng nhập (Đúng mật khẩu)
        if (userDAO.login("admin", "123456") != null) {
            System.out.println("Đăng nhập thành công!");
        } else {
            System.out.println("Sai tài khoản hoặc mật khẩu!");
        }

        // Test đăng nhập (Sai mật khẩu)
        if (userDAO.login("admin", "wrongpass") != null) {
            System.out.println("Đăng nhập thành công!");
        } else {
            System.out.println("Sai tài khoản hoặc mật khẩu!");
        }

        // Lấy danh sách tất cả User
        System.out.println("Danh sách User trong hệ thống:");
        for (User user : userDAO.findAll()) {
            System.out.println("ID: " + user.getUserName() + ", Username: " + user.getPassword());
        }
    }
}
