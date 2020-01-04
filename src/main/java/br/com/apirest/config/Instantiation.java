package br.com.apirest.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.apirest.dto.AuthorDTO;
import br.com.apirest.dto.CommentDTO;
import br.com.apirest.entities.Post;
import br.com.apirest.entities.User;
import br.com.apirest.repository.PostRepository;
import br.com.apirest.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		postRepository.deleteAll();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		Post post1 = new Post(null, LocalDate.parse("21/03/2018", formatter), "Partiu viagem","Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, LocalDate.parse("21/03/2018", formatter), "Bom dia", "Acordei feliz hoje!",new AuthorDTO(maria));

		CommentDTO c1 = new CommentDTO("Boa viagem mano!", LocalDate.parse("21/03/2018", formatter),new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Aproveite!", LocalDate.parse("22/03/2018", formatter), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", LocalDate.parse("23/03/2018", formatter),new AuthorDTO(alex));

		post1.insertComments(Arrays.asList(c1, c2));
		post2.insertComments(Arrays.asList(c3));

		postRepository.saveAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
	}

}
