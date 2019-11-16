package edu.ensit.forum.jwt;


import com.fasterxml.jackson.annotation.JsonIgnore;

import edu.ensit.forum.entity.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
 
import java.util.Collection;
import java.util.Objects;
 
public class UserPrinciple implements UserDetails {
  private static final long serialVersionUID = 1L;
 
  private Long id;
 
    private String name;
 
    private String username;
 
    private String email;
    private boolean enable;
    private String phone;

 
    @JsonIgnore
    private String password;
    private  Collection<? extends GrantedAuthority> authorities;

 

 
    public UserPrinciple(Long id, String name, String username,  boolean enable, String phone,
			String password, Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
	
		this.enable = enable;
		this.phone = phone;
		this.password = password;
		this.authorities = authorities;
	}

	public static UserPrinciple build(User user) {
     
 
        return new UserPrinciple(
                user.getId(),
                user.getName(),
                user.getUsername(),user.isEnable(),user.getPhone(),
                user.getPassword(),
                AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRoles())

        );
    }
 
    public Long getId() {
        return id;
    }
 
    public String getName() {
        return name;
    }
    
 
    public boolean isEnable() {
		return enable;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
        return email;
    }
 
    @Override
    public String getUsername() {
        return username;
    }
 
    @Override
    public String getPassword() {
        return password;
    }
 
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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
        return enable;
    }
 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        UserPrinciple user = (UserPrinciple) o;
        return Objects.equals(id, user.id);
    }

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}}


