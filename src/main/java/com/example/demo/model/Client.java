package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
 	    public int idCliente;
	    public String nombre;
	    public String apellido; 
	    public int dni;
	    public int telefono; 
	    public String email;
	 
	
	  @OneToMany(mappedBy="client" ) 
	  public List<Venta> ventaList;
	 
		
		public Client(int idCliente, String nombre, String apellido, int dni, int telefono, String email) {
			super();
			this.idCliente = idCliente;
		    this.nombre = nombre;
		    this.apellido = apellido; 
		    this.dni = dni; 
		    this.telefono = telefono; 
		    this.email = email; 
		    ventaList = new ArrayList<Venta>(); 
		}
		

		public Client() {
			super();
		}

		public int getIdCliente() {
			return idCliente;
		}
		public void setIdCliente(int idCliente) {
			this.idCliente = idCliente;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApellido() {
			return apellido;
		}

		public void setApellido(String apellido) {
			this.apellido = apellido;
		}

		public int getDni() {
			return dni;
		}

		public void setDni(int dni) {
			this.dni = dni;
		}

		public int getTelefono() {
			return telefono;
		}

		public void setTelefono(int telefono) {
			this.telefono = telefono;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
	
		
	  

}
