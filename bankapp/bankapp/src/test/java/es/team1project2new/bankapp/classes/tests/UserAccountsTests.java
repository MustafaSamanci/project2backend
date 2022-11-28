package es.team1project2new.bankapp.classes.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import es.team1project2new.bankapp.exceptions.InvalidDetailsException;
import es.team1project2new.bankapp.models.BankAccount;
import es.team1project2new.bankapp.models.UserAccount;

@SpringBootTest
public class UserAccountsTests {

	@Test
	void addBankAccount_Returns_True() {
		UserAccount userAccount = new UserAccount();
		BankAccount bankAccount = new BankAccount();
		userAccount.addAccount(bankAccount);
		Assert.assertTrue(userAccount.getBankAccounts().contains(bankAccount));
	}

	@Test
	void createAccountWithParameters() {
		UserAccount account = new UserAccount("1","FirstName", "LastName", "email@gmail.com", "password", "0748364392");
		Assert.assertEquals(account.getFirstName(), "FirstName");
		Assert.assertEquals(account.getLastName(), "LastName");
		Assert.assertEquals(account.getEmail(), "email@gmail.com");
		Assert.assertEquals(account.getPassword(), "password");
		Assert.assertEquals(account.getPhoneNumber(), "0748364392");
	}

	@Test
	void createAccountWithInvalidEmail_ThrowsInvalidDetailsException() {

		Exception exception = assertThrows(InvalidDetailsException.class, () -> {
			UserAccount account = new UserAccount("1","FirstName", "LastName", "email@.com", "password", "0748364392");
		});
	}
	@Test
	void createAccountWithInvalidPhoneNumber_ThrowsInvalidDetailsException() {

		Exception exception = assertThrows(InvalidDetailsException.class, () -> {
			UserAccount account = new UserAccount("1","FirstName", "LastName", "email@gmail.com", "password", "07421a");
		});
	}
	@Test
	void createAccountWithInvalidPassword_ThrowsInvalidDetailsException() {

		Exception exception = assertThrows(InvalidDetailsException.class, () -> {
			UserAccount account = new UserAccount("1","FirstName", "LastName", "email@gmail.com", "pass", "07421a");
		});
	}

}
