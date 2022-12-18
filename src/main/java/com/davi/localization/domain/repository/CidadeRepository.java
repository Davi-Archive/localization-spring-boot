package com.davi.localization.domain.repository;

import com.davi.localization.domain.entity.Cidade;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CidadeRepository extends JpaRepository<Cidade, Long>, JpaSpecificationExecutor<Cidade> {

    // busca pelo nome correto
    List<Cidade> findByNome(String nome);

    // busca pelo nome parecido  upper(X) lower(X)
    @Query(" select c from Cidade c where upper(c.nome) like upper(?1) ")
    List<Cidade> findByNomeLike(String nome, Pageable pageable);

    // busca pelo nome comecando por aquele pedaço
    List<Cidade> findByNomeStartingWith(String nome);

    // busca pelo nome terminando por aquele pedaço
    List<Cidade> findByNomeEndingWith(String nome);

    // busca pelo nome contendo aquele pedaço
    List<Cidade> findByNomeContaining(String nome);

    // Busca por habitantes
    List<Cidade> findByHabitantes(Long habitantes);

    // Busca por habitantes
    List<Cidade> findByHabitantesLessThanEqual(Long habitantes);

    List<Cidade> findByHabitantesLessThanAndNomeLike(Long habitantes, String nome);


}
