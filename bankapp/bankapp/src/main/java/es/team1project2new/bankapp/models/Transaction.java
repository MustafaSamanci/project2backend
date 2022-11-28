package es.team1project2new.bankapp.models;

import java.util.UUID;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

import es.team1project2new.bankapp.exceptions.NegativeValueException;
import lombok.Builder;
import lombok.Data;

@Component


public class Transaction {
	private String id;
	private String sender;
	private String receiver;
	private double amount;
	private String currency;
	private String description;

	public Transaction(String sender, String receiver, String currency, double amount, String description) {
		super();
		this.id = UUID.randomUUID().toString();

		this.sender = sender;
		this.receiver = receiver;
		this.setAmount(amount);
		this.currency = currency;
		this.description = description;
	}

	@Override
	public boolean equals(Object obj) {
		if (((Transaction) obj).getAmount()==(this.getAmount())
				&& ((Transaction) obj).getCurrency().equals(this.getCurrency())
				&& ((Transaction) obj).getSender().equals(this.getSender())
				&& ((Transaction) obj).getReceiver().equals(this.getReceiver())
				&& ((Transaction) obj).getDescription().equals(this.getDescription())
				&& ((Transaction) obj).getId().equals(this.getId())

				)
			return true;
		return false;
	}
	public Transaction() {
		this.id = UUID.randomUUID().toString();

	}
//id,sender, receiver, amount,currency, description

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		if(amount<0)throw new NegativeValueException();
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
