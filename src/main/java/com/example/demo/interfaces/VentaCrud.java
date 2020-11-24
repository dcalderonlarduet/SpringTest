package com.example.demo.interfaces;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Venta;

public interface VentaCrud extends CrudRepository<Venta, Integer>{

}
