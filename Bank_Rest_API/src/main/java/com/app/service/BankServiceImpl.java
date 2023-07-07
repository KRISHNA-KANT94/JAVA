package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.APIResponse;
import com.app.dto.BankDTO;
import com.app.dto.BankReqDTO;
import com.app.entities.AccountType;
import com.app.entities.Bank;
import com.app.repositories.BankRepo;

@Service
@Transactional
public class BankServiceImpl implements BankService {
	
	@Autowired
	private BankRepo bRepo;
	
	@Autowired
	private ModelMapper maps;
	@Override
	public List<Bank> getAllAccount() {
		
		return bRepo.findAll();
	}

	@Override
	public BankDTO addBankDetails(BankDTO b) {
		Bank b1= maps.map(b, Bank.class);
		return maps.map(bRepo.save(b1), BankDTO.class);
	}

	@Override
	public BankDTO updateBankDetails(BankDTO b) {
		Bank b2=maps.map(b, Bank.class);
		return maps.map(bRepo.save(b2), BankDTO.class);
	}

	@Override
	public String deleteBankDetails(Long bid) {
		String messg= "invalid bank id";
		if(bRepo.existsById(bid)) {
			bRepo.deleteById(bid);
			messg="id deleted";
		}
		return messg;
	}

	@Override
	public Bank getBankDetails(Long bid) {
		
		return bRepo.findById(bid).orElseThrow(()-> new ResourceNotFoundException("invalid Id"));
	}

	@Override
	public BankDTO custSignin(BankReqDTO dto) {
		
		Bank b1 = bRepo.findByEmailAndPassword(dto.getEmail(), dto.getPassword()).orElseThrow(()-> new ResourceNotFoundException("invalid email and password"));
		
		BankDTO b2= maps.map(b1, BankDTO.class);
		return b2;
	}

	@Override
	public List<Bank> getByType(AccountType name) {
		List<Bank> b= bRepo.findByType(name);
//		List<BankDTO> dto= new ArrayList<>();
//		b.forEach(i->{BankDTO a= maps.map(i, BankDTO.class);
//				dto.add(a);
//		});
		return b;
	}

	@Override
	public List<Bank> getByName(String name) {
		// TODO Auto-generated method stub
		return bRepo.findByFirstName(name);
	}

	

}
