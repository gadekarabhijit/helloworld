package com.dreamland.core.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.dreamland.core.model.ComUserDetails;


/**
 * @author Abhijit
 * @Created Date : Oct 26, 2015
 */
public interface UserDetailsService
{
	public UserDetails loadUserByUsername(String username);
	public ComUserDetails getUserByUsername(String username);
}
