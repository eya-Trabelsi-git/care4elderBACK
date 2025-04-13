package tn.esprit.spring.auteurms.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;
import tn.starter.mongoShared.entity.BaseEntity;


@Document(collection = "auteur")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class auteurEntity extends BaseEntity {

    private String nom;
    private String prenom;
    private String biographie;
}
