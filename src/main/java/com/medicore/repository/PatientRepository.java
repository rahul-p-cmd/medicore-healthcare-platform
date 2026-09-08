package com.medicore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicore.entity.Patient;
@Repository
public interface PatientRepository extends JpaRepository<Patient,Long>
{

}