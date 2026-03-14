package br.com.wagner.livraria.service;

import br.com.wagner.livraria.model.Autor;
import br.com.wagner.livraria.model.Biblioteca;
import br.com.wagner.livraria.model.Emprestimo;
import br.com.wagner.livraria.model.Livro;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BibliotecaService {

    private Biblioteca biblioteca;

    public BibliotecaService(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void cadastrarLivro(String titulo, Autor autor) {
        Livro livro = new Livro(titulo, autor);
        biblioteca.getLivros().add(livro);
        biblioteca.getAutores().add(autor);
    }

    public void listarLivros() {

        List<Livro> livros = biblioteca.getLivros();

        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado \n");
            return;
        }

        boolean temLivroDisponivel = false;

        for (Livro livro : livros) {
            if (livro.getIndicadorDisponibilidade()) {
                temLivroDisponivel = true;
                System.out.println("ID: " + livro.getIdLivro()
                + " | Título: " + livro.getTituloLivro()
                + " | Autor: " + livro.getAutor().getNomeAutor());
            }
        }

        if (!temLivroDisponivel) {
            System.out.println("Todos os livros estão emprestados \n");
        }
    }

    public void emprestarLivro(int idLivro, String nomeCliente) {

        List<Livro> livros = biblioteca.getLivros();

        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado \n");
            return;
        }

        Livro livroEncontrado = null;

        for (Livro livro : livros) {
            if (livro.getIdLivro() == idLivro) {
                livroEncontrado = livro;
                break;
            }
        }

        if (livroEncontrado == null) {
            System.out.println("ID informado não encontrado \n");
            return;
        }

        if (livroEncontrado.getIndicadorDisponibilidade()) {
            registrarEmprestimo(livroEncontrado, nomeCliente);
            System.out.println("Empréstimo efetuado com sucesso \n");
        } else {
            System.out.println("Livro indisponivel para empréstimo \n");
        }
    }

    private void registrarEmprestimo(Livro livroEmprestado, String nomeCliente) {

        livroEmprestado.setIndicadorDisponibilidade(false);
        Emprestimo emprestimo = new Emprestimo(livroEmprestado, nomeCliente);
        biblioteca.getEmprestimos().add(emprestimo);
    }

    public void devolverLivro(int idLivro) {

        List<Emprestimo> emprestimos = biblioteca.getEmprestimos();

        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum livro aguardando devolucao \n");
            return;
        }

        Emprestimo devolucaoLivro = null;

        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getLivroEmprestado().getIdLivro() == idLivro) {
                devolucaoLivro = emprestimo;
                break;
            }
        }

        if (devolucaoLivro == null) {
            System.out.println("ID informado não foi encontrado \n");
            return;
        }

        if (devolucaoLivro.getLivroEmprestado().getIndicadorDisponibilidade()) {
            System.out.println("ID informado não pertence ao livro emprestado \n");
            return;
        }

        devolucaoLivro.getLivroEmprestado().setIndicadorDisponibilidade(true);
        devolucaoLivro.setDataDevolucao(LocalDate.now());
        System.out.printf("Titulo '%S' do autor %s, devolvido em %td/%tm/%tY \n\n"
                        , devolucaoLivro.getLivroEmprestado().getTituloLivro()
                        , devolucaoLivro.getLivroEmprestado().getAutor().getNomeAutor()
                        , devolucaoLivro.getDataDevolucao()
                        , devolucaoLivro.getDataDevolucao()
                        , devolucaoLivro.getDataDevolucao());
    }
    public void listarLivrosEmprestados() {

        List<Emprestimo> emprestimos = biblioteca.getEmprestimos();

        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum livro aguardando devolucao \n");
            return;
        }

        boolean temLivroEmprestado = false;

        for (Emprestimo emprestimo : emprestimos) {
            if (!emprestimo.getLivroEmprestado().getIndicadorDisponibilidade()) {
                temLivroEmprestado = true;
                DateTimeFormatter formataData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                System.out.println("ID: " + emprestimo.getLivroEmprestado().getIdLivro()
                        + " | Título: " + emprestimo.getLivroEmprestado().getTituloLivro()
                        + " | Autor: " + emprestimo.getLivroEmprestado().getAutor().getNomeAutor()
                        + " | Cliente: " + emprestimo.getNomeCliente()
                        + " | Data emprestimo: " + formataData.format(emprestimo.getDataEmprestimo()));
            }
        }

        if (!temLivroEmprestado) {
            System.out.println("Nenhum livro emprestado no momento \n");
        }
    }
}
