package com.example.estoque.repository;


import com.example.estoque.entity.ProdutoEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProdutoRepositoryIntegrationTest {

    @Autowired
    private ProdutoRepository repository;

    @Test
    public void givenProductExists_whenIFindbyNome_thenfoundProduct(){
        //dado que o produto existe
        //Quando busco por nome
        //Retorna sucesso no produto


        var produto = new ProdutoEntity();
        produto.setNome("Notebook");
        produto.setDescricao("Lenovo");
        produto.setPreco(3000.0);
        produto.setQtd(2);
        repository.save(produto);

    var found = repository.findByNome("Notebook");
    Assertions.assertNotNull(found);
        Assertions.assertEquals("Notebook", found.getNome());
    }

  @Test
   public void  givenProductNotExists_whenIFindbyNome_thenReturnNull(){
        //dado que o produto não existe
        //quando pesquiso pelo nome
        //então retornar nulo
        var produto = repository.findByNome(null);
        Assertions.assertNull(produto);
    }

}
