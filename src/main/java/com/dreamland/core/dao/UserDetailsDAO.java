package com.dreamland.core.dao;

import com.dreamland.core.model.ComUserDetails;

/**
 * @author Abhijit
 * @Created Date : Oct 26, 2015
 */
public interface UserDetailsDAO
{
	public ComUserDetails loadUserByUsername(String username);
}
