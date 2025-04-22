package tn.esprit.spring.servicems.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ServiceOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer duration; // en minutes
    private Long clientId;
    public Long getClientId() {
        return this.clientId;
    }
}