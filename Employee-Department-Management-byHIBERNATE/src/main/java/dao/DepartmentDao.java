package dao;

import pojos.Department;

public interface DepartmentDao {
	
	//add new dept
	String AddDepartment(Department dept);
	
	//delete the department by name
	
	String deleteDepartmentByName(String name);
	
	//fetch the data of department by just giving name;
	// ek baat yaad rakho.. ki jab bhi bina id se delete karoge.. to query to run hogi..
	//lekin wo dono table pe hogi..
	//kya hme wo chahiye...??? nahi na...!!!
	// to hme fetch type ko.. lazy krna hoga.. aur left join krna hoga..
	//tb sirf ek department table pe kaam hoga...
	Department getDepartmentDetails(String name);

}
