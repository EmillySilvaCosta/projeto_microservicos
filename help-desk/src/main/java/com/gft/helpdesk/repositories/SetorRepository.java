package com.gft.helpdesk.repositories;

import com.gft.helpdesk.entities.Setor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Long> {

	Page<Setor> findAll(Pageable pageable);

}
