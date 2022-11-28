package es.team1project2new.bankapp.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Arrays;
import java.util.List;
import es.team1project2new.bankapp.models.UserAccount;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AccountsControllerTests {
	@LocalServerPort
	private int port;
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testGetAccounts() {
		final String baseUrl = "http://localhost:" + port + "/users";
		UserAccount[] forEntity = restTemplate.getForObject(baseUrl, UserAccount[].class);

		assertThat(forEntity.length).isEqualTo(4);
	}
	@Test
	public void testGetAccountById() {
		final String baseUrl = "http://localhost:" + port + "/users"+"/1";
		UserAccount userEntity = restTemplate.getForObject(baseUrl, UserAccount.class);
		UserAccount userAccount = new UserAccount("1", "FirstName", "LastName", "email@gmail.com", "password",
				"0748364392");
		assertThat(userAccount.equals(userAccount)).isTrue();

	}
	@Test
	public void testPostAccount() {
		final String baseUrl = "http://localhost:" + port + "/users";
		UserAccount userAccount = new UserAccount("5", "FirstName", "LastName", "email@gmail.com", "password",
				"0748364392");
		UserAccount[] newList = restTemplate.postForObject(baseUrl,userAccount,UserAccount[].class);
		assertThat(Arrays.stream(newList).filter(e->e.getId().equals("5")).findFirst().get()).isEqualTo(userAccount);
		

	}
	@Test
	public void testDeleteAccount() {
		final String baseUrl = "http://localhost:" + port + "/users/3";
		
		
		ResponseEntity<List<UserAccount>> accountsList=restTemplate.exchange(baseUrl,HttpMethod.DELETE,null,new ParameterizedTypeReference<List<UserAccount>>() {
		});		
	UserAccount account = accountsList.getBody().stream().filter(e->e.getId().equals("2")).findFirst().orElse(null);
assertThat(account).isNull();
	}
	@Test
	public void testPutAccount() {
		final String baseUrl = "http://localhost:" + port + "/users/4";
		UserAccount userAccount = new UserAccount("3", "FirstName3", "LastName3", "email@gmail.com", "password",
				"0748364392");
		HttpEntity<UserAccount> entity= new HttpEntity<>(userAccount);
		ResponseEntity<List<UserAccount>> accountsList = restTemplate.exchange(baseUrl,HttpMethod.PUT,entity,new ParameterizedTypeReference<List<UserAccount>>() {
		});
		
	}
	

}
