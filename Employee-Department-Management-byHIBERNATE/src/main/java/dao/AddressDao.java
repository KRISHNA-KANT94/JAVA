package dao;

import pojos.Address;

public interface AddressDao {
	
	public String newEmpAddress(Address adr, long empsId);
	
	//get address details by empid
	
	public Address fetchAddrByEmpId(long empsId);

}
