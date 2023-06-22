package tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.AddressDaoImpl;
import static utils.HibernateUtils.getFactory;

public class fetchAddrByEmpId {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			AddressDaoImpl dao= new AddressDaoImpl();
			System.out.println("enter employee id");
			;
			System.out.println("address fetched successfully::"+dao.fetchAddrByEmpId(sc.nextLong()));
			
		}

	}

}
