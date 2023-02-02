package com.gft.helpdesk.dtos.setor;

import com.gft.helpdesk.entities.Setor;

public class SetorMapper {

	public static Setor fromDTO(RegistroSetorDTO dto) {
		return new Setor(dto.getNome());
	}

	public static ConsultaSetorDTO fromEntity(Setor setor) {
		return new ConsultaSetorDTO(setor.getId(), setor.getNome());
	}

}
