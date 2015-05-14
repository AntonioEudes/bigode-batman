package br.com.biblioteca.emprestimos;

public class Monografia extends Obras {

    private int id;
    private String autor;
    private String orientador;

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getOrientador() {
        return orientador;
    }

    public void setOrientador(String orientador) {
        this.orientador = orientador;
    }

    public String toString() {
        return "Monografia [id=" + id + ", autor=" + autor + ", orientador="
                + orientador + "]";
    }

}
