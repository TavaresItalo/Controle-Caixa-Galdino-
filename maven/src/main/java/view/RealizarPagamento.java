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
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RealizarPagamento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

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
		setBounds(100, 100, 583, 413);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(183, 91, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblTitulo = new JLabel("REALIZAR PAGAMENTO");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.gridwidth = 2;
		gbc_lblTitulo.insets = new Insets(0, 0, 50, 5);
		gbc_lblTitulo.gridx = 0;
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
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 0;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setForeground(new Color(255, 255, 255));
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblCliente.anchor = GridBagConstraints.EAST;
		gbc_lblCliente.gridx = 0;
		gbc_lblCliente.gridy = 1;
		contentPane.add(lblCliente, gbc_lblCliente);
		
		JComboBox comboBoxClientes = new JComboBox();
		comboBoxClientes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_comboBoxClientes = new GridBagConstraints();
		gbc_comboBoxClientes.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxClientes.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxClientes.gridx = 1;
		gbc_comboBoxClientes.gridy = 1;
		contentPane.add(comboBoxClientes, gbc_comboBoxClientes);
		
		JLabel lblTotal = new JLabel("Total Débitos:");
		lblTotal.setForeground(new Color(255, 255, 255));
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.anchor = GridBagConstraints.EAST;
		gbc_lblTotal.insets = new Insets(0, 0, 50, 5);
		gbc_lblTotal.gridx = 0;
		gbc_lblTotal.gridy = 2;
		contentPane.add(lblTotal, gbc_lblTotal);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 50, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("REALIZAR PAGAMENTO");
		btnNewButton.setBackground(new Color(128, 64, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 4;
		contentPane.add(btnNewButton, gbc_btnNewButton);
	}

}
