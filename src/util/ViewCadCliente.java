package util;

import javax.swing.*;//importa todos os componentes do pacote swing
import javax.swing.event.*;//importa todos os eventos do pacote swing
import javax.swing.text.MaskFormatter;

import java.awt.*;//importa todos os componentes do pacote awt
import java.awt.event.*;//importa todos os eventos do pacote awt
import java.text.ParseException;
import java.util.*;//importa todos os componente do pacote util
import java.util.List;

import model.*;//importa os modelos do banco de dados
import controller.*;//importa os controle do banco
import util.*;//importa componentes uteis para apliçao

/**
 * 
 * @author wellington
 */

/**
 * Falta validar CPF e Email
 * Implementa as informações ao combobox
 * Verificar campo
 * Titulo dinamico da janela
 * 
*/

//class ViewCadCliente herda JFrame para a construçao das telas
public class ViewCadCliente extends JFrame{

    private Container c;//Declara o container da tela
    private JTextField textField, txtcodigo, txtnome, txtendereco, txtcep;
    private JTextField txtnumcasa, txttelefone, txtcelular, txtcomplemento;
    private JTextField txtcpf,txtemail, txtpesquisa;
    private JComboBox cbbairro, cbcidade, cbuf;
    private JButton btpesquisa;
    private JButton btcancelar;
    private JButton btexcluir;
    private JButton btalterar;
    private JButton btnovo;
    private JButton btsalva;
    private MaskFormatter cep;
    private MaskFormatter cpf;
    private MaskFormatter tel, cel;
    private JTable table;
    
    private String funcao = "salvar";
    private String funcao2;
    
	
    private ModelCadCliente mCadCliente;//Declarando o modelo do banco cliente
    private ControllerCadCliente cCadCliente;//Declanrando o controle do banco
	
