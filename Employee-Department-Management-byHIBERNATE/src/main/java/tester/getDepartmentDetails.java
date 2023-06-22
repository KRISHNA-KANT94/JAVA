package tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.DeaprtmentDaoImpl;
import static utils.HibernateUtils.getFactory;

public class getDepartmentDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			DeaprtmentDaoImpl dao= new DeaprtmentDaoImpl();
			System.out.println("enter name of the department");
			dao.getDepartmentDetails(sc.next());
			System.out.println("fetched");
			

	}

}
}
