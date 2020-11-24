package com.example.demo.interfaces;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Producto;

public interface ProductoCrud extends CrudRepository<Producto, Integer>{

}
