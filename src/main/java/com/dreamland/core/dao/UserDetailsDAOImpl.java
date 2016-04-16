package com.dreamland.core.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.dreamland.core.model.ComUserDetails;


/**
 * @author Abhijit
 * @Created Date : Oct 26, 2015
 */
@Repository
public class UserDetailsDAOImpl extends BaseDAOImpl implements UserDetailsDAO
{
	@Override
	public ComUserDetails loadUserByUsername(String username)
	{
		List<ComUserDetails> users = new ArrayList<ComUserDetails>();
		ComUserDetails comUserDetails = new ComUserDetails();
		Criteria criteria = getCriteria(ComUserDetails.class);
		criteria.add(Restrictions.eq("userName", username));
		users = criteria.list();
		if (users.size() > 0)
		{
			comUserDetails = users.get(0);
		} else
		{
			return null;
		}
		return comUserDetails;

	}
}
