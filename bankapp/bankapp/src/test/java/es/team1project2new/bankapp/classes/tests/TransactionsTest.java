package es.team1project2new.bankapp.classes.tests;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import es.team1project2new.bankapp.exceptions.NegativeValueException;
import es.team1project2new.bankapp.models.BankAccount;
import es.team1project2new.bankapp.models.Transaction;

@SpringBootTest
public class TransactionsTest {

	@Test
	void createBankAccountWithParameters() {
	
		
		Transaction transaction = new Transaction("Sender","Receiver","USD",20.5,"Description");
		Assert.assertEquals(transaction.getSender(), "Sender");
		Assert.assertEquals(transaction.getReceiver(), "Receiver");
		Assert.assertEquals(transaction.getCurrency(), "USD");
		Assert.assertEquals(transaction.getAmount(), 20.5,0.01);
		Assert.assertEquals(transaction.getDescription(),"Description");
	}
	@Test
	void createBankAccountWithNegativeAmount_Throws_NegativeValueException() {
	
		
Exception exception= assertThrows(NegativeValueException.class, ()->{
	Transaction transaction = new Transaction("Sender","Receiver","USD",-20.5,"Description");

});	
	}
}
