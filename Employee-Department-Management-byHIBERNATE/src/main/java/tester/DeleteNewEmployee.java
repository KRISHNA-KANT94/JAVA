package tester;
import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.EmployeeDaoImpl;

public class DeleteNewEmployee {

	public static void main(String[] args) {
		
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			
			EmployeeDaoImpl dao= new EmployeeDaoImpl();
			System.out.println("enter email and dept name");
			dao.DeleteNewEmployee(sc.next(), sc.next());
			System.out.println("deleted successfully");
			
		}

	}

}
