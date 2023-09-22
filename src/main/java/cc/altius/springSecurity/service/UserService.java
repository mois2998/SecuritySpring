/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cc.altius.springSecurity.service;

import cc.altius.springSecurity.model.CustomUserDetails;

/**
 *
 * @author altius
 */
public interface UserService {
    public CustomUserDetails getUserByUsername(String username);
}
