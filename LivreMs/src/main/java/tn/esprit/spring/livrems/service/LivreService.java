package tn.esprit.spring.livrems.service;
import tn.esprit.spring.livrems.entity.Livre;
import tn.starter.mysqlShared.dto.LivreDTO;
import tn.starter.mysqlShared.dto.auteurDTO;
import tn.starter.mysqlShared.service.IGenericService;
public interface LivreService extends IGenericService<LivreDTO,Long> {
    auteurDTO getAuteurById(String id);
    Livre updatelivre(Livre l);

}
