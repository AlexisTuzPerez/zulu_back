package com.zulu_bd.repository;


import com.zulu_bd.model.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Long> {



    @Query("SELECT c FROM Productos c")
    List<Productos> findAll();



    Productos findById(int id);




}
