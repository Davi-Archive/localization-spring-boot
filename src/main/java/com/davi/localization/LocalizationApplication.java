package com.davi.localization;

import com.davi.localization.domain.entity.Cidade;
import com.davi.localization.domain.repository.CidadeRepository;
import com.davi.localization.service.CidadeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LocalizationApplication implements CommandLineRunner {

    @Autowired
    private CidadeService service;
    @Autowired
    private CidadeRepository cidadeRepository;

    @Override
    public void run(String... args) throws Exception {
       // service.listarCidadesPorNome();
        var cidade = new Cidade(null, "Porto Alegre", null);
        service.filtroDinamico(cidade).forEach(System.out::println);
        service.listarCidadesSpecsFiltroDinamico(cidade);
    }


    public static void main(String[] args) {
        SpringApplication.run(LocalizationApplication.class, args);
    }

}
