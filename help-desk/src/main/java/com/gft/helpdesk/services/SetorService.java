package com.gft.helpdesk.services;

import com.gft.helpdesk.entities.Setor;
import com.gft.helpdesk.exceptions.EntityNotFoundException;
import com.gft.helpdesk.repositories.SetorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SetorService {

	private final SetorRepository setorRepository;
	private final FilaService filaService;

	public SetorService(SetorRepository setorRepository, FilaService filaService) {
		this.setorRepository = setorRepository;
		this.filaService = filaService;
	}

	public Setor salvarSetor(Setor setor) {
		setor = setorRepository.save(setor);
		filaService.criarFilasDoSetor(setor);
		return setor;

	}

	public Page<Setor> listarSetores(Pageable pageable) {

		return setorRepository.findAll(pageable);

	}

	public Setor buscarSetor(Long id) {
		Optional<Setor> optional = setorRepository.findById(id);

		return optional.orElseThrow(() -> new EntityNotFoundException("Setor não encontrado"));

	}

	public Setor atualizarSetor(Setor setor, Long id) {

		Setor setorOriginal = this.buscarSetor(id);

		setor.setId(setorOriginal.getId());

		return setorRepository.save(setor);

	}

	public void excluirSetor(Long id) {
		Setor setorOriginal = this.buscarSetor(id);

		setorRepository.delete(setorOriginal);

	}
}
