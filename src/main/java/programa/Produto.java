/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

/**
 *
 * @author biiel
 */
public class Produto {
    
    private int codigo;
    private String nome;
    private double valor;
    private int quantidade;
    
    public Produto () {} //pra poder instanciar antes de ter valores

    public Produto(int codigo, String nome, double valor, int quantidade) {
        this.nome = nome;    
        this.valor = valor;
        this.codigo = codigo;
        this.quantidade = quantidade;        
    }
    
    public int getCodigo() {
        return codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
       
}
