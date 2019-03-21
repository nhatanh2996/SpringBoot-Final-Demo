
package com.example.finaldemo.service;

import com.example.finaldemo.dao.UserDAO;
import com.example.finaldemo.dto.UserDTO;
import java.util.List;

/**
 *
 * @author Nguyen Duc Nhat Anh
 * @email nhatanh2996@gmail.com
 */
public class UserServiceImpl implements UserService{
    private UserDAO userDAO = new UserDAO();
    @Override
    public boolean checkLogin(String username, String password) {
        return userDAO.checkLogin(username, password);
    }

    @Override
    public String createUser(UserDTO userDTO) {
       return userDAO.addNewUser(userDTO);
         
    }

    @Override
    public String updateUser(UserDTO userDTO) {
       return userDAO.editUser(userDTO);
    }

    public String removeUser(int id) {
      return  userDAO.removeUser(id);
    }

    @Override
    public List<UserDTO> getAllUser() {
       return  userDAO.findAll();
    }

    @Override
    public UserDTO findUserById(int id) {
        return  userDAO.findUserById(id);
    }

    @Override
    public UserDTO findUserByUsername(String username) {
        return userDAO.findUserByUsername(username);
    }

    @Override
    public List<UserDTO> findAllUserByNameContains(String name) {
        return userDAO.findAllUserByNameContains(name);
    }

  

}
