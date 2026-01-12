## Sistema Bancário em Java (CLI)

Projeto de estudo desenvolvido em Java, simulando o funcionamento básico de um sistema bancário, com interface em linha de comando (CLI) e foco em POO, responsabilidade de classes e fluxo real de usuário.


## Objetivo do Projeto

Este projeto foi criado com o objetivo de:

Praticar Programação Orientada a Objetos

Aplicar separação de responsabilidades

Desenvolver um fluxo de usuário realista em CLI

## Funcionalidades

Criar conta bancária

Acessar conta pelo número

Realizar depósitos

Realizar saques

Visualizar extrato com data, hora e tipo da transação

Listar transações associadas à conta

Navegação por menus no terminal

## Pacote banco

Contém o domínio da aplicação:

Regras de negócio

Entidades

Operações bancárias

Registro de transações

## Pacote frontendcli

Responsável exclusivamente pela interface com o usuário:

Menus

Leitura de entrada

Fluxo de navegação

Exibição de informações

## Decisões de Projeto

Interface CLI tratada como frontend

SistemaBancario atua como orquestrador

Conta representa o estado da conta (saldo, número, titular)

Transações são registradas com data e hora





