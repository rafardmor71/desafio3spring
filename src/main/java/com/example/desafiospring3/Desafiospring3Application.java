package com.example.desafiospring3;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.desafiospring3.entities.Cliente;
import com.example.desafiospring3.service.ClienteServiceI;

@SpringBootApplication
public class Desafiospring3Application implements CommandLineRunner {

	@Autowired
	private ClienteServiceI clienteService;

	public static void main(String[] args) {
		SpringApplication.run(Desafiospring3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Fechas
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaNacimiento1= format.parse("1989-07-01");
		Date fechaNacimiento2 = format.parse("1998-01-08");
		
		// Creacion de Clientes
		Cliente cliente1 = new Cliente();
		cliente1.setApellidos("Perez Gutierrez");
		cliente1.setNombre("Pepito");
		cliente1.setDNI("12345678L");
		cliente1.setFechaNacimiento(fechaNacimiento1);
		
		Cliente cliente2 = new Cliente();
		cliente2.setApellidos("Torres Palomares");
		cliente2.setNombre("Rodolfo");
		cliente2.setDNI("19995678L");
		cliente2.setFechaNacimiento(fechaNacimiento2);

		// añadir cliente
		clienteService.añadirCliente(cliente1);
		clienteService.añadirCliente(cliente2);
		
		System.out.println("Cliente con DNI + " + cliente1.getDNI() + " creado correctamente");
		System.out.println("Cliente con DNI + " + cliente2.getDNI() + " creado correctamente");
		
		/*
		//Listar Clientes y recorrerla
		System.out.println("Listar todos los clientes");
		List<Cliente> listaClientes = clienteService.listarTodosLosClientes();
		for (int i = 0; i < listaClientes.size(); i++) {
			System.out.println(listaClientes.get(i).toString());
		}
		
		//Borrar Cliente
		clienteService.borrarCliente(cliente1);
		System.out.println("Cliente con DNI: " + cliente1.getDNI() + " borrado correctamente");
		
		//Modificar Cliente
		cliente1.setApellidos("Lopez Perez");
		clienteService.modificarCliente(cliente1);
		System.out.println("Cliente con DNI: " + cliente1.getDNI() + " modificado correctamente");
	
		//Listar Clientes Para ver Cambios 
		System.out.println("Listar Clientes para ver los cambios");
		List<Cliente> listaClienteConCambios = clienteService.listarTodosLosClientes();
		for (int i = 0; i < listaClienteConCambios.size(); i++) {
			System.out.println(listaClientes.get(i).toString());
		}
		//Buscar Por Nombre y apellidos
		//Listar Clientes de nuevo por Nombre Y Apellidos
		System.out.println("Listar Por Nombre y Apellido");
		List<Cliente> listaClientesPorNombreYApellidos = clienteService.buscarClientePorNombreYApellidos("Rodolfo","Torres Palomares");
		for (int i = 0; i < listaClientesPorNombreYApellidos.size(); i++) {
			System.out.println(listaClientesPorNombreYApellidos.get(i).toString());
		}
	
	*/
	}
}
