/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author biiel
 */
public class EditEstoque extends javax.swing.JFrame {

    /**
     * Creates new form EditEstoque
     */    
    private String funcao;
    private Arquivo arquivo;    
    private Erro erro = new Erro();

    public EditEstoque(Arquivo arq, String func) {
        initComponents();
        this.arquivo = arq;
        this.funcao = func;

        Iterator<Produto> iterator = arquivo.getEstoque().iterator();
        DefaultTableModel tabel = (DefaultTableModel) tabela.getModel();
        while (iterator.hasNext()) {
            Produto produto = iterator.next();
            tabel.addRow(new String[]{String.valueOf(produto.getCodigo()), produto.getNome()});
        }

        switch (funcao) {
            case "+":                
                tfNome.setVisible(false);
                txtNome.setVisible(false);
                btPesquisar.setVisible(false);
                btSelecionar.setVisible(false);
                btSalvar.setText("ADICIONAR");
                break;
            
            case "=":
                btSalvar.setText("EDITAR");
                break;
            
            case "-":               
                tfNome2.setVisible(false);
                tfValor.setVisible(false);
                txtNome2.setVisible(false);
                txtValor.setVisible(false);
                btSelecionar.setVisible(false);
                tfQuantidade.setVisible(false);
                txtQuantidade.setVisible(false);
                btSalvar.setText("REMOVER");
                break;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNome = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        btPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        btSelecionar = new javax.swing.JButton();
        txtNome2 = new javax.swing.JLabel();
        txtValor = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JLabel();
        tfNome2 = new javax.swing.JTextField();
        tfValor = new javax.swing.JTextField();
        tfQuantidade = new javax.swing.JTextField();
        btSalvar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtNome.setText("Nome:");
        txtNome.setToolTipText("");

        btPesquisar.setText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setResizable(false);
        }

        btSelecionar.setText("Selecionar");
        btSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelecionarActionPerformed(evt);
            }
        });

        txtNome2.setText("NOME");

        txtValor.setText("VALOR");

        txtQuantidade.setText("QUANTIDADE");

        tfValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfValorKeyTyped(evt);
            }
        });

        tfQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfQuantidadeKeyTyped(evt);
            }
        });

        btSalvar.setText("SALVAR");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btCancelar.setText("CANCELAR");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNome)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtNome2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtValor)
                        .addGap(99, 99, 99)
                        .addComponent(txtQuantidade))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfNome2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfValor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btPesquisar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btSelecionar)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome2)
                    .addComponent(txtValor)
                    .addComponent(txtQuantidade))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNome2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar)
                    .addComponent(btCancelar))
                .addGap(68, 68, 68))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed

        String nome = tfNome.getText();
        Iterator<Produto> iterator = arquivo.getEstoque().iterator();
        DefaultTableModel tabel = (DefaultTableModel) tabela.getModel();
        tabel.setNumRows(0); //limpar a tabela
        while (iterator.hasNext()) {
            Produto produto = iterator.next();
            if (produto.getNome().contains(nome)) {
                tabel.addRow(new String[]{String.valueOf(produto.getCodigo()), produto.getNome()});
            }
        }
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void btSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelecionarActionPerformed
        //O produto recebe o valor selecionado na tabela -1, já que se inicia em 0

        if (tabela.getSelectedRow() != -1) {
            Produto prod = arquivo.getProduto(Integer.parseInt(tabela.getValueAt(tabela.getSelectedRow(), 0).toString()) - 1); 

            tfNome2.setText(prod.getNome());
            tfQuantidade.setText(String.valueOf(prod.getQuantidade()));
            tfValor.setText(String.valueOf(prod.getValor()));
        } else {
            erro.erro("Item não selecionado", "Primeiramente selecione um valor", "erro");
        }
    }//GEN-LAST:event_btSelecionarActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        Produto prod = new Produto();
        
        switch (funcao) {
            
            case "+":
                if (!tfNome2.getText().isBlank() && !tfValor.getText().isBlank() && !tfQuantidade.getText().isBlank()) {

                    prod.setNome(tfNome2.getText());
                    prod.setValor(Double.parseDouble(tfValor.getText()));
                    prod.setQuantidade(Integer.parseInt(tfQuantidade.getText()));

                    arquivo.adiciona(prod);
                    this.dispose();
                } else {
                    erro.erro("Campos em Branco", "Insira todas as informações para o cadastro", "erro");
                }
            break;
                
            case "=":
                prod = arquivo.getProduto(Integer.parseInt(tabela.getValueAt(tabela.getSelectedRow(), 0).toString()) - 1);

                if (!tfNome2.getText().isBlank() && !tfValor.getText().isBlank() && !tfQuantidade.getText().isBlank() && tabela.getSelectedRow() != -1) {

                    prod.setNome(tfNome2.getText());
                    prod.setQuantidade(Integer.parseInt(tfQuantidade.getText()));
                    prod.setValor(Double.parseDouble(tfValor.getText()));                    
                    arquivo.edita(prod);
                    erro.erro("Edição realizada", "Edição feita com sucesso!", "info");
                    
                    Object[] options = {"Sim", "Não"};
                    int teste = JOptionPane.showOptionDialog(this, "Deseja editar mais feitos?", "Nova edição", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    
                    switch (teste) {
                        case 0: //Sim
                            tfNome2.setText("");
                            tfQuantidade.setText("");
                            tfValor.setText("");
                            break;
                        case 1: //Não
                            this.dispose();
                        case -1: //Fechar
                            this.dispose();
                    }
                } else {
                    erro.erro("Campos em Branco", "Insira todas as informações para o cadastro", "erro");
                }
            break;
                
            case "-":
                if (tabela.getSelectedRow() != -1) {
                    prod = arquivo.getProduto(Integer.parseInt(tabela.getValueAt(tabela.getSelectedRow(), 0).toString()) - 1);
                    arquivo.remove(prod);
                    this.dispose();
                } else {
                    erro.erro("Selecão não realizada", "Selecione um produto para excluir", "erro");
                }
            break;
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void tfValorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfValorKeyTyped
        String caracteres = "0987654321.";
        if (!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }
    }//GEN-LAST:event_tfValorKeyTyped

    private void tfQuantidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfQuantidadeKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }
    }//GEN-LAST:event_tfQuantidadeKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JButton btSelecionar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfNome2;
    private javax.swing.JTextField tfQuantidade;
    private javax.swing.JTextField tfValor;
    private javax.swing.JLabel txtNome;
    private javax.swing.JLabel txtNome2;
    private javax.swing.JLabel txtQuantidade;
    private javax.swing.JLabel txtValor;
    // End of variables declaration//GEN-END:variables
}
