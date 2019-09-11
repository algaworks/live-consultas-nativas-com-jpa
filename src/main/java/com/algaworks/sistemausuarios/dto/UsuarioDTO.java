package com.algaworks.sistemausuarios.dto;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    @EqualsAndHashCode.Include
    private Integer id;

    private String login;

    private String nome;
}
