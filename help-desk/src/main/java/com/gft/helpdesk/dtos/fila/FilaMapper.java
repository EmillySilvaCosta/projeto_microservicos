package com.gft.helpdesk.dtos.fila;

import com.gft.helpdesk.dtos.chamado.ChamadoMapper;
import com.gft.helpdesk.dtos.operador.OperadorMapper;
import com.gft.helpdesk.dtos.setor.SetorMapper;
import com.gft.helpdesk.entities.Fila;

public class FilaMapper {

	public static FilaDTO fromEntity(Fila fila) {
		return new FilaDTO(fila.getId(), SetorMapper.fromEntity(fila.getSetor()),
				fila.getNivel(), fila.getOperadores().stream().map(OperadorMapper::fromEntity).toList(),
				fila.getChamados().stream().map(ChamadoMapper::fromEntity).toList());
	}

}
