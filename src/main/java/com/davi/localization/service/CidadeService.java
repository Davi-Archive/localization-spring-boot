package com.davi.localization.service;

import com.davi.localization.domain.entity.Cidade;
import com.davi.localization.domain.repository.CidadeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
