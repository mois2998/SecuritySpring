/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cc.altius.springSecurity.daoImpl;

import cc.altius.springSecurity.dao.UserDao;
import cc.altius.springSecurity.model.BusinessFunction;
import cc.altius.springSecurity.model.CustomUserDetails;
import cc.altius.springSecurity.rowMapper.BusinessFunctionRowMapper;
import cc.altius.springSecurity.rowMapper.CustomUserDetailsRowMapper;
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
public class UserDaoImpl implements UserDao {
    private DataSource dataSource ;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
    @Autowired
    public void setDataSource(DataSource datasource){
    this.dataSource = datasource;
    this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(datasource);
            }

    @Override
    public CustomUserDetails getUserByUsername(String username) {
        String sql = "SELECT u.USER_ID , u.EMAIL_ID , u.PASSWORD , ur.ROLE_ID , r.ROLE_NAME , u.ACTIVE "
                + "FROM us_user u"
                + "LEFT JOIN us_user_role ur ON u.USER_ID = ur.USER_ID "
                + "LEFT JOIN us_role r ON ur.ROLE_ID =r.ROLE_ID "
                + "WHERE u.EMAIL_ID=:username";
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        return this.namedParameterJdbcTemplate.queryForObject(sql, map, new CustomUserDetailsRowMapper());
    }

    @Override
    public List<BusinessFunction> getBusinessFunctionListByRole(String roleId) {

        String sql = "SELECT rbf.BUSINESS_FUNCTION_ID , bf.BUSINESS_FUNCTION_DESC FROM us_role_business_function rbf"
                + "LEFT JOIN us_business_function bf ON rbf.BUSINESS_FUNCTION_ID= bf.BUSINESS_FUNCTION"
                + "WHERE rbf.ROLE_ID =:roleId";
        Map<String, Object> map = new HashMap<>();
        map.put("roleId", roleId);
        return this.namedParameterJdbcTemplate.query(sql, map, new BusinessFunctionRowMapper());
    }
}
