import java.util.Scanner;

public class Controle {
    Scanner sc = new Scanner(System.in);

    private Task[] task;
    private int contaTask;

    public Controle() {
        this.task = new Task[10];
        this.contaTask = 0;
    }

    public void criarTarefa() {
        Task task = new Task("Tarefa", "Descrição");
        System.out.print("Digite o nome da Tarefa: ");
        task.setName(sc.nextLine());
        System.out.print("Digite a descrição da Tarefa: ");
        task.setDescription(sc.nextLine());
        setTask(task);
        System.out.println("Tarefa Salva");
    }

    public void atualizarTarefa() {
        System.out.println("Digite o N° da Tarefa que quer Atualizar");
        listarTasks();
        int tarefaAtulizar = sc.nextInt()-1;
        if (tarefaAtulizar < 0 || tarefaAtulizar >= task.length || task[tarefaAtulizar] == null) {
            System.out.println("Essa tarefa NÃO existe - Aperte enter para voltar ao Menu");
            sc.nextLine();
        }
        else {
            sc.nextLine();
            System.out.print("Digite o novo nome da Tarefa: ");
            task[tarefaAtulizar].setName(sc.nextLine());
            System.out.print("Digite a nova descrição da Tarefa: ");
            task[tarefaAtulizar].setDescription(sc.nextLine());
            System.out.print("Tarefa Atualizada - Aperte enter para voltar ao Menu");
            sc.nextLine();
        }
    }

    public void alterarStatus() {
        System.out.println("Qual o N° da Tarefa que quer Mudar Status: ");
        listarTasks();
        int tarefaAtulizar = sc.nextInt()-1;
        if (tarefaAtulizar < 0 || tarefaAtulizar >= task.length || task[tarefaAtulizar] == null) {
            System.out.println("Essa tarefa NÃO existe - Aperte enter para voltar ao Menu");
            sc.nextLine();
        }
        else {
            System.out.println("Deseja Alterar para qual Status: ");
            System.out.println("1. Não Feita");
            System.out.println("2. Em Progresso");
            System.out.println("3. Feita");
            int acao = sc.nextInt();
            if (acao > 3) {
                System.out.println("Comando Inválido - Aperte enter para voltar ao Menu");
                sc.nextLine();
            }
            else {
                task[tarefaAtulizar].setStatus(acao);
                System.out.println("Status Atualizado - Aperte enter para voltar ao Menu");
                sc.nextLine();
            }
        }
    }

    public void setTask(Task task) {
        this.task[contaTask] = task;
        contaTask++;
    }

    public void listarTasks() {
        int cont = 0;
        for (int i = 0; i < 10; i++) {
            if (task[i] != null) {
                System.out.println((1+i)+". "+ task[i].toString());
                cont++;
            }
        }
        if (cont == 0) {
            System.out.println("Você não tem Tarefas - Aperte enter para voltar ao Menu");
            sc.nextLine();
        }
    }

    public void listarTasksFeitas() {
        int cont = 0;
        for (int i = 0; i < 10; i++) {
            if(task[i] != null && task[i].getStatus().equals("Done")) {
                System.out.println((1+i)+". "+ task[i].toString());
                cont++;
            }
        }
        if (cont == 0) {
            System.out.println("Você não tem Tarefas Feitas - Aperte enter para voltar ao Menu");
            sc.nextLine();
        }
    }

    public void listarTasksEmProgresso() {
        int cont = 0;
        for (int i = 0; i < 10; i++) {
            if(task[i] != null && task[i].getStatus().equals("in Progress")) {
                System.out.println((1+i)+". "+ task[i].toString());
                cont++;
            }
        }
        if (cont == 0) {
            System.out.println("Você não tem Tarefas Em Progresso - Aperte enter para voltar ao Menu");
            sc.nextLine();
        }
    }

    public void listarTasksNaoFeitas() {
        int cont = 0;
        for (int i = 0; i < 10; i++) {
            if(task[i] != null && task[i].getStatus().equals("to Do")) {
                System.out.println((1+i)+". "+ task[i].toString());
                cont++;
            }
        }
        if (cont == 0) {
            System.out.println("Você não tem Tarefas Não Feitas - Aperte enter para voltar ao Menu");
            sc.nextLine();
        }
    }

    public void deletarTasks() {
        System.out.println("Digite o N° da Tarefa que quer Deletar");
        listarTasks();
        int tarefaDeletar = sc.nextInt()-1;
        if (tarefaDeletar < 0 || tarefaDeletar >= task.length || task[tarefaDeletar] == null) {
            System.out.println("Essa tarefa NÃO existe - Aperte enter para voltar ao Menu");
            sc.nextLine();
        }
        else {
            for (int i = tarefaDeletar; i < task.length-1; i++) {
                task[i] = task[i+1];
            }
            task[task.length-1] = null;
            System.out.println("Tarefa Deletada - Aperte enter para voltar ao Menu");
            sc.nextLine();
        }
    }

    public boolean existeTaks() {
        int cont=0;
        for (Task value : task) {
            if (value != null) {
                cont++;
            }
        }
        if (cont == 0) {
            return false;
        }
        return true;
    }
}