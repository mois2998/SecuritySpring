/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cc.altius.springSecurity;
import cc.altius.springSecurity.serviceimpl.EmployeeServiceImpl;
import cc.altius.springSecurity.serviceimpl.UserServiceImpl;
import jakarta.servlet.DispatcherType;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 *
 * @author altius
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
@Autowired
 private UserServiceImpl userService;

    @Bean
        public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(this.userService);
        authProvider.setPasswordEncoder(this.bcryptPasswordEncoder());
        return authProvider;
        
        }
        
        
        
        
//        @Bean
//        public UserDetailsService userDetailService(){
//            UserDetails user = User.builder()
//                                    .username("moiz")
//                                    .password("$2a$10$BZeQhooA9dBf2fLROcMzeuihZMgnBCUaHCKDTyuATvrQYJsCWY8OK")
//                                    .roles("USER")
//                                    .build();
//            UserDetails user1 = User.builder()
//                                    .username("ziom")
//                                    .password("$2a$10$nHLuHp.JUXpW5/KlaHzAhOGTeeOVLSl1m3ly86R1HrwSOB0z7GdKC")
//                                    .roles("USER" , "ADMIN")
//                                    .build();
//            List<UserDetails> users = new LinkedList<>();
//            users.add(user);
//            users.add(user1);
//            return new InMemoryUserDetailsManager(users);
//        }
    
//    
//    public class SimplePasswordEncoder implements PasswordEncoder {
//        @Override
//        public boolean matches(CharSequence rawPassword, String encodedPassword) {
//            if (rawPassword == null || encodedPassword == null) {
//                return false;
//            }
//            if (rawPassword.toString().equals(encodedPassword)) {
//                System.err.println(encodedPassword+""+rawPassword.toString());
//                return true;
//            } else {
//                return false;
//            }
//        }
//
//        @Override
//        public String encode(CharSequence rawPassword) {
//            return rawPassword.toString();
//        }
//    }
//
//    @Bean
//    public PasswordEncoder simplePasswordEncoder() {
//        return new SimplePasswordEncoder();
//    }
        
        @Bean
        public PasswordEncoder bcryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
        }

        
//     @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .exceptionHandling(e
                        -> e
                        .accessDeniedPage("/accessDenied.htm"))
                .formLogin(form
                        -> form
                        .loginPage("/login.htm").defaultSuccessUrl("/employeeList.htm")
                        .permitAll()
                )
                .logout(out
                        -> out
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login.htm")
                        .permitAll()
                )
                .authenticationProvider(authenticationProvider())
                .authorizeHttpRequests(t -> t
                .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                .requestMatchers("/favicon.ico*").permitAll()
                .requestMatchers("/error*").permitAll()
                .requestMatchers("/employeeList.htm*").hasAnyAuthority("ROLE_BF_VIEW_EMPLOYEE")
                .requestMatchers("/addEmployee.htm*").hasAnyAuthority("ROLE_BF_ADD_EMPLOYEE")
                .requestMatchers("/editEmployee.htm*").hasAnyAuthority("ROLE_BF_EDIT_EMPLOYEE")
                .anyRequest().authenticated()
                );
        return http.build();
    }
}
