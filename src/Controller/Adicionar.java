package Controller;

import Model.Tarefa;  // import da classe tarefa do model

import java.util.ArrayList; // import da javaclass arraylist

public class Adicionar {

    ArrayList<Tarefa> listaDeTarefas = new ArrayList<>(); // criação do arraylist listaDeTarefas

    // criação da ação de adicionar uma nova tarefa nova
    public void adicionarTarefa(String nome, String descricao) {
        Tarefa novaTarefa = new Tarefa(nome, descricao);
        listaDeTarefas.add(novaTarefa);
    }

    // getter para utilizar a lista de tarefas em outras classes
    public ArrayList<Tarefa> getListaDeTarefas() {
        return listaDeTarefas;
    }
}
