package com.hello.hellospring.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.hello.hellospring.dao.UserDao;
import com.hello.hellospring.model.UserRole;


public class HelloUserDetailService implements UserDetailsService{

    public HelloUserDetailService(){
        System.out.println("#################INSIDE_FESES########################");
    }



	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

		System.out.println("@#$#%%$$^$$^%#%^&#^$Q&@&^#%^&$");
		com.hello.hellospring.model.User user = userDao.findByUserName(username);
		List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());

		return buildUserForAuthentication(user, authorities);
		

	}

	
	private User buildUserForAuthentication(com.hello.hellospring.model.User user, List<GrantedAuthority> authorities) {
		System.out.println("@#$#%%$$^$$^%#%^&#^$Q&@&^#%^&$");
		return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
		System.out.println("@#$#%%$$^$$^%#%^&#^$Q&@&^#%^&$");
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		for (UserRole userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


}
