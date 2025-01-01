package com.zulu_bd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Main {

    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);

    }







//
//
//    @GetMapping("/") //Return the Greet Response
//    public GreetResponse greet(){
//
//
//        return new GreetResponse("Hello World!");
//    }
//
//
//    public record GreetResponse(String greet){}
//






    /*






    Pasos para crear la app bien:


    1.Conectar a la base de datos

    spring:
      main:
        web-application-type: servlet
      datasource:
        url: jdbc:postgresql://localhost:5432/zulu_db
        username: postgres
        password: 12345
      jpa:
        hibernate:
          ddl-auto: update
        properties:
          hibernate.dialect: org.hibernate.dialect.PostgreSQLDialect



      2. Crear el modelo:


        @Entity //Clase de JPA
        @Table(name = "clientes") //Mapeo a la tabla
        public class Clientes {

            //Hay que mapear cada columna, las restrincciones no son necesarias del todo

            @Id //the primary key
            @GeneratedValue(strategy = GenerationType.IDENTITY) // incremente automaticamente el id
            @Column(name = "cliente_id") // Mapeo, el nombre debe ser el mismo que la tabla
            private int id; //el nombre puede variar,pero es importante

            @Column(name="nombre_cliente")//Mapeo
            private String nombre;











      3. Crear el repositorio

      4. Crear la capa de servicio

      5. Crear el controlador






     */


}

