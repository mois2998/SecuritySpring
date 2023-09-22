/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cc.altius.springSecurity.model;
import cc.altius.springSecurity.model.Role;
import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
/**
 *
 * @author altius
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class CustomUserDetails implements UserDetails , Serializable {
    private int userId;
    private String emailId;
    private String password;
    private Role role;
    private List<BusinessFunction> businessFunctionList;
    private boolean active;
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorityList = new LinkedList<>();
        authorityList.add(new SimpleGrantedAuthority(role.getRoleId()));
        for (BusinessFunction bf : this.businessFunctionList) {
            authorityList.add(new SimpleGrantedAuthority(bf.getBusinessFunctionId()));
        }
        return authorityList;
    }

    @Override
    public String getPassword() {
       return this.password;
    }

    @Override
    public String getUsername() {
        return this.emailId;
    }

    @Override
    public boolean isAccountNonExpired() {
       return true;
    }

    @Override
    public boolean isAccountNonLocked() {
     return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
    return this.active;
    }

    
    
}
