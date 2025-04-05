package Com.company.fashiondesktop.BUSINESSLOGIC;

import Com.company.fashiondesktop.SCHEMACLASS.User;
import Com.company.fashiondesktop.SCHEMAOBJECT.UserDAO;
import Com.company.fashiondesktop.util.PasswordUtil;

public class BLUser {
    private UserDAO userDAO;
    public BLUser() {
        this.userDAO = new UserDAO(); // Gán đối tượng tại đây
    }
    public User login(String username, String password) {
        User user = userDAO.findByUsername(username);
        if (user != null && PasswordUtil.checkPassword(password, user.getPassword())) {
            return user; // Trả về User nếu đúng mật khẩu
        }
        return null; // Trả về null nếu sai mật khẩu hoặc không tìm thấy user
    }
}
