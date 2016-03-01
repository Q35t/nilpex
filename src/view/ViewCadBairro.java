/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerBairro;
import controller.ControllerBairroCidadeEstado;
import controller.ControllerCidade;
import controller.ControllerEstado;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ListSelectionModel;
import model.ModelBairro;
import model.ModelBairroCidadeEstado;
import model.ModelCidade;
import model.ModelEstado;
import util.ModeloTabela;

/**
 *
 * @author wellington
 */
public class ViewCadBairro extends javax.swing.JFrame {
    
    
    private String funcao = "salvar";
    private String funcao2;
    
    private ModelBairroCidadeEstado mBaCiEs;
    private ControllerBairroCidadeEstado cBaiCiEs;
    
    private ControllerCidade cCidade;
    private ControllerEstado cEstado;
    
    private ModelBairro mBairro;
    
    /**
     * Creates new form ViewCadBairro
     */
    public ViewCadBairro() {
        initComponents();
        setLocationRelativeTo(null);
        txtcodigo.setEditable(false);
        preenchertabela();
        listarCidades();
        listarEstados();
        
        this.cCidade = new ControllerCidade();
        this.cEstado = new ControllerEstado();
        
        this.mBairro = new ModelBairro();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtcodigo = new javax.swing.JTextField();
        lbcodigo = new javax.swing.JLabel();
        cbuf = new javax.swing.JComboBox<>();
        lbuf = new javax.swing.JLabel();
        txtbairro = new javax.swing.JTextField();
        lbbairro = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btCancelar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        cbcidade = new javax.swing.JComboBox<>();
        lbcidade = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbcodigo.setText("Código:");

        lbuf.setText("UF:");

        lbbairro.setText("Nome do Bairro:");

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

        lbcidade.setText("Cidade");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtbairro)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbbairro)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btSalvar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbcidade)
                                .addGap(0, 171, Short.MAX_VALUE))
                            .addComponent(cbcidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbuf)
                            .addComponent(cbuf, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbcodigo)
                    .addComponent(lbbairro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtbairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbuf)
                    .addComponent(lbcidade))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbuf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbcidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar)
                    .addComponent(btExcluir)
                    .addComponent(btEditar)
                    .addComponent(btNovo)
                    .addComponent(btSalvar))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
       
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
       
    }//GEN-LAST:event_btEditarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
       
    }//GEN-LAST:event_btNovoActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        
    }//GEN-LAST:event_btSalvarActionPerformed
    
    /*================================================OUTROS METODOS========================================*/
    //metodo para desabilitar componentes
    private void desabilitarcomponentes(){//inicio
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
        
        txtcodigo.setEditable(true);
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
        cbcidade.setSelectedIndex(0);
        cbuf.setSelectedIndex(0);
    }//fim do metodo limpa campos
    
    private ModelBairro montarBairro(String funcao){
	//modelo
	mBairro = new ModelBairro();
	//codicao
            if(funcao.equals("salvar")){
		mBairro.setBairro_nome(txtbairro.getText());
		mBairro.setBairro_idcidade(cbcidade.getSelectedIndex()+1);
                mBairro.setBairro_iduf(cbuf.getSelectedIndex()+1);
		}
            else{	
		mBairro.setBairro_nome(txtbairro.getText());
		mBairro.setBairro_idcidade(cbcidade.getSelectedIndex()+1);
                mBairro.setBairro_iduf(cbuf.getSelectedIndex()+1);
                if (this.txtcodigo.getText() != null && !this.txtcodigo.getText().equals("")) {
			mBairro.setBairro_id(Integer.parseInt(this.txtcodigo.getText()));
                    }
			
            }
		//retorno do objeto modelo
		return mBairro;
    }//fim metodo para construir tela
    
     private void preenchertabela(){
		
	//ConexaoJdbc.executarSQL("Select * from cad_categoria");
	this.mBaCiEs = new ModelBairroCidadeEstado();
        this.cBaiCiEs = new ControllerBairroCidadeEstado();
        
	//Lista de clientes recebe do controle o retorno de uma consulta no banco
	List<ModelBairroCidadeEstado> BaiCiEs = cBaiCiEs.select();
	//criar o vetor dados para preencher a tabela
	ArrayList dados = new ArrayList();
		
	//para preencher as linhas da tabela com os dados
            for (ModelBairroCidadeEstado model : BaiCiEs) {
             //add cada dado em linhas da table
                dados.add(new Object[]{model.getId(),model.getBairro_nome(),model.getCid_nome(),model.getUf()});//fim dados.add
            }//fim for
		
            //seta um modelo da tabela com os dados em linhae colunas
            table.setModel(new ModeloTabela(dados,new String[] {"Código", "Bairro", "Cidade", "UF"}));
            table.getTableHeader().setReorderingAllowed(false);
            //para preencher cada campo com lagura de 50 e impedir que
            //seja remensionado false
                for(int i=0;i<4;i++){
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
    
    
    /*================================================== FIM ====================================================*/
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
            java.util.logging.Logger.getLogger(ViewCadBairro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCadBairro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCadBairro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCadBairro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewCadBairro().setVisible(true);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbbairro;
    private javax.swing.JLabel lbcidade;
    private javax.swing.JLabel lbcodigo;
    private javax.swing.JLabel lbuf;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtbairro;
    private javax.swing.JTextField txtcodigo;
    // End of variables declaration//GEN-END:variables
}
