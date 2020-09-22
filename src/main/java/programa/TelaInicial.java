package programa;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author biiel
 */
public class TelaInicial extends javax.swing.JFrame {

    /**
     * Creates new form TelaInicial
     */
    private final DecimalFormat DF = new DecimalFormat ("###,##0.00");
    private final Erro ERRO = new Erro();
    private final AbrirCaixa ABRE_CAIXA;        
    private final Arquivo ARQUIVO;
    
    private EditEstoque editaEstoque;
    private EditPessoa editaPessoa;
    private ViewPessoas pessoas;
    private Pagamento pagamento;
    private ViewEstoque view;   
    private TelaVenda venda;
    
    private double saldoInicial = 0;
    private double saldoFinal = 0;
    private int virgula;

    public TelaInicial() throws IOException {

        initComponents();

        ARQUIVO = new Arquivo();
        ABRE_CAIXA = new AbrirCaixa(ARQUIVO);
        
        txtValorCaixa.setVisible(false);
        btFecharCaixa.setVisible(false);
        txtSaldo.setVisible(false);
        btVender.setVisible(false);        
        mCaixa.setVisible(false);        
        
        ARQUIVO.adiciona("- aplicativo aberto");

        this.setLocationRelativeTo(null);
    }

    public void iniciarCaixa() {

        txtValorCaixa.setVisible(true);        
        btFecharCaixa.setVisible(true);
        btVender.setVisible(true);
        txtSaldo.setVisible(true);
        mCaixa.setVisible(true);       
        
        saldoInicial = ARQUIVO.getSaldoAtual();
        txtSaldo.setText(String.valueOf(saldoInicial));
        
        ARQUIVO.adiciona("- função iniciar caixa");
    }

    public void vendaRealizada() {
        txtSaldo.setText(String.valueOf(ARQUIVO.getSaldoAtual()));
    }
    
