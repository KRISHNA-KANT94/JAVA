
package pojos;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="departments")
public class Department extends BaseEntity {
	@Column(name="department_name",length = 30,unique = true)
	private String departmentName;
	@Column(length = 50)
	private String location;
	@OneToMany(mappedBy = "dept",fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Employee> emplist= new ArrayList<Employee>();

	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(String departmentName, String location) {
		super();
		this.departmentName = departmentName;
		this.location = location;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public List<Employee> getEmplist() {
		return emplist;
	}

	public void setEmplist(List<Employee> emplist) {
		this.emplist = emplist;
	}
	
	public void addNewEmployee(Employee e) {
		emplist.add(e);
		e.setDept(this);
	}
	
	public void removeEmployee(Employee e) {
		emplist.remove(e);
		e.setDept(null);
	}

	// Project tip :
	// DO NOT add any association fields in toString (to avoid recursion)
	@Override
	public String toString() {
		return "Department [departmentName=" + departmentName + ", location=" + location + "]";
	}
	


}
