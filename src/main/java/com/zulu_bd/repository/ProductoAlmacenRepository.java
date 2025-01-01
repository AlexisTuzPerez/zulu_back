package com.zulu_bd.repository;


import com.zulu_bd.model.Clientes;
import com.zulu_bd.model.ProductoAlmacen;
import com.zulu_bd.model.ProductoAlmacenId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoAlmacenRepository extends JpaRepository<ProductoAlmacen, ProductoAlmacenId> { // instead of long u need to use the compund key




    @Query(value = """
        SELECT 
            pa.producto_id AS productoId, 
            pa.almacen_id AS almacenId,
            aa.nombre AS almacenNombre,  
            p.nombre AS productoNombre, 
            pa.cantidad AS cantidad
        FROM producto_almacen pa
        JOIN productos p ON pa.producto_id = p.producto_id
        JOIN almacen aa ON pa.almacen_id = aa.almacen_id
        """, nativeQuery = true)
    List<Object[]> findAllDetailed();




    @Query(value = "SELECT * FROM validacion_producto(:cantidad, :clienteId, :productoId)", nativeQuery = true)
    String callValidacionProducto(@Param("cantidad") int cantidad,
                                  @Param("clienteId") int clienteId,
                                  @Param("productoId") int productoId);

//
//    @Query("SELECT c FROM ProductoAlmacen c")
//    List<ProductoAlmacen> findAll();
//
//    ProductoAlmacen findById(ProductoAlmacenId id);
//





}
