package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;

import controllers.ControllerCliente;
import controllers.ExcecaoControladores;
import data.ExcecaoDados;
import models.Cliente;

import javax.swing.event.ListSelectionEvent;

public class VisualizarClientes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTelefone;
	private JTextField txtEmail;
	private ControllerCliente controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizarClientes frame = new VisualizarClientes();
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
	public VisualizarClientes() {
		
		controller = new ControllerCliente();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 519);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(183, 91, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblTitulo = new JLabel("VISUALIZAR CLIENTES");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTitulo.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.gridwidth = 3;
		gbc_lblTitulo.insets = new Insets(0, 0, 5, 0);
		gbc_lblTitulo.gridx = 1;
		gbc_lblTitulo.gridy = 0;
		contentPane.add(lblTitulo, gbc_lblTitulo);
		
		JButton btnNewButton = new JButton("VOLTAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaPrincipal().setVisible(true);
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(128, 64, 0));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(10, 0, 5, 0);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 0;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		DefaultListModel<String> jListModel = new DefaultListModel();
		ArrayList<String> nomeClientes = new ArrayList<>();
		
		try {
			nomeClientes = controller.buscarNomeTodosOsClientes();
			jListModel.addAll(nomeClientes);;
		} catch (ExcecaoDados e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		JList listaClientes = new JList(jListModel);
		listaClientes.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int index = listaClientes.getSelectedIndex();
				String nomeCliente = jListModel.get(index);
				
				Cliente cliente = controller.buscarClientePorNome(nomeCliente);
				
				txtEmail.setText(cliente.getEmail());
				txtEmail.setEditable(false);
				txtTelefone.setText(cliente.getTelefone());
				txtTelefone.setEditable(false);
				
			}
		});
		GridBagConstraints gbc_listaClientes = new GridBagConstraints();
		gbc_listaClientes.gridheight = 12;
		gbc_listaClientes.insets = new Insets(65, 10, 0, 5);
		gbc_listaClientes.fill = GridBagConstraints.BOTH;
		gbc_listaClientes.gridx = 0;
		gbc_listaClientes.gridy = 0;
		contentPane.add(listaClientes, gbc_listaClientes);
		
		JLabel lblNewLabel = new JLabel("Telefone:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 2;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		txtTelefone = new JTextField();
		txtTelefone.setEditable(false);
		GridBagConstraints gbc_txtTelefone = new GridBagConstraints();
		gbc_txtTelefone.insets = new Insets(0, 0, 5, 5);
		gbc_txtTelefone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTelefone.gridx = 3;
		gbc_txtTelefone.gridy = 2;
		contentPane.add(txtTelefone, gbc_txtTelefone);
		txtTelefone.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 200, 5);
		gbc_lblEmail.gridx = 2;
		gbc_lblEmail.gridy = 3;
		contentPane.add(lblEmail, gbc_lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.insets = new Insets(0, 0, 200, 5);
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.gridx = 3;
		gbc_txtEmail.gridy = 3;
		contentPane.add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExcluir.setBackground(new Color(128, 64, 0));
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnExcluir.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
		gbc_btnExcluir.insets = new Insets(0, 0, 20, 5);
		gbc_btnExcluir.gridx = 2;
		gbc_btnExcluir.gridy = 11;
		contentPane.add(btnExcluir, gbc_btnExcluir);
		
		JButton btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtEmail.setText("");
				txtEmail.setEditable(true);
				txtTelefone.setText("");
				txtTelefone.setEditable(true);
			}
		});
		btnEditar.setForeground(new Color(255, 255, 255));
		btnEditar.setBackground(new Color(128, 64, 0));
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_btnEditar = new GridBagConstraints();
		gbc_btnEditar.insets = new Insets(0, 0, 20, 5);
		gbc_btnEditar.gridx = 3;
		gbc_btnEditar.gridy = 11;
		contentPane.add(btnEditar, gbc_btnEditar);
		
		JButton btnAtualizar = new JButton("ATUALIZAR");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String novoTelefone = txtTelefone.getText();
				String novoEmail = txtEmail.getText();
				
				int index = listaClientes.getSelectedIndex();
				String nomeCliente = jListModel.get(index);
				
				try {
					controller.AtualizarDadosCliente(novoEmail, novoTelefone, nomeCliente);
					JOptionPane.showMessageDialog(null, "Dados alterados com sucesso.", "Success", JOptionPane.INFORMATION_MESSAGE);
					
				} catch (ExcecaoControladores e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnAtualizar.setForeground(new Color(255, 255, 255));
		btnAtualizar.setBackground(new Color(128, 64, 0));
		btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_btnAtualizar = new GridBagConstraints();
		gbc_btnAtualizar.insets = new Insets(0, 0, 20, 0);
		gbc_btnAtualizar.gridx = 4;
		gbc_btnAtualizar.gridy = 11;
		contentPane.add(btnAtualizar, gbc_btnAtualizar);
	}

}
