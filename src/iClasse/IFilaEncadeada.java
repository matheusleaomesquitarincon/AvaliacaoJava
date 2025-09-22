package iClasse;

public interface IFilaEncadeada<T> {
    void enfileirar(T elemento);

    T desenfileirar();

    T buscar(int id);

    T buscar(String nome);

    boolean vazia();

    int tamanho();

    void listar();
}
