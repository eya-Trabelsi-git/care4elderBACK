package tn.esprit.spring.livrems.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.starter.mysqlShared.entity.baseEntity;

@Entity
@Table(name = "livres")  // Nom explicite pour la table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Livre extends baseEntity {

    @Column(nullable = false, length = 255)  // Ajout de contraintes
    String titre;

    @Column(nullable = false, length = 100)
    String genre;
}
