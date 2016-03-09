/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerCidade;
import controller.ControllerEstado;
import controller.ControllerFornecedor;
import controller.ControllerFornecedorCidadeUf;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import model.ModelCidade;
import model.ModelEstado;
import model.ModelFornecedor;
import model.ModelFornecedorCidadeUf;
import util.ModeloTabela;

/**
 *
 * @author wellington
 */
public class ViewCadFornecedor extends javax.swing.JFrame {
    
    private String funcao = "salvar";
    private String funcao2;
    
    private ModelFornecedor mCadFornecedor;
    private ControllerFornecedor cCadFornecedor;
    
    private ModelFornecedorCidadeUf mForCidBaiUf;
    private ControllerFornecedorCidadeUf cForCidBaiUf;
    
    private ControllerEstado cEstado;
    private ControllerCidade cCidade;
    
    /**
     * Creates new form ViewCadFornecedor
     */
    public ViewCadFornecedor() {
        initComponents();
        setLocationRelativeTo(null);
        txtcodigo.setEditable(false);
        desabilitarcomponentes();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        this.mCadFornecedor = new ModelFornecedor();
        this.cCadFornecedor = new ControllerFornecedor();
        
        cCidade = new ControllerCidade();
        cEstado = new ControllerEstado();
        
        preenchertabela();
        listarCidades();
        listarEstados();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtp = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jTextField11 = new javax.swing.JTextField();
        lbpesquisa = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lbcodigo = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        lbnome = new javax.swing.JLabel();
        txtnome = new javax.swing.JTextField();
        txtcpf = new javax.swing.JTextField();
        lbcpf = new javax.swing.JLabel();
        lbcelular = new javax.swing.JLabel();
        lbtelefone = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        lbemail = new javax.swing.JLabel();
        txttelefone = new javax.swing.JFormattedTextField();
        txtcelular = new javax.swing.JFormattedTextField();
        jPanel5 = new javax.swing.JPanel();
        lbendereco = new javax.swing.JLabel();
        txtnumcasa = new javax.swing.JTextField();
        lbuf = new javax.swing.JLabel();
        cbuf = new javax.swing.JComboBox<>();
        lbcomplemento = new javax.swing.JLabel();
        txtendereco = new javax.swing.JTextField();
        txtcomplemento = new javax.swing.JTextField();
        lbnumcasa = new javax.swing.JLabel();
        lbcep = new javax.swing.JLabel();
        cbcidade = new javax.swing.JComboBox<>();
        lbcidade = new javax.swing.JLabel();
        lbbairro = new javax.swing.JLabel();
        txtbairro = new javax.swing.JTextField();
        txtcep = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btCancelar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Cadastro de Fornecedor");

        lbpesquisa.setText("Pesquisa:");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField11)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbpesquisa)
                        .addGap(0, 610, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbpesquisa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtp.addTab("Consulta", jPanel2);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados da Empresa"));

        lbcodigo.setText("Código:");

        lbnome.setText("Nome do Fornecedor:");

        lbcpf.setText("CPF/CNPJ:");

        lbcelular.setText("Tel.Comercial");

        lbtelefone.setText("Telefone:");

        lbemail.setText("E-mail:");

        try {
            txttelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtcelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbemail))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lbtelefone)
                                .addGap(96, 96, 96))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(txttelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lbcelular)
                                .addGap(0, 92, Short.MAX_VALUE))
                            .addComponent(txtcelular, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbcodigo)
                            .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbnome)
                            .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcpf)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lbcpf)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbcodigo)
                    .addComponent(lbnome)
                    .addComponent(lbcpf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbemail)
                    .addComponent(lbtelefone)
                    .addComponent(lbcelular))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Localidade"));

        lbendereco.setText("Endereço:");

        lbuf.setText("UF:");

        lbcomplemento.setText("Complemento:");

        lbnumcasa.setText("Nª:");

        lbcep.setText("CEP:");

        lbcidade.setText("Cidade:");

        lbbairro.setText("Bairro:");

        try {
            txtcep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtendereco, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbendereco))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnumcasa, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbnumcasa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lbcomplemento)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtcomplemento)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbcidade, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbcidade))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbuf, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbuf))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbbairro)
                            .addComponent(txtbairro, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lbcep)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtcep))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbendereco)
                    .addComponent(lbnumcasa)
                    .addComponent(lbcomplemento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtendereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnumcasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcomplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbbairro)
                    .addComponent(lbuf)
                    .addComponent(lbcep)
                    .addComponent(lbcidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbcidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbuf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtbairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 17, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jEditorPane1);

        jLabel1.setText("Observação:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtp.addTab("Cadastro", jPanel1);

        getContentPane().add(jtp, java.awt.BorderLayout.CENTER);

        jPanel3.setPreferredSize(new java.awt.Dimension(675, 50));

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 269, Short.MAX_VALUE)
                .addComponent(btSalvar)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar)
                    .addComponent(btExcluir)
                    .addComponent(btEditar)
                    .addComponent(btNovo)
                    .addComponent(btSalvar))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        desabilitarcomponentes();//desabilita botoes e campos de texto
        limpartela();//limpa a tela
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        //retorna o indice da linha
        int linha = table.getSelectedRow();
            if(linha >= 0){
                //pergunta
                String descricao = "Deseja excluir o Forncedor:"+table.getValueAt(linha,1)+"?";
                //obtem o valor verdadeiro ou falso (1,0)
                int opcao = JOptionPane.showConfirmDialog(null,descricao,"Atenção",JOptionPane.YES_NO_OPTION);
                    //faz a comparação
                    if(opcao == JOptionPane.YES_OPTION){
                        //pega o codigo do cliente
                        mCadFornecedor.setFor_id((int) (table.getValueAt(linha, 0)));
                        //passa para o delete
                        cCadFornecedor.delete(mCadFornecedor);
                        //assim que o usuario e excluido
                        //atualiza a tebela
                        preenchertabela();
                    }
                    else{
                        //senao quiser excluir cliente
                        //desabilita os camppos
                       desabilitarcomponentes();
                    }
            }
            else{
                JOptionPane.showMessageDialog(null, "Selecione um campo no banco de dados!");
            }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        jtp.setSelectedIndex(1);
        funcao = "editar";//add a função editar para a variavel
        habilitacomponentes();//habilita campos e botoes
        pegadadosdatabela();//e recupera os dados da tabela
    }//GEN-LAST:event_btEditarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        jtp.setSelectedIndex(1);
        habilitacomponentes();
        //limpa a tela
        limpartela();
        //add a fução novo
        funcao = "salvar";
    }//GEN-LAST:event_btNovoActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
         //para salvar depende da funcao se recebeu salvar ou editar
            //se funcao receber salvar ao clickar no botao novo ele excuta
            //o insert
            if(funcao.equals("salvar")){
               //insert recebe os dados dos campos de texto
               //retorna para a insersão ao banco
               cCadFornecedor.insert(montarForcedor("salvar"));
               //apos desabilita os campos
               habilitacomponentes();
               //limpa a tela
               limpartela();
               //atualiza a tabela
               preenchertabela();
               desabilitarcomponentes();
               limpartela();
               
            }
            else{//senao for salvar, foi clickado no boatao editar
               //e o metodo montar tela pega os dados do campo
               //e retorna para update atualizar as informações do
               //usuario
               cCadFornecedor.update(montarForcedor("editar"));
               //desabilita os campos
               desabilitarcomponentes();
               //limpa a tela
               limpartela();
               //atualiza a tabela
               preenchertabela();
            }
    }//GEN-LAST:event_btSalvarActionPerformed

    /*================================================OUTROS METODOS========================================*/
    //metodo para desabilitar componentes
    private void desabilitarcomponentes(){//inicio
        txtnome.setEditable(false);
        txtcpf.setEditable(false);
        txtemail.setEditable(false);
        txttelefone.setEditable(false);
        txtcelular.setEditable(false);
        txtendereco.setEditable(false);
        txtnumcasa.setEditable(false);;
        txtcomplemento.setEditable(false);
        txtcep.setEditable(false);
        
        txtbairro.setEditable(false);
        cbcidade.setEnabled(false);
        cbuf.setEnabled(false);
        
        btCancelar.setEnabled(false);
        btSalvar.setEnabled(false);
        
        btNovo.setEnabled(true);
        btEditar.setEnabled(true);
        btExcluir.setEnabled(true);
        

    }//fim metodo desabilitarcomponentes
    
    //metodo habilitar componentes
    private void habilitacomponentes(){
        
        txtnome.setEditable(true);
        txtcpf.setEditable(true);
        txtemail.setEditable(true);
        txttelefone.setEditable(true);
        txtcelular.setEditable(true);
        txtendereco.setEditable(true);
        txtnumcasa.setEditable(true);
        txtcomplemento.setEditable(true);
        txtcep.setEditable(true);
        
        txtbairro.setEditable(true);
        cbcidade.setEnabled(true);
        cbuf.setEnabled(true);
        
        btCancelar.setEnabled(true);
        btSalvar.setEnabled(true);
        
        btNovo.setEnabled(false);
        btEditar.setEnabled(false);
        btExcluir.setEnabled(false);
        
    }//fim metodo de habilitar componentes
    
    //metodo para limpar campos
    private void limpartela(){//incio
        txtcodigo.setText("");
        txtnome.setText("");
        txtcpf.setText("");
        txtemail.setText("");
        txttelefone.setText("");
        txtcelular.setText("");
        txtendereco.setText("");
        txtnumcasa.setText("");
        txtcomplemento.setText("");
        txtcep.setText("");
        txtbairro.setText("");
    }//fim do metodo limpa campos
    
        //metodo para obter dados do campos de texto
    //retorna o objeto do modelo cliente
    //o controle recebe o modelo, para cadastrar autlizar ou excluir
    private ModelFornecedor montarForcedor(String funcao){
	//modelo
	this.mCadFornecedor = new ModelFornecedor();
	//codicao
            if(funcao.equals("salvar")){
		this.mCadFornecedor.setFor_nome(txtnome.getText());
		this.mCadFornecedor.setFor_cnpj_cpf(txtcpf.getText());
		this.mCadFornecedor.setFor_email(txtemail.getText());
		this.mCadFornecedor.setFor_telefone(txttelefone.getText());
		this.mCadFornecedor.setFor_telcomercial(txtcelular.getText());
		this.mCadFornecedor.setFor_endereco(txtendereco.getText());
		this.mCadFornecedor.setFor_num(txtnumcasa.getText());
		this.mCadFornecedor.setFor_complemento(txtcomplemento.getText());
		this.mCadFornecedor.setFor_bairro(txtbairro.getText());
		this.mCadFornecedor.setFor_idcidade(cCidade.select(cbcidade.getSelectedItem().toString()));
		this.mCadFornecedor.setFor_idestado(cEstado.select(cbuf.getSelectedItem().toString()));
		this.mCadFornecedor.setFor_cep(txtcep.getText());
		}
            else{	
		this.mCadFornecedor.setFor_nome(txtnome.getText());
		this.mCadFornecedor.setFor_cnpj_cpf(txtcpf.getText());
		this.mCadFornecedor.setFor_email(txtemail.getText());
		this.mCadFornecedor.setFor_telefone(txttelefone.getText());
		this.mCadFornecedor.setFor_telcomercial(txtcelular.getText());
		this.mCadFornecedor.setFor_endereco(txtendereco.getText());
		this.mCadFornecedor.setFor_num(txtnumcasa.getText());
		this.mCadFornecedor.setFor_complemento(txtcomplemento.getText());
		this.mCadFornecedor.setFor_bairro(txtbairro.getText());
		this.mCadFornecedor.setFor_idcidade(cCidade.select(cbcidade.getSelectedItem().toString()));
		this.mCadFornecedor.setFor_idestado(cEstado.select(cbuf.getSelectedItem().toString()));
		this.mCadFornecedor.setFor_cep(txtcep.getText());
                    if (this.txtcodigo.getText() != null && !this.txtcodigo.getText().equals("")) {
			this.mCadFornecedor.setFor_id(Integer.parseInt(this.txtcodigo.getText()));
                    }
			
		}
		//retorno do objeto modelo
		return this.mCadFornecedor;
    }//fim metodo para construir tela
    
     //pegar dados da tabela e retorna para os campos
    private void pegadadosdatabela(){
     int linha = table.getSelectedRow();
     if(linha >= 0){
     //table retona a index da coluna (linha,coluna)
        txtcodigo.setText(""+table.getValueAt(linha, 0));
        txtnome.setText(""+table.getValueAt(linha, 1));
        txtcpf.setText(""+table.getValueAt(linha, 2));
        txtemail.setText(""+table.getValueAt(linha, 3));
        txttelefone.setText(""+table.getValueAt(linha, 4));
        txtcelular.setText(""+table.getValueAt(linha, 5));
        txtendereco.setText(""+table.getValueAt(linha, 6));
        txtnumcasa.setText(""+table.getValueAt(linha, 7));
        txtcomplemento.setText(""+table.getValueAt(linha, 8));
        txtbairro.setText(""+table.getValueAt(linha, 9));
        cbcidade.setSelectedItem(""+table.getValueAt(linha, 10));
        cbuf.setSelectedItem(""+table.getValueAt(linha, 11));
        txtcep.setText(""+table.getValueAt(linha, 12));
     }
     else{
         JOptionPane.showMessageDialog(null, "Selecione um campo na tabela!");
         desabilitarcomponentes();
     }
    }
    
     private void preenchertabela(){
		
	//ConexaoJdbc.executarSQL("Select * from cad_categoria");
	mForCidBaiUf = new ModelFornecedorCidadeUf();
	cForCidBaiUf = new ControllerFornecedorCidadeUf();
		
	//Lista de clientes recebe do controle o retorno de uma consulta no banco
	List<ModelFornecedorCidadeUf> m = cForCidBaiUf.select();
	//criar o vetor dados para preencher a tabela
	ArrayList dados = new ArrayList();
		
	//para preencher as linhas da tabela com os dados
            for (ModelFornecedorCidadeUf model : m) {
             //add cada dado em linhas da table
                dados.add(new Object[]{model.getId(),model.getNome(),model.getCnpj_cpf(),
                model.getEmail(),model.getTelefone(),model.getTelcomercial(),
		model.getEndereco(),model.getNum(),model.getComeplemento(),
		model.getBairro(), model.getCidade(), model.getUf(),
		model.getCep()
                });//fim dados.add
            }//fim for
		
            //seta um modelo da tabela com os dados em linhae colunas
            table.setModel(new ModeloTabela(dados,new String[] {"Código", "Nome", "CPF", "E-mail", "Telefone", "Celular", "Endereço",
				"Núm.Casa", "Complemento", "Bairro", "Cidade","UF", "CEP"}));
            table.getTableHeader().setReorderingAllowed(false);
            //para preencher cada campo com lagura de 50 e impedir que
            //seja remensionado false
                for(int i=0;i<12;i++){
		//table.getColumnModel().getColumn(i).setResizable(false);
                table.getColumnModel().getColumn(i).setPreferredWidth(100);
                 }
		table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}//fim metodo preenchertabela
    
    private void listarEstados(){
        this.cEstado = new ControllerEstado();
        List<ModelEstado> listEstado  = cEstado.select();
        cbuf.removeAllItems();
        for(ModelEstado mEstado : listEstado){
            cbuf.addItem(mEstado.getEstado_uf());
        }
    }
    private void listarCidades(){
        this.cCidade = new ControllerCidade();
        List<ModelCidade> listCidade = this.cCidade.select();
        cbcidade.removeAllItems();
        for(ModelCidade m : listCidade){
            cbcidade.addItem(m.getCid_nome());
        }
    }
    
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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewCadFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCadFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCadFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCadFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewCadFornecedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox<String> cbcidade;
    private javax.swing.JComboBox<String> cbuf;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTabbedPane jtp;
    private javax.swing.JLabel lbbairro;
    private javax.swing.JLabel lbcelular;
    private javax.swing.JLabel lbcep;
    private javax.swing.JLabel lbcidade;
    private javax.swing.JLabel lbcodigo;
    private javax.swing.JLabel lbcomplemento;
    private javax.swing.JLabel lbcpf;
    private javax.swing.JLabel lbemail;
    private javax.swing.JLabel lbendereco;
    private javax.swing.JLabel lbnome;
    private javax.swing.JLabel lbnumcasa;
    private javax.swing.JLabel lbpesquisa;
    private javax.swing.JLabel lbtelefone;
    private javax.swing.JLabel lbuf;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtbairro;
    private javax.swing.JFormattedTextField txtcelular;
    private javax.swing.JFormattedTextField txtcep;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtcomplemento;
    private javax.swing.JTextField txtcpf;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtendereco;
    private javax.swing.JTextField txtnome;
    private javax.swing.JTextField txtnumcasa;
    private javax.swing.JFormattedTextField txttelefone;
    // End of variables declaration//GEN-END:variables
}
