package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaces.ClienteCrud;
import com.example.demo.model.Client;

@Service
public class ClientServices {
	
	@Autowired
	ClienteCrud clienteCrud;
	
	 public List<Client> findAll() {
	        return (List<Client>) clienteCrud.findAll();
	    }

	    public Optional<Client> findById(int id) {
	        return clienteCrud.findById(id);
	    }

	    public void updateClient(Client client, int id) {
	    	Optional<Client> clien = findById(id);
	    	if(client!=null) {
	    		clien.get().setNombre(client.nombre);
	    		clien.get().setApellido(client.apellido);
	     		clien.get().setDni(client.dni);
	     		clien.get().setEmail(client.email);
	     		clien.get().setTelefono(client.telefono);
	         clienteCrud.save(client);
	    	}
	    }
	    public void insertClient(Client client) {
	    	if(client!=null) {
	         clienteCrud.save(client);
	    	}
	    }

	    public void deleteById(int id) {
	    	clienteCrud.deleteById(id);
	    }
	}
