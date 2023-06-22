package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import static utils.HibernateUtils.getFactory;

import pojos.Department;
import pojos.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public String AddNewEmployee(Employee emp, long deptid) {
       String mesg = "Adding new emp failed!!!!!!!!!";
		
		Session session = getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		try {
			Department dept = session.get(Department.class, deptid);
			dept.addNewEmployee(emp);
			
			tx.commit();
			mesg="addedd successfully"+ dept;
			
			   
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public String DeleteNewEmployee(String email, String name) {
		String mesg = "Adding new dept failed!!!!!!!!!";
		String jpql="select d from Department d where d.departmentName=:nm";
		String jpql1="select e from Employee e where e.email=:em";
		
		Session session = getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		try {
			
			Department d1 = session.createQuery(jpql,Department.class).setParameter("nm", name).getSingleResult();
			Employee e1 = session.createQuery(jpql1,Employee.class).setParameter("em", email).getSingleResult();
			d1.removeEmployee(e1);
			tx.commit();
			System.out.println("employee deleted successfully");
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}
	}

