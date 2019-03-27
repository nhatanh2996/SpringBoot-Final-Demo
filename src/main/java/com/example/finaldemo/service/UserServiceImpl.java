package com.example.finaldemo.service;

//<editor-fold defaultstate="collapsed" desc="IMPORT">
import com.example.finaldemo.dao.UserDAO;
import com.example.finaldemo.dto.UserDTO;
import com.example.finaldemo.my_utils.MyUtils;
import java.util.List;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
//</editor-fold>

/**
 *
 * @author Nguyen Duc Nhat Anh
 * @email nhatanh2996@gmail.com
 */
@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO = new UserDAO();

    @Override
    public boolean checkLogin(String username, String password) {

        UserDTO userLogging = userDAO.findUserByUsername(username);

        if (userLogging == null) {
            return false;
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        return passwordEncoder.matches(password, userLogging.getPassword());

    }

    @Override
    public String createUser(UserDTO userDTO) {
        int userId = MyUtils.random9digits();
      UserDTO  user = userDAO.findUserById(userId);

        if (user != null) {
            return "add_failed_exist_id";
        }
        user = userDAO.findUserByUsername(userDTO.getUsername());
        if (user != null) {
            return "add_failed_exist_username";
        }
        userDTO.setPassword(MyUtils.BcryptStringEncode(userDTO.getPassword()));
        userDTO.setId(userId);

        return userDAO.addNewUser(userDTO);

    }

    @Override
    public String updateUser(UserDTO userDTO) {
        return userDAO.editUser(userDTO);
    }

    @Override
    public String removeUser(int id) {
        return userDAO.removeUser(id);
    }

    @Override
    public List<UserDTO> getAllUser() {
        return userDAO.findAll();
    }

    @Override
    public UserDTO findUserById(int id) {
        return userDAO.findUserById(id);
    }

    @Override
    public UserDTO findUserByUsername(String username) {
        return userDAO.findUserByUsername(username);
    }

    @Override
    public List<UserDTO> findAllUserByNameContains(String name) {
        return userDAO.findAllUserByNameContains(name);
    }

    @Override
    public String changPassword(int id, String newPassword) {

        return userDAO.changePassword(id, MyUtils.BcryptStringEncode(newPassword));
    }
}
