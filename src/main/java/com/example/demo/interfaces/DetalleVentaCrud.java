package com.example.demo.interfaces;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.DetalleVenta;

public interface DetalleVentaCrud extends CrudRepository<DetalleVenta, Integer> {

}
