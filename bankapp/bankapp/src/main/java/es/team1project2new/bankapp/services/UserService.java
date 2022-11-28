package es.team1project2new.bankapp.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import es.team1project2new.bankapp.models.UserAccount;

@Service
public class UserService {
	public List<UserAccount> mockdata = new ArrayList<>(
			Arrays.asList(new UserAccount("1", "FirstName", "LastName", "email@gmail.com", "password", "0748364392"),
					new UserAccount("2", "FirstName2", "LastName2", "email2@gmail.com", "password2", "0748364392"),
					new UserAccount("4", "FirstName4", "LastName4", "email4@gmail.com", "password4", "0748364392")));

	public List<UserAccount> findAll() {
		return mockdata;
	}

	public UserAccount getUser(String id) {
		return mockdata.stream().filter(e -> e.getId().equals(id)).findFirst().get();

	}

	public List<UserAccount> deleteUser(String id) {
		mockdata = mockdata.stream().filter(e -> (e.getId().equals(id))).collect(Collectors.toList());
		return mockdata;
	}

	public List<UserAccount> updateUser(String id, UserAccount account) {

		for (int i = 0; i < mockdata.size(); i++) {
			if (mockdata.get(i).getId().equals(id))
				
			mockdata.get(i).setId(id);

			mockdata.get(i).setEmail(account.getEmail());
			mockdata.get(i).setFirstName(account.getFirstName());
			mockdata.get(i).setLastName(account.getLastName());
			mockdata.get(i).setPassword(account.getPassword());
			mockdata.get(i).setPhoneNumber(account.getPhoneNumber());
		}

		return mockdata;

	}

	public void setMockdata(List<UserAccount> mockdata) {
		this.mockdata = mockdata;
	}

}
