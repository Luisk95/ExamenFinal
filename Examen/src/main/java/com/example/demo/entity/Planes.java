package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import org.hibernate.annotations.SQLInsert;

@Entity
@Table(name="tbl_planes")
public class Planes {

	
	public Long getId_Planes() {
		return Id_Planes;
	}

	public void setId_Planes(Long id_Planes) {
		Id_Planes = id_Planes;
	}

	public String getNombre_Plan() {
		return Nombre_Plan;
	}

	public void setNombre_Plan(String nombre_Plan) {
		Nombre_Plan = nombre_Plan;
	}

	public String getDescripcion_Plan() {
		return Descripcion_Plan;
	}

	public void setDescripcion_Plan(String descripcion_Plan) {
		Descripcion_Plan = descripcion_Plan;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id_Planes;
	
	private String Nombre_Plan;
	
	private String Descripcion_Plan;

}
