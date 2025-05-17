package com.example.estoque;

import com.example.estoque.domain.Pedido;
import com.example.estoque.domain.Produto;
import com.example.estoque.entity.ProdutoEntity;
import com.example.estoque.repository.ProdutoRepository;
import com.example.estoque.service.ProdutoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ProdutoServiceUnitTest {
    @Mock
    private ProdutoRepository repository;

    @InjectMocks
    private ProdutoService produtoService;


    /*Avaliar qual será o cenário de teste que vou criar
        */
    @Test
    public void givenExistingProduct_whenCadastrarProduto_thenUpdateQtdAndSave() {
        var produto = new Produto("Notebook", "Lenovo", 3000.0, 5);
        var entity = new ProdutoEntity(produto);
        entity.setQtd(2); // valor anterior

        Mockito.when(repository.findByNome("Notebook")).thenReturn(entity);

        produtoService.cadastrarProduto(produto);

        Mockito.verify(repository).save(Mockito.argThat(p -> p.getQtd() == 5));
    }

    @Test
    void givenNewProduct_whenCadastrarProduto_thenSaveNewEntity() {
        var produto = new Produto("Mouse", "USB", 150.0, 5);

        Mockito.when(repository.findByNome("Mouse")).thenReturn(null);

        produtoService.cadastrarProduto(produto);

        Mockito.verify(repository).save(Mockito.any(ProdutoEntity.class));
    }

    @Test
    void whenFindAll_thenReturnListOfProdutos() {
        var entity = new ProdutoEntity(new Produto("Teclado", "Logitech", 100.0, 1));

        Mockito.when(repository.findAll()).thenReturn(List.of(entity));

        var result = produtoService.encontrarTodos();

        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals("Teclado", result.get(0).getNome());
    }

    @Test
    void givenNome_whenFindByNome_thenReturnProduto() {
        var entity = new ProdutoEntity(new Produto("Cadeira", "Ergonomica", 1000.0, 5));

        Mockito.when(repository.findByNome("Cadeira")).thenReturn(entity);

        var result = produtoService.encontrarPorNome("Cadeira");

        Assertions.assertEquals("Cadeira", result.getNome());
    }


}
