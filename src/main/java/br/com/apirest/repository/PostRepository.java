package br.com.apirest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.apirest.entities.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
