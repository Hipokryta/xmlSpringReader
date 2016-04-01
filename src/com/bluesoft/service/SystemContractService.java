package com.bluesoft.service;

import java.util.List;

import com.bluesoft.entities.SystemContract;

public interface SystemContractService {
	
	public void addSystemContract(SystemContract systemContract);

	public List<SystemContract> listSystemContract();
	
	//public SystemContract getSystemContract(int empid);
	
	public void deleteSystemContract(SystemContract systemContract);
}