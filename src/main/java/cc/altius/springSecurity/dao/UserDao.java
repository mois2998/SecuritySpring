/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cc.altius.springSecurity.dao;

import cc.altius.springSecurity.model.BusinessFunction;
import cc.altius.springSecurity.model.CustomUserDetails;
import java.util.List;

/**
 *
 * @author altius
 */
public interface UserDao {

    public CustomUserDetails getUserByUsername(String username);

    public List<BusinessFunction> getBusinessFunctionListByRole(String roleId);
}
