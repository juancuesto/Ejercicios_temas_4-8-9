package com.example.Ejercicio1_Sesion6;

import com.example.Ejercicio1_Sesion6.entity.Laptop;
import com.example.Ejercicio1_Sesion6.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Ejercicio1Sesion6Application {


	public static void main(String[] args) {

		ApplicationContext context=SpringApplication.run(Ejercicio1Sesion6Application.class, args);

		LaptopRepository repository=context.getBean(LaptopRepository.class);

		Laptop ord1=new Laptop(null,"HP","16GB","3.2GHz",399.0);
		Laptop ord2=new Laptop(null,
				"AMD","32GB","4.0GHz",789.99);

        System.out.println("el numero de libros en base de datos es: "+repository.count());

		repository.save(ord1);
		repository.save(ord2);

        System.out.println("el numero de libros en base de datos es: "+repository.findAll().size());
	}

}
