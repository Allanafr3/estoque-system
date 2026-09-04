package br.com.allan.estoque.model;

public class Produto {
   private String nome;
   private double preco;
   private int id;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public double getPreco(){
        return preco;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

}