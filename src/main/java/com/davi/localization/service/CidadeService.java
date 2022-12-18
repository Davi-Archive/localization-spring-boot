package com.davi.localization.service;

import com.davi.localization.domain.entity.Cidade;
import com.davi.localization.domain.repository.CidadeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.davi.localization.domain.repository.specs.CidadeSpecs.habitantesGreaterThan;
import static com.davi.localization.domain.repository.specs.CidadeSpecs.nomeEqual;

@Service
public class CidadeService {

    @Autowired
    private final CidadeRepository repository;

    public CidadeService(CidadeRepository repository) {
        this.repository = repository;
    }

    @Transactional
    void salvarCidade() {
        var cidade = new Cidade(1L, "São Paulo", 123963721L);
        repository.save(cidade);
    }

    public void listarCidades() {
        repository.findAll().forEach(System.out::println);
    }

    public void listarCidadesPorNome() {
        Pageable sortedByName = PageRequest.of(1, 3);
        repository.findByNomeLike("%a%", sortedByName).forEach(System.out::println);
    }

    public void listarCidadesPorHabitates() {
        repository.findByHabitantesLessThanEqual(100000000L).forEach(System.out::println);
    }

    public List<Cidade> filtroDinamico(Cidade cidade) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING);
        Example<Cidade> example = Example.of(cidade, matcher);
//        return repository
//                .findByHabitantesLessThanAndNomeLike(null, "Porto");

        return repository.findAll(example);
    }

    public void listarCidadesByNomeSpec() {
        Specification<Cidade> spec = nomeEqual("São Paulo")
                .and(habitantesGreaterThan(1000L));
        repository.findAll(spec);
    }

}
