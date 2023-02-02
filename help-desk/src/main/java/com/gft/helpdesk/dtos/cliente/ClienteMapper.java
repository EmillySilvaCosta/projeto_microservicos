package com.gft.helpdesk.dtos.cliente;

import com.gft.helpdesk.entities.Cliente;

public class ClienteMapper {

	public static Cliente fromDTO(ClienteRegistroDTO dto) {
		return new Cliente(null, dto.getNome(), dto.getEmail());
	}

	public static Cliente fromDTO(ClienteConsultaDTO dto) {
		return new Cliente(dto.getId(), dto.getNome(), dto.getEmail());
	}

	public static ClienteConsultaDTO fromEntity(Cliente cliente) {
		return new ClienteConsultaDTO(cliente.getId(), cliente.getNome(), cliente.getEmail());
	}
}
