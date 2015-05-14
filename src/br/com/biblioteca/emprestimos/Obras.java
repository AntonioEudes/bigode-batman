package br.com.biblioteca.emprestimos;

import java.sql.Date;

import br.com.biblioteca.Modeloprincipal.Aluno;
import br.com.biblioteca.Modeloprincipal.Funcionario;

public class Obras {

    private String titulo;
    private String ano;
    private String area;
    //private Emprestimo emprestimo;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    //public Emprestimo getEmprestimo() {
      //  return emprestimo;
    //}

    //public void setEmprestimo(Emprestimo emprestimo) {
     //   this.emprestimo = emprestimo;
    //}

   
}
