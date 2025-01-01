package com.zulu_bd.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.zulu_bd.model.Ventas;

@Repository
public interface VentasRepository extends MongoRepository<Ventas, Integer> {






}




