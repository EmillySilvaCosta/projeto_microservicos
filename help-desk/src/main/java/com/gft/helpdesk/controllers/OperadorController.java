package com.gft.helpdesk.controllers;

import com.gft.helpdesk.dtos.operador.ConsultaOperadorDTO;
import com.gft.helpdesk.dtos.operador.OperadorMapper;
import com.gft.helpdesk.dtos.operador.RegistroOperadorDTO;
import com.gft.helpdesk.entities.Operador;
import com.gft.helpdesk.services.OperadorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("v1/operadores")
public class OperadorController {
	private final OperadorService operadorService;

	public OperadorController(OperadorService operadorService) {
		this.operadorService = operadorService;
	}

	@GetMapping
	public ResponseEntity<Page<ConsultaOperadorDTO>> listarOperadores(@PageableDefault Pageable pageable) {

		return ResponseEntity.ok(operadorService.listarOperadores(pageable).map(OperadorMapper::fromEntity));

	}

	@PostMapping
	public ResponseEntity<ConsultaOperadorDTO> salvarOperador(@RequestBody @Valid RegistroOperadorDTO dto) {
		Operador operador = operadorService.salvarOperador(OperadorMapper.fromDTO(dto));

		return new ResponseEntity<>(OperadorMapper.fromEntity(operador), HttpStatus.CREATED);

	}

	@GetMapping("{id}")
	public ResponseEntity<ConsultaOperadorDTO> buscarOperador(@PathVariable Long id) {
		Operador operador = operadorService.buscarOperador(id);
		return ResponseEntity.ok(OperadorMapper.fromEntity(operador));
	}

	@PutMapping("{id}")
	public ResponseEntity<ConsultaOperadorDTO> alterarOperador(@RequestBody @Valid RegistroOperadorDTO dto,
			@PathVariable Long id) {

		Operador operador = operadorService.atualizarOperador(OperadorMapper.fromDTO(dto), id);
		return ResponseEntity.ok(OperadorMapper.fromEntity(operador));

	}

	@DeleteMapping("{id}")
	public ResponseEntity<Object> excluirOperador(@PathVariable Long id) {
		try {
			operadorService.excluirOperador(id);
			return ResponseEntity.status(HttpStatus.OK).body("Operador removido com sucesso.");

		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Operador não encontrado.");
		}

	}
}
