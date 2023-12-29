package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(183, 91, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setForeground(new Color(255, 0, 0));
		btnSair.setBackground(new Color(128, 64, 0));
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_btnSair = new GridBagConstraints();
		gbc_btnSair.insets = new Insets(0, 0, 5, 0);
		gbc_btnSair.gridx = 3;
		gbc_btnSair.gridy = 0;
		contentPane.add(btnSair, gbc_btnSair);
		
		JLabel lblTitulo = new JLabel("MENU PRINCIPAL");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 30));
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.gridwidth = 4;
		gbc_lblTitulo.insets = new Insets(20, 0, 50, 0);
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 1;
		contentPane.add(lblTitulo, gbc_lblTitulo);
		
		JButton btnCadastrarCliente = new JButton("CADASTRAR CLIENTE");
		btnCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new CadastrarCliente().setVisible(true);
			}
		});
		btnCadastrarCliente.setForeground(new Color(255, 255, 255));
		btnCadastrarCliente.setBackground(new Color(128, 64, 0));
		btnCadastrarCliente.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_btnCadastrarCliente = new GridBagConstraints();
		gbc_btnCadastrarCliente.gridwidth = 4;
		gbc_btnCadastrarCliente.insets = new Insets(0, 0, 15, 0);
		gbc_btnCadastrarCliente.gridx = 0;
		gbc_btnCadastrarCliente.gridy = 2;
		contentPane.add(btnCadastrarCliente, gbc_btnCadastrarCliente);
		
		JButton btnRealizarVenda = new JButton("REALIZAR VENDA");
		btnRealizarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new RealizarVenda().setVisible(true);
			}
		});
		btnRealizarVenda.setForeground(new Color(255, 255, 255));
		btnRealizarVenda.setBackground(new Color(128, 64, 0));
		btnRealizarVenda.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_btnRealizarVenda = new GridBagConstraints();
		gbc_btnRealizarVenda.insets = new Insets(0, 0, 15, 0);
		gbc_btnRealizarVenda.gridwidth = 4;
		gbc_btnRealizarVenda.gridx = 0;
		gbc_btnRealizarVenda.gridy = 3;
		contentPane.add(btnRealizarVenda, gbc_btnRealizarVenda);
		
		JButton btnVisualizarDebitos = new JButton("VISUALIZAR DÉBITOSs");
		btnVisualizarDebitos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new VisualizarDebitos().setVisible(true);
			}
		});
		btnVisualizarDebitos.setForeground(new Color(255, 255, 255));
		btnVisualizarDebitos.setBackground(new Color(128, 64, 0));
		btnVisualizarDebitos.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_btnVisualizarDebitos = new GridBagConstraints();
		gbc_btnVisualizarDebitos.insets = new Insets(0, 0, 15, 0);
		gbc_btnVisualizarDebitos.gridwidth = 4;
		gbc_btnVisualizarDebitos.gridx = 0;
		gbc_btnVisualizarDebitos.gridy = 4;
		contentPane.add(btnVisualizarDebitos, gbc_btnVisualizarDebitos);
		
		JButton btnVisualizarClientes = new JButton("VISUALIZAR CIENTES ");
		btnVisualizarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new VisualizarClientes().setVisible(true);
			}
		});
		btnVisualizarClientes.setForeground(new Color(255, 255, 255));
		btnVisualizarClientes.setBackground(new Color(128, 64, 0));
		btnVisualizarClientes.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_btnVisualizarClientes = new GridBagConstraints();
		gbc_btnVisualizarClientes.insets = new Insets(0, 0, 15, 0);
		gbc_btnVisualizarClientes.gridwidth = 4;
		gbc_btnVisualizarClientes.gridx = 0;
		gbc_btnVisualizarClientes.gridy = 5;
		contentPane.add(btnVisualizarClientes, gbc_btnVisualizarClientes);
		
		JButton btnRealizarPagemento = new JButton("REALIZAR PAGAMENTO");
		btnRealizarPagemento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new RealizarPagamento().setVisible(true);
			}
		});
		btnRealizarPagemento.setBackground(new Color(128, 64, 0));
		btnRealizarPagemento.setForeground(new Color(255, 255, 255));
		btnRealizarPagemento.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_btnRealizarPagemento = new GridBagConstraints();
		gbc_btnRealizarPagemento.gridwidth = 4;
		gbc_btnRealizarPagemento.insets = new Insets(0, 0, 0, 5);
		gbc_btnRealizarPagemento.gridx = 0;
		gbc_btnRealizarPagemento.gridy = 6;
		contentPane.add(btnRealizarPagemento, gbc_btnRealizarPagemento);
	}

}
