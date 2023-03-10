package com.baan.ompaloompa.enviodeemailms.repositories;

import com.baan.ompaloompa.enviodeemailms.entities.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<EmailModel, Long> {
}
