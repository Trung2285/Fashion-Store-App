/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import Com.company.fashiondesktop.dao.UserDAO;
import Com.company.fashiondesktop.entity.User;
import Com.company.fashiondesktop.util.PasswordUtil;

/**
 *
 * @author hohuu
 */
public class test {
    public static void main(String[] args) {
        UserDAO userDao = new UserDAO();

        // ✅ Thêm User với mật khẩu đã mã hóa
        String hashedPassword = PasswordUtil.hashPassword("123456");
        User newUser = new User(1, hashedPassword);
        userDao.save(newUser);
        System.out.println("Đã tạo tài khoản!");
        // ✅ Kiểm tra đăng nhập
        boolean loginSuccess = userDao.login("admin", "123456");
        if (loginSuccess) {
            System.out.println("Đăng nhập thành công!");
        } else {
            System.out.println("Sai tài khoản hoặc mật khẩu!");
        }
    }
}
