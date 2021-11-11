package com.example.desafiospring3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.desafiospring3.entities.Cliente;
import com.example.desafiospring3.service.ClienteServiceI;

@Controller
public class AppController {
	@Autowired
	private ClienteServiceI clienteService;
	public static String APP_VIEW = "app";
	public static String LISTAR_VIEW = "listarClientes";
	public static String CREAR_VIEW = "crearClientes";
	public static String BUSCAR_POR_NOMBRE_VIEW = "clientePorNombreApellidos";

	@GetMapping("/app")
	public String principal() {
		return APP_VIEW;
	}

	@GetMapping("/listarClientes")
	public String listar(Model model) {
		model.addAttribute("listCliente", clienteService.listarTodosLosClientes());
		return LISTAR_VIEW;
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model) {
		clienteService.borrarClientePorId(id);
		model.addAttribute("listCliente", clienteService.listarTodosLosClientes());
		return LISTAR_VIEW;
	}

	@GetMapping("/crearClientes")
	public String mostrarCrearClientes(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("add", true);
		model.addAttribute("cliente", cliente);
		return CREAR_VIEW;

	}

	@PostMapping(value = "/clientes/crear")
	public String crearClientes(Model model, @ModelAttribute("cliente") Cliente cliente) {
		clienteService.añadirCliente(cliente);
		model.addAttribute("listCliente", clienteService.listarTodosLosClientes());
		return LISTAR_VIEW;

	}

	@GetMapping("/clientesPorNombre")
	public String mostrarBuscarPorNombre(Model model) {
		Cliente cliente = new Cliente();
		//model.addAttribute("add", true);
		model.addAttribute("cliente", cliente);
		
		
		return BUSCAR_POR_NOMBRE_VIEW;
	}
	
	@GetMapping("/clientes/clientesPorNombre/{nombre}/{apellidos}")
	public String buscarPorNombre(Model model, @ModelAttribute("cliente") Cliente cliente) {
		model.addAttribute("listCliente", clienteService.buscarClientePorNombreYApellidos(cliente.getNombre(), cliente.getApellidos()));
		return LISTAR_VIEW;
	}
}
