package es.team1project2new.bankapp.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import es.team1project2new.bankapp.exceptions.InvalidDetailsException;
import es.team1project2new.bankapp.models.BankAccount;

@Component
public class UserAccount {
	@Autowired
	List<BankAccount> bankAccounts= new ArrayList<>();
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String phoneNumber;

	private boolean patternMatches(String emailAddress, String regexPattern) {
		return Pattern.compile(regexPattern).matcher(emailAddress).matches();
	}

	public UserAccount() {
		super();

		this.bankAccounts = new ArrayList<>();
	}

	@Override
	public boolean equals(Object obj) {
		if (((UserAccount) obj).getId().equals(this.getId())
				&& ((UserAccount) obj).getFirstName().equals(this.getFirstName())
				&& ((UserAccount) obj).getLastName().equals(this.getLastName())
				&& ((UserAccount) obj).getEmail().equals(this.getEmail())
				&& ((UserAccount) obj).getPassword().equals(this.getPassword())
				&& ((UserAccount) obj).getPhoneNumber().equals(this.getPhoneNumber())
				&& ((UserAccount) obj).getBankAccounts().equals(this.getBankAccounts()))
			return true;
		return false;
	}

	public UserAccount(String id, String firstName, String lastName, String email, String password,
			String phoneNumber) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		setPhoneNumber(phoneNumber);
		setEmail(email);
		this.password = password;

	}
	public UserAccount( String firstName, String lastName, String email, String password,
			String phoneNumber) {
	
		this.firstName = firstName;
		this.lastName = lastName;
		setPhoneNumber(phoneNumber);
		setEmail(email);
		this.password = password;

	}
public void addBankAccount(BankAccount account) {
	this.bankAccounts.add(account);
}
	public List<BankAccount> getBankAccounts() {
		return this.bankAccounts;
	}

	public void addAccount(BankAccount bankAccount) {
		this.bankAccounts.add(bankAccount);

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {

		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {

		if (password.length() <= 3)
			throw new InvalidDetailsException();
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		if (phoneNumber.matches("[0-9]+")) {
			this.phoneNumber = phoneNumber;
		} else {
			throw new InvalidDetailsException();
		}

	}

	public void setBankAccounts(List<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}

	@Override
	public String toString() {
		return "UserAccount [bankAccounts=" + bankAccounts + ", id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", password=" + password + ", phoneNumber=" + phoneNumber + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
