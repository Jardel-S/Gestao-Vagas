package com.study.gestao_vagas.modules.candidate.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.gestao_vagas.exceptions.JobNotFoundException;
import com.study.gestao_vagas.exceptions.UserNotFoundException;
import com.study.gestao_vagas.modules.candidate.CandidateRepository;
import com.study.gestao_vagas.modules.candidate.entity.ApplyJobEntity;
import com.study.gestao_vagas.modules.candidate.repository.ApplyJobRepository;
import com.study.gestao_vagas.modules.company.repository.JobRepository;

@Service
public class ApplyJobCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private ApplyJobRepository applyJobRepository;

    @Autowired
    private JobRepository jobRepository;

    //Necessito id do candidato e do job
    public ApplyJobEntity execute(UUID idCandidate, UUID idJob) {
        //Validar existencia de candidato
        this.candidateRepository.findById(idCandidate)
                .orElseThrow(() -> {
                    throw new UserNotFoundException();
                });

        //Validar existencia do job
        this.jobRepository.findById(idJob)
                .orElseThrow(() -> {
                    throw new JobNotFoundException();
                });

        //Inscrever o candidato na vaga
        var applyJob = ApplyJobEntity.builder()
        .candidateId(idCandidate)
        .jobId(idJob).build();
        
        applyJob =  applyJobRepository.save(applyJob);
        return applyJob;
    }

}
