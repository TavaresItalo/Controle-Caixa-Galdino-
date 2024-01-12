package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.ControllerCliente;
import controllers.ControllerVendas;
import data.ExcecaoDados;
import models.Cliente;

import java.awt.GridBagLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class RealizarPagamento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTotalDebitos;
	private ControllerCliente controllerCliente = new ControllerCliente();
	private ControllerVendas controllerVendas = new ControllerVendas();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RealizarPagamento frame = new RealizarPagamento();
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
	public RealizarPagamento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(183, 91, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblTitulo = new JLabel("REALIZAR PAGAMENTO");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.gridwidth = 2;
		gbc_lblTitulo.insets = new Insets(0, 0, 50, 5);
		gbc_lblTitulo.gridx = 1;
		gbc_lblTitulo.gridy = 0;
		contentPane.add(lblTitulo, gbc_lblTitulo);
		
		JButton btnNewButton_1 = new JButton("VOLTAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaPrincipal().setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(128, 64, 0));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 50, 0);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 0;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
		DefaultListModel<String> jListModel = new DefaultListModel();
		ArrayList<String> nomeClientes = new ArrayList<>();
		
		try {
			nomeClientes = controllerCliente.buscarNomeTodosOsClientes();
			jListModel.addAll(nomeClientes);
		} catch (ExcecaoDados e1) {
			e1.printStackTrace();
		}
		
		JList listaClientes = new JList(jListModel);
		
		listaClientes.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				
				int index = listaClientes.getSelectedIndex();
				String nomeCliente = jListModel.get(index);
				
				txtTotalDebitos.setText("" + controllerCliente.buscarDebitoCliente(nomeCliente) + "R$");
			}
		});
		
		GridBagConstraints gbc_listaClientes = new GridBagConstraints();
		gbc_listaClientes.gridheight = 6;
		gbc_listaClientes.insets = new Insets(0, 0, 5, 5);
		gbc_listaClientes.fill = GridBagConstraints.BOTH;
		gbc_listaClientes.gridx = 0;
		gbc_listaClientes.gridy = 0;
		contentPane.add(listaClientes, gbc_listaClientes);
		
		JLabel lblTotal = new JLabel("Total Débitos:");
		lblTotal.setForeground(new Color(255, 255, 255));
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.gridheight = 3;
		gbc_lblTotal.anchor = GridBagConstraints.EAST;
		gbc_lblTotal.insets = new Insets(0, 0, 50, 5);
		gbc_lblTotal.gridx = 1;
		gbc_lblTotal.gridy = 1;
		contentPane.add(lblTotal, gbc_lblTotal);
		
		txtTotalDebitos = new JTextField();
		txtTotalDebitos.setEditable(false);
		txtTotalDebitos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_txtTotalDebitos = new GridBagConstraints();
		gbc_txtTotalDebitos.gridwidth = 2;
		gbc_txtTotalDebitos.gridheight = 3;
		gbc_txtTotalDebitos.insets = new Insets(0, 0, 50, 5);
		gbc_txtTotalDebitos.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTotalDebitos.gridx = 2;
		gbc_txtTotalDebitos.gridy = 1;
		contentPane.add(txtTotalDebitos, gbc_txtTotalDebitos);
		txtTotalDebitos.setColumns(10);
		
		JButton btnRealizarPagemento = new JButton("REALIZAR PAGAMENTO");
		btnRealizarPagemento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index = listaClientes.getSelectedIndex();
				String nomeCliente = jListModel.get(index);
				
				controllerCliente.realizarPagamento(nomeCliente);
				JOptionPane.showMessageDialog(null, "O pagamento foi realizado com sucesso.", "Success", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnRealizarPagemento.setBackground(new Color(128, 64, 0));
		btnRealizarPagemento.setForeground(new Color(255, 255, 255));
		btnRealizarPagemento.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_btnRealizarPagemento = new GridBagConstraints();
		gbc_btnRealizarPagemento.gridheight = 2;
		gbc_btnRealizarPagemento.gridwidth = 3;
		gbc_btnRealizarPagemento.insets = new Insets(0, 0, 0, 5);
		gbc_btnRealizarPagemento.gridx = 1;
		gbc_btnRealizarPagemento.gridy = 4;
		contentPane.add(btnRealizarPagemento, gbc_btnRealizarPagemento);
	}

}
