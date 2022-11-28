package es.team1project2new.bankapp.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import es.team1project2new.bankapp.exceptions.NegativeValueException;
@Component
public class BankAccount {
	@Id
	private String id;
	private String holderName;
	private String currency;
private String holderId;
	private double balance;
	@Autowired
	private List<Transaction> transactions= new ArrayList<>();

	public BankAccount(String holderId,String holderName, String currency, double balance) {
		this.id=UUID.randomUUID().toString();
		this.holderId=holderId;
		this.holderName=holderName;
		this.currency=currency;
		this.setBalance(balance);
		this.transactions=new ArrayList<>();
		for(Transaction transaction:transactions) {
			this.transactions.add(transaction);
		}
		
	}

	

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		if(balance<0)
			throw new NegativeValueException();
		this.balance = balance;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public boolean equals(Object obj) {
		if (((BankAccount) obj).getBalance()==(this.getBalance())
				&& ((BankAccount) obj).getCurrency().equals(this.getCurrency())
				&& ((BankAccount) obj).getHolderName().equals(this.getHolderName())
				&& ((BankAccount) obj).getTransactions().equals(this.getTransactions())

				)
			return true;
		return false;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getHolderId() {
		return holderId;
	}



	public void setHolderId(String holderId) {
		this.holderId = holderId;
	}
	
	//ID// Name,Balance,Currency,
	//List<Transactions>
}
