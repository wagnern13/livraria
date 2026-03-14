package br.com.wagner.livraria.model;

import java.time.LocalDate;

public class Emprestimo {

    private static int contador = 0;
    private int idEmprestimo;
    private Livro livroEmprestado;
    private String nomeCliente;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo(Livro livroEmprestado, String nomeCliente) {
        this.idEmprestimo = ++contador;
        this.livroEmprestado = livroEmprestado;
        this.nomeCliente = nomeCliente;
        this.dataEmprestimo = LocalDate.now();
    }

    public Livro getLivroEmprestado() {
        return livroEmprestado;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}
