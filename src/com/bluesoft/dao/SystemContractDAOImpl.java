package com.bluesoft.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bluesoft.entities.SystemContract;

//@Repository("systemContractDAO")
public class SystemContractDAOImpl implements SystemContractDAO{
	
	@Autowired
	//@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	@Autowired
	public SystemContractDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public List<SystemContract> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SystemContract getSystemContract(int systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteSystemContract(SystemContract system) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addSystemContract(SystemContract system) {
		// TODO Auto-generated method stub
		
	}

}
