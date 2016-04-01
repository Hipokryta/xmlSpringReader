package com.bluesoft.dao;

import java.util.List;

import com.bluesoft.entities.SystemContract;

public interface SystemContractDAO {
	
	public List<SystemContract> list();
	public SystemContract getSystemContract(int systemId);
	public void deleteSystemContract(SystemContract system);
	public void addSystemContract(SystemContract system);
}
