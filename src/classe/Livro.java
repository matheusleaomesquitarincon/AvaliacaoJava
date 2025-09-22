package classe;

import iClasse.ILivro;

public class Livro implements ILivro {
    private final int id;
    private String nome;
    private String categoria;

    public Livro(int id, String nome, String categoria) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getCategoria() {
        return categoria;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Categoria: " + categoria;
    }
}
