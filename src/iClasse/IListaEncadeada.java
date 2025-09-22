package iClasse;

public interface IListaEncadeada<T> {
    void inserir(T elemento);

    T remover(int indice);

    T buscar(int id);

    T buscar(String nome);

    boolean vazia();

    int tamanho();

    void listar();
}
