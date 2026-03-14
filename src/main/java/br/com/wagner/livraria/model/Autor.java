package br.com.wagner.livraria.model;

import java.time.LocalDate;

public class Autor {

    private static int contador = 0;

    private int idAutor;
    private String nomeAutor;
    private LocalDate dataNascimento;

    public Autor (String nomeAutor, LocalDate dataNascimento) {
        this.idAutor = ++contador;
        this.nomeAutor = nomeAutor;
        this.dataNascimento = dataNascimento;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
}
