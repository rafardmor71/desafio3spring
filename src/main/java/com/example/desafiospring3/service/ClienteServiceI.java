package com.example.desafiospring3.service;

import java.util.List;

import com.example.desafiospring3.entities.Cliente;

public interface ClienteServiceI {
	
	void añadirCliente(Cliente cliente);
	void modificarCliente(Cliente cliente);
	List<Cliente> listarTodosLosClientes();
	void borrarCliente(Cliente cliente);
	void borrarClientePorId(Long id);
	List<Cliente> buscarClientePorNombreYApellidos(String nombre, String apellidos);
	Cliente buscarClientePorId(Long idCliente);
	
}
