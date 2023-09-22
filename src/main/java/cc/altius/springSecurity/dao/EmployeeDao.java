/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cc.altius.springSecurity.dao;

import cc.altius.springSecurity.model.BusinessFunction;
import cc.altius.springSecurity.model.CustomUserDetails;
import cc.altius.springSecurity.model.Employee;
import java.util.List;

/**
 *
 * @author altius
 */
public interface EmployeeDao {

    public List<Employee> getEmployeeList();

    public Employee getEmployeeById(int id);

    public boolean updateEmployee(Employee e);

    public int addEmployee(Employee e);

}
