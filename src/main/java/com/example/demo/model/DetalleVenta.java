package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalleVenta")
public class DetalleVenta {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY) 
	  public int  idDetalleVenta;
	  
	  @ManyToOne
		@JoinColumn(name ="idVenta", nullable = false) 
		private Venta venta;
	  
	  @ManyToOne	 
	  @JoinColumn(name ="idProducto", nullable = false) 
	  private Producto producto;

	  
	public DetalleVenta(int idDetalleVenta, Venta venta, Producto producto) {
		super();
		this.idDetalleVenta = idDetalleVenta;
		this.venta = venta;
		this.producto = producto;
	}

	public int getIdDetalleVenta() {
		return idDetalleVenta;
	}

	public void setIdDetalleVenta(int idDetalleVenta) {
		this.idDetalleVenta = idDetalleVenta;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	 

	
}
