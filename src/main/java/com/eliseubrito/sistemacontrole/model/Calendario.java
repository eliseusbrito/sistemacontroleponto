package com.eliseubrito.sistemacontrole.model;

import lombok.*;

import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Calendario {
    @Id
    private long id;
    private String descricao;
}
