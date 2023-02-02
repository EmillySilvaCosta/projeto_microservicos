package com.gft.helpdesk.dtos.chamado;

import com.gft.helpdesk.dtos.cliente.ClienteMapper;
import com.gft.helpdesk.dtos.operador.OperadorMapper;
import com.gft.helpdesk.dtos.setor.SetorMapper;
import com.gft.helpdesk.entities.Chamado;
import com.gft.helpdesk.entities.Cliente;
import com.gft.helpdesk.entities.Operador;
import com.gft.helpdesk.entities.Setor;
import com.gft.helpdesk.enums.NivelEnum;
import com.gft.helpdesk.enums.StatusEnum;

import java.time.LocalDateTime;

public class ChamadoMapper {

	public static Chamado fromDTO(RegistroChamadoDTO dto) {
		return new Chamado(new Cliente(dto.getNomeCliente(), dto.getEmailCliente()), dto.getAssunto(),
				dto.getTexto(), LocalDateTime.now(), new Setor(dto.getIdSetor()), NivelEnum.NIVEL_1,
				StatusEnum.EM_ESPERA);
	}

	public static ConsultaChamadoDTO fromEntity(Chamado chamado) {
		Operador operador = chamado.getOperador();
		if(operador!=null){
			return new ConsultaChamadoDTO(chamado.getId(), ClienteMapper.fromEntity(chamado.getCliente()),
					OperadorMapper.fromEntity(chamado.getOperador()), chamado.getAssunto(), chamado.getTexto(),
					chamado.getDataAbertura(), SetorMapper.fromEntity(chamado.getSetor()), chamado.getNivel(),
					chamado.getStatus(), chamado.getTempoResposta());
		} else {
			return new ConsultaChamadoDTO(chamado.getId(), ClienteMapper.fromEntity(chamado.getCliente()),
					null, chamado.getAssunto(), chamado.getTexto(),
					chamado.getDataAbertura(), SetorMapper.fromEntity(chamado.getSetor()), chamado.getNivel(),
					chamado.getStatus(), chamado.getTempoResposta());
		}
	}

}
