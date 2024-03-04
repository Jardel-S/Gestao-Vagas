package com.study.gestao_vagas.modules.company.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.gestao_vagas.modules.company.entities.JobEntity;;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {
    
    List<JobEntity> findByDescriptionContainingIgnoreCase(String description);

}
