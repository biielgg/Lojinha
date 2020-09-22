/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

import java.util.Date;

/**
 *
 * @author biiel
 */
public class Venda {
    
    private String nomeProduto;
    private double valor;
    private Date data;
    
    public Venda(){}
    
    public Venda(Date data, String nProduto, double valor) {
        this.data = data;
        this.nomeProduto = nProduto;
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getProduto() {
        return nomeProduto;
    }

    public void setProduto(String produto) {
        this.nomeProduto = produto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
       
}
