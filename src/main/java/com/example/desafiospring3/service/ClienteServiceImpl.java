package com.example.desafiospring3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafiospring3.entities.Cliente;
import com.example.desafiospring3.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteServiceI{
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public void añadirCliente(Cliente cliente) {
		clienteRepository.save(cliente);
	}

	@Override
	public List<Cliente> listarTodosLosClientes() {
		return clienteRepository.findAll();
	}

	@Override
	public void borrarCliente(Cliente cliente) {
		clienteRepository.delete(cliente);
	}

	@Override
	public List<Cliente> buscarClientePorNombreYApellidos(String nombre, String apellidos) {
		return clienteRepository.findByNombreAndApellidos(nombre, apellidos);
	}

	@Override
	public Cliente buscarClientePorId(Long idCliente) {
		return clienteRepository.findById(idCliente).get();
	}

	@Override
	public void modificarCliente(Cliente cliente) {
		clienteRepository.save(cliente);
		
	}

	@Override
	public void borrarClientePorId(Long id) {
		clienteRepository.deleteById(id);
	}

}
