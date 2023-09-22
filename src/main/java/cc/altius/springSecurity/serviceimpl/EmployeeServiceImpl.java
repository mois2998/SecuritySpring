/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cc.altius.springSecurity.serviceimpl;

import cc.altius.springSecurity.dao.EmployeeDao;
import cc.altius.springSecurity.model.CustomUserDetails;
import cc.altius.springSecurity.model.Employee;
import cc.altius.springSecurity.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author altius
 */
@Service
public class EmployeeServiceImpl implements EmployeeService 
//        , UserDetailsService 
{
    @Autowired
    private EmployeeDao employeeDao;
    
    @Override
    public List<Employee> getEmployeeList(){
    return employeeDao.getEmployeeList();
    }
    @Override
     public Employee getEmployeeById(int id){
     return this.employeeDao.getEmployeeById(id);
     }
     @Override
    public boolean updateEmployee(Employee e ){
    return this.employeeDao.updateEmployee(e);   
     }
       @Override
    public int addEmployee(Employee e) {
      return this.employeeDao.addEmployee(e);
    }
//
//    @Override
//    public CustomUserDetails getUserByUsername(String username) {
//        CustomUserDetails user = this.employeeDao.getUserByUsername(username);
//        if(user==null)
//            throw  new UsernameNotFoundException("username not found");
//        user.setBusinessFunction(employeeDao.getBusinessFunctionListByRole(user.getRole().getRoleId()));
//    return user ;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//    return this.getUserByUsername(username);}
}


