package View;

import Controller.TarefaController;
import Model.Tarefa;

import java.util.Scanner;

public class Main {
    private static Scanner scanner;
    private static TarefaController tarefaController;

    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // todas as vezes que precisar usar algo de uma classe, é necessário instanciar ela como objeto
        TarefaController tarefaController = new TarefaController();
        int escolha;
        do {
            System.out.println("--- Menu ---\n" + "1 - Adicionar tarefa\n" + "2 - Listar tarefas\n" + "3 - Excluir tarefas\n" + "0 - Sair\n");
            escolha = scanner.nextInt();
            scanner.nextLine();
            switch (escolha) {
                case 1:
                    System.out.println("Digite o nome da tarefa");
                    String nomeDigitado = scanner.nextLine();
                    System.out.println("Digite a descrição da tarefa");
                    String descricaoDigitada = scanner.nextLine(); // enviando dados para controller.adicionar realizar a ação de adicionar de uma nova tarefa a partir dos dados digitados nos scanners acima
                    tarefaController.adicionarTarefa(nomeDigitado, descricaoDigitada);
                    break;
                case 2:
                    System.out.println(" --- Lista de tarefas --- "); // for-each para mostrar a lista de tarefas
                    for (Tarefa tarefa : tarefaController.getListaDeTarefas()) {
                        System.out.println("nome: " + tarefa.getNome() + " " + "Descrição: " + tarefa.getDescricao());
                    }
                    System.out.println("\n1 - voltar");
                    escolha = scanner.nextInt();
                    break;
                case 3:
                    int i = 1;
                    System.out.println(" --- Lista de tarefas --- "); // for-each para mostrar a lista de tarefas
                    for (Tarefa tarefa : tarefaController.getListaDeTarefas()) {
                        System.out.println(i + " - " + "nome: " + tarefa.getNome() + " " + "Descrição: " + tarefa.getDescricao());
                        i++;
                    }
                    System.out.println("\nDigite a posição da tarefa que deseja excluir: ");
                    int indice = scanner.nextInt() - 1;
                    if (indice >= tarefaController.getListaDeTarefas().size() || indice < 0){
                        System.out.println("\nTarefa não encontrada\n");
                        break;
                    }
                    tarefaController.excluirTarefa(indice);
                    System.out.println("\nTarefa excluída\n");
                    break;
                case 0:
                    System.out.println("Encerrando sistema...");
                    break;
                default:
                    System.out.println("Digite uma opção válida");
                    break;
            }
        } while (escolha != 0);
    }
}