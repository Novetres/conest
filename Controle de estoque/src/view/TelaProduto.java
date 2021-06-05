package view;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import Atxy2k.CustomTextField.RestrictedTextField;
import model.DAO;

public class TelaProduto extends JDialog {
	private JTextField txtBarcode;
	private JTextField txtProduto;
	private JTextField txtFabricante;
	private JTextField txtQuantidade;
	private JTextField txtEstoqueMinimo;
	private JTextField txtLocalizacao;
	private JDateChooser dateChooser;
	private JTextField txtValor;
	private JComboBox cboMedida;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProduto dialog = new TelaProduto();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public TelaProduto() {
		setResizable(false);
		setTitle("CONEST - Produto");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaProduto.class.getResource("/icones/pc.png")));
		setModal(true);
		setBounds(145, 135, 800, 600);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaProduto.class.getResource("/icones/barcode.png")));
		lblNewLabel.setBounds(18, 31, 64, 45);
		getContentPane().add(lblNewLabel);

		txtBarcode = new JTextField();
		txtBarcode.setBounds(116, 45, 238, 20);
		getContentPane().add(txtBarcode);
		txtBarcode.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Produto");
		lblNewLabel_1.setBounds(36, 110, 46, 14);
		getContentPane().add(lblNewLabel_1);

		txtProduto = new JTextField();

		txtProduto.setBounds(116, 107, 392, 20);
		getContentPane().add(txtProduto);
		txtProduto.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Fabricante");
		lblNewLabel_2.setBounds(36, 167, 72, 14);
		getContentPane().add(lblNewLabel_2);

		txtFabricante = new JTextField();
		txtFabricante.setBounds(116, 164, 166, 20);
		getContentPane().add(txtFabricante);
		txtFabricante.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Validade");
		lblNewLabel_3.setBounds(395, 167, 64, 14);
		getContentPane().add(lblNewLabel_3);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(469, 164, 166, 20);
		getContentPane().add(dateChooser);

		JLabel lblNewLabel_4 = new JLabel("Quantidade");
		lblNewLabel_4.setBounds(36, 225, 72, 14);
		getContentPane().add(lblNewLabel_4);

		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(116, 222, 86, 20);
		getContentPane().add(txtQuantidade);
		txtQuantidade.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Medida");
		lblNewLabel_5.setBounds(263, 225, 46, 14);
		getContentPane().add(lblNewLabel_5);

		cboMedida = new JComboBox();
		cboMedida.setModel(new DefaultComboBoxModel(new String[] { "Selecione", "Un", "Cx", "Pct", "Kg" }));
		cboMedida.setBounds(330, 221, 104, 22);
		getContentPane().add(cboMedida);

		JLabel lblNewLabel_6 = new JLabel("Estoque M\u00EDnimo");
		lblNewLabel_6.setBounds(499, 225, 90, 14);
		getContentPane().add(lblNewLabel_6);

		txtEstoqueMinimo = new JTextField();
		txtEstoqueMinimo.setBounds(605, 222, 86, 20);
		getContentPane().add(txtEstoqueMinimo);
		txtEstoqueMinimo.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Valor");
		lblNewLabel_7.setBounds(36, 282, 46, 14);
		getContentPane().add(lblNewLabel_7);

		txtValor = new JTextField();
		txtValor.setBounds(116, 279, 86, 20);
		getContentPane().add(txtValor);
		txtValor.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Localiza\u00E7\u00E3o");
		lblNewLabel_8.setBounds(344, 282, 86, 14);
		getContentPane().add(lblNewLabel_8);

		txtLocalizacao = new JTextField();
		txtLocalizacao.setBounds(440, 279, 166, 20);
		getContentPane().add(txtLocalizacao);
		txtLocalizacao.setColumns(10);

		JButton btnAdicionarProduto = new JButton("");
		btnAdicionarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inserirProduto();
			}
		});
		btnAdicionarProduto.setToolTipText("Adicionar Produto");
		btnAdicionarProduto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdicionarProduto.setIcon(new ImageIcon(TelaProduto.class.getResource("/icones/create.png")));
		btnAdicionarProduto.setBorder(null);
		btnAdicionarProduto.setBackground(SystemColor.control);
		btnAdicionarProduto.setBounds(366, 396, 64, 64);
		getContentPane().add(btnAdicionarProduto);

		// txtProduto
		RestrictedTextField barcode = new RestrictedTextField(txtBarcode);
		barcode.setLimit(100);

		// txtProduto
		RestrictedTextField produto = new RestrictedTextField(txtProduto);
		produto.setLimit(100);

		// txtFabricante
		RestrictedTextField fabricante = new RestrictedTextField(txtFabricante);
		fabricante.setLimit(100);

		// Validacao dos campos com a biblioteca Atxy2k
		// txtquantidade
		RestrictedTextField quantidade = new RestrictedTextField(txtQuantidade);
		quantidade.setOnlyNums(true);
		quantidade.setLimit(9);

		// txtquantidade
		RestrictedTextField estoqueMin = new RestrictedTextField(txtEstoqueMinimo);
		estoqueMin.setOnlyNums(true);
		estoqueMin.setLimit(9);

		// txtvalor
		// obs(dentro de parenteses escolhemos os caracteres permitidos)
		RestrictedTextField valor = new RestrictedTextField(txtValor, "0123456789.");
		valor.setLimit(8);

		// txtlocalizacao
		RestrictedTextField localizacao = new RestrictedTextField(txtLocalizacao);
		localizacao.setLimit(100);

	}// The End

	DAO dao = new DAO();

	/**
	 * Inserir produto
	 */

	private void inserirProduto() {
		// validacao dos campos obrigatorios
		if (txtProduto.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o campo Produto");
			// retorno o cursor ao campo
			txtProduto.requestFocus();

		} else if (txtFabricante.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o campo Fabricante");
			txtFabricante.requestFocus();

		} else if (dateChooser.getDate() == null) {
			JOptionPane.showMessageDialog(null, "Preencha a data de validade");
			dateChooser.requestFocus();

		} else if (txtQuantidade.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o campo Quantidade");
			txtQuantidade.requestFocus();

		} else if (cboMedida.getSelectedItem() == "Selecione") {
			JOptionPane.showMessageDialog(null, "Informe a medida");
			cboMedida.requestFocus();

		} else if (txtEstoqueMinimo.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Informe o estoque mínimo");
			txtEstoqueMinimo.requestFocus();
		} else {
			// validacao bem sucedida - inserir dados no banco
			// Query
			String insertProdutos = "insert into estoque (barcode,produto,fabricante,dataval,quantidade,estoquemin,medida,valor,localizacao) values(?,?,?,?,?,?,?,?,?)";
			//
			try {
				Connection con = dao.conectar();
				// preparar a conexao substituindo os parametros "?" pelo conteudo dos objetos
				// (caixa de texto, combobox etc.)

				PreparedStatement pst = con.prepareStatement(insertProdutos);
				pst.setString(1, txtBarcode.getText());
				pst.setString(2, txtProduto.getText());
				pst.setString(3, txtFabricante.getText());

				// formartar o valor da Jcalendar para insercao correta no banco de dados
				SimpleDateFormat formartador = new SimpleDateFormat("yyyyMMdd");
				String dataValidade = formartador.format(dateChooser.getDate());
				pst.setString(4, dataValidade);

				pst.setString(5, txtQuantidade.getText());
				pst.setString(6, txtEstoqueMinimo.getText());

				// captura combobox
				pst.setString(7, cboMedida.getSelectedItem().toString());

				pst.setString(8, txtValor.getText());
				pst.setString(9, txtLocalizacao.getText());

				// executar a query (confirmacao)
				int sucesso = pst.executeUpdate();
				// resultado 0 = Deu erro 1 = Deu certo
				if (sucesso == 1) {
					JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");
				}
				

				con.close();
				limpar();
			} catch (SQLIntegrityConstraintViolationException e) {
				JOptionPane.showMessageDialog(null, "Código de barras duplicado");
				txtBarcode.setText(null);
				txtBarcode.requestFocus();
								
			} catch (Exception e) {
				System.out.println(e);
				

			
			}}}
		
		private void limpar() {
		txtBarcode.setText(null);
		txtProduto.setText(null);
		dateChooser.setDate(null);
		txtFabricante.setText(null);
		txtQuantidade.setText(null);
		txtEstoqueMinimo.setText(null);
		cboMedida.setSelectedItem(null);
		txtValor.setText(null);
		txtLocalizacao.setText(null);
		

	}
}
