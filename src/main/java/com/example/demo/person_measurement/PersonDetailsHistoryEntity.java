package com.example.demo.person_measurement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "PersonDetailsHistoryEntity")
@Getter
@Setter
class PersonDetailsHistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID personDetailHistoryId;
    private UUID userId;
    @JsonIgnore
    @OneToMany(
            mappedBy = "personDetailsHistory",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<NewPersonDetailEntity> newPersonDetail = new ArrayList<>();
}
