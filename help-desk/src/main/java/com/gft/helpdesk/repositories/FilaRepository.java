package com.gft.helpdesk.repositories;

import com.gft.helpdesk.entities.Fila;
import com.gft.helpdesk.entities.Setor;
import com.gft.helpdesk.enums.NivelEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilaRepository extends JpaRepository<Fila, Long> {

    Fila findBySetorAndNivel(Setor setor, NivelEnum nivelEnum);


}
