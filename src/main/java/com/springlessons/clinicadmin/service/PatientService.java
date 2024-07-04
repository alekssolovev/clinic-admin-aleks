package com.springlessons.clinicadmin.service;

import com.springlessons.clinicadmin.entity.Patient;
import com.springlessons.clinicadmin.repository.PatientRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.stream.Collectors;

public class PatientService {
    private PatientRepository patientRepository;


    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Bean("patient-executor")
    public Executor patientExecutor() {
        ThreadPoolTaskExecutor executor =
                new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(1);
        executor.setMaxPoolSize(5);
        executor.setQueueCapacity(20);
        executor.setKeepAliveSeconds(60);
        executor.setThreadNamePrefix("patient-executor-");
        executor.initialize();
        return executor;
    }

    public List<String> findAllEmail() {
        Pageable firstPageWithTenElements = PageRequest.of(0, 10);
        List<Patient> patientList;
        Page<Patient> patientPage = patientRepository.findAll(firstPageWithTenElements);
        patientList = patientPage.getContent();
        List<String> patientEmail ;
         patientEmail = patientList.stream().
                map(patient -> patient.getEmail()).
                        collect(Collectors.toList());
        return patientEmail;
    }

}