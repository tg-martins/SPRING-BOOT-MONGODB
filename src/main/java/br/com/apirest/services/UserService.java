package br.com.apirest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apirest.entities.User;
import br.com.apirest.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public Optional<User> findById(String id) {
		Optional<User> obj = repository.findById(id);
		
		return obj;
		
		 
	}

}
