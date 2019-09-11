package com.algaworks.sistemausuarios;

import com.algaworks.sistemausuarios.dto.UsuarioDTO;
import com.algaworks.sistemausuarios.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class ConsultasNativas {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("Usuarios-PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

//        consultaSimplesMapeandoParaEntidade(entityManager);
//        mapeandoResultado(entityManager);
//        mapeandoResultadoParaUmDTO(entityManager);
        usandoNamedNativeQuery(entityManager);

        entityManager.close();
        entityManagerFactory.close();
    }

    public static void usandoNamedNativeQuery(EntityManager entityManager) {
        Query query = entityManager.createNamedQuery("namedQuery.Usuario");

        List<Usuario> lista = query.getResultList();

        lista.stream().forEach(u -> System.out.println(
                String.format("Usuário => Id: %s, Nome: %s", u.getId(), u.getNome())));
    }

    public static void mapeandoResultadoParaUmDTO(EntityManager entityManager) {
        Query query = entityManager.createNativeQuery(
                "select usu_codigo, usu_email, usu_nome from sis_usuario",
                "mapeamento.UsuarioDTO");

        List<UsuarioDTO> lista = query.getResultList();

        lista.stream().forEach(u -> System.out.println(
                String.format("Usuário => Id: %s, Nome: %s", u.getId(), u.getNome())));
    }

    public static void mapeandoResultado(EntityManager entityManager) {
        Query query = entityManager.createNativeQuery(
                "select * from sis_usuario",
                "mapeamento.Usuario");

        List<Usuario> lista = query.getResultList();

        lista.stream().forEach(u -> System.out.println(
                String.format("Usuário => Id: %s, Nome: %s", u.getId(), u.getNome())));
    }

	public static void consultaSimplesMapeandoParaEntidade(EntityManager entityManager) {
        Query query = entityManager.createNativeQuery(
                "select usu_codigo id, usu_email login, usu_senha senha, usu_nome nome " +
                        "from sis_usuario",
                Usuario.class);

        List<Usuario> lista = query.getResultList();

        lista.stream().forEach(u -> System.out.println(
                String.format("Usuário => Id: %s, Nome: %s", u.getId(), u.getNome())));
	}
}