    public boolean testeCaracteres(String texto){
        return texto.matches("[^\\d]+");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btAbrirCaixa = new javax.swing.JButton();
        btVender = new javax.swing.JButton();
        txtSaldo = new javax.swing.JLabel();
        txtValorCaixa = new javax.swing.JLabel();
        btFecharCaixa = new javax.swing.JButton();
        btReceber = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        mEstoque = new javax.swing.JMenu();
        miAdicionarEstoque = new javax.swing.JMenuItem();
        miEditarEstoque = new javax.swing.JMenuItem();
        miRemoverEstoque = new javax.swing.JMenuItem();
        mPessoas = new javax.swing.JMenu();
        miAdicionarPessoa = new javax.swing.JMenuItem();
        miEditarPessoa = new javax.swing.JMenuItem();
        miRemoverPessoa = new javax.swing.JMenuItem();
        mRelatorios = new javax.swing.JMenu();
        miRelatorioEstoque = new javax.swing.JMenuItem();
        miRelatorioPessoas = new javax.swing.JMenuItem();
        mCaixa = new javax.swing.JMenu();
        miAdicionarCaixa = new javax.swing.JMenuItem();
        miRemoverCaixa = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btAbrirCaixa.setText("ABRIR CAIXA");
        btAbrirCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAbrirCaixaActionPerformed(evt);
            }
        });

        btVender.setText("VENDER");
        btVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVenderActionPerformed(evt);
            }
        });

        txtSaldo.setFont(new java.awt.Font("Book Antiqua", 0, 36)); // NOI18N
        txtSaldo.setText("Saldo");

        txtValorCaixa.setText("Valor em Caixa");

        btFecharCaixa.setText("FECHAR CAIXA");
        btFecharCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFecharCaixaActionPerformed(evt);
            }
        });

        btReceber.setText("Receber Pagamento");
        btReceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btReceberActionPerformed(evt);
            }
        });

        mEstoque.setText("Estoque");

        miAdicionarEstoque.setText("Adicionar");
        miAdicionarEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAdicionarEstoqueActionPerformed(evt);
            }
        });
        mEstoque.add(miAdicionarEstoque);

        miEditarEstoque.setText("Editar");
        miEditarEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miEditarEstoqueActionPerformed(evt);
            }
        });
        mEstoque.add(miEditarEstoque);

        miRemoverEstoque.setText("Remover");
        miRemoverEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRemoverEstoqueActionPerformed(evt);
            }
        });
        mEstoque.add(miRemoverEstoque);

        jMenuBar1.add(mEstoque);

        mPessoas.setText("Pessoas");

        miAdicionarPessoa.setText("Adicionar");
        miAdicionarPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAdicionarPessoaActionPerformed(evt);
            }
        });
        mPessoas.add(miAdicionarPessoa);

        miEditarPessoa.setText("Editar");
        miEditarPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miEditarPessoaActionPerformed(evt);
            }
        });
        mPessoas.add(miEditarPessoa);

        miRemoverPessoa.setText("Remover");
        miRemoverPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRemoverPessoaActionPerformed(evt);
            }
        });
        mPessoas.add(miRemoverPessoa);

        jMenuBar1.add(mPessoas);

        mRelatorios.setText("Relatórios");

        miRelatorioEstoque.setText("Estoque");
        miRelatorioEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRelatorioEstoqueActionPerformed(evt);
            }
        });
        mRelatorios.add(miRelatorioEstoque);

        miRelatorioPessoas.setText("Pessoas");
        miRelatorioPessoas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRelatorioPessoasActionPerformed(evt);
            }
        });
        mRelatorios.add(miRelatorioPessoas);

        jMenuBar1.add(mRelatorios);

        mCaixa.setText("Caixa");

        miAdicionarCaixa.setText("Adicionar");
        miAdicionarCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAdicionarCaixaActionPerformed(evt);
            }
        });
        mCaixa.add(miAdicionarCaixa);

        miRemoverCaixa.setText("Retirar");
        miRemoverCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRemoverCaixaActionPerformed(evt);
            }
        });
        mCaixa.add(miRemoverCaixa);

        jMenuBar1.add(mCaixa);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btFecharCaixa)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(txtSaldo))))
                    .addComponent(btVender, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(txtValorCaixa))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btAbrirCaixa)
                        .addGap(36, 36, 36)))
                .addContainerGap(122, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btReceber)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btReceber)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(btAbrirCaixa)
                .addGap(31, 31, 31)
                .addComponent(btVender, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108)
                .addComponent(txtSaldo)
                .addGap(18, 18, 18)
                .addComponent(txtValorCaixa)
                .addGap(29, 29, 29)
                .addComponent(btFecharCaixa)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btFecharCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharCaixaActionPerformed
        //botão de fechar caixa
        ARQUIVO.adiciona("- função fechar caixa");
        Produto prod = ARQUIVO.getProduto(0);
        saldoFinal = ARQUIVO.getSaldoAtual() - saldoInicial;
        
        if (prod.getQuantidade() != 0){
            ERRO.erro("Fechamento", "Saldo final de vendas: " + DF.format(saldoFinal) + " reais.\n"+
                      "Sobraram " + prod.getQuantidade() + " salgados.", "nada"); 
        } else {
            ERRO.erro("Fechamento", "Saldo final de vendas: " + DF.format(saldoFinal) + " reais.", "nada");
        }
                
        btFecharCaixa.setVisible(false);
        txtValorCaixa.setVisible(false);
        btAbrirCaixa.setVisible(true);
        txtSaldo.setVisible(false);
        btVender.setVisible(false);        
        mCaixa.setVisible(false);               
    }//GEN-LAST:event_btFecharCaixaActionPerformed

    private void miAdicionarEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAdicionarEstoqueActionPerformed
        //Adicionar ao estoque
        editaEstoque = new EditEstoque(this.ARQUIVO, "+");
        editaEstoque.setLocationRelativeTo(null);
        editaEstoque.setVisible(true);        
    }//GEN-LAST:event_miAdicionarEstoqueActionPerformed

    private void miEditarEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miEditarEstoqueActionPerformed
        //Editar o estoque
        editaEstoque = new EditEstoque(this.ARQUIVO, "=");
        editaEstoque.setLocationRelativeTo(null);
        editaEstoque.setVisible(true);        
    }//GEN-LAST:event_miEditarEstoqueActionPerformed

    private void miRelatorioEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRelatorioEstoqueActionPerformed
        //Relatório de estoque
        try {
            view = new ViewEstoque(ARQUIVO.getEstoque());
        } catch (IOException ex) {
            Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
        view.setLocationRelativeTo(null);
        view.setVisible(true);        
    }//GEN-LAST:event_miRelatorioEstoqueActionPerformed

    private void miRemoverEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRemoverEstoqueActionPerformed
        // Remover do Estoque
        editaEstoque = new EditEstoque(this.ARQUIVO, "-");
        editaEstoque.setLocationRelativeTo(null);
        editaEstoque.setVisible(true);        
    }//GEN-LAST:event_miRemoverEstoqueActionPerformed

    private void miAdicionarCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAdicionarCaixaActionPerformed
        // Adicionar ao caixa
        String valor = JOptionPane.showInputDialog(this, "Insira o valor para adicionar ao caixa", "Insira o valor", JOptionPane.INFORMATION_MESSAGE);
        virgula = valor.indexOf(",");
        if (!(virgula == -1) || testeCaracteres(valor)) {
            ERRO.erro("Inclusão Incorreta", "Favor inserir apenas números e separar o valor com '.'", "erro");
        } else {
            ARQUIVO.adiciona(Double.parseDouble(valor), "+");
        }
        txtSaldo.setText(DF.format(ARQUIVO.getSaldoAtual()));
    }//GEN-LAST:event_miAdicionarCaixaActionPerformed

    private void miRemoverCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRemoverCaixaActionPerformed
        // Retirar do caixa
        String valor = JOptionPane.showInputDialog(null, "Insira o valor para retirar do caixa", "Insira o valor", JOptionPane.INFORMATION_MESSAGE);
        virgula = valor.indexOf(",");
        if (!(virgula == -1) || testeCaracteres(valor)) {
            ERRO.erro("Inclusão Incorreta", "Favor inserir apenas números e separar o valor com '.'", "erro");
        } else if (ARQUIVO.getSaldoAtual() - Double.parseDouble(valor) < 0) {
            ERRO.erro("Valor incorreto", "Valor inserido é maior que o disponível em caixa", "erro");
        } else {
            ARQUIVO.adiciona(Double.parseDouble(valor), "-");
        }
        txtSaldo.setText(DF.format(ARQUIVO.getSaldoAtual()));
    }//GEN-LAST:event_miRemoverCaixaActionPerformed

    private void btVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVenderActionPerformed
        // Ação de venda
        venda = new TelaVenda(this.ARQUIVO);
        venda.confirma(this);
        venda.setVisible(true);
        venda.setLocationRelativeTo(null);
    }//GEN-LAST:event_btVenderActionPerformed

    private void btAbrirCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAbrirCaixaActionPerformed
        // Abrir caixa
        ARQUIVO.adiciona("- o botão abrir caixa foi ativado");
        ABRE_CAIXA.setLocationRelativeTo(null);
        ABRE_CAIXA.setResizable(false);
        btAbrirCaixa.setVisible(false);
        ABRE_CAIXA.setVisible(true);        
        ABRE_CAIXA.confirma(this);        
    }//GEN-LAST:event_btAbrirCaixaActionPerformed

    private void miRelatorioPessoasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRelatorioPessoasActionPerformed
        //Relatório de pessoas
        try {
            pessoas = new ViewPessoas(ARQUIVO.getPessoas());
        } catch (IOException ex) {
            Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
        pessoas.setLocationRelativeTo(null);
        pessoas.setVisible(true);        
    }//GEN-LAST:event_miRelatorioPessoasActionPerformed

    private void miAdicionarPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAdicionarPessoaActionPerformed
        // Adicionar nova pessoa
        editaPessoa = new EditPessoa(ARQUIVO, "+");
        editaPessoa.setLocationRelativeTo(null);  
        editaPessoa.setVisible(true);        
    }//GEN-LAST:event_miAdicionarPessoaActionPerformed

    private void miEditarPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miEditarPessoaActionPerformed
        // Editar uma pessoa cadastrada
        editaPessoa = new EditPessoa(ARQUIVO, "=");
        editaPessoa.setLocationRelativeTo(null);
        editaPessoa.setVisible(true);                
    }//GEN-LAST:event_miEditarPessoaActionPerformed

    private void miRemoverPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRemoverPessoaActionPerformed
        // Remover uma pessoa cadastrada
        editaPessoa = new EditPessoa(ARQUIVO, "-");
        editaPessoa.setLocationRelativeTo(null); 
        editaPessoa.setVisible(true);        
    }//GEN-LAST:event_miRemoverPessoaActionPerformed

    private void btReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btReceberActionPerformed
        //Receber pagamento de dívida
        pagamento = new Pagamento(ARQUIVO);
        pagamento.setLocationRelativeTo(null); 
        pagamento.setVisible(true);        
    }//GEN-LAST:event_btReceberActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new TelaInicial().setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAbrirCaixa;
    private javax.swing.JButton btFecharCaixa;
    private javax.swing.JButton btReceber;
    private javax.swing.JButton btVender;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mCaixa;
    private javax.swing.JMenu mEstoque;
    private javax.swing.JMenu mPessoas;
    private javax.swing.JMenu mRelatorios;
    private javax.swing.JMenuItem miAdicionarCaixa;
    private javax.swing.JMenuItem miAdicionarEstoque;
    private javax.swing.JMenuItem miAdicionarPessoa;
    private javax.swing.JMenuItem miEditarEstoque;
    private javax.swing.JMenuItem miEditarPessoa;
    private javax.swing.JMenuItem miRelatorioEstoque;
    private javax.swing.JMenuItem miRelatorioPessoas;
    private javax.swing.JMenuItem miRemoverCaixa;
    private javax.swing.JMenuItem miRemoverEstoque;
    private javax.swing.JMenuItem miRemoverPessoa;
    private javax.swing.JLabel txtSaldo;
    private javax.swing.JLabel txtValorCaixa;
    // End of variables declaration//GEN-END:variables
}