package br.com.biblioteca.Modeloprincipal;


public class Aluno extends Pessoa {

    private String matricula;
    private String periodo;
    private String curso;
    private int id;
    private Endereco enderecoAluno = new Endereco();
    private Telefone telefoneAluno = new Telefone();

    public Aluno() {

    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Endereco getEnderecoAluno() {
        return enderecoAluno;
    }

    public void setEnderecoAluno(Endereco enderecoAluno) {
        this.enderecoAluno = enderecoAluno;
    }

    public Telefone getTelefoneAluno() {
        return telefoneAluno;
    }

    public void setTelefoneAluno(Telefone telefoneAluno) {
        this.telefoneAluno = telefoneAluno;
    }

    

}
