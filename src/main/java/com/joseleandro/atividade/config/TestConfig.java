package com.joseleandro.atividade.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.joseleandro.atividade.entities.Aluno;
import com.joseleandro.atividade.entities.Endereco;
import com.joseleandro.atividade.entities.Nota;
import com.joseleandro.atividade.repositories.AlunoRepository;
import com.joseleandro.atividade.repositories.EnderecoRepository;
import com.joseleandro.atividade.repositories.NotaRepository;

//Por enquanto, isso vai servir de data base seeding
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private NotaRepository notaRepository;
    
    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public void run(String... args) throws Exception {

        Endereco end1 = new Endereco(null, "Rua Exemplo", 123, "Cidade Exemplo", "Estado Exemplo", "12345678");
        Endereco end2 = new Endereco(null, "Avenida Principal", 456, "Cidade Grande", "Estado Grande", "87654321");
        Endereco end3 = new Endereco(null, "Rua Secundária", 789, "Cidade Pequena", "Estado Pequeno", "98765432");

        Aluno alu1 = new Aluno(null, "José Leandro", 25, "ADS", true);
        Aluno alu2 = new Aluno(null, "Maria Silva", 22, "Engenharia", true);
        Aluno alu3 = new Aluno(null, "Karina", 20, "Medicina", false);

        Nota nota1 = new Nota(null, "Laboratorio de banco de dados", 10.0);
        Nota nota2 = new Nota(null, "Programação Orientada a Objetos", 8.5);
        Nota nota3 = new Nota(null, "Estrutura de Dados", 9.0);

        // Manda para o banco de dados
        enderecoRepository.saveAll(Arrays.asList(end1, end2, end3));
        notaRepository.saveAll(Arrays.asList(nota1, nota2, nota3));
        alunoRepository.saveAll(Arrays.asList(alu1, alu2, alu3));

    }

}