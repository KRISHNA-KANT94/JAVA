package tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.AddressDaoImpl;
import pojos.Address;

import static utils.HibernateUtils.getFactory;

public class newEmpAddress {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			AddressDaoImpl dao= new AddressDaoImpl();
			System.out.println(" adrLine1,  adrLine2,  city,  state,  country,  zipCode, empId");
			dao.newEmpAddress(new Address(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next()), sc.nextLong());
			System.out.println("address assigned to emp");

	}

}
}
