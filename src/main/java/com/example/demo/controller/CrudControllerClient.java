package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.CartShoppingTest1Application;
import com.example.demo.model.Client;
import com.example.demo.service.ClientServices;

@RestController
@RequestMapping("/api/client")
public class CrudControllerClient {
	 
	@Autowired
	ClientServices  clientService;
	
	private static final Logger LOGGER = LogManager.getLogger(CartShoppingTest1Application.class.getName());
	  
	
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")		
	public String test() {	
		return "Test done";	
		}
	 
	//----------------Client---------------------//
	     @PutMapping(value="/createClient", produces = "application/json")
	      public String createClient(@RequestBody Client client) throws Exception{
	    	clientService.insertClient(client);
	        return "Success";
	    }


	    @RequestMapping(value="/listClient",method = RequestMethod.GET, produces = "application/json")
	    public List<Client> listClientfindAll() throws Exception{
	       List<Client> list = new ArrayList<Client>();
	       clientService.findAll().forEach(x -> list.add(x));
	         return list;
	    }

	    @GetMapping("/findCientById/{id}")
	    public Client findCientById(@PathVariable("id") int id) throws Exception {
	        Client client = clientService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	        return client;
	    }
	    
	    @PutMapping("/updateClient")  
	    public void UpdateClient(@RequestBody Client client, int id) throws  Exception{
	    	clientService.updateClient(client, id);
	    }
	    
	    
	    @DeleteMapping("/deleteClient/{id}")
	    public void deleteClient(@PathVariable int id)throws Exception {
	    	clientService.deleteById(id);
	    }
	
	 
}
