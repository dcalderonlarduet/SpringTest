package com.example.demo.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.example.demo.model.User;


public class ReadFiles {

	public User leerArchivoUser(String nameUser, String pass) throws Exception {
		Resource r = new ClassPathResource("static/user.ini");
		File file = null;
		
		String passw = null;
		String nameUs = null;
	    	if (r.exists()) {
			file = r.getFile();
			Scanner scanner;
				scanner = new Scanner(file);
				while (scanner.hasNextLine()) {
					String linea = scanner.nextLine();
					Scanner delimitar = new Scanner(linea);			
					delimitar.useDelimiter("\\s*,\\s*");
					nameUs = delimitar.next();
					passw = delimitar.next();								
					if (nameUser.equals(nameUs) && pass.equals(passw)) {
						User user = new User(nameUs,passw );
						scanner.close();
						return user;
					}					
				}
				scanner.close();
	    	}
		return null;
	}
	
	public static Map<String, String> leerArchivoConfig() {
		ResourceBundle bundle = ResourceBundle.getBundle("static/aplication.properties"); 
		Map<String, String> mapParam= new HashMap<String, String>();
		mapParam.put("JWT_SECRET", bundle.getString("JWT_SECRET"));
		return mapParam;
	}
}
