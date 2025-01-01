package com.zulu_bd.service;


import com.zulu_bd.repository.ClientesRepository;
import com.zulu_bd.model.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import java.util.List;

@Service  //Servicio
public class ClientesService {

    @Autowired // usa el repositorio
    private ClientesRepository clientesRepository;

    public List<Clientes> findAll(){
        return clientesRepository.findAll();
    }

    public Clientes findById(int id){
        return clientesRepository.findById(id);
    }

    //Update
    //Se tiene un método que ingresa el id y la info del cliente
    public Clientes updateCliente(int id, Clientes cliente){


        Clientes clienteExistente = clientesRepository.findById(id);

        if (clienteExistente == null) {
            throw new RuntimeException("Cliente con ID " + id + " no encontrado.");
        }

        clienteExistente.setNombre_cliente(cliente.getNombre());
        clienteExistente.setApellido_cliente(cliente.getApellido());
        clienteExistente.setTelefono_cliente(cliente.getTelefono());
        clienteExistente.setCorreo_cliente(cliente.getCorreo());
        clienteExistente.setProductosComprados(cliente.getProductosComprados());
        return clientesRepository.save(clienteExistente);

    }

    public Clientes addClient(Clientes cliente) {
        cliente.setId(0);
        return clientesRepository.save(cliente);
    }

    public void deleteCliente(int id) {


        Clientes clienteExistente = clientesRepository.findById(id);

        if(clienteExistente == null){
            throw new RuntimeException("Cliente con ID " + id + " no encontrado.");
        }

        clientesRepository.delete(clienteExistente);
    }

}
