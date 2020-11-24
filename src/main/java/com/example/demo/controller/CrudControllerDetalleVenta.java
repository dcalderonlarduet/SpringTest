package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.DetalleVenta;
import com.example.demo.service.DetalleVentasServices;

@RestController
@RequestMapping("/api/detalleVenta")
public class CrudControllerDetalleVenta {
	
	@Autowired
	DetalleVentasServices detalleVentasServices;
	  
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")		
	public String test() {	
		return "Test product";	
		}
	 
	//----------------DetalleVenta---------------------//
	     @PutMapping(value="/createDetalleVenta", produces = "application/json")
	      public String createDetalleVenta(@RequestBody DetalleVenta detalleVenta){
	    	 detalleVentasServices.save(detalleVenta);
	        return "Success";
	    }

	
	  
	    
	    @RequestMapping(value="/listDetalleVenta",method = RequestMethod.GET, produces = "application/json")
	    public List<DetalleVenta> listDetalleVentafindAll(){
	       List<DetalleVenta> list = new ArrayList<DetalleVenta>();
	       detalleVentasServices.findAll().forEach(x -> list.add(x));
	         return list;
	    }

	    @GetMapping("/findProductById/{id}")
	    public DetalleVenta findProductById(@PathVariable("id") int id) {
	    	DetalleVenta detalleVenta = detalleVentasServices.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid DetalleVenta Id:" + id));
	        return detalleVenta;
	    }
	    
	    @PutMapping("/updateProduct")  
	    public void updateProduct(@RequestBody DetalleVenta detalleVenta) {
	    	detalleVentasServices.save(detalleVenta); 
	    }
	    
	    
	    @DeleteMapping("/deleteVentas/{id}")
	    public void deleteVentas(@PathVariable int id) {
	    	detalleVentasServices.deleteById(id);
	    }
}