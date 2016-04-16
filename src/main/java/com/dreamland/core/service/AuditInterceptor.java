package com.dreamland.core.service;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.dreamland.core.model.BaseModel;


public class AuditInterceptor extends EmptyInterceptor
{

	private static ThreadLocal userPerThread = new ThreadLocal();

	public static void setUserForCurrentThread(String user)
	{
		userPerThread.set(user);
	}

	public static String getUserForCurrentThread()
	{
		return (String) userPerThread.get();
	}

	@Override
	public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types)
	{

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		boolean changed = false;
		int index = 0;
		if (entity instanceof BaseModel)
		{
			for (String property : propertyNames)
			{
				switch (property)
				{
				case Constants.UPDATED_DATE:
					currentState[index] = new Date();
					break;
				case Constants.UPDATED_BY:
					currentState[index] = authentication.getName();
					break;
				}
				index++;
				changed = true;
			}
		}
		return changed;
	}

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] currentState, String[] propertyNames, Type[] types)
	{
		boolean changed = false;
		if (entity instanceof BaseModel)
		{
			changed = updateAuditable(currentState, propertyNames);
		}
		return changed;

	}

	private boolean updateAuditable(Object[] currentState, String[] propertyNames)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		boolean changed = false;
		int index = 0;
		for (String property : propertyNames)
		{
			if (currentState[index] == null)
			{
				switch (property)
				{
				case Constants.CREATED_BY:
					currentState[index] = authentication.getName();
					break;
				case Constants.CREATED_DATE:
					currentState[index] = new Date();
					break;
				case Constants.RECORD_STATUS:
					currentState[index] = Constants.ACTIVE_RECORD_STATUS;
					break;
				}
			}
			index++;
			changed = true;
		}

		return changed;
	}

}