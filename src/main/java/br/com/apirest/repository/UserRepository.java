package br.com.apirest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.apirest.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
