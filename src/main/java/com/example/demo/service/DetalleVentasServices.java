package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaces.DetalleVentaCrud;
import com.example.demo.model.DetalleVenta;

@Service
public class DetalleVentasServices {
	@Autowired
	DetalleVentaCrud detalleVentaCrud;
	
	 public List<DetalleVenta> findAll() {
	        return (List<DetalleVenta>) detalleVentaCrud.findAll();
	    }

	    public Optional<DetalleVenta> findById(int id) {
	        return detalleVentaCrud.findById(id);
	    }
	    
	    public DetalleVenta save(DetalleVenta dventa) {
	        return detalleVentaCrud.save(dventa);
	    }

	    public void deleteById(int id) {
	    	detalleVentaCrud.deleteById(id);
	    }
}
