package com.bluesoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluesoft.entities.SystemContract;


//@Service("systemContractService")
public class SystemContractServiceImpl implements SystemContractService{

	@Autowired
	private SystemContract systemContractDao;
	
	public void addSystemContract(SystemContract systemContract) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SystemContract> listSystemContract() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteSystemContract(SystemContract systemContract) {
		// TODO Auto-generated method stub
		
	}

}
