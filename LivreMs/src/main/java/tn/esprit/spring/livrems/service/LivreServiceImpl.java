package tn.esprit.spring.livrems.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.livrems.entity.Livre;
import tn.esprit.spring.livrems.feignClients.AuteurClient;
import tn.esprit.spring.livrems.repository.LivreRepository;
import tn.starter.mysqlShared.dto.LivreDTO;
import tn.starter.mysqlShared.dto.auteurDTO;
import tn.starter.mysqlShared.service.IGenericServiceImpl;

@Service
public class LivreServiceImpl extends IGenericServiceImpl<LivreDTO, Livre,Long> implements LivreService {

    private final AuteurClient auteurClient;
    private final LivreRepository repository;

    @Autowired
    public LivreServiceImpl(AuteurClient auteurClient, LivreRepository repository) {
        this.auteurClient = auteurClient;
        this.repository = repository;
    }

    @Override
    public auteurDTO getAuteurById(String id) {
        return auteurClient.getAuteurById(id);
    }

    @Override
    public Livre updatelivre(Livre l) {
        return repository.save(l);
    }




}
