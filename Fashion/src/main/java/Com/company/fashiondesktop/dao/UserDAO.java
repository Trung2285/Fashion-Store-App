/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Com.company.fashiondesktop.dao;

import Com.company.fashiondesktop.entity.User;
import Com.company.fashiondesktop.util.HibernateUtil;
import Com.company.fashiondesktop.util.PasswordUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author hohuu
 */
public class UserDAO implements GenericDAO<User, Integer>{
 // Đăng nhập: kiểm tra username + mật khẩu
     public User login(String username, String password) {
         User user = findByUsername(username);
         if (user != null && PasswordUtil.checkPassword(password, user.getPassword())) {
             return user; // Trả về User nếu đúng mật khẩu
         }
         return null; // Trả về null nếu sai mật khẩu hoặc không tìm thấy user
     }

    @Override
   public void save(User entity) {
       Transaction transaction = null;
       try (Session session = HibernateUtil.getSession()) {
           transaction = session.beginTransaction();
           // Mã hóa mật khẩu trước khi lưu vào database
           entity.setPassword(PasswordUtil.hashPassword(entity.getPassword()));
           session.save(entity);
           transaction.commit();
       } catch (Exception e) {
           if (transaction != null) transaction.rollback();
           e.printStackTrace();
       }
   }


    @Override
    public void update(User entity) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }


    @Override
    public void delete(Integer id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            if (user != null) {
                session.delete(user);
                transaction.commit();
            } else {
                transaction.rollback();
                System.out.println("User không tồn tại!");
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }


    @Override
    public User findById(Integer id) {
        try (Session session = HibernateUtil.getSession()) {
            return session.get(User.class, id);
        }
    }

    @Override
    public List<User> findAll() {
        try (Session session = HibernateUtil.getSession()) {
            return session.createQuery("FROM User", User.class).list();
        }
    }
    
    // 🆕 Tìm User theo tên đăng nhập (username)
    // 🆕 Tìm User theo tên đăng nhập (username)
    public User findByUsername(String username) {
        try (Session session = HibernateUtil.getSession()) {
            List<User> users = session.createQuery("FROM User WHERE username = :username", User.class)
                    .setParameter("username", username)
                    .getResultList();
            return users.isEmpty() ? null : users.get(0); // Trả về user đầu tiên nếu có
        }
    }
    
}
