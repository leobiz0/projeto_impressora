# Sistema para Controlar a Impressora Elgin

Trabalho de Programação Orientada a Objetos.

## Sobre o projeto

Programa em Java, rodando no console, que controla uma impressora térmica Elgin (i8 ou i9) usando a DLL da própria Elgin.

Depois do login, aparece um menu onde dá para configurar e abrir a conexão com a impressora e mandar ela imprimir texto, QR Code, código de barras e cupons SAT, além de abrir a gaveta, apitar, avançar o papel e ver se ainda tem papel.

## Tecnologias

- Java 17
- IntelliJ IDEA
- JNA 5.15.0
- DLL E1_Impressora01 da Elgin
- Impressora Elgin i9 (USB)

## Estrutura

```
projeto_impressora/
├── Bibliotecas E1 Impressora/   (DLL x64 e x86)
├── libs Java/                   (jna-5.15.0.jar)
├── src/
│   ├── Main.java
│   ├── Usuario.java
│   ├── Impressora.java
│   ├── Entrada.java
│   └── ImpressoraDLL.java
├── XMLSAT.xml
├── CANC_SAT.xml
└── README.md
```

- **Main**: faz o login e mostra o menu.
- **Usuario**: guarda o login e a senha e confere se estão certos.
- **Impressora**: guarda os dados da conexão e tem um método para cada comando da impressora.
- **Entrada**: lê o que o usuário digita e não deixa passar letra onde precisa de número.
- **ImpressoraDLL**: ligação do Java com a DLL (veio pronta, não mexemos).

## Como executar

O programa precisa de Windows, porque a DLL da Elgin só funciona nele.

1. Clone o repositório e abra a pasta no IntelliJ.
2. Adicione o JNA em File → Project Structure → Libraries → + → Java, escolhendo o `jna-5.15.0.jar` da pasta `libs Java`.
3. Em Run → Edit Configurations, deixe o Working directory como a pasta principal do projeto. Sem isso a DLL e os XMLs não são encontrados.
4. Ligue a impressora no USB e rode a classe `Main`.
5. No menu, use a opção 1 com `1`, `i9`, `USB` e `0`, e depois a opção 2 para abrir a conexão.

## Login de teste

- Usuário: `admin`
- Senha: `1234`

São 3 tentativas. Se errar as três, o programa fecha.

## Menu

1. Configurar conexão
2. Abrir conexão
3. Fechar conexão
4. Imprimir texto (de 1 a 5 cópias)
5. Imprimir QR Code
6. Imprimir código de barras
7. Imprimir XML SAT
8. Imprimir XML de cancelamento SAT
9. Abrir gaveta
10. Sinal sonoro
11. Avançar papel
12. Status do papel
0. Sair

As opções de 4 a 12 só funcionam com a conexão aberta. Se ela estiver fechada, o programa avisa e volta para o menu sem pedir nada.

Também usamos try/catch para quando o usuário digita letra no lugar de número, quando o arquivo XML não existe e quando a DLL não carrega. Em nenhum desses casos o programa fecha.

## Testes realizados

Testamos tudo num computador com Windows e a impressora ligada no USB:

- Login errado 3 vezes e login certo
- Opção de impressão com a conexão fechada
- Letras e números inválidos no menu
- Configurar e abrir a conexão
- Imprimir texto, QR Code e código de barras
- Imprimir os XMLs de venda e de cancelamento
- Arquivo XML que não existe
- Abrir gaveta, sinal sonoro e avançar papel
- Status do papel
- Fechar a conexão e sair

Todos funcionaram.

## Autores

- **Leonardo Bizo** ([@leobiz0](https://github.com/leobiz0)): estrutura do projeto, login, menu e conexão com a impressora.
- **Yago Barbosa Santos** ([@YagoTRush](https://github.com/YagoTRush)): comandos da impressora: texto, QR Code, código de barras, XMLs SAT, gaveta, sinal sonoro, avançar papel e status do papel.
- **Sofia Porto Campos** ([@portososo](https://github.com/portososo)): documentação do projeto (README).

## Links

Documentação dos comandos da Elgin: https://elgindevelopercommunity.github.io/group___m1.html
