<table>
 <tr>
    <td> <img src="https://github.com/OctavioBernalGH/BTC_Reus2022_UD16/blob/main/dou_logo.png" alt="Team DOU"/></td>
    <td><h1>Ejercicio UD20 T07</h1></td>
  
 </tr>
</table>
 
<hr>
 
[![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white&labelColor=101010)]()
[![GitHub](https://img.shields.io/badge/GITHUB-%20-yellow)]()
<br>
Este ejercicio ha sido realizado por los miembros del equipo 1. Dicho equipo esta formado por:

  [- J.Oriol López Bosch](https://github.com/mednologic)<br>
  [- Octavio Bernal](https://github.com/OctavioBernalGH)<br>
  [- David Dalmau](https://github.com/DavidDalmauDieguez)
  

  
<p align="justify">En este ejercicio se pide crear una aplicación gráfica mediante JFrameForm con una ventana que contiene un botón, un toggleButton, dos etiquetas y dos campos de texto simnple. Este aplicativo permitirá al usuario convertir los euros introducidos a pesetas y viceversa. Mediante el toggleButton ejecutaremos el cambio de divisas y mediante el botón cambiar cambiaremos el factor de conversión de esta. </p>

![UD20-T7](https://user-images.githubusercontent.com/103035621/167314418-deea6658-4ff6-4329-ae75-d4efff8dd6a0.png)


<p align="justify">En la imagen anterior se puede observar el programa en ejecución con una breve descripción de funcionamiento. El usuario introducirá la cantidad a convertir, mediante el botón cambiar seleccionará el tipo de conversión a realizar y mediante el togglerButtón ejecutará dicha conversión.</p>

<details>
  <summary>En este spoiler se muestra el código creado en la Clase Exercise7.java</summary>
<br>

  ```java
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
		//Declararion
		JLabel lblcantidad = new JLabel("Cantidad a convertir");
		JLabel lblResultado = new JLabel("Resultado");
		JButton btnCambiar = new JButton("Cambiar");
		tfResultado = new JTextField();
		tfValor = new JTextField();
		btnCalculo = new JButton("Euros a ptas");
		
		//Parametring
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		lblcantidad.setBounds(6, 28, 127, 16);
		frame.getContentPane().add(lblcantidad);
		
		
		tfValor.setBounds(139, 23, 87, 26);
		frame.getContentPane().add(tfValor);
		tfValor.setColumns(10);
		
		
		lblResultado.setBounds(238, 28, 62, 16);
		frame.getContentPane().add(lblResultado);
		
		
		tfResultado.setColumns(10);
		tfResultado.setBounds(312, 23, 87, 26);
		btnCalculo.setBounds(70, 90, 117, 29);
		btnCambiar.setBounds(199, 90, 117, 29);
		
		//Action Listeners
		btnCalculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double casting = Double.valueOf(tfValor.getText());
				Double op = conversion(casting);
				tfResultado.setText(String.valueOf(df.format(op)));
				
			}
		});
		
		btnCambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(btnCalculo.getText().equals("Euros a ptas")) {
					btnCalculo.setText("Ptas a Euros");
				}else {
					btnCalculo.setText("Euros a ptas");
				}
			}
		});
		
		
		//Adding to frame
		frame.getContentPane().add(tfResultado);
		frame.getContentPane().add(btnCalculo);
		frame.getContentPane().add(btnCambiar);
	}
	
	//Funtion of conversion
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

  ```
 </details>
 
