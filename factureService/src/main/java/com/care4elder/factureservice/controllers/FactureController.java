package com.care4elder.factureservice.controllers;

import com.care4elder.factureservice.entities.Facture;
import com.care4elder.factureservice.services.FactureService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/factures")
public class FactureController {

    private final FactureService factureService;

    public FactureController(FactureService factureService) {
        this.factureService = factureService;
    }

    @GetMapping
    public List<Facture> getAllFactures() {
        return factureService.getAllFactures();
    }

    @GetMapping("/{id}")
    public Facture getFactureById(@PathVariable String id) {
        return factureService.getFactureById(id);
    }

    @PostMapping
    public Facture createFacture(@RequestBody Facture facture) {
        return factureService.saveFacture(facture);
    }

    @DeleteMapping("/{id}")
    public void deleteFacture(@PathVariable String id) {
        factureService.deleteFacture(id);
    }
}
