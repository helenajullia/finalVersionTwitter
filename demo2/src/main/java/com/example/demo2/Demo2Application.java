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

		UserRepository userService = context.getBean(UserRepository.class); // Instantiate userService



	}



}
