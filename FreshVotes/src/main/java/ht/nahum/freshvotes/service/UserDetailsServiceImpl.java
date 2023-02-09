package ht.nahum.freshvotes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ht.nahum.freshvotes.domain.User;
import ht.nahum.freshvotes.repository.UserRepository;
import ht.nahum.freshvotes.security.CustomSecurityUser;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("Invalid Username and password");
		}
		return new CustomSecurityUser(user);
	}

}
