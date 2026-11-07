package aplication;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Controle {
    private final Scanner sc;
    private final List<Task> tasks = new ArrayList<>();

    public Controle(Scanner sc) {
        this.sc = sc;
    }

    public void criarTarefa() {
        String nome = lerTexto("Digite o nome da Tarefa: ");
        String descricao = lerTexto("Digite a descrição da Tarefa: ");

        System.out.print("Essa tarefa tem prazo? (s/n): ");
        boolean temPrazo = sc.nextLine().trim().equalsIgnoreCase("s");

        try {
            Task nova;
            if (temPrazo) {
                nova = new TaskComPrazo(nome, descricao, lerPrazo("Digite o prazo (dd/MM/yyyy HH:mm): "));
            } else {
                nova = new TaskSimples(nome, descricao);
            }
            tasks.add(nova);
            pausar("Tarefa Salva");
        } catch (IllegalArgumentException e) {
            pausar("Erro: " + e.getMessage());
        }
    }

    public void atualizarTarefa() {
        Task t = escolherTarefa("Digite o N° da Tarefa que quer Atualizar");
        if (t == null) return;

        System.out.print("Novo nome (enter para manter): ");
        String nome = sc.nextLine();
        if (!nome.isBlank()) t.setName(nome);

        System.out.print("Nova descrição (enter para manter): ");
        String desc = sc.nextLine();
        if (!desc.isBlank()) t.setDescription(desc);

        // Só tarefas com prazo têm prazo para alterar (verificação de tipo)
        if (t instanceof TaskComPrazo comPrazo) {
            System.out.print("Novo prazo (dd/MM/yyyy HH:mm, enter para manter): ");
            String texto = sc.nextLine().trim();
            if (!texto.isEmpty()) {
                try {
                    comPrazo.setPrazo(LocalDateTime.parse(texto, Task.FORMATO));
                } catch (DateTimeParseException e) {
                    System.out.println("Data inválida, prazo mantido.");
                }
            }
        }
        pausar("Tarefa Atualizada");
    }

    public void alterarStatus() {
        Task t = escolherTarefa("Qual o N° da Tarefa que quer Mudar Status");
        if (t == null) return;

        System.out.println("Deseja Alterar para qual Status: ");
        System.out.println("1. Não Feita");
        System.out.println("2. Em Progresso");
        System.out.println("3. Feita");
        Status novo = Status.deOpcao(lerInt("Opção: "));

        if (novo == null) {
            pausar("Comando Inválido");
        } else {
            t.setStatus(novo);
            pausar("Status Atualizado");
        }
    }

    public void deletarTarefa() {
        Task t = escolherTarefa("Digite o N° da Tarefa que quer Deletar");
        if (t == null) return;
        tasks.remove(t);
        pausar("Tarefa Deletada");
    }

    public void listarTodas() {
        listar("Você não tem Tarefas", t -> true);
    }

    public void listarPorStatus(Status status) {
        listar("Você não tem Tarefas " + status, t -> t.getStatus() == status);
    }

    public void listarAtrasadas() {
        listar("Você não tem Tarefas Atrasadas", Task::estaAtrasada);
    }

    private int listar(String msgVazio, Predicate<Task> filtro) {
        int cont = 0;
        for (int i = 0; i < tasks.size(); i++) {
            Task t = tasks.get(i);
            if (filtro.test(t)) {
                System.out.println((i + 1) + ". " + t);
                cont++;
            }
        }
        if (cont == 0) {
            System.out.println(msgVazio);
        }
        return cont;
    }

    public boolean existeTarefa() {
        return !tasks.isEmpty();
    }


    public List<Task> getTasks() {
        return Collections.unmodifiableList(tasks);
    }

    private Task escolherTarefa(String mensagem) {
        System.out.println(mensagem);
        listarTodas();
        int indice = lerInt("N°: ") - 1;
        if (indice < 0 || indice >= tasks.size()) {
            pausar("Essa tarefa NÃO existe");
            return null;
        }
        return tasks.get(indice);
    }

    private int lerInt(String prompt) {
        System.out.print(prompt);
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private String lerTexto(String prompt) {
        String texto;
        do {
            System.out.print(prompt);
            texto = sc.nextLine();
        } while (texto.isBlank());
        return texto;
    }

    private LocalDateTime lerPrazo(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return LocalDateTime.parse(sc.nextLine().trim(), Task.FORMATO);
            } catch (DateTimeParseException e) {
                System.out.println("Formato inválido. Exemplo: 25/12/2026 18:30");
            }
        }
    }

    public void pausar(String mensagem) {
        System.out.println(mensagem + " - Aperte enter para voltar ao Menu");
        sc.nextLine();
    }
}