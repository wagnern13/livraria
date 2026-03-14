package br.com.wagner.livraria.ui;

import br.com.wagner.livraria.model.Autor;
import br.com.wagner.livraria.model.Biblioteca;
import br.com.wagner.livraria.service.BibliotecaService;

import java.time.LocalDate;
import java.util.Scanner;

public class Menu {

    public Menu() {
    }

    public void menuPrincipal() {

        Autor autor1 = new Autor("Autor 1", LocalDate.of(1970,1,15));
        Autor autor2 = new Autor("Autor 2", LocalDate.of(1971,2,16));
        Autor autor3 = new Autor("Autor 3", LocalDate.of(1972,3,17));

        Biblioteca biblioteca = new Biblioteca();
        BibliotecaService service = new BibliotecaService(biblioteca);

        service.cadastrarLivro("Livros 1", autor1);
        service.cadastrarLivro("Livros 2", autor2);
        service.cadastrarLivro("Livros 3", autor3);

        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 5) {

            System.out.println("01 - Livros Disponiveis");
            System.out.println("02 - Emprestar Livro");
            System.out.println("03 - Livros Emprestados");
            System.out.println("04 - Devolver Livro");
            System.out.println("05 - Sair \n" );
            System.out.println("Entre com a opção desejada: ");

            if (sc.hasNextInt()) {
                opcao = sc.nextInt();
            } else {
                opcao = 0;
                sc.next();
            }

            switch (opcao) {
                case 1: {
                    service.listarLivros();
                    System.out.println(" ");
                    break;
                }
                case 2: {
                    int idLivro;
                    String nomeCliente;

                    System.out.println("Informe o ID do livro: ");

                    if (sc.hasNextInt()) {
                        idLivro = sc.nextInt();
                        sc.nextLine();
                    } else {
                        System.out.println("ID informado é inválido");
                        opcao = 0;
                        sc.next();
                        break;
                    }

                    do {
                        System.out.println(("Informe seu nome: "));
                        nomeCliente = sc.nextLine().trim();

                        if (nomeCliente.isEmpty()) {
                            System.out.println("Nome inválid. Informe um nome valido. ");
                        }
                    } while (nomeCliente.isEmpty());

                    service.emprestarLivro(idLivro, nomeCliente);
                    break;
                }
                case 3: {
                    service.listarLivrosEmprestados();
                    System.out.println(" ");
                    break;
                }
                case 4: {
                    int idLivro;

                    System.out.println("Informe do ID do livro que está sendo devolvido: ");

                    if (sc.hasNextInt()) {
                        idLivro = sc.nextInt();
                        sc.nextLine();
                        service.devolverLivro(idLivro);
                    } else {
                        System.out.println("ID informado é inválido");
                        opcao = 0;
                        sc.next();
                    }

                    break;
                }
                case 5: {
                    System.out.println("Obrigado por utilizar o nosso sistema. Volte sempre!!!");
                    break;
                }
                default: {
                    System.out.println("Opção invalida");
                }
            }
        }
        sc.close();
    }
}
