package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;

public class Login {

	private JFrame frame;
	private JTextField txtLogin;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 710, 501);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblTitle = new JLabel("BEM-VINDO");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.gridwidth = 2;
		gbc_lblTitle.insets = new Insets(0, 0, 100, 0);
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 0;
		frame.getContentPane().add(lblTitle, gbc_lblTitle);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblLogin = new GridBagConstraints();
		gbc_lblLogin.anchor = GridBagConstraints.EAST;
		gbc_lblLogin.insets = new Insets(0, 200, 20, 5);
		gbc_lblLogin.gridx = 0;
		gbc_lblLogin.gridy = 1;
		frame.getContentPane().add(lblLogin, gbc_lblLogin);
		
		txtLogin = new JTextField();
		txtLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_txtLogin = new GridBagConstraints();
		gbc_txtLogin.insets = new Insets(0, 0, 20, 200);
		gbc_txtLogin.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLogin.gridx = 1;
		gbc_txtLogin.gridy = 1;
		frame.getContentPane().add(txtLogin, gbc_txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblPassword = new JLabel("Senha:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = new Insets(0, 200, 100, 5);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 2;
		frame.getContentPane().add(lblPassword, gbc_lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 100, 200);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 2;
		frame.getContentPane().add(passwordField, gbc_passwordField);
		
		JButton btnLogin = new JButton("ENTRAR");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.gridwidth = 2;
		gbc_btnLogin.gridx = 0;
		gbc_btnLogin.gridy = 4;
		frame.getContentPane().add(btnLogin, gbc_btnLogin);
	}

}
