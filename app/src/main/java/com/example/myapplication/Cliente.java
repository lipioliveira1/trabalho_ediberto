package com.example.myapplication;

import java.io.Serializable;



public class Cliente implements Serializable {

    private Integer id;

    private String matricula;

    private String nome;

    private String endereco;

    private String numero;

    private String complemento;

    private String cidade;



    public Cliente() {

        this.id = id;

        this.matricula = matricula;

        this.nome = nome;

        this.endereco = endereco;

        this.numero = numero;

        this.complemento = complemento;

        this.cidade = cidade;

    }



    public Integer getId() {

        return id;

    }



    public void setId(Integer id) {

        this.id = id;

    }



    public String getMatricula() {

        return matricula;

    }



    public void setMatricula(String matricula) {

        this.matricula = matricula;

    }



    public String getNome() {

        return nome;

    }



    public void setNome(String nome) {

        this.nome = nome;

    }



    public String getEndereco() {

        return endereco;

    }



    public void setEndereco(String endereco) {

        this.endereco = endereco;

    }



    public String getNumero() {

        return numero;

    }



    public void setNumero(String numero) {

        this.numero = numero;

    }



    public String getComplemento() {

        return complemento;

    }



    public void setComplemento(String complemento) {

        this.complemento = complemento;

    }



    public String getCidade() {

        return cidade;

    }



    public void setCidade(String cidade) {

        this.cidade = cidade;

    }



    public String toString(){

        return "Nome : " + nome + "\n"+ "Matricula: " + matricula + "\n" + "Endereço: " + endereco + "\n" + "Numero: "+ numero + "\n" + "Complemento: " + complemento + "\n" + "Cidade:"+ cidade;

    }



}