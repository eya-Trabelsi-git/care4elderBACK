package tn.esprit.spring.livrems.entity;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.starter.mysqlShared.entity.baseEntity;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LivreAuteur extends baseEntity {
    long idLivre;
    String idAuteur;
}
