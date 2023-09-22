/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cc.altius.springSecurity.rowMapper;

import cc.altius.springSecurity.model.BusinessFunction;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author altius
 */
public class BusinessFunctionRowMapper implements RowMapper<BusinessFunction> {
    
    @Override
    public BusinessFunction mapRow(ResultSet rs, int rowNum) throws SQLException {
       return new BusinessFunction(
       rs.getString("BUSINESS_FUNCTION"),
               rs.getString("BUSINESS_FUNCTION_DESC")
       );
    }
    
}
