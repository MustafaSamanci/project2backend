package es.team1project2new.bankapp.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import es.team1project2new.bankapp.models.BankAccount;
import es.team1project2new.bankapp.models.UserAccount;

public class BankAccountsService {
	public List<UserAccount> mockdata;

	public BankAccountsService() {
		mockdata = new ArrayList<>(Arrays.asList(
				new UserAccount("1", "FirstName", "LastName", "email@gmail.com", "password", "0748364392"),
				new UserAccount("2", "FirstName2", "LastName2", "email2@gmail.com", "password2", "0748364392"),
				new UserAccount("4", "FirstName4", "LastName4", "email4@gmail.com", "password4", "0748364392")));
		for (int i = 0; i < 3; i++) {
			mockdata.get(i).addAccount(new BankAccount("i", "Holder", "USD", (double) 3));
		}
	}

	public BankAccount findBankAccount(String id) {
		this.mockdata.forEach(e -> {
			for (int i = 0; i < e.getBankAccounts().size(); i++) {
				if (e.getBankAccounts().get(i).getId().equals(id))
					return e.getBankAccounts().get(i);
			}
		});
		return null;
	}
	public BankAccount findAccount(String id) {}

}
