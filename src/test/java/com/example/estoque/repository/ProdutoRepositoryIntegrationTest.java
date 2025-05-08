package com.example.estoque.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ProdutoRepositoryIntegrationTest {
    @Autowired
    private ProdutoRepository repository;

    @Test
    public void givenProductExists_whenIFindbyNome_thenfoundProduct(){
    //código aqui
    }

    @Test
    public void  givenProductNotExists_whenIFindbyNome_thenReturnNull(){
        //testar quando o produto não existe e retornar nulo
    }

}
