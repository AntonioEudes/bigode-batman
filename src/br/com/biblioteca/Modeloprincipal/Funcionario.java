package br.com.biblioteca.Modeloprincipal;

import java.util.Date;

public class Funcionario extends Pessoa {

    private int id;
    private String cargo;
    private Date dataAdmicao;
    private Endereco enderecoFuncionario = new Endereco();
    private Telefone telefoneFuncionario = new Telefone();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getDataAdmicao() {
        return dataAdmicao;
    }

    public void setDataAdmicao(Date dataAdmicao) {
        this.dataAdmicao = dataAdmicao;
    }

    public Endereco getEnderecoFuncionario() {
        return enderecoFuncionario;
    }

    public void setEnderecoFuncionario(Endereco enderecoFuncionario) {
        this.enderecoFuncionario = enderecoFuncionario;
    }

    public Telefone getTelefoneFuncionario() {
        return telefoneFuncionario;
    }

    public void setTelefoneFuncionario(Telefone telefoneFuncionario) {
        this.telefoneFuncionario = telefoneFuncionario;
    }

    
    

    
}
