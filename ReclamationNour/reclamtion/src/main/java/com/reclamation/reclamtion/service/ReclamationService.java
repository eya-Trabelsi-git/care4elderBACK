package com.reclamation.reclamtion.service;

import java.util.List;

import com.reclamation.reclamtion.model.Reclamation;


public interface  ReclamationService {

    List<Reclamation> getAllReclamations();

  
    Reclamation getReclamationById(Long id);


    Reclamation createReclamation(Reclamation reclamation);

 
    Reclamation updateReclamation(Long id, Reclamation updatedReclamation);


    void deleteReclamation(Long id);


    
}
