package teste;

import classe.FilaEncadeada;
import classe.ListaEncadeadaSimples;
import classe.Livro;

public class TesteGestaoLivros {
        public static void main(String[] args) {
                System.out.println("=== GERENCIADOR DE LIVROS ===\n");

                ListaEncadeadaSimples<Livro> bibliotecaLista = new ListaEncadeadaSimples<>();
                FilaEncadeada<Livro> bibliotecaFila = new FilaEncadeada<>();

                System.out.println("1) Adicionando livros ao sistema...");
                bibliotecaLista.inserir(new Livro(1, "O Senhor dos Anéis", "Fantasia"));
                bibliotecaLista.inserir(new Livro(2, "1984", "Ficção Científica"));
                bibliotecaLista.inserir(new Livro(3, "Dom Casmurro", "Literatura Brasileira"));
                bibliotecaLista.inserir(new Livro(4, "Harry Potter", "Fantasia"));
                bibliotecaLista.inserir(new Livro(5, "A Revolução dos Bichos", "Ficção Política"));

                bibliotecaFila.enfileirar(new Livro(1, "O Senhor dos Anéis", "Fantasia"));
                bibliotecaFila.enfileirar(new Livro(2, "1984", "Ficção Científica"));
                bibliotecaFila.enfileirar(new Livro(3, "Dom Casmurro", "Literatura Brasileira"));
                bibliotecaFila.enfileirar(new Livro(4, "Harry Potter", "Fantasia"));
                bibliotecaFila.enfileirar(new Livro(5, "A Revolução dos Bichos", "Ficção Política"));

                System.out.println("Cadastro concluído!\n");

                System.out.println("2) Exibindo todos os registros:");
                System.out.println("\n--- Conteúdo da Lista ---");
                bibliotecaLista.listar();
                System.out.println("\n--- Conteúdo da Fila ---");
                bibliotecaFila.listar();

                System.out.println("\n3) Realizando buscas com medição de tempo:");

                System.out.println("\n--- Busca por ID (ID = 3) ---");
                long inicioLista = System.nanoTime();
                Livro achadoLista = bibliotecaLista.buscar(3);
                long fimLista = System.nanoTime();
                long tempoLista = fimLista - inicioLista;

                long inicioFila = System.nanoTime();
                Livro achadoFila = bibliotecaFila.buscar(3);
                long fimFila = System.nanoTime();
                long tempoFila = fimFila - inicioFila;

                System.out.println("Na Lista: " + (achadoLista != null ? achadoLista.toString() : "Não encontrado"));
                System.out.println("Tempo (Lista): " + tempoLista + " ns");
                System.out.println("Na Fila: " + (achadoFila != null ? achadoFila.toString() : "Não encontrado"));
                System.out.println("Tempo (Fila): " + tempoFila + " ns");

                System.out.println("\n--- Busca por Nome (Nome = 'Harry Potter') ---");
                inicioLista = System.nanoTime();
                achadoLista = bibliotecaLista.buscar("Harry Potter");
                fimLista = System.nanoTime();
                tempoLista = fimLista - inicioLista;

                inicioFila = System.nanoTime();
                achadoFila = bibliotecaFila.buscar("Harry Potter");
                fimFila = System.nanoTime();
                tempoFila = fimFila - inicioFila;

                System.out.println("Na Lista: " + (achadoLista != null ? achadoLista.toString() : "Não encontrado"));
                System.out.println("Tempo (Lista): " + tempoLista + " ns");
                System.out.println("Na Fila: " + (achadoFila != null ? achadoFila.toString() : "Não encontrado"));
                System.out.println("Tempo (Fila): " + tempoFila + " ns");

                System.out.println("\n4) Testando remoções:");

                System.out.println("\n--- Removendo posição 2 da Lista ---");
                Livro excluidoLista = bibliotecaLista.remover(2);
                System.out.println("Removido da Lista: " + (excluidoLista != null ? excluidoLista.toString() : "Nenhum"));

                System.out.println("\n--- Removendo primeiro da Fila ---");
                Livro excluidoFila = bibliotecaFila.desenfileirar();
                System.out.println("Removido da Fila: " + (excluidoFila != null ? excluidoFila.toString() : "Nenhum"));

                System.out.println("\n5) Estruturas após remoções:");
                System.out.println("\n--- Lista atualizada ---");
                bibliotecaLista.listar();
                System.out.println("\n--- Fila atualizada ---");
                bibliotecaFila.listar();

                System.out.println("\n6) Relatório Final:");
                System.out.println("Itens na Lista: " + bibliotecaLista.tamanho());
                System.out.println("Itens na Fila: " + bibliotecaFila.tamanho());
                System.out.println("Lista está vazia? " + bibliotecaLista.vazia());
                System.out.println("Fila está vazia? " + bibliotecaFila.vazia());

                System.out.println("\n=== EXECUÇÃO FINALIZADA ===");
        }
}
