package com.gft.helpdesk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.helpdesk.entities.Fila;
import com.gft.helpdesk.services.FilaService;

@RestController
@RequestMapping("/v1/filas")
public class FilaController {

	@Autowired
	private FilaService filaService;

	@GetMapping("{id}")
	public ResponseEntity<Fila> buscarFila(@PathVariable Long id) {
		return ResponseEntity.ok(filaService.buscarFila(id));

	}

}
