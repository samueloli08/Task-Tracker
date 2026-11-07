package aplication;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Controle controle = new Controle(sc);

        while (true) {
            System.out.println("------------------------");
            System.out.println("TELA DE COMANDO");
            System.out.println("------------------------");
            System.out.println("Digite o N° da Ação Desejada");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Atualizar Tarefa");
            System.out.println("3. Alterar Status de Tarefa");
            System.out.println("4. Listar Todas as Tarefas");
            System.out.println("5. Listar Tarefas Feitas");
            System.out.println("6. Listar Tarefas Em Progresso");
            System.out.println("7. Listar Tarefas Não Feitas");
            System.out.println("8. Deletar Tarefa");
            System.out.println("9. Listar Tarefas Atrasadas");
            System.out.println("0. Sair");
            System.out.println("------------------------");
            System.out.print("Opção: ");

            String entrada = sc.nextLine().trim();
            int acao;
            try {
                acao = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                controle.pausar("Comando Inválido");
                continue;
            }

            switch (acao) {
                case 0 -> {
                    System.out.println("Até logo!");
                    return;
                }
                case 1 -> controle.criarTarefa();
                case 2, 3, 8 -> {
                    if (!controle.existeTarefa()) {
                        controle.pausar("Você não tem nenhuma Tarefa");
                    } else if (acao == 2) {
                        controle.atualizarTarefa();
                    } else if (acao == 3) {
                        controle.alterarStatus();
                    } else {
                        controle.deletarTarefa();
                    }
                }
                case 4 -> controle.listarTodas();
                case 5 -> controle.listarPorStatus(Status.FEITA);
                case 6 -> controle.listarPorStatus(Status.EM_PROGRESSO);
                case 7 -> controle.listarPorStatus(Status.A_FAZER);
                case 9 -> controle.listarAtrasadas();
                default -> controle.pausar("Comando Inválido");
            }
        }
    }
}