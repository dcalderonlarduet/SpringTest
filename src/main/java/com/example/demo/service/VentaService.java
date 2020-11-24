package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaces.VentaCrud;
import com.example.demo.model.Venta;

@Service
public class VentaService {
	
	@Autowired
	VentaCrud ventaCrud;
	
	 public List<Venta> findAll() {
	        return (List<Venta>) ventaCrud.findAll();
	    }

	    public Optional<Venta> findById(int id) {
	        return ventaCrud.findById(id);
	    }

	    public Venta save(Venta venta) {
	        return ventaCrud.save(venta);
	    }

	    public void deleteById(int id) {
	    	ventaCrud.deleteById(id);
	    }
}
