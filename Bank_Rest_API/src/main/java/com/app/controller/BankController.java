package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.BankDTO;
import com.app.dto.BankReqDTO;
import com.app.entities.AccountType;
import com.app.entities.Bank;
import com.app.service.BankService;

@RestController
@RequestMapping("/")
public class BankController {
	
	@Autowired
	private BankService bService;
	
	public BankController() {
		System.out.println("in bank controller"+ getClass());
	}
	
	@GetMapping("/list")
	public List<Bank> getAllBanks(){
		return bService.getAllAccount();
	}
	
	@PostMapping("/add")
	
	public BankDTO addBankDetails(@RequestBody @Valid BankDTO b) {
	return bService.addBankDetails(b);
	}
	
	@PutMapping("/update")
	
	public BankDTO updateBankDetails(@RequestBody @Valid BankDTO b) {
		return bService.updateBankDetails(b);
	}
	
	@DeleteMapping("/{bid}")
	public String deleteBankDetails(@PathVariable Long bid) {
		return bService.deleteBankDetails(bid);
	}
	
	@GetMapping("/{bid}")
	public Bank getBankDetails(@PathVariable Long bid) {
		return bService.getBankDetails(bid);
	}
	
	@PostMapping("/signin")
	public BankDTO emailPass(@RequestBody @Valid BankReqDTO b) {
		return bService.custSignin(b);
	}
	
	@GetMapping("/bank/{type}")
	List<Bank> getByTypedetails(@PathVariable String type){
		return bService.getByType(AccountType.valueOf(type.toUpperCase()));
	}
	
	@GetMapping("/banks/{name}")
	List<Bank> getByName(@PathVariable String name){
		return bService.getByName(name);
	}

}
