package es.team1project2new.bankapp.classes.tests;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import es.team1project2new.bankapp.exceptions.InvalidDetailsException;
import es.team1project2new.bankapp.exceptions.NegativeValueException;
import es.team1project2new.bankapp.models.BankAccount;
import es.team1project2new.bankapp.models.Transaction;

@SpringBootTest
public class BankAccountsTests {

	@Test
	void createBankAccountWithParameters() {
		List<Transaction> transactions = new ArrayList<>();
		transactions.add(new Transaction());
		BankAccount bankAccount = new BankAccount("Holder name", "USD", 20.5434, transactions);
		Assert.assertEquals(bankAccount.getHolderName(), "Holder name");
		Assert.assertEquals(bankAccount.getCurrency(), "USD");
		Assert.assertEquals(bankAccount.getBalance(), 20.5434, 0.01);
		Assert.assertEquals(transactions, bankAccount.getTransactions());
	}

	@Test
	void createBankAccountWithInvalidParameters_Throws_NegativeValueException() {
		List<Transaction> transactions = new ArrayList<>();
		transactions.add(new Transaction());
		Exception exception= assertThrows(NegativeValueException.class, ()->{
			BankAccount bankAccount = new BankAccount("Holder name", "USD", -20.5434, transactions);

		});
	}
	

}
