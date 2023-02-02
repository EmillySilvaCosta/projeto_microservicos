package com.gft.helpdesk.controllers;

import com.gft.helpdesk.dtos.chamado.ChamadoMapper;
import com.gft.helpdesk.dtos.chamado.ConsultaChamadoDTO;
import com.gft.helpdesk.dtos.chamado.RegistroChamadoDTO;
import com.gft.helpdesk.entities.Chamado;
import com.gft.helpdesk.services.ChamadoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/chamados")
public class ChamadoController {

	private final ChamadoService chamadoService;

	public ChamadoController(ChamadoService chamadoService) {
		this.chamadoService = chamadoService;
	}


	@PostMapping
	public ResponseEntity<String> abrirChamado(@RequestBody RegistroChamadoDTO dto){
		Chamado chamado = chamadoService.abrirChamado(ChamadoMapper.fromDTO(dto));
		String resposta = chamadoService.verificarEstadoDoChamado(chamado);

		return ResponseEntity.ok(resposta);
	}

	@GetMapping("{id}")
	public ResponseEntity<ConsultaChamadoDTO> buscarChamado(@PathVariable Long id){
		Chamado chamado = chamadoService.buscarChamado(id);
		return ResponseEntity.ok(ChamadoMapper.fromEntity(chamado));
	}

	@GetMapping
	public ResponseEntity<Page<ConsultaChamadoDTO>> buscarChamado(@PageableDefault Pageable pageable){
		Page<Chamado> chamados = chamadoService.listarChamados(pageable);
		return ResponseEntity.ok(chamados.map(ChamadoMapper::fromEntity));
	}

	@PatchMapping("/escalar/{idChamado}/nivel/{nivel}")
	public ResponseEntity<ConsultaChamadoDTO> escalarChamado(@PathVariable Long idChamado, @PathVariable int nivel){
		Chamado chamado = chamadoService.escalarChamado(idChamado, nivel);
		return ResponseEntity.ok(ChamadoMapper.fromEntity(chamado));
	}

	@PatchMapping("/transferir/{idChamado}/setor/{idSetor}")
	public ResponseEntity<ConsultaChamadoDTO> transferirChamado(@PathVariable Long idChamado, @PathVariable Long idSetor){
		Chamado chamado = chamadoService.transferirChamado(idChamado, idSetor);
		return ResponseEntity.ok(ChamadoMapper.fromEntity(chamado));
	}

	@PatchMapping("/finalizar/{id}")
	public ResponseEntity<ConsultaChamadoDTO> finalizarChamado(@PathVariable Long id){
		Chamado chamado = chamadoService.finalizarChamado(id);
		return ResponseEntity.ok(ChamadoMapper.fromEntity(chamado));
	}

}
