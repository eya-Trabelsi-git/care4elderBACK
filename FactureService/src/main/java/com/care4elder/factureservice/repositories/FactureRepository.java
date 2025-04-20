package com.care4elder.factureservice.repositories;

import com.care4elder.factureservice.entities.Facture;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FactureRepository extends MongoRepository<Facture, String> {
}
