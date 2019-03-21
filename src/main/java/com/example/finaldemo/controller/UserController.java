package com.example.finaldemo.controller;

import com.example.finaldemo.dto.UserDTO;
import com.example.finaldemo.my_utils.MyUtils;
import com.example.finaldemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    
@Autowired
private UserService userService;

    @GetMapping(value = "/")
    public String homePage(Model model) {
       // model.addAttribute("user", new UserDTO());

        return "index";

    }
    @GetMapping(value = "/login")
    public String getLoginPage(){
        return "login";
    }
    
    @PostMapping(value = "/login")
    public String login(    @RequestParam(name = "username")String username,
                            @RequestParam(name = "password") String password){
        
        String hashedpassword = MyUtils.BcryptStringEncode(password);
        //check hashedPass
        return "index";
        
    }
    
    @PostMapping(value = "/register")
    public String register( @RequestParam(name = "username")String username,
                            @RequestParam(name = "password") String password,
                            @RequestParam(name = "name") String name){
        
       
        
        UserDTO user = new UserDTO();
        
        user.setId(MyUtils.random9digits());
        user.setName(name);
        user.setUsername(username);
        user.setPassword(MyUtils.BcryptStringEncode(password));
     return   userService.createUser(user);
        
    }
}
