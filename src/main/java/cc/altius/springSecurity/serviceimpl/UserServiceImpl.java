/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cc.altius.springSecurity.serviceimpl;

import cc.altius.springSecurity.dao.UserDao;
import cc.altius.springSecurity.model.CustomUserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import cc.altius.springSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
/**
 *
 * @author altius
 */
@Service
public class UserServiceImpl implements UserDetailsService , UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public CustomUserDetails getUserByUsername(String username) {
        CustomUserDetails user = this.userDao.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Username not found");
        }
        user.setBusinessFunctionList(this.userDao.getBusinessFunctionListByRole(user.getRole().getRoleId()));
        return user;
    }

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.getUserByUsername(username);
    }

}
