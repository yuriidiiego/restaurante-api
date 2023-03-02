# Gerenciador de Lanchonete

Esse é um projeto para uma aplicação web que gerencia uma lanchonete que vende lanches personalizados e opções de cardápio.

A lanchonete vende lanches personalizados e opções de cardápio. Cada lanche é composto por uma ou mais opções de ingredientes, que podem ser selecionados pelo cliente.

Os ingredientes disponíveis são:

- [x] Alface: R$ 0,40
- [x] Bacon: R$ 2,00
- [x] Hambúrguer: R$ 3,00
- [x] Ovo: R$ 0,80
- [x] Queijo: R$ 1,50

As opções de cardápio e seus respectivos ingredientes são:

- [x] X-Bacon: Bacon, hambúrguer de carne e queijo
- [x] X-Burger: Hambúrguer de carne e queijo
- [x] X-Egg: Ovo, hambúrguer de carne e queijo
- [x] X-Egg Bacon: Ovo, bacon, hambúrguer de carne e queijo

O preço de cada opção do cardápio é dado pela soma dos ingredientes que compõe o lanche. Se o cliente escolher ingredientes personalizados, o preço do lanche será calculado pela soma dos ingredientes escolhidos.
Solução proposta

A solução proposta é uma aplicação web que permita ao cliente selecionar uma opção de cardápio ou criar um lanche personalizado, selecionando os ingredientes desejados. A aplicação deve calcular o preço do lanche e permitir ao cliente fazer o pedido.

## Como rodar o projeto

- Faça um clone do projeto e abra na usa IDE de preferência.
- Rode o projeto com o comando `docker compose up -d` para iniciar o servidor.
- Acesse a documentação da API em `http://localhost:8080/restaurante/swagger-ui.html` para ver os endpoints disponíveis
- Importe o arquivo `gestao-hospitalar.postman_collection.json` no Postman para ter acesso aos endpoints já configurados.

## O que eu sei fazer, porém não deu tempo

- Autorização e autenticação com Spring Security e JWT
- Testes de unidade e integração
- A regra de negócio das promoções
