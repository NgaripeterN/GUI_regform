package registrationForm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldUsername;
	private JPasswordField passwordFieldPasswd;
	private JPasswordField passwordFieldConPasswd;
	private JTextField textFieldEmail;
	private JTextField textFieldPhone;
	private JTextField textFieldAddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register Form");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(10, 10, 257, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(94, 91, 86, 19);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(72, 180, 86, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Username:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setBounds(72, 143, 86, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Confirm Password:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(15, 231, 143, 19);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(104, 280, 54, 19);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Phone:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(94, 322, 54, 19);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Address:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(85, 374, 73, 13);
		contentPane.add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(154, 420, 85, 21);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try {
				Class.forName("com.mysql.cj.jdbc");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/registration_form","root","root");
				String sql="INSERT INTO REGISTRATION_FORM(NAME,USERNAME,PASSWORD,CONFIRM PASSWORD,EMAIL,PHONE,ADDRESS) VALUES (?,?,?,?,?,?,?)";
				PreparedStatement pr=con.prepareStatement(sql);
				pr.setString(1, textFieldName.getText());
				pr.setString(2, textFieldUsername.getText());
				pr.setString(3, passwordFieldPasswd.getText());
				pr.setString(4, passwordFieldConPasswd.getText());
				pr.setString(5, textFieldEmail.getText());
				pr.setString(6, textFieldPhone.getText());
				pr.setString(7, textFieldAddress.getText());
				int count=pr.executeUpdate();
				if (count==1) 
				{
					JOptionPane.showMessageDialog(null, "Record added Successfully");
					textFieldName.setText("");
					textFieldUsername.setText("");
					passwordFieldPasswd.setText("");
					passwordFieldConPasswd.setText("");
					textFieldEmail.setText("");
					textFieldPhone.setText("");
					textFieldAddress.setText("");
					con.close();
				}
				else {
					JOptionPane.showMessageDialog(null, "No record added");
					con.close();
				}
			}
			catch(Exception e) {
			
			}
			}
		
		
		public void  validatePassword()
		{
			 String password1= passwordFieldPasswd.getText();
			 String password2= passwordFieldPasswd.getText();
			 if (!password1.equals(password2))
			 {
				 JOptionPane.showMessageDialog(null, "Passwords don't match");
			 }
		}
		});
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(300, 420, 85, 21);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    if (e.getSource() == btnNewButton) {
			        // Submit button action
			        // ...
			    } else if (e.getSource() == btnNewButton_1) {
			        textFieldName.setText("");
			        textFieldUsername.setText("");
			        passwordFieldPasswd.setText("");
			        passwordFieldConPasswd.setText("");
			        textFieldEmail.setText("");
			        textFieldPhone.setText("");
			        textFieldAddress.setText("");
			    } else if (e.getSource() == btnNewButton_1) {
			        System.exit(0);
			    }
			}});
		JButton btnNewButton_2 = new JButton("Close");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setBounds(475, 420, 85, 21);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
			        // Close the window
			        dispose();
			    }});
		
		textFieldName = new JTextField();
		textFieldName.setBounds(193, 93, 116, 19);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(193, 142, 116, 19);
		contentPane.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		passwordFieldPasswd = new JPasswordField();
		passwordFieldPasswd.setBounds(193, 185, 116, 19);
		contentPane.add(passwordFieldPasswd);
		
		passwordFieldConPasswd = new JPasswordField();
		passwordFieldConPasswd.setBounds(193, 233, 116, 19);
		contentPane.add(passwordFieldConPasswd);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(193, 282, 116, 19);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setBounds(193, 322, 116, 19);
		contentPane.add(textFieldPhone);
		textFieldPhone.setColumns(10);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setBounds(193, 368, 116, 19);
		contentPane.add(textFieldAddress);
		textFieldAddress.setColumns(10);
	}
}
