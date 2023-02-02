package com.gft.helpdesk.services;

import com.gft.helpdesk.entities.Cliente;
import com.gft.helpdesk.exceptions.EntityNotFoundException;
import com.gft.helpdesk.repositories.ClienteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

	private final ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public Cliente salvarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public Page<Cliente> buscarTodosClientes(Pageable pageable) {
		return clienteRepository.findAll(pageable);
	}

	public Cliente buscarCliente(Long id) {
		return clienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente não Encontrado"));
	}

	public Cliente atualizarCliente(Long id, Cliente cliente) {
		Cliente clienteEncontrado = buscarCliente(id);
		cliente.setId(clienteEncontrado.getId());

		return salvarCliente(cliente);
	}

	public void deletarCliente(Long id) {
		clienteRepository.delete(buscarCliente(id));
	}

    public Cliente buscarOuSalvarNovoCliente(Cliente cliente) {
		Optional<Cliente> clienteOptional = clienteRepository.findByNomeAndEmail(cliente.getNome(), cliente.getEmail());
		if(clienteOptional.isPresent()){
			return clienteOptional.get();
		}else {
			return salvarCliente(cliente);
		}

    }
}
