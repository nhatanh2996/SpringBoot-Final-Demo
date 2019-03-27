package com.example.finaldemo.controller;

//<editor-fold defaultstate="collapsed" desc="IMPORT">
import com.example.finaldemo.dto.UserDTO;
import com.example.finaldemo.service.UserService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
//</editor-fold>

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //<editor-fold defaultstate="collapsed" desc="GET HOME PAGE">
    @GetMapping(value = "/")
    public String homePage(Model model) {
        // model.addAttribute("user", new UserDTO());
        return "login";
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET LOGIN PAGE">
    @GetMapping(value = "/login")
    public String getLoginPage() {
        return "login";
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET ADMIN PAGE">
    @GetMapping(value = "/admin")
    public ModelAndView getAdminPage() {
        List<UserDTO> list = userService.getAllUser();
        ModelMap map = new ModelMap();
        map.addAttribute("listUser", list);
        return new ModelAndView("admin", map);
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="LOGIN API">
    @PostMapping(value = "/login")
    public String login(@RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password, HttpSession session) {
            boolean check = userService.checkLogin(username, password);
        if (check) {

            UserDTO userDTO = userService.findUserByUsername(username);
            session.setAttribute("userLogged", userDTO);
            return "redirect:/admin";
        }
        return "redirect:/login";
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="REGISTER API">
     @PostMapping(value = "/register")
    public String register(@RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password,
            @RequestParam(name = "name") String name,
            @RequestParam(name = "address") String address) {

        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(username);
        userDTO.setName(name);
        userDTO.setAddress(address);
        userDTO.setPassword(password);

        String msg = userService.createUser(userDTO);
        if (msg.equals("add_success")) {
            return "redirect:/admin";
        }
        return msg;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="EDIT API">
    @GetMapping(value = "/edit")
    public String edit(@RequestParam(name = "id") int id, @RequestParam(name = "name") String name,
            @RequestParam(name = "address") String address) {

        UserDTO userDTO = new UserDTO();
        userDTO.setId(id);
        userDTO.setName(name);
        userDTO.setAddress(address);

        String msg = userService.updateUser(userDTO);
        if (msg.equals("edit_success")) {
            return "redirect:/admin";
        }
        return msg;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET USER BY ID">
    @GetMapping(value = "/user")
    @ResponseBody
    public UserDTO getUserById(@RequestParam(name = "id") int id) {
        return userService.findUserById(id);
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="REMOVE USER BY ID">
    @GetMapping(value = "/remove")

    public String removeById(@RequestParam(name = "id") int id) {
        String msg = userService.removeUser(id);
        if (msg.equals("remove_success")) {
            return "redirect:/admin";
        }
        return msg;
    }
//</editor-fold>

//
//    @GetMapping(value = "/testGet")
//    public String testGet() {
//        System.out.println("get");
//        return "login";
//    }
//
//    @PostMapping(value = "/testPost")
//    @ResponseBody
//    public String testPost() {
//        System.out.println("post");
//        return "login";
//    }
}
