package com.example.demo.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="venta")
public class Venta {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	public int idVenta;
	public Timestamp date;

	@ManyToOne
	@JoinColumn(name ="idCliente", nullable = false) 
	private Client client;
	
	 @OneToMany(mappedBy="venta" ) 
	  public List<DetalleVenta> detalleVentaList;

	public Venta(int idVenta, Timestamp date, Client client) {
		super();
	this.idVenta = idVenta;
	this.date = date; 
	this.client = client;
	detalleVentaList = new ArrayList<DetalleVenta>();
	}
	
	

	public Venta() {
		super();
	}



	public int getIdVenta() { 
		return idVenta; 
	}

	public void setIdVenta(int idVenta) { 
		this.idVenta = idVenta; 
		}

	public Client getClient(){
		return client;
		}

	public void setCliente(Client client) {
		this.client = client; 
		}

	public Timestamp getDate() {
		return date; 
		}

	public void setDate(Timestamp date) { 
		this.date = date; 
		}


}
