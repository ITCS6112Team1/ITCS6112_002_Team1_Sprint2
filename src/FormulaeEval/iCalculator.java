package FormulaeEval;


import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.UIManager;

import main.MainMethod;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class iCalculator {

	JFrame frmIcalculator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					iCalculator window = new iCalculator();
					window.frmIcalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public iCalculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIcalculator = new JFrame();
		frmIcalculator.setForeground(Color.WHITE);
		frmIcalculator.setTitle("iCalculator");
		frmIcalculator.setBounds(100, 100, 352, 300);
		frmIcalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIcalculator.getContentPane().setLayout(null);
		
		JButton btnFormulae = new JButton("Formulae Evaluation");
		btnFormulae.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					frmIcalculator.dispose();
					Formulae frm=new Formulae();
					frm.setVisible(true);
					
				}
				catch(Exception e)
				{
				JOptionPane.showMessageDialog(null, "pls select option");
				}
				
			}
		});
		btnFormulae.setBackground(Color.WHITE);
		btnFormulae.setFont(UIManager.getFont("Button.font"));
		btnFormulae.setForeground(Color.BLACK);
		btnFormulae.setBounds(92, 176, 169, 59);
		frmIcalculator.getContentPane().add(btnFormulae);
		
		JButton btnNormalCalculator = new JButton("Scientific Calculator");
		btnNormalCalculator.setForeground(Color.BLACK);
		btnNormalCalculator.setFont(UIManager.getFont("Button.font"));
		btnNormalCalculator.setBackground(Color.WHITE);
		btnNormalCalculator.setBounds(92, 92, 169, 59);
		frmIcalculator.getContentPane().add(btnNormalCalculator);
		
		JButton button = new JButton("Normal Calculator");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmIcalculator.dispose();
				MainMethod nw = new MainMethod();
				MainMethod.Redirect();
			}
		});
		button.setForeground(Color.BLACK);
		button.setFont(UIManager.getFont("Button.font"));
		button.setBackground(Color.WHITE);
		button.setBounds(92, 11, 169, 59);
		frmIcalculator.getContentPane().add(button);
	}
}

