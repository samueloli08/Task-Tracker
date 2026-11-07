# Task Tracker

Gerenciador de tarefas em linha de comando, feito em Java para praticar Programação Orientada a Objetos (encapsulamento e polimorfismo).

## Funcionalidades

- Adicionar tarefas, com ou sem prazo (data e hora limite)
- Atualizar nome, descrição e prazo de uma tarefa
- Alterar o status: **A Fazer**, **Em Progresso** ou **Feita**
- Listar todas as tarefas ou filtrar por status
- Listar tarefas **atrasadas**
- Deletar tarefas

Uma tarefa com prazo é considerada atrasada quando o prazo já passou e ela ainda não está Feita. Tarefas sem prazo nunca ficam atrasadas.

## Estrutura do projeto

```
src/
└── tasktaker/
    ├── Main.java          # Menu e ponto de entrada
    ├── Controle.java      # Regras da aplicação e leitura de entrada
    ├── Task.java          # Classe abstrata base das tarefas
    ├── TaskSimples.java   # Tarefa sem prazo
    ├── TaskComPrazo.java  # Tarefa com prazo e verificação de atraso
    └── Status.java        # Enum com os status possíveis
```

## Conceitos de POO aplicados

**Encapsulamento**
- Atributos privados, acessados por getters e setters
- Setters validam os dados (nome não pode ser vazio, prazo não pode ser nulo, status deve ser válido)
- `Status` é um enum, no lugar de Strings soltas
- `Controle.getTasks()` devolve uma lista somente leitura

**Polimorfismo**
- `Task` é abstrata e define `getTipo()`, `estaAtrasada()` e `detalhesPrazo()`
- `TaskSimples` e `TaskComPrazo` implementam esses métodos de formas diferentes
- O `Controle` trata todas as tarefas como `Task`, sem precisar saber o tipo concreto

## Como executar

Requisito: JDK 17 ou superior.

**Pelo IntelliJ:** abra o projeto, abra `tasktaker/Main.java` e clique no botão de executar ao lado do método `main`.

**Pelo terminal**, na pasta `src`:

```
javac -d out tasktaker/*.java
java -cp out tasktaker.Main
```

## Como usar

Ao iniciar, o menu é exibido:

```
1. Adicionar Tarefa
2. Atualizar Tarefa
3. Alterar Status de Tarefa
4. Listar Todas as Tarefas
5. Listar Tarefas Feitas
6. Listar Tarefas Em Progresso
7. Listar Tarefas Não Feitas
8. Deletar Tarefa
9. Listar Tarefas Atrasadas
0. Sair
```

Digite o número da opção e siga as instruções na tela.

O prazo deve ser informado no formato `dd/MM/yyyy HH:mm`, por exemplo `25/12/2026 18:30`.

Exemplo de listagem:

```
1. Entregar trabalho de POO - [A Fazer] (Com Prazo)
   Prazo: 01/11/2026 23:59  ** ATRASADA **
-> Enviar o projeto no SIGAA

2. Ler capítulo 5 - [Em Progresso] (Simples)
-> Livro de estruturas de dados
```

## Limitações

- As tarefas ficam apenas em memória e são perdidas ao fechar o programa.

## Próximos passos

- Salvar e carregar tarefas de um arquivo
- Ordenar tarefas por prazo
- Adicionar prioridade às tarefas

## Autor

Samuel Oliveira.
