package com.dreamland.core.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.dreamland.core.model.BaseModel;
import com.dreamland.core.model.ComUserDetails;
import com.dreamland.core.service.AuditInterceptor;
import com.dreamland.core.service.Constants;
import com.dreamland.core.service.UserDetailsService;

@Repository
public class BaseDAOImpl implements BaseDAO
{
	@Autowired
	protected SessionFactory sessionFactory;

	@Override
	public void setSessionFactory(SessionFactory sf)
	{
		this.sessionFactory = sf;
	}

	private UserDetailsService userDetailsService;

	@Autowired(required = true)
	@Qualifier(value = "userDetailsService")
	protected void setUserDetailsService(UserDetailsService userDetailsService)
	{
		this.userDetailsService = userDetailsService;
	}

	protected ComUserDetails getUserDetails()
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return userDetailsService.getUserByUsername(authentication.getName());
	}

	protected Criteria getCriteriaForSelect(Class modelClass)
	{
		ComUserDetails user = getUserDetails();
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(modelClass);
		criteria.add(Restrictions.eq(Constants.RECORD_STATUS, Constants.ACTIVE_RECORD_STATUS));
		criteria.add(Restrictions.eq(Constants.INSTITUTE_VARIABLE_NAME, user.getInstituteId()));
		return criteria;
	}

	@SuppressWarnings(
	{ "unchecked", "rawtypes" })
	protected Object get(Class modelClass, Integer id)
	{
		Session session = getHibernateSession();
		Object obj = session.get(modelClass, id);
		session.flush();
		session.close();
		return obj;
	}

	protected List get(String hql)
	{
		ComUserDetails user = getUserDetails();
		Session session = getHibernateSession();
		hql = hql + " where instituteId = " + user.getInstituteId() + " and " + Constants.RECORD_STATUS + " = " + "'"
				+ Constants.ACTIVE_RECORD_STATUS + "'";
		Query query = session.createQuery(hql);
		List list = query.list();
		session.flush();
		session.close();
		return list;
	}

	protected Criteria getCriteria(Class modelClass)
	{
		Session session = this.sessionFactory.getCurrentSession();
		return session.createCriteria(modelClass);
	}

	protected Object save(BaseModel baseModel)
	{
		ComUserDetails user = getUserDetails();
		Session session = getHibernateSession();
		baseModel.setInstituteId(user.getInstituteId());
		session.saveOrUpdate(baseModel);
		session.flush();
		session.close();
		return baseModel;
	}

	protected Object delete(BaseModel baseModel)
	{
		Session session = getHibernateSession();
		baseModel.setRecordStatus(Constants.DELETED_RECORD_STATUS);
		session.update(baseModel);
		return baseModel;
	}

	private Session getHibernateSession()
	{
		return this.sessionFactory.withOptions().interceptor(new AuditInterceptor()).openSession();
	}

}
