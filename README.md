# Gerenciador de Tarefas (Task Tracker) - Java

Este é um projeto de estudo desenvolvido em Java com o objetivo de praticar conceitos fundamentais da **Programação Orientada a Objetos (POO)** e a manipulação de estruturas de dados básicas (arrays/vetores) sem o uso de bibliotecas externas de coleções.

---

## Sobre o Projeto

O projeto consiste em um sistema de gerenciamento de tarefas via terminal (CLI). Ele permite ao usuário criar, listar, filtrar, atualizar o status e deletar tarefas.

---

## Conceitos de POO e Programação Aplicados

- **Encapsulamento**: Atributos das classes (`Task` e `Controle`) definidos como `private`, garantindo o acesso e a modificação segura por meio de métodos de acesso e modificação (*getters* e *setters*).
- **Construtores**: Inicialização padronizada dos objetos. Por padrão, toda nova tarefa é criada com o status `"to Do"`.
- **Sobrescrita do Método `toString()`**: Personalização do método `toString()` na classe `Task` para formatar e exibir os detalhes de cada tarefa de forma clara.
- **Manipulação de Arrays em Java**: Organização do armazenamento fixo de tarefas (`Task[]`) sem o uso de `ArrayList`.
- **Lógica de Remoção em Vetores**: Algoritmo para deslocar elementos à esquerda ao remover uma tarefa, mantendo a integridade dos índices e limpando a última posição com `null`.

---

## Estrutura das Classes

- **`Task.java`**: Representa a entidade da tarefa, contendo título (`name`), descrição (`description`) e o status (`status`).
- **`Controle.java`**: Classe responsável pela regra de negócio, gerenciando o array de tarefas, filtros de busca por status, atualização e deleção.
- **`Main.java`**: Ponto de entrada da aplicação, responsável pela exibição do menu interativo no console.

---

## Funcionalidades

1. **Adicionar Tarefa**: Cria uma nova tarefa e insere no array.
2. **Atualizar Tarefa**: Permite alterar o título e a descrição de uma tarefa existente.
3. **Alterar Status**: Atualiza o estado da tarefa para `to Do`, `in Progress` ou `Done`.
4. **Listar Tarefas**: Exibe todas as tarefas registradas.
5. **Filtrar por Status**:
   - Listar Tarefas Feitas
   - Listar Tarefas Em Progresso
   - Listar Tarefas Não Feitas
6. **Deletar Tarefa**: Remove a tarefa selecionada e reorganiza as posições do vetor.

---

## Como Executar

1. **Pré-requisitos**: Possuir o **JDK 8+** instalado em sua máquina.
2. **Clonar o repositório**:
   ```bash
   git clone [https://github.com/seu-usuario/seu-repositorio.git](https://github.com/seu-usuario/seu-repositorio.git)
