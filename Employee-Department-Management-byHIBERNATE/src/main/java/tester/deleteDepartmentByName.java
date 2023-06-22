package tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.DeaprtmentDaoImpl;
import static utils.HibernateUtils.getFactory;

public class deleteDepartmentByName {

	public static void main(String[] args) {
		
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			DeaprtmentDaoImpl dao= new DeaprtmentDaoImpl();
			
			System.out.println("Enter department name");
			dao.deleteDepartmentByName(sc.next());
			System.out.println("deleted successfully");

	}

}
}
