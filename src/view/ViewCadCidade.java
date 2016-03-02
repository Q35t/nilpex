/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.*;
import controller.*;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import util.ModeloTabela;

/**
 *
 * @author wellington
 */
public class ViewCadCidade extends javax.swing.JFrame {
    
    private String funcao = "salvar";
    private String funcao2;
    
    
    private ControllerEstado cEstado;
    private ModelCidade mCadCidade;
    private ControllerCidade cCadCidade;
    
    private ArrayList<ModelEstado> listaModelEstados = new ArrayList<ModelEstado>();
    private ModelCidadeEstado mCidadeEstado;
    private ControllerCidadeEstado cCidadeEstado;
   
    
    /**
     * Creates new form ViewCadCidade
     */
    public ViewCadCidade() {
        initComponents();
        setLocationRelativeTo(null);//posicionar tela no centro
        txtcodigo.setEditable(false);//não editavel
        desabilitarcomponentes();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        preenchertabela();
        listarEstados();
        
        
        mCadCidade = new ModelCidade();
        cCadCidade = new ControllerCidade();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbcodigo = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        lbuf = new javax.swing.JLabel();
        cbuf = new javax.swing.JComboBox<>();
        lbcidade = new javax.swing.JLabel();
        txtcidade = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btCancelar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Cidade");

        lbcodigo.setText("Código:");

        lbuf.setText("UF:");

        lbcidade.setText("Cidade:");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbcodigo)
                            .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbuf)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cbuf, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(txtcidade)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbcidade)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btSalvar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbcodigo)
                    .addComponent(lbuf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbuf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbcidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtcidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar)
                    .addComponent(btExcluir)
                    .addComponent(btEditar)
                    .addComponent(btNovo)
                    .addComponent(btSalvar))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        desabilitarcomponentes();//desabilita botoes e campos de texto
        limpartela();//limpa a tela
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
         //retorna o indice da linha
         int linha = table.getSelectedRow();
                //pergunta
            if(linha >= 0){
                String descricao = "Deseja excluir a Cidade:"+table.getValueAt(linha,1)+"?";
                //obtem o valor verdadeiro ou falso (1,0)
                int opcao = JOptionPane.showConfirmDialog(null,descricao,"Atenção",JOptionPane.YES_NO_OPTION);
                    //faz a comparação
                    if(opcao == JOptionPane.YES_OPTION){
                        //pega o codigo do da cidade
                        
                        this.mCadCidade.setCid_id((int) (table.getValueAt(linha, 0)));
                        //passa para o delete
                        this.cCadCidade.delete(this.mCadCidade);
                        //assim que o a cidade e excluido
                        //atualiza a tebela
                        preenchertabela();
                    }
                    else{
                        //senao quiser excluir a cidade
                        //desabilita os camppos
                       desabilitarcomponentes();
                    }
            }
            else{
               JOptionPane.showMessageDialog(null, "Selecione algum campo na tabela!");
               desabilitarcomponentes();
            }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        funcao = "editar";//add a função editar para a variavel
        habilitacomponentes();//habilita campos e botoes
        pegadadosdatabela();//e recupera os dados da tabela
    }//GEN-LAST:event_btEditarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
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
               this.cCadCidade.insert(montarCidade("salvar"));
               //apos desabilita os campos
               habilitacomponentes();
               //limpa a tela
               limpartela();
               //atualiza a tabela
               preenchertabela();
               
            }
            else{//senao for salvar, foi clickado no boatao editar
               //e o metodo montar tela pega os dados do campo
               //e retorna para update atualizar as informações do
               //usuario
               this.cCadCidade.update(montarCidade("editar"));
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
        txtcidade.setEditable(false);
        cbuf.setEnabled(false);
        
        btCancelar.setEnabled(false);
        btSalvar.setEnabled(false);
        
        btNovo.setEnabled(true);
        btEditar.setEnabled(true);
        btExcluir.setEnabled(true);
        

    }//fim metodo desabilitarcomponentes
    //metodo habilitar componentes
    private void habilitacomponentes(){
        
        txtcidade.setEditable(true);
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
        txtcidade.setText("");
    }//fim do metodo limpa campos
    
    private ModelCidade montarCidade(String funcao){
	//modelo
	this.mCadCidade = new ModelCidade();
	//codicao
            if(funcao.equals("salvar")){
		this.mCadCidade.setCid_nome(txtcidade.getText());
		this.mCadCidade.setCid_idestado(cbuf.getSelectedIndex()+1);
		}
            else{	
		this.mCadCidade.setCid_nome(txtcidade.getText());
                this.mCadCidade.setCid_idestado((cbuf.getSelectedIndex()+1));
                System.out.println(cbuf.getSelectedIndex());
                    //se ele não for nulo e nao estiver vazio
                    if (this.txtcodigo.getText() != null && !this.txtcodigo.getText().equals("")) {
                        this.mCadCidade.setCid_id(Integer.parseInt(this.txtcodigo.getText()));
                    }
			
		}
		//retorno do objeto modelo
		return this.mCadCidade;
    }//fim metodo para construir tela
    
    private void pegadadosdatabela(){
     int linha = table.getSelectedRow();
     
     if(linha >= 0 ){
        //table retona a index da coluna (linha,coluna)
        txtcodigo.setText(""+table.getValueAt(linha, 0));
        txtcidade.setText(""+table.getValueAt(linha, 1));
        cbuf.setSelectedItem(""+table.getValueAt(linha, 2));
     }
     else{
         JOptionPane.showMessageDialog(null, "Selecione algum campo na tabela!");
         desabilitarcomponentes();
     }
     
    }
    
    //metodo para modelo a tabela do form
    //e preencher o mesmo
    private void preenchertabela(){
		
	//ConexaoJdbc.executarSQL("Select * from cad_categoria");
	this.mCidadeEstado = new ModelCidadeEstado();
        this.cCidadeEstado = new ControllerCidadeEstado();
		
	//Lista de clientes recebe do controle o retorno de uma consulta no banco
	List<ModelCidadeEstado> cidadesEstados = this.cCidadeEstado.select();
	//criar o vetor dados para preencher a tabela
	ArrayList dados = new ArrayList();
		
	//para preencher as linhas da tabela com os dados
            for (ModelCidadeEstado model : cidadesEstados) {
             //add cada dado em linhas da table
                dados.add(new Object[]{model.getCid_id(),model.getCid_nome(),model.getEstado_uf(),model.getEstado_nome()});//fim dados.add
            }//fim for
		
            //seta um modelo da tabela com os dados em linhae colunas
            table.setModel(new ModeloTabela(dados,new String[] {"Código", "Cidade", "UF","Nome Estado"}));
            table.getTableHeader().setReorderingAllowed(false);
            //para preencher cada campo com lagura de 50 e impedir que
            //seja remensionado false
                for(int i=0;i<4;i++){
		//table.getColumnModel().getColumn(i).setResizable(false);
                table.getColumnModel().getColumn(i).setPreferredWidth(178);
                 }
		table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}//fim metodo preenchertabela
    
    //preencher combobox
    private void listarEstados(){
        this.cEstado = new ControllerEstado();
        List<ModelEstado> listEstado  = cEstado.select();
        cbuf.removeAllItems();
        for(ModelEstado mEstado : listEstado){
            cbuf.addItem(mEstado.getEstado_uf());
        }
    }
    
        
    /*============================================================FIM DE OUTROS METODOS==================================*/
    
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
            java.util.logging.Logger.getLogger(ViewCadCidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCadCidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCadCidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCadCidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewCadCidade().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox<String> cbuf;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbcidade;
    private javax.swing.JLabel lbcodigo;
    private javax.swing.JLabel lbuf;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtcidade;
    private javax.swing.JTextField txtcodigo;
    // End of variables declaration//GEN-END:variables
}
