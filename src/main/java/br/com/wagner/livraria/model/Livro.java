package br.com.wagner.livraria.model;

import java.time.LocalDate;

public class Livro {

    private static int contador = 0;
    private int idLivro;
    private String tituloLivro;
    private Autor autor;
    private boolean indicadorDisponibilidade;
    private LocalDate dataCadastro;
    private LocalDate dataAtualizacao;

    public Livro(String tituloLivro, Autor autor) {

        this.idLivro = ++contador;
        this.tituloLivro = tituloLivro;
        this.autor = autor;
        this.indicadorDisponibilidade = true;
        this.dataCadastro = LocalDate.now();
    }

    public int getIdLivro() {
        return idLivro;
    }

    public String getTituloLivro() {
        return tituloLivro;
    }

    public Autor getAutor() {
        return autor;
    }

    public boolean getIndicadorDisponibilidade() {
        return indicadorDisponibilidade;
    }

    public void setIndicadorDisponibilidade(boolean indicadorDisponibilidade) {
        this.indicadorDisponibilidade = indicadorDisponibilidade;
    }
}
