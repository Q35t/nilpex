/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerFornecedor;
import controller.ControllerProduto;
import controller.ControllerProdutoFornecedor;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import model.ModelFornecedor;
import model.ModelProduto;
import model.ModeloProdutoFornecedor;
import util.ManipularImagen;
import util.ModeloTabela;

/**
 *
 * @author wellington
 */
public class ViewCadProduto extends javax.swing.JFrame {
    
    private String funcao = "salvar";
    private String funcao2;
    private ModelProduto mProduto;
    private ControllerProduto cProduto; 
    private ModelFornecedor mFor;
    private ControllerFornecedor cFor;
    
    private ModeloProdutoFornecedor mProFor;
    private ControllerProdutoFornecedor cProFor;
    
    private BufferedImage imagem;
    /**
     * Creates new form ViewCadProduto
     */
    public ViewCadProduto() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        txtcodigo.setEditable(false);
        desabilitarcomponentes();
         
        this.cProduto = new ControllerProduto();
        this.mProduto = new ModelProduto();
        
        this.mFor = new ModelFornecedor();
        this.cFor = new ControllerFornecedor();
       
        listarFornecedores();
        preenchertabela();
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
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtpesquisa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        cbfornecedor = new javax.swing.JComboBox<>();
        lbfornecedor = new javax.swing.JLabel();
        txtvalor = new javax.swing.JTextField();
        lbvalor = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        lbcodigo = new javax.swing.JLabel();
        lbquantestoque = new javax.swing.JLabel();
        txtquantidade = new javax.swing.JTextField();
        txtnomeproduto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        plfoto = new javax.swing.JPanel();
        lbfoto = new javax.swing.JLabel();
        btaddfoto = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        btAddItem = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btCancelar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Produto");

