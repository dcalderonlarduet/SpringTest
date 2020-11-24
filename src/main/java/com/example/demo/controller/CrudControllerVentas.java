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

import com.example.demo.model.Venta;
import com.example.demo.service.VentaService;

@RestController
@RequestMapping("/api/ventas")
public class CrudControllerVentas {
	 
	@Autowired
	VentaService ventaService;
	  
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")		
	public String test() {	
		return "Test done";	
		}
	 
	//----------------Ventas---------------------//
	     @PutMapping(value="/createVenta", produces = "application/json")
	      public String createVentas(@RequestBody Venta venta){
	    	 ventaService.save(venta);
	        return "Success";
	    }

	
	  
	    
	    @RequestMapping(value="/listVenta",method = RequestMethod.GET, produces = "application/json")
	    public List<Venta> listVentafindAll(){
	       List<Venta> list = new ArrayList<Venta>();
	       ventaService.findAll().forEach(x -> list.add(x));
	         return list;
	    }

	    @GetMapping("/findVentasById/{id}")
	    public Venta findVentasById(@PathVariable("id") int id) {
	        Venta venta = ventaService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	        return venta;
	    }
	    
	    @PutMapping("/updateVenta")  
	    public void updateVenta(@RequestBody Venta venta) {
	    	ventaService.save(venta); 
	    }
	    
	    
	    @DeleteMapping("/deleteVentas/{id}")
	    public void deleteVentas(@PathVariable int id) {
	    	ventaService.deleteById(id);
	    }
	
}
