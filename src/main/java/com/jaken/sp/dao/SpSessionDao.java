package com.jaken.sp.dao;

import java.io.Serializable;
import java.util.Collection;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.session.mgt.eis.SessionDAO;

public class SpSessionDao extends EnterpriseCacheSessionDAO implements SessionDAO{

	@Override
	public Serializable create(Session arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Session arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Session> getActiveSessions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Session readSession(Serializable arg0) throws UnknownSessionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Session arg0) throws UnknownSessionException {
		// TODO Auto-generated method stub
		
	}
}
