package ht.nahum.freshvotes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ht.nahum.freshvotes.domain.User;
import ht.nahum.freshvotes.repository.UserRepository;
import ht.nahum.freshvotes.security.Authority;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User save(User user) {
		if(user==null) {
			throw new UsernameNotFoundException("Invalid Username and password");
		}
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		Authority authority = new Authority();
		authority.setAuthority("ROLE_USER");
		authority.setUser(user);
		user.getAuthorities().add(authority);
		
		return userRepository.save(user);
	}

}
