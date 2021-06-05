package view;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.DAO;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				status();
			}
		});
		setTitle("CONEST- Sistema de controle de estoque");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/icones/pc.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 507, 794, 64);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblDataLabel = new JLabel("");
		lblDataLabel.setForeground(SystemColor.textHighlightText);
		lblDataLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDataLabel.setBounds(485, 11, 309, 42);
		panel.add(lblDataLabel);
		
		lblStatus = new JLabel("");
		lblStatus.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/dbcon.png")));
		lblStatus.setBounds(21, 11, 32, 32);
		panel.add(lblStatus);
		
		JButton btnProduto = new JButton("");
		btnProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaProduto produto = new TelaProduto();
			    produto.setVisible(true);
			}			
		});
		btnProduto.setToolTipText("Entrada");
		btnProduto.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/entrada.png")));
		btnProduto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnProduto.setBounds(10, 21, 128, 128);
		contentPane.add(btnProduto);
		
		JButton btnConsulta = new JButton("");
		btnConsulta.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/consulta.png")));
		btnConsulta.setToolTipText("Consulta");
		btnConsulta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConsulta.setBounds(330, 21, 128, 128);
		contentPane.add(btnConsulta);
		
		JButton btnSaida = new JButton("");
		btnSaida.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/saida.png")));
		btnSaida.setToolTipText("Sa\u00EDda");
		btnSaida.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSaida.setBounds(644, 21, 128, 128);
		contentPane.add(btnSaida);
		
		JButton btnFornecedor = new JButton("");
		btnFornecedor.setToolTipText("Fornecedor");
		btnFornecedor.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/fornecedor.png")));
		btnFornecedor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFornecedor.setBounds(171, 168, 128, 128);
		contentPane.add(btnFornecedor);
		
		JButton btnRelatorio = new JButton("");
		btnRelatorio.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/report.png")));
		btnRelatorio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRelatorio.setToolTipText("Relat\u00F3rios");
		btnRelatorio.setBounds(495, 168, 128, 128);
		contentPane.add(btnRelatorio);
		
		JButton btnSobre = new JButton("");
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// evento clicar no botão sobre
				TelaSobre sobre = new TelaSobre();
				sobre.setVisible(true);
			}
			
		});
		btnSobre.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/about.png")));
		btnSobre.setToolTipText("Sobre");
		btnSobre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSobre.setBounds(330, 318, 128, 128);
		contentPane.add(btnSobre);
	}
	DAO dao = new DAO();
	private JLabel lblDataLabel;
	private JLabel lblStatus;

	/**
	 * Status da conexão
	 */
	private void status() {
		try {
			// estabelecer uma conexão
			Connection con = dao.conectar();
			// status
			// System.out.println(con);
			// trocando o icone do database(status da conexão)
			if (con != null) {
			lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/dbon.png")));

			} else
				lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/dbof.png")));
			{
			}
			con.close(); // encerrar conexão
		
				} catch (Exception e) {
			System.out.println(e);
			
			
		}
 // modificar a label do rodapé para a data atual
		Date datalabel = new Date();
		DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
		lblDataLabel.setText(formatador.format(datalabel));
	}
}
