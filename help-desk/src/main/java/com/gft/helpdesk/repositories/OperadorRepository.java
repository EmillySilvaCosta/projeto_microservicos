package com.gft.helpdesk.repositories;

import com.gft.helpdesk.entities.Operador;
import com.gft.helpdesk.entities.Setor;
import com.gft.helpdesk.enums.NivelEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OperadorRepository extends JpaRepository<Operador, Long> {
	Page<Operador> findAll(Pageable pageable);

	List<Operador> findBySetorAndNivel(Setor setor, NivelEnum nivel);

	List<Operador> findByDisponivelAndSetorAndNivel(boolean disponivel, Setor setor, NivelEnum nivel);



}
