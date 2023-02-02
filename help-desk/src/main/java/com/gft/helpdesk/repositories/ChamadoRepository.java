package com.gft.helpdesk.repositories;

import com.gft.helpdesk.entities.Chamado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, Long> {

	public Page<Chamado> findAll(Pageable paginacao);

}
