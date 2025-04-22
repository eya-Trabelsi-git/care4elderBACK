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

    // Méthode PUT pour mettre à jour une facture
    public Facture updateFacture(String id, Facture facture) {
        // Vérifie si la facture existe
        Facture existingFacture = factureRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Facture non trouvée"));

        // Mise à jour des propriétés
        existingFacture.setReference(facture.getReference());
        existingFacture.setMontant(facture.getMontant());
        existingFacture.setDescription(facture.getDescription());
        existingFacture.setStatut(facture.getStatut());
        existingFacture.setDateEcheance(facture.getDateEcheance());
        existingFacture.setDateCreation(facture.getDateCreation());

        // Sauvegarde et retourne la facture mise à jour
        return factureRepository.save(existingFacture);
    }

}

