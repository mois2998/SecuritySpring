/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cc.altius.springSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
/**
 *
 * @author altius
 */
public class BcryptPasswordEncoder {
    public static void main(String[] args) {
        String password = "ssap";
        
        
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); 
        
        
        String hashedPassword = encoder.encode(password);
        
        
        System.out.println("Password: " + hashedPassword);
    }
}
