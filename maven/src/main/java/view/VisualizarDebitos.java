package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.ControllerCliente;
import controllers.ControllerPdf;
import controllers.ControllerVendas;
import controllers.ExcecaoControladores;
import data.ExcecaoDados;
import models.Cliente;
import models.Venda;
import models.VendasTableModel;

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
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

public class VisualizarDebitos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTotal;
	private JTable tableDebitos;
	private ControllerCliente controllerCliente = new ControllerCliente();
	private ControllerVendas controllerVendas = new ControllerVendas();
	private ControllerPdf controllerPdf = new ControllerPdf();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizarDebitos frame = new VisualizarDebitos();
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
	public VisualizarDebitos() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 529);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(183, 91, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblTitulo = new JLabel("VISUALIZAR DÉBITOS");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.gridwidth = 3;
		gbc_lblTitulo.insets = new Insets(0, 0, 5, 5);
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
		btnVoltar.setBackground(new Color(128, 64, 0));
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_btnVoltar = new GridBagConstraints();
		gbc_btnVoltar.insets = new Insets(0, 0, 5, 0);
		gbc_btnVoltar.gridx = 3;
		gbc_btnVoltar.gridy = 0;
		contentPane.add(btnVoltar, gbc_btnVoltar);
		
		DefaultListModel<String> jListModel = new DefaultListModel();
		ArrayList<String> nomeClientes = new ArrayList<>();
		
		try {
			nomeClientes = controllerCliente.buscarNomeTodosOsClientes();
			jListModel.addAll(nomeClientes);;
		} catch (ExcecaoDados e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JList listaClientes = new JList(jListModel);
		tableDebitos = new JTable();
		
		listaClientes.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				
				int index = listaClientes.getSelectedIndex();
				String nomeCliente = jListModel.get(index);
				
				Cliente cliente = controllerCliente.buscarClientePorNome(nomeCliente);
				txtTotal.setText(controllerCliente.buscarDebitoCliente(nomeCliente) + "R$");
				
				ArrayList<Venda> vendasCliente = controllerVendas.buscarVendasCliente(nomeCliente);
				
				VendasTableModel model = new VendasTableModel(vendasCliente);
				
				tableDebitos.setModel(model);
				
			}
		});
		
		listaClientes.setForeground(new Color(0, 0, 0));
		listaClientes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_listaClientes = new GridBagConstraints();
		gbc_listaClientes.gridheight = 12;
		gbc_listaClientes.insets = new Insets(0, 0, 0, 5);
		gbc_listaClientes.fill = GridBagConstraints.BOTH;
		gbc_listaClientes.gridx = 0;
		gbc_listaClientes.gridy = 1;
		contentPane.add(listaClientes, gbc_listaClientes);
	
		
		tableDebitos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tableDebitos.setEnabled(false);
		GridBagConstraints gbc_tableDebitos = new GridBagConstraints();
		gbc_tableDebitos.gridwidth = 2;
		gbc_tableDebitos.gridheight = 11;
		gbc_tableDebitos.insets = new Insets(0, 0, 5, 0);
		gbc_tableDebitos.fill = GridBagConstraints.BOTH;
		gbc_tableDebitos.gridx = 2;
		gbc_tableDebitos.gridy = 1;
		contentPane.add(tableDebitos, gbc_tableDebitos);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotal.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.insets = new Insets(0, 0, 0, 5);
		gbc_lblTotal.anchor = GridBagConstraints.EAST;
		gbc_lblTotal.gridx = 1;
		gbc_lblTotal.gridy = 12;
		contentPane.add(lblTotal, gbc_lblTotal);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		GridBagConstraints gbc_txtTotal = new GridBagConstraints();
		gbc_txtTotal.insets = new Insets(0, 0, 0, 5);
		gbc_txtTotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTotal.gridx = 2;
		gbc_txtTotal.gridy = 12;
		contentPane.add(txtTotal, gbc_txtTotal);
		txtTotal.setColumns(10);
		
		JButton btnGerarPdf = new JButton("GERAR \r\nPDF");
		btnGerarPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index = listaClientes.getSelectedIndex();
				String nomeCliente = jListModel.get(index);
				
				ArrayList<Venda> vendasCliente = controllerVendas.buscarVendasCliente(nomeCliente);
				
				try {
					controllerPdf.criarPdfVendas(vendasCliente, nomeCliente);
				} catch (ExcecaoControladores e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null, "O pdf foi gerado com sucesso. Acesse a pasta 'PDFS' para visualizar", "Success", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnGerarPdf.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGerarPdf.setForeground(new Color(255, 255, 255));
		btnGerarPdf.setBackground(new Color(128, 64, 0));
		GridBagConstraints gbc_btnGerarPdf = new GridBagConstraints();
		gbc_btnGerarPdf.gridx = 3;
		gbc_btnGerarPdf.gridy = 12;
		contentPane.add(btnGerarPdf, gbc_btnGerarPdf);
	}

}
