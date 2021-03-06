package com.example.finaldemo.my_utils;

//<editor-fold defaultstate="collapsed" desc="IMPORT">
import java.util.Random;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//</editor-fold>

/**
 *
 * @author Nguyen Duc Nhat Anh
 * @email nhatanh2996@gmail.com
 */
public class MyUtils {

    public static int random9digits() {
        Random rand = new Random();
        return rand.nextInt(1000000000);
    }

    public static String BcryptStringEncode(String s) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(s);
    }
}
