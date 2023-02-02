package com.gft.helpdesk.controllers;

import com.gft.helpdesk.dtos.setor.ConsultaSetorDTO;
import com.gft.helpdesk.dtos.setor.RegistroSetorDTO;
import com.gft.helpdesk.dtos.setor.SetorMapper;
import com.gft.helpdesk.entities.Setor;
import com.gft.helpdesk.services.SetorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/setores")
public class SetorController {

	private final SetorService setorService;

	public SetorController(SetorService setorService) {
		this.setorService = setorService;
	}

	@GetMapping
	public ResponseEntity<Page<ConsultaSetorDTO>> buscarTodosOsSetors(@PageableDefault Pageable pageable) {

		return ResponseEntity.ok(setorService.listarSetores(pageable).map(SetorMapper::fromEntity));

	}

	@PostMapping
	public ResponseEntity<ConsultaSetorDTO> salvarSetor(@RequestBody RegistroSetorDTO dto) {

		Setor setor = setorService.salvarSetor(SetorMapper.fromDTO(dto));

		return ResponseEntity.ok(SetorMapper.fromEntity(setor));

	}

	@GetMapping("{id}")
	public ResponseEntity<ConsultaSetorDTO> buscarSetor(@PathVariable Long id) {

		Setor setor = setorService.buscarSetor(id);

		return ResponseEntity.ok(SetorMapper.fromEntity(setor));

	}

	@PutMapping("{id}")
	public ResponseEntity<ConsultaSetorDTO> alterarSetor(@RequestBody RegistroSetorDTO dto, @PathVariable Long id) {

		try {

			Setor setor = setorService.atualizarSetor(SetorMapper.fromDTO(dto), id);

			return ResponseEntity.ok(SetorMapper.fromEntity(setor));
		} catch (RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping("{id}")
	public ResponseEntity<ConsultaSetorDTO> excluirSetor(@PathVariable Long id) {

		try {
			setorService.excluirSetor(id);

			return ResponseEntity.ok().build();
		} catch (RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}

	}

}
