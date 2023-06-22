package pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
//all specs Java EE supplied
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity // Mandatory to tell hibernate , following class is a standalone entity , life
		// cycle to be managed by hibernate
@Table(name = "emps") // to specify table name
public class Employee extends BaseEntity {

	@Column(name = "first_name", length = 20) // varchar(20)
	private String firstName;
	@Column(name = "last_name", length = 20)
	private String lastName;
	@Column(length = 30, unique = true) // unique constraint
	private String email;
	@Column(length = 20, nullable = false) // NOT NULL constraint
	private String password;
	@Transient // => skips from persistence => no col. generation
	private String confirmPassword;
	@Column(name = "join_date")
	private LocalDate joinDate;
	@Enumerated(EnumType.STRING) // => col type :
	// varchar => enum const name
	@Column(length = 20)
	private EmploymentType type;
	private double salary;
	@Lob // => large object : col type : longblob : Mbs
	private byte[] image;
	// Employee *----->1 Department
	@ManyToOne
	@JoinColumn(name="dept_id")
	private Department dept;
	@ManyToMany(mappedBy = "Emps")
	private Set<Project> project= new HashSet<Project>();
	@Embedded
	private AdhaarCard acard;
	@ElementCollection
	@CollectionTable(name="payment_option",joinColumns = @JoinColumn(name="emp_id"))
	private List<PaymentOption> payment= new ArrayList<>();
	@ElementCollection
	@CollectionTable(name="emp_skill",joinColumns = @JoinColumn(name="emp_id"))
	@Column(name="skill_name",length=30)
	private List<String> skills;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String firstName, String lastName, String email, String password, String confirmPassword,
			LocalDate joinDate, EmploymentType type, double salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.joinDate = joinDate;
		this.type = type;
		this.salary = salary;
	}

	// additional overloaded ctor : to be used in JPQL ctor expression
	public Employee(String firstName, String lastName, double salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	public EmploymentType getType() {
		return type;
	}

	public void setType(EmploymentType type) {
		this.type = type;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}
	public Set<Project> getProject() {
		return project;
	}

	public void setProject(Set<Project> project) {
		this.project = project;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + getId() + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", joinDate=" + joinDate + ", type=" + type + ", salary=" + salary + "]";
	}

}
