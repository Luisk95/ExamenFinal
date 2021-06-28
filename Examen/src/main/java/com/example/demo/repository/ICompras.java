package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Compras;
import com.example.demo.entity.Consulta;
@Repository
public interface ICompras extends JpaRepository<Compras,Long> {
	@Query("SELECT SUM(Acumulado) as Total_Acumulado  from Compras where Id_Cliente=:Id")
	Long Total(@Param("Id") Long Id);


	

}
