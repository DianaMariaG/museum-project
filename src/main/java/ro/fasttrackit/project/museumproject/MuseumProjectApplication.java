package ro.fasttrackit.project.museumproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.fasttrackit.project.museumproject.model.Museum;
import ro.fasttrackit.project.museumproject.repository.MuseumRepository;

import java.util.List;

@SpringBootApplication
public class MuseumProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MuseumProjectApplication.class, args);
	}

//	@Bean
//	CommandLineRunner atStartup(MuseumRepository repo) {
//		return args -> {
//			repo.saveAll(List.of(
//					new Museum("Egypt",100,"09:00","16:00")));
//		};
//	}
}
