package ht.nahum.freshvotes.security;

import java.util.Set;
import org.springframework.security.core.userdetails.UserDetails;
import ht.nahum.freshvotes.domain.User;

public class CustomSecurityUser extends User implements UserDetails{
	
	private static final long serialVersionUID = -3798544624347135444L;
	
	public CustomSecurityUser() {
		
	}

	public CustomSecurityUser(User user) {
		this.setAuthorities(user.getAuthorities());
		this.setId(user.getId());
		this.setName(user.getName());
		this.setPassword(user.getPassword());
		this.setUsername(user.getUsername());
	}

	@Override
	public Set<Authority> getAuthorities() {
		return super.getAuthorities();
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getUsername();
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
		return true;
	}

}