        jLabel7.setText("Pesquisa na tabela:");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtpesquisa)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(245, 245, 245)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtp.addTab("Consulta", jPanel1);

        lbfornecedor.setText("Fornecedor:");

        lbvalor.setText("Valor:");

        lbcodigo.setText("Código:");

        lbquantestoque.setText("Quantidade estoque:");

        jLabel2.setText("Nome do Produto:");

        plfoto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        plfoto.setLayout(new java.awt.BorderLayout());

        lbfoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbfoto.setText("FOTO");
        plfoto.add(lbfoto, java.awt.BorderLayout.CENTER);

        btaddfoto.setText("Add imagem");
        btaddfoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btaddfotoActionPerformed(evt);
            }
        });

        jLabel1.setText("Categoria:");

        btAddItem.setText("add item");
        btAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddItemActionPerformed(evt);
            }
        });

        jLabel3.setText("Descrição:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField1)
                        .addGap(47, 47, 47)
                        .addComponent(btaddfoto)
                        .addGap(44, 44, 44))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtvalor, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbvalor))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbquantestoque)
                                        .addComponent(txtquantidade)))
                                .addComponent(jLabel2)
                                .addComponent(txtnomeproduto)
                                .addComponent(lbfornecedor)
                                .addComponent(cbfornecedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbcodigo))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(btAddItem)))))
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(plfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbcodigo)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btAddItem))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtnomeproduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbquantestoque)
                            .addComponent(lbvalor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtvalor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtquantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbfornecedor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbfornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addComponent(plfoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btaddfoto))
                .addContainerGap(105, Short.MAX_VALUE))
        );

        jtp.addTab("Cadastra produto", jPanel2);

        getContentPane().add(jtp, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        // TODO add your handling code here:
        desabilitarcomponentes();//desabilita botoes e campos de texto
        limpartela();//limpa a tela
        
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        // TODO add your handling code here:
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
                        mProduto.setPro_id((int) (table.getValueAt(linha, 0)));
                        //passa para o delete
                        cProduto.delete(mProduto);
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
                JOptionPane.showMessageDialog(null, "Selecione um campo na tabela de Consulta!");
            }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        // TODO add your handling code here:
        jtp.setSelectedIndex(1);
        funcao = "editar";//add a função editar para a variavel
        habilitacomponentes();//habilita campos e botoes
        pegadadosdatabela();//e recupera os dados da tabela
    }//GEN-LAST:event_btEditarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        // TODO add your handling code here:
        jtp.setSelectedIndex(1);
        habilitacomponentes();
        //limpa a tela
        limpartela();
        //add a fução novo
        funcao = "salvar";
    }//GEN-LAST:event_btNovoActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        // TODO add your handling code here:
        //para salvar depende da funcao se recebeu salvar ou editar
            //se funcao receber salvar ao clickar no botao novo ele excuta
            //o insert
            if(funcao.equals("salvar")){
               //insert recebe os dados dos campos de texto
               //retorna para a insersão ao banco
               cProduto.insert(montarProduto("salvar"));
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
               cProduto.update(montarProduto("editar"));
               //desabilita os campos
               desabilitarcomponentes();
               //limpa a tela
               limpartela();
               //atualiza a tabela
               preenchertabela();
            }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btaddfotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btaddfotoActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        int res = fc.showOpenDialog(null);
        
        if(res == JFileChooser.APPROVE_OPTION){
            File arquivo = fc.getSelectedFile();
            
            try{
                imagem = ManipularImagen.setImagemDimensao(arquivo.getAbsolutePath(),170, 170);
                lbfoto.setText("");
                lbfoto.setIcon(new ImageIcon(imagem));
            }catch(Exception e){
                
            }
        }
        
    }//GEN-LAST:event_btaddfotoActionPerformed

    private void btAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddItemActionPerformed
        // TODO add your handling code here:
        new ViewTipoProduto().setVisible(true);
    }//GEN-LAST:event_btAddItemActionPerformed
    
    //metodo para desabilitar componentes
    private void desabilitarcomponentes(){//inicio
        txtnomeproduto.setEditable(false);
        txtvalor.setEditable(false);
        txtquantidade.setEditable(false);
      
        cbfornecedor.setEnabled(false);
        
        btCancelar.setEnabled(false);
        btSalvar.setEnabled(false);
        
        btNovo.setEnabled(true);
        btEditar.setEnabled(true);
        btExcluir.setEnabled(true);
        

    }//fim metodo desabilitarcomponentes
    
    //metodo habilitar componentes
    private void habilitacomponentes(){
        
        txtnomeproduto.setEditable(true);
        txtvalor.setEditable(true);
        txtquantidade.setEditable(true);
        cbfornecedor.setEnabled(true);
        
        btCancelar.setEnabled(true);
        btSalvar.setEnabled(true);
        
        btNovo.setEnabled(false);
        btEditar.setEnabled(false);
        btExcluir.setEnabled(false);
        
    }//fim metodo de habilitar componentes
    
    //metodo para limpar campos
    private void limpartela(){//incio
        txtcodigo.setText("");
        txtnomeproduto.setText("");
        txtvalor.setText("");
        txtquantidade.setText("");
        
        lbfoto.setIcon(null);
    }//fim do metodo limpa campos
    
    private void pegadadosdatabela(){
     int linha = table.getSelectedRow();
     int codigo = Integer.parseInt(table.getValueAt(linha, 0).toString());
     ModelProduto mp = (ModelProduto) cProduto.select(codigo);
     
     if(linha >= 0){
     //table retona a index da coluna (linha,coluna)
        txtcodigo.setText(""+table.getValueAt(linha, 0));
        txtnomeproduto.setText(""+table.getValueAt(linha, 1));
        txtquantidade.setText(""+table.getValueAt(linha, 2));
        txtvalor.setText(""+table.getValueAt(linha, 3));
        lbfoto.setText("");
        ManipularImagen.exibiImagemLabel(mp.getPro_imagen(), lbfoto);
        cbfornecedor.setSelectedItem(""+table.getValueAt(linha, 4));
     }
     else{
         JOptionPane.showMessageDialog(null, "Selecione um campo na tabela!");
         desabilitarcomponentes();
     }
    }
    
    private ModelProduto montarProduto(String funcao){
        if(funcao.equals("slavar")){
            this.mProduto.setPro_nome(txtnomeproduto.getText());
            this.mProduto.setPro_valor(Double.parseDouble(txtvalor.getText()));
            this.mProduto.setPro_estoq(Integer.parseInt(txtquantidade.getText()));
            this.mProduto.setPro_idfornecedor(cFor.select(cbfornecedor.getSelectedItem().toString()));
            this.mProduto.setPro_imagen(ManipularImagen.getImgBytes(imagem));
        }
        else{
            this.mProduto.setPro_nome(txtnomeproduto.getText());
            this.mProduto.setPro_valor(Double.parseDouble(txtvalor.getText()));
            this.mProduto.setPro_estoq(Integer.parseInt(txtquantidade.getText()));
            this.mProduto.setPro_idfornecedor(cFor.select(cbfornecedor.getSelectedItem().toString()));
                if(imagem != null){
                  this.mProduto.setPro_imagen(ManipularImagen.getImgBytes(imagem));  
                }
                if (this.txtcodigo.getText() != null && !this.txtcodigo.getText().equals("")) {
			this.mProduto.setPro_id(Integer.parseInt(this.txtcodigo.getText()));
                }
        }
        
        return this.mProduto;
    }
    
    private void preenchertabela(){
		
	//ConexaoJdbc.executarSQL("Select * from cad_categoria");
	mProFor = new ModeloProdutoFornecedor();
	cProFor = new ControllerProdutoFornecedor();
		
	//Lista de clientes recebe do controle o retorno de uma consulta no banco
	List<ModeloProdutoFornecedor> m = (List<ModeloProdutoFornecedor>) cProFor.select();
	//criar o vetor dados para preencher a tabela
	ArrayList dados = new ArrayList();
		
            //para preencher as linhas da tabela com os dados
            for (ModeloProdutoFornecedor model : m) {
             //add cada dado em linhas da table
                dados.add(new Object[]{model.getPro_id(),model.getPro_nome(),model.getPro_quant(),
                model.getPro_valor(),model.getPro_fornecedor()});//fim dados.add
            }//fim for
		
            //seta um modelo da tabela com os dados em linhae colunas
            table.setModel(new ModeloTabela(dados,new String[] {"Código", "Produto", "Quantidade", "Valor.Uni", "Fornecedor"}));
            table.getTableHeader().setReorderingAllowed(false);
            //para preencher cada campo com lagura de 50 e impedir que
            //seja remensionado false
                for(int i=0;i<5;i++){
		//table.getColumnModel().getColumn(i).setResizable(false);
                table.getColumnModel().getColumn(i).setPreferredWidth(100);
                 }
		table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}//fim metodo preenchertabela
    
    private void listarFornecedores(){
        this.cFor = new ControllerFornecedor();
        List<ModelFornecedor> listfor  = cFor.select();
        cbfornecedor.removeAllItems();
        for(ModelFornecedor mforn : listfor){
            cbfornecedor.addItem(mforn.getFor_nome());
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
            java.util.logging.Logger.getLogger(ViewCadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewCadProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddItem;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSalvar;
    private javax.swing.JButton btaddfoto;
    private javax.swing.JComboBox<String> cbfornecedor;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTabbedPane jtp;
    private javax.swing.JLabel lbcodigo;
    private javax.swing.JLabel lbfornecedor;
    private javax.swing.JLabel lbfoto;
    private javax.swing.JLabel lbquantestoque;
    private javax.swing.JLabel lbvalor;
    private javax.swing.JPanel plfoto;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtnomeproduto;
    private javax.swing.JTextField txtpesquisa;
    private javax.swing.JTextField txtquantidade;
    private javax.swing.JTextField txtvalor;
    // End of variables declaration//GEN-END:variables
}
