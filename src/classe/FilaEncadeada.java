package classe;

import iClasse.IFilaEncadeada;

public class FilaEncadeada<T> implements IFilaEncadeada<T> {
    private No<T> primeiro;
    private No<T> ultimo;
    private int tamanho;

    public FilaEncadeada() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    @Override
    public void enfileirar(T elemento) {
        No<T> novoNo = new No<>(elemento);

        if (vazia()) {
            primeiro = novoNo;
            ultimo = novoNo;
        } else {
            ultimo.setProximo(novoNo);
            ultimo = novoNo;
        }
        tamanho++;
    }

    @Override
    public T desenfileirar() {
        if (vazia()) {
            return null;
        }

        T elementoRemovido = primeiro.getElemento();
        primeiro = primeiro.getProximo();

        if (primeiro == null) {
            ultimo = null;
        }

        tamanho--;
        return elementoRemovido;
    }

    @Override
    public T buscar(int id) {
        No<T> atual = primeiro;
        while (atual != null) {
            if (atual.getElemento() instanceof Livro livro) {
                if (livro.getId() == id) {
                    return atual.getElemento();
                }
            }
            atual = atual.getProximo();
        }
        return null;
    }

    @Override
    public T buscar(String nome) {
        No<T> atual = primeiro;
        while (atual != null) {
            if (atual.getElemento() instanceof Livro livro) {
                if (livro.getNome().equals(nome)) {
                    return atual.getElemento();
                }
            }
            atual = atual.getProximo();
        }
        return null;
    }

    @Override
    public boolean vazia() {
        return tamanho == 0;
    }

    @Override
    public int tamanho() {
        return tamanho;
    }

    @Override
    public void listar() {
        if (vazia()) {
            System.out.println("Fila vazia.");
            return;
        }

        No<T> atual = primeiro;
        int posicao = 0;
        while (atual != null) {
            System.out.println("Posição " + posicao + ": " + atual.getElemento().toString());
            atual = atual.getProximo();
            posicao++;
        }
    }
}
