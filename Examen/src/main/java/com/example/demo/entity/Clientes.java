package com.example.demo.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;





@Entity
@Table(name="tbl_clientes")

public class Clientes {
	
	

	public Long getId_Cliente() {
		return Id_Cliente;
	}

	public void setId_Cliente(Long id_Cliente) {
		Id_Cliente = id_Cliente;
	}

	public String getNombre_Cliente() {
		return Nombre_Cliente;
	}

	public void setNombre_Cliente(String nombre_Cliente) {
		Nombre_Cliente = nombre_Cliente;
	}

	public String getPais() {
		return Pais;
	}

	public void setPais(String pais) {
		Pais = pais;
	}

	public String getNumero_Tarjeta() {
		return Numero_Tarjeta;
	}

	public void setNumero_Tarjeta(String numero_Tarjeta) {
		Numero_Tarjeta = numero_Tarjeta;
	}

	public Long getId_Plan() {
		return Id_Plan;
	}

	public void setId_Plan(Long id_Plan) {
		Id_Plan = id_Plan;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id_Cliente;
	
	private String Nombre_Cliente;
	
	private String Pais;
	
	private String Numero_Tarjeta;
	
	private Long Id_Plan;
	
	
	
}