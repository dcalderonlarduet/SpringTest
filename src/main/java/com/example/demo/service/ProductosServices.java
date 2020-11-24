package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaces.ProductoCrud;
import com.example.demo.model.Producto;

@Service
public class ProductosServices {
	
	@Autowired
	ProductoCrud productoCrud;
	
	 public List<Producto> findAll() {
	        return (List<Producto>) productoCrud.findAll();
	    }

	    public Optional<Producto> findById(int id) {
	        return productoCrud.findById(id);
	    }

	    public Producto save(Producto producto) {
	        return productoCrud.save(producto);
	    }

	    public void deleteById(int id) {
	    	productoCrud.deleteById(id);
	    }
}
