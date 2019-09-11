package com.algaworks.sistemausuarios.model;

import com.algaworks.sistemausuarios.dto.UsuarioDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SqlResultSetMappings({
        @SqlResultSetMapping(name = "mapeamento.Usuario",
                entities = @EntityResult(entityClass = Usuario.class,
                        fields = {
                                @FieldResult(name = "id", column = "usu_codigo"),
                                @FieldResult(name = "login", column = "usu_email"),
                                @FieldResult(name = "senha", column = "usu_senha"),
                                @FieldResult(name = "nome", column = "usu_nome")
                        })),
        @SqlResultSetMapping(name = "mapeamento.UsuarioDTO", classes = {
                @ConstructorResult(targetClass = UsuarioDTO.class, columns = {
                        @ColumnResult(name = "usu_codigo", type = Integer.class),
                        @ColumnResult(name = "usu_email", type = String.class),
                        @ColumnResult(name = "usu_nome", type = String.class),
                })
        })
})
@NamedNativeQueries({
        @NamedNativeQuery(name = "namedQuery.Usuario",
                query = "select * from sis_usuario", resultSetMapping = "mapeamento.Usuario"
//                query = "select * from usuario", resultClass = Usuario.class
        )})
@Table(name = "usuario")
@Entity
public class Usuario {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;

    private String login;

    private String senha;

    private String nome;
}
