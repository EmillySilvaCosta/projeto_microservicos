package com.gft.helpdesk.controllers;

import com.gft.helpdesk.dtos.cliente.ClienteConsultaDTO;
import com.gft.helpdesk.dtos.cliente.ClienteMapper;
import com.gft.helpdesk.dtos.cliente.ClienteRegistroDTO;
import com.gft.helpdesk.entities.Cliente;
import com.gft.helpdesk.services.ClienteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/clientes")
public class ClienteController {
	private final ClienteService clienteService;

	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@PostMapping
	public ResponseEntity<ClienteConsultaDTO> salvarCliente(@RequestBody ClienteRegistroDTO clienteDTO) {
		Cliente cliente = clienteService.salvarCliente(ClienteMapper.fromDTO(clienteDTO));
		return ResponseEntity.ok(ClienteMapper.fromEntity(cliente));
	}

	@GetMapping
	public ResponseEntity<Page<ClienteConsultaDTO>> buscarTodosCliente(@PageableDefault Pageable pageable) {
		Page<Cliente> clientes = clienteService.buscarTodosClientes(pageable);
		return ResponseEntity.ok(clientes.map(ClienteMapper::fromEntity));
	}

	@GetMapping("{id}")
	public ResponseEntity<ClienteConsultaDTO> buscarCliente(@PathVariable Long id) {
		Cliente cliente = clienteService.buscarCliente(id);
		return ResponseEntity.ok(ClienteMapper.fromEntity(cliente));
	}

	@PutMapping("{id}")
	public ResponseEntity<ClienteConsultaDTO> alterarCliente(@PathVariable Long id,
			@RequestBody ClienteRegistroDTO clienteDTO) {
		Cliente cliente = clienteService.atualizarCliente(id, ClienteMapper.fromDTO(clienteDTO));
		return ResponseEntity.ok(ClienteMapper.fromEntity(cliente));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<ClienteConsultaDTO> deletarCliente(@PathVariable Long id) {
		clienteService.deletarCliente(id);
		return ResponseEntity.ok().build();
	}

}