    //metodo construtor
    public ViewCadCliente() {
	super("Cadastro de Cliente");//titulo da janela
	setSize(633,481);//tamanho da tela
	setLocationRelativeTo(null);//deixa a janela no centro
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//fechar a janela
	setResizable(false);//para a tela não ser maximizada
	c = getContentPane();//inicia o container
	c.setLayout(null); //posicao do layout absoluta
		
	//Declarando e iniciando os rotulos 
	JLabel lbcodigo = new JLabel("Código:");
	JLabel lbnome = new JLabel("Nome Completo:");
	JLabel lbcpf = new JLabel("CPF:");
	JLabel lbemail = new JLabel("E-mail:");
	JLabel lbtelefone = new JLabel("Telefone:");
	JLabel lbcelular = new JLabel("Celular:");
	JLabel lbendereco = new JLabel("Endereço:");
	JLabel lbnumcasa = new JLabel("Nº:");
	JLabel lbcomplemento = new JLabel("Complemento:");
	JLabel lbbairro = new JLabel("Bairro:");
	JLabel lbcidade = new JLabel("Cidade:");
	JLabel lbuf = new JLabel("UF:");
	JLabel lbcep = new JLabel("CEP:");
	JLabel lbpesquisa = new JLabel("Pesquisa:");
	
        try {
            //mascaras de campo
            cep = new MaskFormatter("#####-###");
            //so aceita numeros
            cep.setValidCharacters("0123456789");
            cpf = new MaskFormatter("###.###.###-##");
            cpf.setValidCharacters("0123456789");
            cel = new MaskFormatter("(##)#####-####");
            cel.setValidCharacters("0123456789");
            tel = new MaskFormatter("(##)#####-####");
            tel.setValidCharacters("0123456789");
        } catch (ParseException se) {
            JOptionPane.showMessageDialog(null, "Aviso: " + se.getMessage());
        }
	//Inciando o campos de texto
	txtcodigo = new JTextField();
        txtcodigo.setEditable(false);//desabilitar campo de texto
	txtnome = new JTextFieldSomenteLetras();//forca somente letra
        txtcpf = new JFormattedTextField(cpf);//cpf mascara para cpf
	txtemail = new JTextField();
	txtendereco = new JTextFieldSomenteLetras();//forca somente letra
	txtnumcasa = new JTextFieldSomenteNumeros();//forca a aceitar so numero
	txtcomplemento = new JTextFieldSomenteLetras();//forca somente letra
        txttelefone = new JFormattedTextField(tel);//tel mascara para telefone   
        txtcelular = new JFormattedTextField(cel);//cel mascara para telefone celular
        txtcep = new JFormattedTextField(cep);//cep mascara para cep
	txtpesquisa = new JTextField();
		
	//Inciando combobox
	cbbairro = new JComboBox();
	cbcidade = new JComboBox();
	cbuf = new JComboBox();
		
	//Declarando e iniciando os botaos
	btpesquisa = new JButton("Pesquisa");
	btcancelar = new JButton("Cancelar");
	btexcluir = new JButton("Excluir");
	btalterar = new JButton("Alterar");
	btnovo = new JButton("Novo");
	btsalva = new JButton("Salvar");
		
	//posições dos rotulos
	lbcodigo.setBounds(12, 12, 70, 15);
	lbnome.setBounds(138, 12, 150, 15);
	lbendereco.setBounds(12, 102, 82, 15);
	lbbairro.setBounds(12, 147, 70, 15);
	lbcidade.setBounds(157, 147, 70, 15);
	lbnumcasa.setBounds(280, 102, 40, 15);
	lbtelefone.setBounds(286, 55, 70, 15);
	lbcomplemento.setBounds(359, 102, 150, 15);
	lbcelular.setBounds(456, 55, 70, 15);
	lbcpf.setBounds(448, 12, 70, 15);
	lbemail.setBounds(12, 55, 70, 15);
	lbpesquisa.setBounds(12, 201, 70, 15);
	lbuf.setBounds(302, 147, 70, 15);
	lbcep.setBounds(448, 147, 70, 15);
		
	//posiçoes dos compos de texto
	txtcodigo.setBounds(12, 30, 114, 19);
	txtnome.setBounds(138, 30, 297, 19);
	txtcpf.setBounds(448, 30, 169, 19);
	txtemail.setBounds(12, 74, 262, 19);
	txttelefone.setBounds(285, 74, 158, 19);
	txtcelular.setBounds(455, 74, 162, 19);
	txtendereco.setBounds(12, 121, 256, 19);
	txtnumcasa.setBounds(279, 121, 68, 19);
	txtcomplemento.setBounds(359, 121, 257, 19);
	txtcep.setBounds(448, 168, 169, 19);
	txtpesquisa.setBounds(12, 221, 478, 19);
		
	//lagura de cada campo de texto
	txtcodigo.setColumns(10);
	txtnome.setColumns(10);
	txtcpf.setColumns(10);
	txtemail.setColumns(10);
	txttelefone.setColumns(10);
	txtcelular.setColumns(10);
	txtendereco.setColumns(10);
	txtnumcasa.setColumns(10);
	txtcomplemento.setColumns(10);
	txtcep.setColumns(10);		
	txtpesquisa.setColumns(10);
		
	//posicao dos combobox
	cbbairro.setBounds(12, 165, 133, 24);
	cbcidade.setBounds(157, 165, 133, 24);
	cbuf.setBounds(302, 165, 133, 24);
		
	//posicao dos botoes
	btpesquisa.setBounds(500, 218, 117, 25);
	btcancelar.setBounds(12, 418, 96, 25);
	btexcluir.setBounds(120, 418, 95, 25);
	btalterar.setBounds(227, 418, 95, 25);
	btnovo.setBounds(334, 418, 95, 25);
	btsalva.setBounds(525, 418, 95, 25);
		
		//add o rotulos na tela
	c.add(lbcodigo);		
	c.add(lbnome);
	c.add(lbendereco);
	c.add(lbbairro);
	c.add(lbcidade);
	c.add(lbuf);
	c.add(lbcomplemento);		
	c.add(lbcelular);
	c.add(lbcpf);
	c.add(lbnumcasa);
	c.add(lbcep);
	c.add(lbtelefone);
	c.add(lbemail);
	c.add(lbpesquisa);
		
	//add campos de texto na tela
	c.add(txtcodigo);
	c.add(txtnome);
	c.add(txtendereco);
	c.add(txtcep);
	c.add(txtnumcasa);
	c.add(txttelefone);		
	c.add(txtcelular);
	c.add(txtcomplemento);
	c.add(txtcpf);		
	c.add(txtemail);
	c.add(txtpesquisa);
		
	//add combobox na tela
	c.add(cbbairro);
	c.add(cbcidade);		
	c.add(cbuf);
						
	//add botoes na tela
	c.add(btpesquisa);
	c.add(btcancelar);
	c.add(btexcluir);
	c.add(btalterar);
	c.add(btnovo);
	c.add(btsalva);
        
        //incia os botoes e campos de texto desabilitado
        desabilitarBotoes();
        
        //ouvites de eventos
        btnovo.addActionListener(new Bt_novo());
        btcancelar.addActionListener(new Bt_cancelar());
        btsalva.addActionListener(new Bt_salva());
        btalterar.addActionListener(new Bt_editar());
        btexcluir.addActionListener(new Bt_excluir());
        
        table = new JTable();
	preenchertabela();
	JScrollPane scrollPane = new JScrollPane(table);
	scrollPane.setBounds(12, 252, 605, 154);
	getContentPane().add(scrollPane);
	
		
	}//fim metodo constructor
	
