# 🖨️ Sistema para Controlar a Impressora Elgin

---

## 📘 Sobre o Projeto

Este projeto foi desenvolvido por alunos para se comunicar com uma impressora térmica **Elgin i8/i9** usando a biblioteca `E1_Impressora01.dll`. O sistema tem login e um menu de onde dá para configurar a conexão e mandar a impressora imprimir texto, QR Code, código de barras e cupons SAT, além de abrir a gaveta, apitar e verificar o papel. Faz parte da disciplina de **Programação Orientada a Objetos**.

---

## 🧰 Tecnologias Utilizadas

- **Java 17**
- **IntelliJ IDEA**
- **JNA 5.15.0** (comunicação com a DLL)
- **DLL E1_Impressora01** (SDK da Elgin)
- **Impressora Elgin i9** (usada nos testes, via USB)

---

## 📁 Estrutura do Projeto

```
/src                       → Código-fonte
   Main.java               → Inicia o programa, faz o login e mostra o menu
   Usuario.java            → Guarda o login e a senha e confere se estão certos
   Impressora.java         → Guarda os dados da conexão e tem um método para cada comando
   Entrada.java            → Lê o que o usuário digita e valida os números
   ImpressoraDLL.java      → Ligação do Java com a DLL (veio pronta)
/Bibliotecas E1 Impressora → DLLs da Elgin (x64 e x86)
/libs Java                 → jna-5.15.0.jar
XMLSAT.xml                 → Cupom SAT de venda (exemplo)
CANC_SAT.xml               → Cupom SAT de cancelamento (exemplo)
```

---

## ⚙️ Instalação e Execução

O programa precisa rodar no **Windows**, porque a DLL da Elgin só funciona nele.

### 1. Baixar o projeto
1. Acesse o repositório no GitHub: https://github.com/leobiz0/projeto_impressora
2. Clique em **Code → Download ZIP**.
3. Extraia o arquivo.

### 2. Abrir no IntelliJ IDEA
1. **File → Open** e escolha a pasta extraída.
2. Em **File → Project Structure → Libraries**, confirme que o `jna-5.15.0.jar` está adicionado. Se não estiver, clique em **+ → Java** e escolha o arquivo dentro de `libs Java`.
3. Em **Run → Edit Configurations**, deixe o **Working directory** como a pasta principal do projeto. Sem isso a DLL e os XMLs não são encontrados.
4. Conecte e ligue a impressora.
5. Abra `Main.java` e clique em ▶️ **Run**.
6. No menu, use a opção **1** com `1`, `i9`, `USB` e `0`, e depois a opção **2** para abrir a conexão.

---

## 🔐 Login

- **Usuário:** `admin`
- **Senha:** `1234`

São permitidas **3 tentativas**. A cada erro o programa mostra quantas restam, e se errar as três ele encerra.

---

## 📋 Funcionalidades do Menu

| Opção | O que faz |
|---|---|
| 1 | Configura a conexão (tipo, modelo, conexão e parâmetro) |
| 2 | Abre a conexão com a impressora |
| 3 | Fecha a conexão |
| 4 | Imprime um texto, de 1 a 5 cópias |
| 5 | Imprime um QR Code com o conteúdo digitado |
| 6 | Imprime um código de barras |
| 7 | Imprime o cupom SAT de venda a partir do XML |
| 8 | Imprime o cupom SAT de cancelamento a partir do XML |
| 9 | Abre a gaveta de dinheiro |
| 10 | Faz a impressora apitar |
| 11 | Avança o papel de 1 a 10 linhas |
| 12 | Mostra se tem papel, se está acabando ou se acabou |
| 0 | Fecha a conexão e sai do programa |

As opções de 4 a 12 só funcionam com a conexão aberta. Se ela estiver fechada, o programa avisa e volta para o menu sem pedir nada. Também usamos try/catch para quando o usuário digita letra no lugar de número, quando o arquivo XML não existe e quando a DLL não carrega, então o programa não fecha sozinho.

---

## 🧪 Testes Realizados

Testamos tudo num computador com Windows e a impressora ligada no USB:

- Login com senha errada 3 vezes e login certo
- Opção de impressão com a conexão fechada
- Letras e números inválidos no menu
- Configurar e abrir a conexão
- Impressão de texto, QR Code e código de barras
- Impressão dos XMLs de venda e de cancelamento
- Arquivo XML que não existe
- Gaveta, bip e avançar papel
- Status do papel
- Fechar a conexão e sair

Todos os testes funcionaram.

---

## 📚 Documentação Adicional

- Documentação dos comandos da impressora Elgin: https://elgindevelopercommunity.github.io/group___m1.html
- Documentação do SDK E1_Impressora (DLL `E1_Impressora01`)

---

## 👥 Autores

- Leonardo Bizo ([@leobiz0](https://github.com/leobiz0))
- Sofia Porto Campos ([@portososo](https://github.com/portososo))
- Yago Barbosa Santos ([@YagoTRush](https://github.com/YagoTRush))
