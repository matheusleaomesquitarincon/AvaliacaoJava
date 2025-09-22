package iClasse;

public interface ILivro {
    int getId();

    String getNome();

    String getCategoria();

    void setNome(String nome);

    void setCategoria(String categoria);

    @Override
    String toString();
}
