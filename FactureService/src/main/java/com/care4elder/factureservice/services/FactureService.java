package com.care4elder.factureservice.services;

import com.care4elder.factureservice.entities.Facture;
import com.care4elder.factureservice.repositories.FactureRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactureService {

    private final FactureRepository factureRepository;

    public FactureService(FactureRepository factureRepository) {
        this.factureRepository = factureRepository;
    }

    public List<Facture> getAllFactures() {
        return factureRepository.findAll();
    }

    public Facture getFactureById(String id) {
        return factureRepository.findById(id).orElse(null);
    }

    public Facture saveFacture(Facture facture) {
        return factureRepository.save(facture);
    }

    public void deleteFacture(String id) {
        factureRepository.deleteById(id);
    }
}
