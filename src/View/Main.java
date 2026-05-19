package View;

import Controller.Adicionar;
import Model.Tarefa;

import java.util.Scanner;

public class Main {
    static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // todas as vezes que precisar usar algo de uma classe, é necessário instanciar ela como objeto
        Adicionar adicionar = new Adicionar();

        int escolha;

        do {
            System.out.println(
                    "--- Menu ---\n" +
                    "1 - Adicionar tarefa\n" +
                    "2 - Listar tarefas\n" +
                    "3 - Excluir tarefas\n" +
                    "0 - Sair\n"
            );
            escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    System.out.println("Digite o nome da tarefa");
                    String nomeDigitado = scanner.nextLine();

                    System.out.println("Digite a descrição da tarefa");
                    String descricaoDigitada = scanner.nextLine();

                    // enviando dados para controller.adicionar realizar a ação de adicionar de uma nova tarefa a partir dos dados digitados nos scanners acima
                    adicionar.adicionarTarefa(nomeDigitado, descricaoDigitada);

                    break;
                case 2:

                    // for-each para mostrar a lista de tarefas
                    for (Tarefa listaDeTarefas : adicionar.getListaDeTarefas()){
                        System.out.println(
                                " --- lista de tarefas --- \n\n" +
                                "nome: " + listaDeTarefas.getNome() + "\n" +
                                "Descrição: " + listaDeTarefas.getDescricao() + "\n\n"
                        );

                    }
                    System.out.println("\n1 - voltar");
                    escolha = scanner.nextInt();

                    break;
                case 3:
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
