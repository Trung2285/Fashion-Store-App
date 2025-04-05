package test;

import Com.company.fashiondesktop.BUSINESSLOGIC.BLUser;
import Com.company.fashiondesktop.SCHEMAOBJECT.UserDAO;
import Com.company.fashiondesktop.SCHEMACLASS.User;

public class Test {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        BLUser blUser = new BLUser();
        // 🆕 1. Thêm User mới
//        User newUser = new User();
//        newUser.setFullName(" ho huu huy");
//        newUser.setUsername("nguyenvana");
//        newUser.setPassword("123456");
//        newUser.setEmail("nguyenvana@example.com");
//        newUser.setPhoneNumber("0123456789");
//        newUser.setGender(true);
//        userDAO.save(newUser);
//        System.out.println("✅ Đã thêm User mới!");

        // 🆕 2. Đăng nhập đúng mật khẩu
        User loginUser = blUser.login("nguyenvana", "123456");
        if (loginUser != null) {
            System.out.println("✅ Đăng nhập thành công: " + loginUser.getFullName());
        } else {
            System.out.println("❌ Sai mật khẩu hoặc tài khoản không tồn tại.");
        }

//         🆕 3. Đăng nhập với sai mật khẩu
        User wrongLogin = blUser.login("nguyenvana", "wrongpassword");
        System.out.println(wrongLogin == null ? "✅ Sai mật khẩu, không thể đăng nhập!" : "❌ Lỗi: Đăng nhập sai vẫn thành công.");

//        // 🆕 4. Cập nhật User
//        if (loginUser != null) {
//            loginUser.setFullName("Nguyễn Văn B");
//            userDAO.update(loginUser);
//            System.out.println("✅ Cập nhật User thành công!");
//        }
//
//        // 🆕 5. Tìm User theo ID
//        User foundUser = userDAO.findById(loginUser.getUserId());
//        System.out.println(foundUser != null ? "✅ Tìm thấy User: " + foundUser.getFullName() : "❌ Không tìm thấy User!");
//
//        // 🆕 6. Xóa User
//        userDAO.delete(loginUser.getUserId());
//        User deletedUser = userDAO.findById(loginUser.getUserId());
//        System.out.println(deletedUser == null ? "✅ Xóa User thành công!" : "❌ Lỗi: User vẫn tồn tại sau khi xóa!");
//
//




//        UserDAO userDAO = new UserDAO();
//
//        // Tạo user mới (Mật khẩu sẽ được mã hóa trước khi lưu vào DB)
//        String username = "admin";
//        String pass = "123456";
//
//        User newUser = new User(username, pass);
//        userDAO.save(newUser);  // Gọi phương thức save để lưu vào DB
//        System.out.println("User mới đã được tạo thành công!");
//
//        // Test đăng nhập (Đúng mật khẩu)
//        if (userDAO.login("admin", "123456") != null) {
//            System.out.println("Đăng nhập thành công!");
//        } else {
//            System.out.println("Sai tài khoản hoặc mật khẩu!");
//        }
//
//        // Test đăng nhập (Sai mật khẩu)
//        if (userDAO.login("admin", "wrongpass") != null) {
//            System.out.println("Đăng nhập thành công!");
//        } else {
//            System.out.println("Sai tài khoản hoặc mật khẩu!");
//        }
//
//        // Lấy danh sách tất cả User
//        System.out.println("Danh sách User trong hệ thống:");
//        for (User user : userDAO.findAll()) {
//            System.out.println("ID: " + user.getUsername() + ", Username: " + user.getPassword());
//        }
    }
}