    public void desabilitarBotoes(){
        txtnome.setEditable(false);
        txtcpf.setEditable(false);
        txtemail.setEditable(false);
        txttelefone.setEditable(false);
        txtcelular.setEditable(false);
        txtendereco.setEditable(false);
        txtnumcasa.setEditable(false);;
        txtcomplemento.setEditable(false);
        txtcep.setEditable(false);
        
        cbbairro.setEnabled(false);
        cbcidade.setEnabled(false);
        cbuf.setEnabled(false);
        
        btcancelar.setEnabled(false);
        btsalva.setEnabled(false);
        
        btnovo.setEnabled(true);
        btalterar.setEnabled(true);
        btexcluir.setEnabled(true);
        

    }
    public void habilitaBotoes(){
        
        txtnome.setEditable(true);
        txtcpf.setEditable(true);
        txtemail.setEditable(true);
        txttelefone.setEditable(true);
        txtcelular.setEditable(true);
        txtendereco.setEditable(true);
        txtnumcasa.setEditable(true);
        txtcomplemento.setEditable(true);
        txtcep.setEditable(true);
        
        cbbairro.setEnabled(true);
        cbcidade.setEnabled(true);
        cbuf.setEnabled(true);
        
        btcancelar.setEnabled(true);
        btsalva.setEnabled(true);
        
        btnovo.setEnabled(false);
        btalterar.setEnabled(false);
        btexcluir.setEnabled(false);
        
    }
    public void limpartela(){
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
    }
	
    //metodo para obter dados do campos de texto
    //retorna o objeto do modelo cliente
    //o controle recebe o modelo, para cadastrar autlizar ou excluir
    private ModelCadCliente montarCliente(String funcao){
	//modelo
	mCadCliente = new ModelCadCliente();
	//codicao
            if(funcao.equals("salvar")){
		mCadCliente.setCli_nome(txtnome.getText());
		mCadCliente.setCli_cpf(txtcpf.getText());
		mCadCliente.setCli_email(txtemail.getText());
		mCadCliente.setCli_telefone(txttelefone.getText());
		mCadCliente.setCli_celular(txtcelular.getText());
		mCadCliente.setCli_endereco(txtendereco.getText());
		mCadCliente.setCli_numcasa(txtnumcasa.getText());
		mCadCliente.setCli_complemento(txtcomplemento.getText());
		mCadCliente.setCli_bairro(cbbairro.getSelectedIndex());
		mCadCliente.setCli_idcidade(cbcidade.getSelectedIndex());
		mCadCliente.setCli_idestado(cbuf.getSelectedIndex());
		mCadCliente.setCli_cep(txtcep.getText());
		}
            else{	
		mCadCliente.setCli_nome(txtnome.getText());
		mCadCliente.setCli_cpf(txtcpf.getText());
		mCadCliente.setCli_email(txtemail.getText());
		mCadCliente.setCli_telefone(txttelefone.getText());
		mCadCliente.setCli_celular(txtcelular.getText());
		mCadCliente.setCli_endereco(txtendereco.getText());
		mCadCliente.setCli_numcasa(txtnumcasa.getText());
		mCadCliente.setCli_complemento(txtcomplemento.getText());
		mCadCliente.setCli_bairro(cbbairro.getSelectedIndex());
		mCadCliente.setCli_idcidade(cbcidade.getSelectedIndex());
		mCadCliente.setCli_idestado(cbuf.getSelectedIndex());
		mCadCliente.setCli_cep(txtcep.getText());
                    if (this.txtcodigo.getText() != null && !this.txtcodigo.getText().equals("")) {
			mCadCliente.setCli_id(Integer.parseInt(this.txtcodigo.getText()));
                    }
			
		}
		//retorno do objeto modelo
		return mCadCliente;
    }//fim metodo para construir tela
    
    //pegar dados da tabela e retorna para os campos
    private void pegadados(){
     int linha = table.getSelectedRow();
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
     txtcep.setText(""+table.getValueAt(linha, 12));
    }
	
