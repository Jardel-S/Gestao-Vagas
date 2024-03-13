package com.study.gestao_vagas.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.gestao_vagas.exceptions.CompanyNotFoundException;
import com.study.gestao_vagas.modules.company.entities.JobEntity;
import com.study.gestao_vagas.modules.company.repository.CompanyRepository;
import com.study.gestao_vagas.modules.company.repository.JobRepository;

@Service
public class CreateJobUseCase {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public JobEntity execute(JobEntity jobEntity){
        companyRepository.findById(jobEntity.getCompanyId()).orElseThrow(() -> {
            throw new CompanyNotFoundException();
        });
       return this.jobRepository.save(jobEntity);
    }
    
}