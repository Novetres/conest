package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class TelaSobre extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaSobre dialog = new TelaSobre();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TelaSobre() {
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaSobre.class.getResource("/icones/pc.png")));
		setTitle("Sobre");
		setBounds(100, 100, 450, 240);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Sistema de controle de estoque");
			lblNewLabel.setBounds(35, 44, 332, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Autor: Paloma Kimberly Figueredo");
			lblNewLabel_1.setBounds(35, 69, 205, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Vers\u00E3o 1.0");
			lblNewLabel_2.setBounds(35, 94, 67, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Sob a licen\u00E7a GPL");
			lblNewLabel_3.setBounds(35, 116, 102, 14);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setIcon(new ImageIcon(TelaSobre.class.getResource("/icones/gpl.png")));
			lblNewLabel_4.setBounds(320, 44, 64, 64);
			contentPanel.add(lblNewLabel_4);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("github.com/Novetres");
			lblNewLabel_5.setForeground(SystemColor.textHighlight);
			lblNewLabel_5.setBounds(35, 141, 142, 14);
			contentPanel.add(lblNewLabel_5);
		}
	}

}
