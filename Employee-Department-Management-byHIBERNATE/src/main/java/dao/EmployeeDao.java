package dao;

import pojos.Employee;

public interface EmployeeDao {
	
//Add new emp to dept with deptid
	
	String AddNewEmployee(Employee emp,long deptid);
	
	//delete employee by dept. name;
	
	String DeleteNewEmployee(String email, String name);
	// whenever we want to delete child record by the help of parent record..
	// then in child table.. only FK will delete.. full reference will not be deleted..
	// and update query will be fired..
	// so we have to use orphan in child..
	
}
