package com.care4elder.factureservice.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "factures")
public class Facture {

    @Id
    private String id;

    private String reference;

    @JsonProperty("amount") // correspond à 'amount' dans le JSON
    private Double montant;

    private String description;

    @JsonProperty("status") // correspond à 'status' dans le JSON
    private String statut;

    @JsonProperty("dueDate") // correspond à 'dueDate' dans le JSON
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm") // accepte datetime-local du frontend
    private LocalDateTime dateEcheance;

    private LocalDateTime dateCreation;

    public Facture() {
        this.dateCreation = LocalDateTime.now();
    }

    // Getters et Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public LocalDateTime getDateEcheance() {
        return dateEcheance;
    }

    public void setDateEcheance(LocalDateTime dateEcheance) {
        this.dateEcheance = dateEcheance;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }
}
