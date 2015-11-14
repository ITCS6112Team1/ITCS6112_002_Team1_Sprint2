package FormulaeEval;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import SQL.sqlConnection;
import net.proteanit.sql.DbUtils;

import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Formulae extends JFrame {
	

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulae frame = new Formulae();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection=null;
	private JTextField textFieldform;
	private JTable table_1;
	
	
	public void CloseFrame(){
	    super.dispose();
	}
	
	
	/**
	 * Create the frame.
	 */
	public Formulae() {
		connection=sqlConnection.dbconnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSeeFormulae = new JButton("User Formulae");
		btnSeeFormulae.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query="select * from userformula";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
					rs.close();
					
					
				}
				catch(Exception e)
				{
				JOptionPane.showMessageDialog(null, "pls select option");
				}
				
			}
		});
		btnSeeFormulae.setBounds(71, 216, 119, 23);
		contentPane.add(btnSeeFormulae);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(200, 44, 179, 60);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Enter Formula");
		lblNewLabel.setBounds(21, 155, 91, 14);
		contentPane.add(lblNewLabel);
		
		textFieldform = new JTextField();
		textFieldform.setBounds(104, 152, 86, 20);
		contentPane.add(textFieldform);
		textFieldform.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query="insert into userformula (Formulae) values (?)";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1,textFieldform.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null, "Formula Saved");
					pst.close();
					}
				catch(Exception e2)
				{
					JOptionPane.showMessageDialog(null, "Enter Formula");
				}
			}
		});
		btnSave.setBounds(104, 180, 86, 23);
		contentPane.add(btnSave);
		
		JButton btnCauculate = new JButton("Use");
		btnCauculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
					Evaluation frame = new Evaluation();
					frame.setVisible(true);
					CloseFrame();
					
				}
				catch(Exception e1)
				{
				JOptionPane.showMessageDialog(null, "pls select option");
				}
			}
		});
		btnCauculate.setBounds(389, 67, 62, 14);
		contentPane.add(btnCauculate);
		
		JButton btnUse = new JButton("Use");
		btnUse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
					Evaluation2 frame = new Evaluation2();
					frame.setVisible(true);
					CloseFrame();
					
				}
				catch(Exception e1)
				{
				JOptionPane.showMessageDialog(null, "pls select option");
				}
			}
		});
		btnUse.setBounds(389, 90, 62, 14);
		contentPane.add(btnUse);
		
		JButton btnNewButton = new JButton("Home Screen");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try{
					
					
					iCalculator window = new iCalculator();
					window.frmIcalculator.setVisible(true);
					CloseFrame();
					
				}
				catch(Exception e1)
				{
				JOptionPane.showMessageDialog(null, "pls select option");
				}
			}
		});
		btnNewButton.setBounds(10, 11, 119, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(200, 127, 179, 112);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JButton btnAppFormulae = new JButton("App Formulae");
		btnAppFormulae.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query="select * from AppFormulae";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
					rs.close();
					
					
				}
				catch(Exception e)
				{
				JOptionPane.showMessageDialog(null, "pls select option");
				}
				
			}
		});
		btnAppFormulae.setBounds(227, 11, 119, 23);
		contentPane.add(btnAppFormulae);
	}
}

