package com.example.demo.entity;




public class Consulta {
	
	
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
	public Long getTotal_Compras() {
		return Total_Compras;
	}
	public void setTotal_Compras(Long total_Compras) {
		Total_Compras = total_Compras;
	}
	public String getNombre_Cliente() {
		return Nombre_Cliente;
	}
	public void setNombre_Cliente(String nombre_Cliente) {
		Nombre_Cliente = nombre_Cliente;
	}
	public Long getTotal_Acumulado() {
		return Total_Acumulado;
	}
	public void setTotal_Acumulado(Long total_Acumulado) {
		Total_Acumulado = total_Acumulado;
	}
	private Long Id_Plan;
    private Long Id_Cliente;
	private Long Total_Compras;
	private String Nombre_Cliente;
	private Long Total_Acumulado;
	
	
}
