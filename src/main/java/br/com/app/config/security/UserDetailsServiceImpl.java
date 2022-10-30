package br.com.app.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.app.model.UserModel;
import br.com.app.repository.UserRepository;

@Transactional
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

//	public UserDetailsServiceImpl(UserRepository _userRepository) {
//		this.userRepository = _userRepository;
//	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel userLoadFromDatabase = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found"));

		return new User(userLoadFromDatabase.getUsername(), userLoadFromDatabase.getPassword(), 
				true, true, true, true,
				userLoadFromDatabase.getAuthorities());
	}
}
