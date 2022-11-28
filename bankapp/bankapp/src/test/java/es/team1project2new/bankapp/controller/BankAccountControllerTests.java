package es.team1project2new.bankapp.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import es.team1project2new.bankapp.models.BankAccount;
import es.team1project2new.bankapp.models.UserAccount;
import es.team1project2new.bankapp.services.BankAccountsService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BankAccountControllerTests {

	@Autowired
	private TestRestTemplate template;

	@LocalServerPort
	private int port;
	private String basePort = "http://localhost:" + port + "/bankAccounts";

	private ArrayList<UserAccount> mockdata;

	


	@BeforeEach
	void restart() {
		 mockdata = new ArrayList<>(Arrays.asList(
				new UserAccount("1", "FirstName", "LastName", "email@gmail.com", "password", "0748364392"),
				new UserAccount("2", "FirstName2", "LastName2", "email2@gmail.com", "password2", "0748364392"),
				new UserAccount("4", "FirstName4", "LastName4", "email4@gmail.com", "password4", "0748364392")));
		for (int i = 0; i < 3; i++) {
			mockdata.get(i).addAccount(new BankAccount());
		}
	}

	@Test
	public void getBankAccounts(String accountId) {
		BankAccount[] bankAccounts = template.getForObject(basePort, BankAccount[].class);
assertThat(Arrays.asList(bankAccounts).contains(mockdata.get(0).getBankAccounts().get(0))).isTrue();
	}

}
