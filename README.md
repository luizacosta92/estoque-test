#  Projeto Estoque - Testes Automatizados com Spring Boot

Este repositório foi criado com o objetivo de praticar testes automatizados utilizando **Spring Boot**, com foco em testes de **unidade**, **componente** e boas práticas de escrita de código testável.

##  Objetivo

O projeto simula um sistema de controle de estoque básico, permitindo:

- Cadastrar produtos
- Listar todos os produtos disponíveis
- Buscar produtos pelo nome
- Atualizar o estoque com base em pedidos
- Lidar com exceções de estoque insuficiente

Os testes foram escritos para consolidar o conhecimento em:

- **JUnit 5**
-  **Mockito**
-  **Spring MockMvc**
- 🛡 Boas práticas de organização de testes

##  Testes Implementados

###  Controller (`EstoqueController`)
- Cadastro de produto (`POST /estoque`)
- Listagem de produtos (`GET /estoque`)
- Busca por nome (`GET /estoque/{nome}`)
- Atualização de estoque com sucesso (`POST /estoque/atualizar`)
- Atualização de estoque com falha (exceção de estoque insuficiente)

###  Service (`ProdutoService`)
- Cálculo de atualização de estoque baseado em pedido
- Lançamento da exceção `ForaDeEstoqueException` quando necessário

## Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Web
- JUnit 5
- Mockito
- Spring Test (MockMvc)
- Maven

## 🚀 Como executar os testes

1. Clone este repositório:
   ```bash
   git clone https://github.com/seu-usuario/estoque-test.git
   cd estoque-test
