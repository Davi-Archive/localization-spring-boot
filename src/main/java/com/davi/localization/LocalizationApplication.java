package com.davi.localization;

import com.davi.localization.domain.entity.Cidade;
import com.davi.localization.domain.repository.CidadeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LocalizationApplication implements CommandLineRunner {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("iniciando!");
        listarCidadesPorNome();
        listarCidadesPorHabitates();
    }

    @Transactional
    void salvarCidade() {
        var cidade = new Cidade(1L, "São Paulo", 123963721L);
        cidadeRepository.save(cidade);
    }

    void listarCidades() {
        cidadeRepository.findAll().forEach(System.out::println);
    }

    void listarCidadesPorNome() {
        cidadeRepository.findByNomeLike("%a%").forEach(System.out::println);
    }

    void listarCidadesPorHabitates() {
        cidadeRepository.findByHabitantesLessThanEqual(100000000L)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        SpringApplication.run(LocalizationApplication.class, args);
    }

}
