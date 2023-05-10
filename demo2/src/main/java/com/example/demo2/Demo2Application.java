package com.example.demo2;

import com.example.demo2.model.Post;
import com.example.demo2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo2.repository.UserRepository;
import org.springframework.context.ApplicationContext;
import com.example.demo2.model.Reply;
import org.springframework.stereotype.Repository;

import java.util.List;

@SpringBootApplication
public class Demo2Application {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(Demo2Application.class, args);

		UserRepository userRepository = context.getBean(UserRepository.class);

		/*// Create users
		User user1 = new User("helena-jullia", "Helena", "Pastore", "helena.pastore@yahoo.com", "parola1");
		userRepository.createUser(user1);

		User user2 = new User("banda-daniela", "Daniela", "Banda", "daniela.banda@yahoo.com", "parola2");
		userRepository.createUser(user2);

		// Retrieve users
		User retrievedUser1 = userRepository.getUserByUsername("helena-jullia");
		System.out.println("User 1: " + retrievedUser1);

		User retrievedUser2 = userRepository.getUserByUsername("banda-daniela");
		System.out.println("User 2: " + retrievedUser2);*/


		UserRepository userService = context.getBean(UserRepository.class); // Instantiate userService

		//userService.followUser("helena-jullia", "banda-daniela");
		//userService.followUser("banda-daniela", "helena-jullia");


	}



}
