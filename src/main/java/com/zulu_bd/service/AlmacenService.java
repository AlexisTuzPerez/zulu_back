package com.zulu_bd.service;


import com.zulu_bd.model.Almacen;
import com.zulu_bd.repository.AlmacenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlmacenService {


    @Autowired
    private AlmacenRepository almacenRepository;


    public List<Almacen> findAll(){
        return almacenRepository.findAll();
    }


    public Almacen findById(int id){
        return almacenRepository.findById(id);
    }

    public Almacen addAlmacen(Almacen almacen){

        almacen.setId(0);
        return  almacenRepository.save(almacen);
    }

    public Almacen updateAlmacen(int id, Almacen almacen){
        Almacen almacenExistente = almacenRepository.findById(id);

        if(almacenExistente == null){

            throw new RuntimeException("Almacen con ID " + id + " no encontrado.");

        }
        almacenExistente.setNombre(almacen.getNombre());
        return almacenRepository.save(almacenExistente);
    }

    public void deleteAlmacen(int id){
        Almacen almacenExistente = almacenRepository.findById(id);
        if(almacenExistente == null){
            throw new RuntimeException("Almacen con ID " + id + " no encontrado.");
        }

        almacenRepository.delete(almacenExistente);
    }






}
