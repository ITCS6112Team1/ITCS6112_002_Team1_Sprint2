import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Evaluation2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Evaluation2 frame = new Evaluation2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void CloseFrame(){
	    super.dispose();
	}

	/**
	 * Create the frame.
	 */
	public Evaluation2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 364, 178);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblA = new JLabel("a");
		lblA.setBounds(42, 53, 46, 14);
		contentPane.add(lblA);
		
		textField = new JTextField();
		textField.setBounds(52, 50, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("b");
		lblNewLabel.setBounds(148, 53, 46, 14);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(158, 50, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblResult = new JLabel("Result");
		lblResult.setBounds(79, 104, 46, 14);
		contentPane.add(lblResult);
		
		textField_2 = new JTextField();
		textField_2.setBounds(114, 101, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int val1,val2,ans;
				try{
					val1=Integer.parseInt(textField.getText());
					val2=Integer.parseInt(textField_1.getText());

					ans=((val1-val2)*((val1*val1)+(val1*val2)+(val2*val2)));
					textField_2.setText(Integer.toString(ans));
				}

					catch(Exception e){
						
						JOptionPane.showMessageDialog(null, "Enter Value of a and b");
				}

			}
		});
		btnCalculate.setBounds(254, 49, 89, 23);
		contentPane.add(btnCalculate);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
try{
					
					Formulae frm=new Formulae();
					frm.setVisible(true);
					CloseFrame();
					
				}
				catch(Exception e1)
				{
				JOptionPane.showMessageDialog(null, "pls select option");
				}
			}
		});
		btnBack.setBounds(-1, 0, 72, 23);
		contentPane.add(btnBack);
	}
}
