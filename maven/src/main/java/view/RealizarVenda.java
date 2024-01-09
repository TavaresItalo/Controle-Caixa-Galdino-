package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controllers.ControllerCliente;
import controllers.ControllerVendas;
import controllers.ExcecaoControladores;
import data.ExcecaoDados;

import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class RealizarVenda extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtValor;
	private ControllerCliente controllerCliente = new ControllerCliente();
	private ControllerVendas controllerVendas = new ControllerVendas();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RealizarVenda frame = new RealizarVenda();
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
	public RealizarVenda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(183, 91, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblTitulo = new JLabel("REALIZAR VENDA");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTitulo.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.insets = new Insets(20, 0, 50, 5);
		gbc_lblTitulo.gridwidth = 4;
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 0;
		contentPane.add(lblTitulo, gbc_lblTitulo);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaPrincipal().setVisible(true);
			}
		});
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnVoltar.setBackground(new Color(128, 64, 0));
		GridBagConstraints gbc_btnVoltar = new GridBagConstraints();
		gbc_btnVoltar.insets = new Insets(20, 0, 50, 20);
		gbc_btnVoltar.gridx = 4;
		gbc_btnVoltar.gridy = 0;
		contentPane.add(btnVoltar, gbc_btnVoltar);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setForeground(new Color(255, 255, 255));
		lblValor.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblValor = new GridBagConstraints();
		gbc_lblValor.anchor = GridBagConstraints.EAST;
		gbc_lblValor.insets = new Insets(0, 100, 15, 5);
		gbc_lblValor.gridx = 0;
		gbc_lblValor.gridy = 2;
		contentPane.add(lblValor, gbc_lblValor);
		
		txtValor = new JTextField();
		txtValor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_txtValor = new GridBagConstraints();
		gbc_txtValor.gridwidth = 3;
		gbc_txtValor.insets = new Insets(0, 0, 15, 100);
		gbc_txtValor.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtValor.gridx = 1;
		gbc_txtValor.gridy = 2;
		contentPane.add(txtValor, gbc_txtValor);
		txtValor.setColumns(10);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setForeground(new Color(255, 255, 255));
		lblData.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblData = new GridBagConstraints();
		gbc_lblData.anchor = GridBagConstraints.EAST;
		gbc_lblData.insets = new Insets(0, 0, 15, 5);
		gbc_lblData.gridx = 0;
		gbc_lblData.gridy = 3;
		contentPane.add(lblData, gbc_lblData);
		
		MaskFormatter mascara= null;
		try {
		 mascara = new MaskFormatter("##/##/####");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JFormattedTextField ftxtData = new JFormattedTextField( mascara);
		ftxtData.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_ftxtData = new GridBagConstraints();
		gbc_ftxtData.insets = new Insets(0, 0, 15, 100);
		gbc_ftxtData.fill = GridBagConstraints.HORIZONTAL;
		gbc_ftxtData.gridx = 1;
		gbc_ftxtData.gridy = 3;
		contentPane.add(ftxtData, gbc_ftxtData);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCliente.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.anchor = GridBagConstraints.EAST;
		gbc_lblCliente.insets = new Insets(0, 0, 50, 5);
		gbc_lblCliente.gridx = 0;
		gbc_lblCliente.gridy = 4;
		contentPane.add(lblCliente, gbc_lblCliente);
		
		JComboBox comboBoxClientes = new JComboBox();
		
		try {
			ArrayList<String> nomeClientes = controllerCliente.buscarNomeTodosOsClientes();
			for (String nome : nomeClientes) {
				comboBoxClientes.addItem(nome);
			}
		} catch (ExcecaoDados e1) {
			e1.printStackTrace();
		}
		
		comboBoxClientes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_comboBoxClientes = new GridBagConstraints();
		gbc_comboBoxClientes.gridwidth = 3;
		gbc_comboBoxClientes.insets = new Insets(0, 0, 50, 100);
		gbc_comboBoxClientes.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxClientes.gridx = 1;
		gbc_comboBoxClientes.gridy = 4;
		contentPane.add(comboBoxClientes, gbc_comboBoxClientes);
		
		JButton btnFinalizar = new JButton("FINALIZAR");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String valor = txtValor.getText();
				String data = ftxtData.getText();
				String nomeCliente = comboBoxClientes.getSelectedItem().toString();
				
				try {
					controllerVendas.realizarVenda(valor, data, nomeCliente);
				} catch (ExcecaoControladores e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null, "A venda foi cadastrado com sucesso.", "Success", JOptionPane.INFORMATION_MESSAGE);
				
				txtValor.setText("");
				ftxtData.setText("");
			}
		});
		btnFinalizar.setForeground(new Color(255, 255, 255));
		btnFinalizar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnFinalizar.setBackground(new Color(128, 64, 0));
		GridBagConstraints gbc_btnFinalizar = new GridBagConstraints();
		gbc_btnFinalizar.gridwidth = 4;
		gbc_btnFinalizar.insets = new Insets(0, 0, 0, 5);
		gbc_btnFinalizar.gridx = 0;
		gbc_btnFinalizar.gridy = 7;
		contentPane.add(btnFinalizar, gbc_btnFinalizar);
	}

}
