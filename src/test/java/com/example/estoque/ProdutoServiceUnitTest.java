package com.example.estoque;

import com.example.estoque.repository.ProdutoRepository;
import com.example.estoque.service.ProdutoService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ProdutoServiceUnitTest {

    private ProdutoRepository repository;


    @BeforeEach
    public void setup(){
        System.out.println("Executando o before each");

        repository = Mockito.mock(ProdutoRepository.class);

        ProdutoService produtoService = new ProdutoService(repository);
    }

    /*Avaliar qual será o cenário de teste que vou criar
        */
    @Test
    public void PrimeiroTesteQueAindaVouNomear(){

    }
}
