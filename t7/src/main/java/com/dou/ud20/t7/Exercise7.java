package com.dou.ud20.t7;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class Exercise7 {

	private JFrame frame;
	private JTextField tfValor;
	private JTextField tfResultado;
	private JButton btnCalculo;
	private Double valorEuros = 166.386;
	private DecimalFormat df = new DecimalFormat("#.##");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exercise7 window = new Exercise7();
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
	public Exercise7() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblcantidad = new JLabel("Cantidad a convertir");
		lblcantidad.setBounds(6, 28, 127, 16);
		frame.getContentPane().add(lblcantidad);
		
		tfValor = new JTextField();
		tfValor.setBounds(139, 23, 87, 26);
		frame.getContentPane().add(tfValor);
		tfValor.setColumns(10);
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setBounds(238, 28, 62, 16);
		frame.getContentPane().add(lblResultado);
		
		tfResultado = new JTextField();
		tfResultado.setColumns(10);
		tfResultado.setBounds(312, 23, 87, 26);
		frame.getContentPane().add(tfResultado);
		
		btnCalculo = new JButton("Euros a ptas");
		btnCalculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double casting = Double.valueOf(tfValor.getText());
				Double op = conversion(casting);
				tfResultado.setText(String.valueOf(df.format(op)));
				
			}
		});
		btnCalculo.setBounds(70, 90, 117, 29);
		frame.getContentPane().add(btnCalculo);
		
		JButton btnCambiar = new JButton("Cambiar");
		btnCambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(btnCalculo.getText().equals("Euros a ptas")) {
					btnCalculo.setText("Ptas a Euros");
				}else {
					btnCalculo.setText("Euros a ptas");
				}
			}
		});
		btnCambiar.setBounds(199, 90, 117, 29);
		frame.getContentPane().add(btnCambiar);
	}
	public Double conversion(Double valor) {
		Double resultado = 0.0;
		
		switch(btnCalculo.getText()) {
			case "Ptas a Euros":
				resultado = valor/valorEuros;
				break;
			case "Euros a ptas":
				resultado = valor*valorEuros;
				break;
		}
		return resultado;
	}
}
