package tester;
import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.EmployeeDaoImpl;
import pojos.Employee;
import pojos.EmploymentType;

public class AddNewEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			EmployeeDaoImpl dao= new EmployeeDaoImpl();
			
			//System.out.println("Enter employee details and dept ID");
			System.out.println("firstName,lastName,email,password,confirmPassword,joinDate,type,salary");
			
			Employee emp= new Employee(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), LocalDate.parse(sc.next()), EmploymentType.valueOf(sc.next().toUpperCase()), sc.nextDouble());
			System.out.println("enter deptid");
			System.out.println(dao.AddNewEmployee(emp, sc.nextLong()));

	}

}
}
