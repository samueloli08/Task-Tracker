import java.util.Scanner;

void main() {
    Scanner sc = new Scanner(System.in);

    Controle controle = new Controle();

    while(true) {
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
        System.out.println("------------------------");

        int acao = sc.nextInt();

        if (acao == 1) {
            controle.criarTarefa();
        }
        else if (acao == 2) {
            if (!controle.existeTaks()) {
                System.out.println("Você não tem nenhuma Tarefa");
            }
            else {
                controle.atualizarTarefa();
            }
        }
        else if (acao == 3) {
            if (!controle.existeTaks()) {
                System.out.println("Você não tem nenhuma Tarefa");
            }
            else {
                controle.alterarStatus();
            }
        }
        else if (acao == 4) {
            controle.listarTasks();
        }
        else if (acao == 5) {
            controle.listarTasksFeitas();
        }
        else if (acao == 6) {
            controle.listarTasksEmProgresso();
        }
        else if (acao == 7) {
            controle.listarTasksNaoFeitas();
        }
        else if (acao == 8) {
            if (!controle.existeTaks()) {
                System.out.println("Você não tem nenhuma Tarefa");
            }
            else {
                controle.deletarTasks();
            }
        }
        else {
            System.out.println("Comando Inválido - Aperte enter para voltar ao Menu");
            sc.nextLine();
        }
    }
}