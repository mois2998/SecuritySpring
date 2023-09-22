/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cc.altius.springSecurity.rowMapper;

import cc.altius.springSecurity.model.CustomUserDetails;
import cc.altius.springSecurity.model.Role;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author altius
 */
public class CustomUserDetailsRowMapper implements RowMapper<CustomUserDetails> {

//    @Override
//    public CustomUserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
//        return new CustomUserDetails(
//        rs.getInt("USER_ID"),
//        rs.getString("EMAIL_ID"),
//        rs.getString("PASSWORD"),
//        new Role(rs.getString("ROLE_NAME"),
//        rs.getString("ROLE_NAME")),
//        null,
//        rs.getBoolean("ACTIVE")  
//        );
//
//    }
    @Override
    public CustomUserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new CustomUserDetails(
                rs.getInt("USER_ID"),
                rs.getString("EMAIL_ID"),
                rs.getString("PASSWORD"),
                new Role(rs.getString("ROLE_ID"), rs.getString("ROLE_NAME")),
                null,
                rs.getBoolean("ACTIVE"));
    }
}
