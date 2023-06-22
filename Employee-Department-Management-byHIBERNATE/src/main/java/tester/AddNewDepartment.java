package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.DeaprtmentDaoImpl;
import dao.DepartmentDao;
import pojos.Department;

public class AddNewDepartment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			DeaprtmentDaoImpl dao= new DeaprtmentDaoImpl();
			
			System.out.println(" departmentName,  location");
			
			dao.AddDepartment(new Department(sc.next(), sc.next()));
			
			System.out.println("added successfully");
			
		}

	}

	}
