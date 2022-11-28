package es.team1project2new.bankapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import es.team1project2new.bankapp.models.BankAccount;
import es.team1project2new.bankapp.services.BankAccountsService;

public class BankAccountController {
@Autowired
private BankAccountsService accountsService;
@GetMapping("/bankAccounts/${id}")
public BankAccount getBankAccountById(@PathVariable String id) {
	return null;
	//return accountsService.findBankAccount(id)
}
}
