package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.example.demo.model.User;
import com.example.demo.util.ReadFiles;

@SpringBootApplication
public class CartShoppingTest1Application extends SpringBootServletInitializer{
	
	private static final Logger LOGGER = LogManager.getLogger(CartShoppingTest1Application.class.getName());
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(CartShoppingTest1Application.class, args);

		     User user = new User("Damian", "8564");
		     try {
				User a = new ReadFiles().leerArchivoUser(user.user, user.password);
			System.out.print(a.user);
			System.out.print(a.password);
			 LOGGER.info("Info Message Logged !!! "+ a.user +"");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				 LOGGER.error("Error Message Logged, User  !!!", e.getMessage());
			}
		     
		     
		
		    LOGGER.debug("Debug Message Logged !!!");
	        LOGGER.info("Info Message Logged !!!");
	        LOGGER.error("Error Message Logged !!!", new NullPointerException("NullError"));
	}

}
