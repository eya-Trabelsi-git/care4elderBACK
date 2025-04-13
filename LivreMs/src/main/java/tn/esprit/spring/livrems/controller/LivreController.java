package tn.esprit.spring.livrems.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.livrems.entity.Livre;
import tn.esprit.spring.livrems.service.LivreService;
import tn.starter.mysqlShared.controller.GenericController;
import tn.starter.mysqlShared.dto.LivreDTO;
import tn.starter.mysqlShared.dto.auteurDTO;

@RestController
@RequestMapping("/api/livres")
public class LivreController extends GenericController<LivreDTO, Long> {

    private final LivreService livreService;

    @Autowired
    public LivreController(LivreService livreService) {
        this.livreService = livreService;
    }

    @GetMapping("/getAuteurById/{id}")
    public auteurDTO getAuteurById(@PathVariable String id) {
        return livreService.getAuteurById(id);
    }

    @PutMapping("/update")
    public Livre updateLivre(@RequestBody Livre livre) {
        return livreService.updatelivre(livre);
    }


}
