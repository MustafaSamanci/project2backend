package es.team1project2new.bankapp.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import es.team1project2new.bankapp.models.UserAccount;
import es.team1project2new.bankapp.services.UserService;

@RestController

public class AccountController {
@Autowired
private UserService service;
@PostMapping("/users")
public List<UserAccount> getAccount(@RequestBody UserAccount account ) {
	service.mockdata.add(account);
	
	return service.mockdata;
}
@GetMapping("/users")
public List<UserAccount> getAccounts(){
	return service.findAll();
}
@GetMapping("/users/{id}")
public UserAccount getUsers(@PathVariable String id) {
	return service.getUser(id);
}
@DeleteMapping("/users/{id}")
public List<UserAccount> deleteUsers(@PathVariable String id) {
	return service.deleteUser(id);
}

@PutMapping("/users/{id}")
public List<UserAccount> updateUser(@PathVariable String id,@RequestBody UserAccount account) {
	return service.updateUser(id,account);
}
}