    //metodo para modelo a tabela do form
    //e preencher o mesmo
    private void preenchertabela(){
		
	//ConexaoJdbc.executarSQL("Select * from cad_categoria");
	mCadCliente = new ModelCadCliente();
	cCadCliente = new ControllerCadCliente();
		
	//Lista de clientes recebe do controle o retorno de uma consulta no banco
	List<ModelCadCliente> clientes = cCadCliente.select();
	//criar o vetor dados para preencher a tabela
	ArrayList dados = new ArrayList();
		
	//para preencher as linhas da tabela com os dados
	for (ModelCadCliente model : clientes) {
            //add cada dado em linhas da table
            dados.add(new Object[]{model.getCli_id(),model.getCli_nome(),model.getCli_cpf(),
                model.getCli_email(),model.getCli_telefone(),model.getCli_celular(),
		model.getCli_endereco(),model.getCli_numcasa(),model.getCli_complemento()
		,model.getCli_bairro(), model.getCli_idcidade(), model.getCli_idestado()
		,model.getCli_cep()
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
    
    //novo titulo dinamico
    private void titulodajanela(String titulo){
        new ViewCadCliente().setTitle("Cadastro de Cliente" + titulo);
    }
    
    
    
    //##============================================================EVENTOS===============================================================
        
        //class para add novo cliente
        private class Bt_novo implements ActionListener{
            public void actionPerformed(ActionEvent ae) {
                //abilita campos e botoes
                habilitaBotoes();
                //limpa a tela
                limpartela();
                //add a fução novo
                funcao = "salvar";
                titulodajanela("[Novo Cadastro]");
            }
        }
        //class para inserir as informações no banco de dados
        private class Bt_salva implements ActionListener{
            public void actionPerformed(ActionEvent ae) {     
            //para salvar depende da funcao se recebeu salvar ou editar
            //se funcao receber salvar ao clickar no botao novo ele excuta
            //o insert
            if(funcao.equals("salvar")){
               //insert recebe os dados dos campos de texto
               //retorna para a insersão ao banco
               cCadCliente.insert(montarCliente("salvar"));
               //apos desabilita os campos
               desabilitarBotoes();
               //limpa a tela
               limpartela();
               //atualiza a tabela
               preenchertabela();
               
            }
            else{//senao for salvar, foi clickado no boatao editar
               //e o metodo montar tela pega os dados do campo
               //e retorna para update atualizar as informações do
               //usuario
               cCadCliente.update(montarCliente("editar"));
               //desabilita os campos
               desabilitarBotoes();
               //limpa a tela
               limpartela();
               //atualiza a tabela
               preenchertabela();
            }
          }
        }
        //class pra atualiza dados do cliente
        private class Bt_editar implements ActionListener{
            public void actionPerformed(ActionEvent ae) {
             funcao = "editar";//add a função editar para a variavel
             titulodajanela("[Atualizar Cadastro]");
             habilitaBotoes();//habilita campos e botoes
             pegadados();//e recupera os dados da tabela
            }
        }
        //class para excluir cliente
        private class Bt_excluir implements ActionListener{
            public void actionPerformed(ActionEvent ae) {
                //retorna o indice da linha
                int linha = table.getSelectedRow();
                //pergunta
                String descricao = "Deseja excluir o Cliente:"+table.getValueAt(linha,1)+"?";
                //obtem o valor verdadeiro ou falso (1,0)
                int opcao = JOptionPane.showConfirmDialog(null,descricao,"Atenção",JOptionPane.YES_NO_OPTION);
                    //faz a comparação
                    if(opcao == JOptionPane.YES_OPTION){
                        //pega o codigo do cliente
                        mCadCliente.setCli_id((int) (table.getValueAt(linha, 0)));
                        //passa para o delete
                        cCadCliente.delete(mCadCliente);
                        //assim que o usuario e excluido
                        //atualiza a tebela
                        preenchertabela();
                    }
                    else{
                        //senao quiser excluir cliente
                        //desabilita os camppos
                       desabilitarBotoes();
                    }
             }
        }
        //class para cancelar a acao de outros botoes
        private class Bt_cancelar implements ActionListener{
            public void actionPerformed(ActionEvent ae) {
                desabilitarBotoes();//desabilita botoes e campos de texto
                limpartela();//limpa a tela
            }
        }
        //class de filtro de tabela
        private class Bt_pesquisa implements ActionListener{
            public void actionPerformed(ActionEvent ae) {
            
            }
        }
    //##=======================================================================FIM DE EVENTOS ==========================================
	//metodo principal
	public static void main(String[] args) {
	 //chama a janela tornado à visivel
	 new ViewCadCliente().setVisible(true);
	}//fim metodo principal
}
