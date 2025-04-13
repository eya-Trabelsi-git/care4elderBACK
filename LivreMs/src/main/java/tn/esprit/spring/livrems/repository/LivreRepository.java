package tn.esprit.spring.livrems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.livrems.entity.Livre;
import java.util.Optional;
import tn.starter.mysqlShared.repository.BaseRepository;

public interface LivreRepository extends BaseRepository<Livre,Long> {
}