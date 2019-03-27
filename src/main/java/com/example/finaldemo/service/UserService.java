/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.finaldemo.service;

//<editor-fold defaultstate="collapsed" desc="IMPORT">
import com.example.finaldemo.dto.UserDTO;
import java.util.List;
//</editor-fold>

/**
 *
 * @author Nguyen Duc Nhat Anh
 */

public interface UserService {

    boolean checkLogin(String username, String password);

    String createUser(UserDTO userDTO);

    String updateUser(UserDTO userDTO);
    
    String changPassword(int id , String newPassword);
    
    String removeUser(int id);

    List<UserDTO> getAllUser();

    UserDTO findUserById(int id);

    UserDTO findUserByUsername(String username);

    List<UserDTO> findAllUserByNameContains(String name);
}
