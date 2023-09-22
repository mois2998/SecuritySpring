/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cc.altius.springSecurity.daoImpl;

import cc.altius.springSecurity.dao.EmployeeDao;
import cc.altius.springSecurity.model.BusinessFunction;
import cc.altius.springSecurity.model.CustomUserDetails;
import cc.altius.springSecurity.model.Employee;
import cc.altius.springSecurity.rowMapper.BusinessFunctionRowMapper;
import cc.altius.springSecurity.rowMapper.CustomUserDetailsRowMapper;
import cc.altius.springSecurity.rowMapper.EmployeeRowMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author altius
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private DataSource dataSource;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    String sql = "SELECT * FROM employee";

    @Override
    public List<Employee> getEmployeeList() {
        return this.namedParameterJdbcTemplate.query(sql, new EmployeeRowMapper());
    }

    @Override
    public Employee getEmployeeById(int id) {
        String sql = "SELECT * FROM employee WHERE EMPLOYEE_ID=:id";
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        return this.namedParameterJdbcTemplate.queryForObject(sql, map, new EmployeeRowMapper());
    }

    public boolean updateEmployee(Employee e) {
        String sql = "UPDATE employee SET NAME=:name , GENDER = :gender WHERE EMPLOYEE_ID = :employeeId";
        Map<String, Object> map = new HashMap<>();
        map.put("name", e.getName());
        map.put("gender", e.getGender());
        map.put("employeeId", e.getEmployeeId());
        return (this.namedParameterJdbcTemplate.update(sql, map) == 1);
    }

    public int addEmployee(Employee e) {
        String sql = "INSERT INTO employee(NAME , GENDER) VALUES (:name , :gender)";
        Map<String, Object> map = new HashMap<>();
        map.put("name", e.getName());
        map.put("gender", e.getGender());
        return this.namedParameterJdbcTemplate.update(sql, map);
    }

}
