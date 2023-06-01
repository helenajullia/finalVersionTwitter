package com.example.demo2;

import com.example.demo2.in_memory_repo.UserRepositoryInMemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo2.in_memory_repo.UserRepositoryInMemo;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Demo2Application {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(Demo2Application.class, args);

		UserRepositoryInMemo userRepositoryInMemo = context.getBean(UserRepositoryInMemo.class);



		UserRepositoryInMemo userService = context.getBean(UserRepositoryInMemo.class); // Instantiate userService


	}



}
