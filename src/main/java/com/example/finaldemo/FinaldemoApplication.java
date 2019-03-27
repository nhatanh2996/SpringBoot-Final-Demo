package com.example.finaldemo;

//<editor-fold defaultstate="collapsed" desc="IMPORT">
import com.example.finaldemo.dao.UserDAO;
import com.example.finaldemo.dto.UserDTO;
import com.example.finaldemo.service.UserServiceImpl;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//</editor-fold>

@SpringBootApplication
public class FinaldemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinaldemoApplication.class, args);
//===========================Test All Service=======================================
//        UserServiceImpl userService = new UserServiceImpl();
//        List<UserDTO> list = userService.getAllUser();
//        for (UserDTO userDTO : list) {
//            System.out.println((userDTO) + "/n");
//        }
//
//
//        System.out.println("Status Add New: " + userService.createUser(new UserDTO(213, "nhatanh", "123456", "Nhật Anh", "Q12")));
//        System.out.println("Status Check Login: " +  userService.checkLogin("nhatanh","nhatanh321"));
//        UserDTO userEdit = new UserDTO();
//                userEdit.setId(11946259);
//                userEdit.setName("An");
//                userEdit.setAddress("Quan 1");
//        System.out.println("Status Update : " + userService.updateUser(userEdit));
//        System.out.println("Status Change Password : " + userService.changPassword(11946259,"nhatanh321"));
//        System.out.println("Status Remove User: " + userService.removeUser(11946259));

    }

}
