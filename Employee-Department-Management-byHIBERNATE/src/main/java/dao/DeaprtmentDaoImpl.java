package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import pojos.Department;
import static utils.HibernateUtils.getFactory;

import java.util.List;

public class DeaprtmentDaoImpl implements DepartmentDao {

	@Override
	public String AddDepartment(Department dept) {
		
       String mesg = "Adding new dept failed!!!!!!!!!";
		
		Session session = getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		try {
			session.persist(dept);
			
			tx.commit();
			   
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public String deleteDepartmentByName(String name) {
		// TODO Auto-generated method stub
		String mesg = "deleting dept failed!!!!!!!!!";
		String jpql="select d from Department d where d.departmentName=: nm";
		
		Session session = getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		try {
			
			Department d= session.createQuery(jpql,Department.class).setParameter("nm", name).getSingleResult();
			session.delete(d);
			tx.commit();
			   
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public Department getDepartmentDetails(String name) {
		Department dept=null;
		String mesg = "Adding new dept failed!!!!!!!!!";
		String jplq="select d from Department d left join fetch d.emplist where d.departmentName=: nm";
		
		Session session = getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		try {
			dept = session.createQuery(jplq,Department.class).setParameter("nm", name).getSingleResult();
			System.err.println("details"+ dept);
			
			tx.commit();
			   
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return dept;
	}
	}
