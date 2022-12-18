package com.davi.localization.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_cidade")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cidade {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 50)
    private String nome;

    @Column(name = "qtd_habitantes")
    private Long habitantes;

}
