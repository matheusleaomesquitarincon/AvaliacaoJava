package classe;

import iClasse.IListaEncadeada;

public class ListaEncadeadaSimples<T> implements IListaEncadeada<T> {
    private No<T> primeiro;
    private No<T> ultimo;
    private int tamanho;

    public ListaEncadeadaSimples() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    @Override
    public void inserir(T elemento) {
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
    public T remover(int indice) {
        if (vazia() || indice < 0 || indice >= tamanho) {
            return null;
        }

        T elementoRemovido;

        if (indice == 0) {
            elementoRemovido = primeiro.getElemento();
            primeiro = primeiro.getProximo();
            if (primeiro == null) {
                ultimo = null;
            }
        } else {
            No<T> atual = primeiro;
            for (int i = 0; i < indice - 1; i++) {
                atual = atual.getProximo();
            }
            elementoRemovido = atual.getProximo().getElemento();
            atual.setProximo(atual.getProximo().getProximo());
            if (atual.getProximo() == null) {
                ultimo = atual;
            }
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
            System.out.println("⚠️ Nenhum item cadastrado na lista.");
            return;
        }

        No<T> atual = primeiro;
        int indice = 0;
        System.out.println("📚 Exibindo elementos da lista:");
        while (atual != null) {
            System.out.println("Posição " + indice + " → " + atual.getElemento().toString());
            atual = atual.getProximo();
            indice++;
        }
    }
}
