package com.reclamation.reclamtion.serviceimplementation;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.reclamation.reclamtion.model.Reclamation;
import com.reclamation.reclamtion.repository.ReclamationRepository;
import com.reclamation.reclamtion.service.ReclamationService;

@Service
public class ReclamationServiceImpl implements ReclamationService {

    @Autowired
    private ReclamationRepository reclamationRepository;

    @Override
    public List<Reclamation> getAllReclamations() {
        return reclamationRepository.findAll();
    }

    @Override
    public Reclamation getReclamationById(Long id) {
        Optional<Reclamation> optional = reclamationRepository.findById(id);
        return optional.orElse(null); 
    }

    @Override
    public Reclamation createReclamation(Reclamation reclamation) {
        return reclamationRepository.save(reclamation);
    }

    @Override
    public Reclamation updateReclamation(Long id, Reclamation updatedReclamation) {
        Reclamation existing = getReclamationById(id);
        if (existing != null) {
            existing.setTitre(updatedReclamation.getTitre());
            existing.setDescription(updatedReclamation.getDescription());
            existing.setDateCreation(updatedReclamation.getDateCreation());
            existing.setEtat(updatedReclamation.getEtat());
            return reclamationRepository.save(existing);
        }
        return null; 
    }

    @Override
    public void deleteReclamation(Long id) {
        reclamationRepository.deleteById(id);
    }
}
