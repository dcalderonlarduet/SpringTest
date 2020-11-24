package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Producto;
import com.example.demo.service.ProductosServices;

@RestController
@RequestMapping("/api/product")
public class CrudControllerProduct {

	@Autowired
	ProductosServices productosServices;
	  
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")		
	public String test() {	
		return "Test product";	
		}
	 
	//----------------Product---------------------//
	     @PutMapping(value="/createProduct", produces = "application/json")
	      public String createProduct(@RequestBody Producto product){
	    	 productosServices.save(product);
	        return "Success";
	    }

	
	  
	    
	    @RequestMapping(value="/listProduct",method = RequestMethod.GET, produces = "application/json")
	    public List<Producto> listProductfindAll(){
	       List<Producto> list = new ArrayList<Producto>();
	       productosServices.findAll().forEach(x -> list.add(x));
	         return list;
	    }

	    @GetMapping("/findProductById/{id}")
	    public Producto findProductById(@PathVariable("id") int id) {
	    	Producto product = productosServices.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
	        return product;
	    }
	    
	    @PutMapping("/updateProduct")  
	    public void updateProduct(@RequestBody Producto product) {
	    	productosServices.save(product); 
	    }
	    
	    
	    @DeleteMapping("/deleteVentas/{id}")
	    public void deleteVentas(@PathVariable int id) {
	    	productosServices.deleteById(id);
	    }
}
