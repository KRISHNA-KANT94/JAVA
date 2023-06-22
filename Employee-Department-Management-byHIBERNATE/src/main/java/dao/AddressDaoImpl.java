package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Address;
import pojos.Employee;

import static utils.HibernateUtils.getFactory;

public class AddressDaoImpl implements AddressDao {

	@Override
	public String newEmpAddress(Address adr, long empsId) {
		String mesg = "Adding new dept failed!!!!!!!!!";
	//	String jpql="select a from Address a";
		
		Session session = getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		try {
			Employee e = session.get(Employee.class, empsId);
			if(e!=null) {
			adr.setOwner(e);
			session.persist(adr);
			}
			tx.commit();
			   
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return null;
	}

	@Override
	public Address fetchAddrByEmpId(long empsId) {
		Address adr= null;
		
		Session session = getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		try {
			
			adr = session.get(Address.class, empsId);
			tx.commit();
			   
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return adr;
	}

}
