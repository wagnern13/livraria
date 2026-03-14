📚 Sistema de Livraria (Java Básico)

Este é um projeto simples desenvolvido em Java puro, sem Maven ou Gradle, com o objetivo de praticar lógica de programação, orientação a objetos e organização de código.
O sistema permite gerenciar livros, empréstimos e devoluções através de um menu interativo no console.

▶️ Funcionalidades do Sistema

O menu principal apresenta as seguintes opções:
```
01 - Livros Disponiveis
02 - Emprestar Livro
03 - Livros Emprestados
04 - Devolver Livro
05 - Sair

Entre com a opção desejada:
```
✔️ Descrição das opções

- 01 - Livros Disponíveis  
Lista todos os livros cadastrados que estão com indicador de disponibilidade igual a true.
 
- 02 - Emprestar Livro  
Solicita o ID do livro e o nome do cliente.
Se o livro estiver disponível, registra o empréstimo e marca o livro como indisponível.

- 03 - Livros Emprestados  
Exibe todos os empréstimos ativos, mostrando livro, cliente e data do empréstimo.

- 04 - Devolver Livro  
Solicita o ID do livro emprestado, registra a devolução e marca o livro como disponível novamente.

- 05 - Sair  
Encerra o programa.
 
---

🧱 Estrutura do Projeto

```
livraria/
├── src/
│    └── main/
│         └── java/
│              └── br/com/wagner/livraria/
│                   ├── application/   # Classe principal (Main)
│                   ├── model/         # Entidades: Livro, Emprestimo
│                   ├── service/       # Regras de negócio
│                   └── ui/            # Interface de console (menus)
├── .gitignore
├── livraria.iml
└── README.md
```
---
🛠️ Tecnologias Utilizadas

- Java 17+
- IntelliJ IDEA
- Git / GitHub

---
▶️ Como executar

1. Clone o repositório:

```
git clone https://github.com/SEU_USUARIO/livraria.git
```
2. Abra o projeto no IntelliJ IDEA

3. Execute a classe Main localizada em:

```
br.com.wagner.livraria.application
```
---
📌 Possíveis melhorias futuras

- Persistência em arquivo (JSON, CSV ou TXT)

- Persistência em banco de dados

- Interface gráfica (JavaFX)

- Cadastro de clientes como entidade separada
---

👨‍💻 Autor

Projeto desenvolvido por Wagner como parte do exercício proposto no curso de Fundamentos JAVA da Rocketseat.