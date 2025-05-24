package org.abdullpractice.dao;

import java.util.List;

import org.abdullpractice.dto.EmpDto;

public interface EmpDaoInterface {

	//Select All employees
	public List getAllEmployees();
	
	//Select employee
	public EmpDto getEmployee(int id);
	
	//Update a record into the database
	public boolean updateEmployee(int id);
	
	//Delete a record into the database
	public boolean deleteEmployee(int id);

	//Insert the record into he database
	public boolean insertEmployee(EmpDto e);
	
//Further We can add the much more features	
}
