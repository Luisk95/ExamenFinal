package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Planes;
@Repository
public interface IPlanes extends JpaRepository<Planes, Long> {

}
