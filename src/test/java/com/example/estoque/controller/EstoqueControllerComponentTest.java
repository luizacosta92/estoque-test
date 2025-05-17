package com.example.estoque.controller;

import com.example.estoque.domain.ItemPedido;
import com.example.estoque.domain.Pedido;
import com.example.estoque.domain.Produto;
import com.example.estoque.service.ProdutoService;
import com.fasterxml.jackson.databind.ObjectMapper; 
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class EstoqueControllerComponentTest {
    //Fazer um teste de controller
    @MockitoBean
    private ProdutoService service;

    @Autowired
    private ObjectMapper objectMapper; //objeto java que transforma dados em json

    @Autowired
    private MockMvc mockMvc;

    @Test
    //Dado que para cadastrar produto
    //Preciso adicionar o produto
    //Retornar positivo
    public void givenNewProduct_whenTryRegistrate_thenReturnSucess() throws Exception{
        var produto = new Produto();

        produto.setNome("Notebook");
        produto.setDescricao("lenovo");
        produto.setQtd(1);
        produto.setPreco(3.500);

        Mockito.doNothing().when(service).cadastrarProduto(Mockito.any(Produto.class));

        // When
        var request = MockMvcRequestBuilders.post("/estoque")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(produto));


        var response = mockMvc.perform(request);

        // Then
        response.andDo(
                MockMvcResultHandlers.print()
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        ).andExpect(
                MockMvcResultMatchers.content().string("Cadastrado com Sucesso"));

    }

    @Test
    public void givenValidPedido_whenAtualizaEstoque_thenReturnSuccess() throws Exception {
        var produto = new Produto();
        produto.setNome("Monitor");
        produto.setDescricao("FullHD");
        produto.setQtd(1);
        produto.setPreco(500.0);

        var pedido = new Pedido();
        pedido.setItens(List.of());

        Mockito.doNothing().when(service).atualizarEstoque(Mockito.any(Pedido.class));

        mockMvc.perform(
                        MockMvcRequestBuilders.post("/estoque/atualizar")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(pedido))
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Estoque Atualizado"));
    }



}
