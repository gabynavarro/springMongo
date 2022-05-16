package com.mongoLibreria.libreria.model.Entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Document(collection = "users")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails{
  @Id
  private String id;

  @NotBlank
  @Size(max = 20)
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  @NotBlank
  @Size(max = 120)
  private String password;

  @DBRef
  private Set<Role> roles = new HashSet<>();

    public User(String username, String email, String encode) {
        throw new UnsupportedOperationException("Not supported,  create't user."); 
    }
    
    private Collection<? extends GrantedAuthority> authorities;
    @Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

    @Override
    public boolean isAccountNonExpired() {
        return true; }

    @Override
    public boolean isAccountNonLocked() {
       return true;   }

    @Override
    public boolean isCredentialsNonExpired() {
       return true; }

    @Override
    public boolean isEnabled() {
        return true;    }
 
}
