package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_compras")

public class Compras {



	public Long getId_Compra() {
		return Id_Compra;
	}

	public void setId_Compra(Long id_Compra) {
		Id_Compra = id_Compra;
	}

	public Long getId_Plan() {
		return Id_Plan;
	}

	public void setId_Plan(Long id_Plan) {
		Id_Plan = id_Plan;
	}

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

	public Float getTotal_Compra() {
		return Total_Compra;
	}

	public void setTotal_Compra(Float total_Compra) {
		Total_Compra = total_Compra;
	}

	public String getFecha_Compra() {
		return Fecha_Compra;
	}

	public void setFecha_Compra(String fecha_Compra) {
		Fecha_Compra = fecha_Compra;
	}

	public Long getAcumulado() {
		return Acumulado;
	}

	public void setAcumulado(Long acumulado) {
		Acumulado = acumulado;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id_Compra;

	private Long Id_Plan;

	private Long Id_Cliente;
	
	private String Nombre_Cliente;
	
	private Float Total_Compra;

	private String Fecha_Compra;

	private Long Acumulado;


	
}
