package com.zulu_bd.repository;

import com.zulu_bd.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository //Se importa desde JPA
public interface ClientesRepository extends JpaRepository<Clientes, Long> {


    //Se traducen las queries a funciones




    @Query("SElECT  c FROM Clientes c")
    List<Clientes> findAll();


    //Find by es un método JPA, el nombre del atributo ("nombre") es importante, debe ser el mismo que en el de el modelo
    Clientes findById(int id);






//    Default Methods from JpaRepository: By extending JpaRepository, you automatically inherit methods for basic CRUD operations:
//    findAll() – Retrieve all records.
//            findById(ProductoAlmacenId id) – Find a record by the composite key.
//    save(ProductoAlmacen entity) – Insert or update a record.
//            deleteById(ProductoAlmacenId id) – Delete a record by the composite key.
//    And many more.


}