package com.gft.helpdesk.dtos.operador;

import com.gft.helpdesk.entities.Operador;
import com.gft.helpdesk.entities.Setor;

public class OperadorMapper {

	public static Operador fromDTO(RegistroOperadorDTO dto) {
		return new Operador(null, dto.getNome(), dto.getEmail(), new Setor(dto.getIdSetor()),
				dto.getNivel(), true);
	}

	public static ConsultaOperadorDTO fromEntity(Operador operador) {
		return new ConsultaOperadorDTO(operador.getId(), operador.getNome(), operador.getEmail(),
				operador.getSetor(), operador.getNivel(), operador.isDisponivel());
	}
}
