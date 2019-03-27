
package com.example.finaldemo.dto;


//<editor-fold defaultstate="collapsed" desc="IMPORT">
import com.example.finaldemo.my_utils.MyUtils;
import java.io.Serializable;
//</editor-fold>
/**
 *
 * @author Nguyen Duc Nhat Anh
 * @email nhatanh2996@gmail.com
 */
public class UserDTO implements Serializable{
private int id;
private String username;
private String password;
private String name;
private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UserDTO() {
    }



    public UserDTO(int id ,String username, String password, String name, String address) {
        this.id= id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "id=" + id + ", username=" + username + ", password=" + password + ", name=" + name + ", address=" + address + '}';
    }
    
    

}
