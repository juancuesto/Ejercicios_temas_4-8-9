package com.example.Ejercicio1_Sesion6.controller;

import com.example.Ejercicio1_Sesion6.entity.Laptop;
import com.example.Ejercicio1_Sesion6.repository.LaptopRepository;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    private final Logger log= LoggerFactory.getLogger(LaptopController.class);
    private LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository){
        this.laptopRepository=laptopRepository;
    }
    @GetMapping("/api/laptop")
    public List<Laptop> findAll(@RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        return laptopRepository.findAll();
    }

    @GetMapping("/api/laptop/{id}")
    public ResponseEntity<Laptop> findOneLaptopById(@PathVariable Long id){
        Optional<Laptop> result=laptopRepository.findById(id);

        if(result.isPresent()){

            return ResponseEntity.ok(result.get());

        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/api/laptop")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop,@RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));

        if(laptop.getId()!=null) {
            log.warn("Error al crear objeto el id debe ser nulo");
            System.out.println("Error al crear el Laptop datos introducidos incorrectamente");
            return ResponseEntity.badRequest().build();
        }else{
            Laptop result=laptopRepository.save(laptop);
            return  ResponseEntity.ok(result);
        }

    }

    @PutMapping("/api/laptop")
    public ResponseEntity<Laptop> updateLaptop(@RequestBody Laptop laptop){

        if(laptop.getId()==null){
            log.warn("Necesitamos saber el Id del objeto a actualizar");
            return  ResponseEntity.badRequest().build();
        }
        if(!laptopRepository.existsById(laptop.getId())){
            log.warn("El objeto introducido no existe en la base de datos");
            return ResponseEntity.notFound().build();
        }
        Laptop result=laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/api/laptop/{id}")
    public ResponseEntity<Laptop>  deleteById(@PathVariable Long id){

        if(!laptopRepository.existsById(id)){
            log.warn("El Laptop a eliminar no existe en la base de datos");
            return  ResponseEntity.notFound().build();
        }
        if(laptopRepository.findById(id).get().getId()==null){
            log.warn("No has introducido el id del elemento a eliminar");
            return  ResponseEntity.badRequest().build();
        }
        laptopRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/api/laptop")
    public ResponseEntity<Laptop> deleteAll(){
        log.info("Ejecutando borrar todos los elementos de la base de datos");
        laptopRepository.deleteAll();
        return  ResponseEntity.noContent().build();
    }

}
