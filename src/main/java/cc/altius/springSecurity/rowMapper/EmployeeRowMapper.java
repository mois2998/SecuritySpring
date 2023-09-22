/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cc.altius.springSecurity.rowMapper;

import cc.altius.springSecurity.model.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author altius
 */
public class EmployeeRowMapper implements RowMapper<Employee>{
    
     @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Employee(
        rs.getInt("EMPLOYEE_ID"),
        rs.getString("NAME"),
        rs.getString("GENDER"));
    }
}
