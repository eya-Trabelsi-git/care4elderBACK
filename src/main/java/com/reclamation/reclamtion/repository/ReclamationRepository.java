package com.reclamation.reclamtion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reclamation.reclamtion.model.Reclamation;
@Repository
public interface  ReclamationRepository extends JpaRepository<Reclamation, Long>  {
    
}
