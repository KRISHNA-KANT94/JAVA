package com.app.service;

import java.util.List;

import com.app.dto.BankDTO;
import com.app.dto.BankReqDTO;
import com.app.entities.AccountType;
import com.app.entities.Bank;

public interface BankService {
	
	//get
	
	List<Bank> getAllAccount();
	
	// add
	
	public BankDTO addBankDetails(BankDTO b);
	
	//update
	
	public BankDTO updateBankDetails(BankDTO b);
	
	//delete
	
	public String deleteBankDetails(Long bid);
	
	//get by id 
	
	public Bank getBankDetails(Long bid);
	
	//signin
	public BankDTO custSignin(BankReqDTO dto);
	
	//
	List<Bank> getByType(AccountType name);
	
	//
	
	List<Bank> getByName(String name);

}
