package com.springlessons.clinicadmin.repository;

import com.springlessons.clinicadmin.entity.Patient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PatientRepository  extends PagingAndSortingRepository<Patient,Integer> {


    @Query("select p from Patient p")
    List<Patient> findAll();

}