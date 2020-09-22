/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author biiel
 */
public class TelaVenda extends javax.swing.JFrame {

    /**
     * Creates new form Vendas
     */
    private final DecimalFormat DF = new DecimalFormat ("###,##0.00");
    private final DefaultTableModel TABELA_PRODUTOS;
    private final DefaultTableModel TABELA_ESTOQUE;
    private final ArrayList<Pessoa> NOMES;
    private final Erro ERRO = new Erro();
    private final Arquivo ARQUIVO;
    
    private TelaInicial principal;
    private Produto produto;
    private Double saldo;
    private Venda venda;

    public TelaVenda(Arquivo arq) {

        this.ARQUIVO = arq;

        NOMES = ARQUIVO.getPessoas();
        saldo = 0.0;

        initComponents();
        jlNomeFiado.setVisible(false);
        cbNomesFiado.setVisible(false);

        NOMES.forEach((p) -> {
            cbNomesFiado.addItem(p.getNome());
        });

        Iterator<Produto> iterator = ARQUIVO.getEstoque().iterator();
        TABELA_PRODUTOS = (DefaultTableModel) tProdutos.getModel();
        TABELA_ESTOQUE = (DefaultTableModel) tEstoque.getModel();        
        TABELA_ESTOQUE.setNumRows(0); //limpar a tabela
        
        while (iterator.hasNext()) {
            produto = iterator.next();
            String cod = String.valueOf(produto.getCodigo());
            String nom = produto.getNome();
            String valor = String.valueOf(produto.getValor());
            String quant = String.valueOf(produto.getQuantidade());
            TABELA_ESTOQUE.addRow(new String[]{cod, nom, quant, valor});
        }
    }

