package com.zulu_bd.repository;

import com.zulu_bd.model.Almacen;
import com.zulu_bd.model.Productos;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AlmacenRepository extends JpaRepository<Almacen, Long> {



    @Query("SELECT c FROM Almacen c")
    List<Almacen> findAll();


    Almacen findById(int id);



}