    public void confirma(TelaInicial confirm) { //retorno da tela inicial, pra salvar corretamente
        this.principal = confirm;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btSelecionar = new javax.swing.JButton();
        jlValorTotal = new javax.swing.JLabel();
        tfPesquisa = new javax.swing.JTextField();
        jlTotal = new javax.swing.JLabel();
        btPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tProdutos = new javax.swing.JTable();
        jlLista = new javax.swing.JLabel();
        cbFiado = new javax.swing.JCheckBox();
        btVenda = new javax.swing.JButton();
        jlNomeFiado = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tEstoque = new javax.swing.JTable();
        btCancelar = new javax.swing.JButton();
        bRemover = new javax.swing.JButton();
        cbNomesFiado = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btSelecionar.setText("Selecionar");
        btSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelecionarActionPerformed(evt);
            }
        });

        jlValorTotal.setText("Valor total da compra");

        jlTotal.setFont(new java.awt.Font("Book Antiqua", 0, 24)); // NOI18N
        jlTotal.setText("R$ 00.00");

        btPesquisar.setText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        tProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome", "Valor"
            }
        ));
        jScrollPane1.setViewportView(tProdutos);
        if (tProdutos.getColumnModel().getColumnCount() > 0) {
            tProdutos.getColumnModel().getColumn(0).setMinWidth(10);
            tProdutos.getColumnModel().getColumn(0).setMaxWidth(20);
        }

        jlLista.setText("Produtos Selecionados:");

        cbFiado.setText("Fiado?");
        cbFiado.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cbFiadoStateChanged(evt);
            }
        });

        btVenda.setText("Confirmar Venda");
        btVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVendaActionPerformed(evt);
            }
        });

        jlNomeFiado.setText("Nome da pessoa:");

        tEstoque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome", "Quantidade", "Valor"
            }
        ));
        jScrollPane3.setViewportView(tEstoque);
        if (tEstoque.getColumnModel().getColumnCount() > 0) {
            tEstoque.getColumnModel().getColumn(0).setMinWidth(10);
            tEstoque.getColumnModel().getColumn(0).setMaxWidth(20);
        }

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        bRemover.setText("Remover");
        bRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlLista)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jlNomeFiado)
                                .addGap(18, 18, 18)
                                .addComponent(cbNomesFiado, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(cbFiado)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bRemover))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                                .addComponent(tfPesquisa)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(26, 26, 26)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btVenda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jlTotal)
                                            .addComponent(jlValorTotal)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(btSelecionar)))
                .addGap(21, 21, 21)
                .addComponent(jlLista)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlValorTotal)
                        .addGap(18, 18, 18)
                        .addComponent(jlTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbFiado)
                    .addComponent(bRemover))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNomeFiado)
                    .addComponent(btCancelar)
                    .addComponent(cbNomesFiado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbFiadoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cbFiadoStateChanged
        if (cbFiado.isSelected()) {
            jlNomeFiado.setVisible(true);
            cbNomesFiado.setVisible(true);
        } else {
            jlNomeFiado.setVisible(false);
            cbNomesFiado.setVisible(false);
        }
    }//GEN-LAST:event_cbFiadoStateChanged

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        //Botão Pesquisar
        String nome = tfPesquisa.getText();

        Iterator<Produto> iterator = ARQUIVO.getEstoque().iterator();
        TABELA_ESTOQUE.setNumRows(0); //limpar a tabela
        
        while (iterator.hasNext()) {
            produto = iterator.next();
            if (produto.getNome().contains(nome)) {
                String cod = String.valueOf(produto.getCodigo());
                String nom = produto.getNome();
                String valor = String.valueOf(produto.getValor());
                String quant = String.valueOf(produto.getQuantidade());
                TABELA_ESTOQUE.addRow(new String[]{cod, nom, valor, quant});
            }
        }
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void btSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelecionarActionPerformed
        //Selecionar os produtos para venda 
        if (tEstoque.getSelectedRow() != -1) {
            produto = ARQUIVO.getProduto(Integer.parseInt(tEstoque.getValueAt(tEstoque.getSelectedRow(), 0).toString()) - 1);            
            if (produto.getQuantidade() > 0){                
                tEstoque.setValueAt(produto.getQuantidade()-1, tEstoque.getSelectedRow(), 2);
                produto.setQuantidade(produto.getQuantidade()-1);
                TABELA_PRODUTOS.addRow(new String[]{String.valueOf(produto.getCodigo()), produto.getNome(), String.valueOf(produto.getValor())});
                this.saldo = saldo + produto.getValor();
                jlTotal.setText(DF.format(saldo)); 
            } else {
                ERRO.erro("Quantidade indisponível", "Produto não disponível no estoque", "atencao");
            }                       
        } else {
            ERRO.erro("Item não selecionado", "Primeiramente selecione um produto", "erro");
        }

    }//GEN-LAST:event_btSelecionarActionPerformed

    private void bRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRemoverActionPerformed
        //Remover um item da lista
        if (tProdutos.getSelectedRow() != -1) {
            produto = ARQUIVO.getProduto(Integer.parseInt(tProdutos.getValueAt(tProdutos.getSelectedRow(), 0).toString()) - 1);
            if (tEstoque.getSelectedRow() != -1 && tEstoque.getValueAt(tEstoque.getSelectedRow(), 1) == tProdutos.getValueAt(tProdutos.getSelectedRow(), 1)){
                tEstoque.setValueAt(produto.getQuantidade()+1, tEstoque.getSelectedRow(), 2);
                produto.setQuantidade(produto.getQuantidade()+1);
                TABELA_PRODUTOS.removeRow(tProdutos.getSelectedRow());
                this.saldo = saldo - produto.getValor();
                jlTotal.setText(DF.format(saldo));
            } else {
                ERRO.erro("Seleção Perdida", "A selecão do item no estoque foi perdida. Clique no produto e tente novamente", "erro");
            }            
        } else {
            ERRO.erro("Item não selecionado", "Primeiramente selecione um valor", "erro");
        }
    }//GEN-LAST:event_bRemoverActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVendaActionPerformed
        //Vender                
        if (TABELA_PRODUTOS.getRowCount() != 0) {
            Date data = new Date();
            System.out.println(data);
            for (int i = 0; i <= TABELA_PRODUTOS.getRowCount() - 1; i++) {
                int cod = Integer.parseInt(TABELA_PRODUTOS.getValueAt(i, 0).toString()); //peguei o codigo da tabela
                produto = ARQUIVO.getProduto(cod - 1); //coloco o produto no número dele

                for (int j = 0; j <= ARQUIVO.getEstoque().size() - 1; j++) {
                    if (produto.getCodigo() == ARQUIVO.getProduto(j).getCodigo()) {
                                        
                        ARQUIVO.edita(produto);
                        
                        venda = new Venda(data, produto.getNome(), produto.getValor());
                        ARQUIVO.adiciona(venda);
                    }
                }
            }
            if (cbFiado.isSelected()) { // se for fiado adiciona o valor na pessoa
                if (ARQUIVO.atualizaSaldo(cbNomesFiado.getSelectedItem().toString(), saldo)) {
                    ERRO.erro("Atualização de Saldo", "Venda FIADO feita com sucesso", "info");
                } 
                principal.vendaRealizada();
            } else { //se não for, aumenta o saldo e registra a venda
                ARQUIVO.adiciona(saldo, "+");
                principal.vendaRealizada();
            }

            this.dispose();
        } else {
            ERRO.erro("Seleção Inválida", "Nenhum produto foi selecionado", "atencao");
        }
    }//GEN-LAST:event_btVendaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bRemover;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btSelecionar;
    private javax.swing.JButton btVenda;
    private javax.swing.JCheckBox cbFiado;
    private javax.swing.JComboBox<String> cbNomesFiado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel jlLista;
    private javax.swing.JLabel jlNomeFiado;
    private javax.swing.JLabel jlTotal;
    private javax.swing.JLabel jlValorTotal;
    private javax.swing.JTable tEstoque;
    private javax.swing.JTable tProdutos;
    private javax.swing.JTextField tfPesquisa;
    // End of variables declaration//GEN-END:variables
}
