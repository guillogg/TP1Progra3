package Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;

import juego.Funciones;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import java.awt.SystemColor;


public class Interfaz {

	private JFrame frameFacil;
	private JFrame frameInicio;
	private JFrame frameDificil;
	private JTextField input;
	private JLabel[][] letrasFacil = new JLabel[6][5];
	private JLabel[][] letrasDificil = new JLabel[6][7];
	private int filaMatriz = 0;
	private int intentos = 6; 
	private String palabraElegida;
	
	
	/**
	 * Launch the application.
	 */
	
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					
						window.frameInicio.setVisible(true);
						
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfaz() {
		try 
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		
		inicio();
		ventanaFacil();
		ventanaDificil();
		
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	
///////////////////////////////////V E N T A N A    I N I C I O //////////////////////////////
	private void inicio() {
		
		frameInicio = new JFrame();
		frameInicio.getContentPane().setBackground(Color.ORANGE);
		frameInicio.setBackground(Color.gray);
		frameInicio.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		frameInicio.setBounds(100, 100, 516, 474);
		frameInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameInicio.getContentPane().setLayout(null);

		JLabel wordleLabel = new JLabel("Wordle");
		wordleLabel.setBounds(102, 45, 303, 92);
		wordleLabel.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 80));
		frameInicio.getContentPane().add(wordleLabel);

		JLabel lblNewLabel = new JLabel("Elegir modo");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		lblNewLabel.setBounds(129, 179, 129, 44);
		frameInicio.getContentPane().add(lblNewLabel);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		comboBox.setBounds(268, 183, 120, 38);
		frameInicio.getContentPane().add(comboBox);

		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Fácil", "Difícil"}));


		JButton botonJugar = new JButton("Jugar");
		botonJugar.setBackground(Color.ORANGE);
		botonJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameInicio.setVisible(false);
				String dificultad = (String) comboBox.getSelectedItem();
				
				if(dificultad.equals("Fácil")) {
					palabraElegida = Funciones.DarPalabra(Dificultad.FACIL);
					frameFacil.remove(frameFacil);
					intentos=6;
					filaMatriz=0;
					ventanaFacil();
					frameFacil.setVisible(true);
					frameFacil.toFront();
					}
					
				else {
					palabraElegida = Funciones.DarPalabra(Dificultad.DIFICIL);
					frameDificil.remove(frameDificil);
					intentos=6;
					filaMatriz=0;
					ventanaDificil();
					frameDificil.setVisible(true);
					frameDificil.toFront();
				}

			}
		});
		botonJugar.setBounds(190, 287, 155, 38);
		botonJugar.setHorizontalTextPosition(SwingConstants.CENTER);
		botonJugar.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		frameInicio.getContentPane().add(botonJugar);


		JButton botonSalir = new JButton("Salir");
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frameInicio.setVisible(false);

			}
		});
		botonSalir.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		botonSalir.setBounds(397, 396, 80, 31);
		frameInicio.getContentPane().add(botonSalir);



	}
	
	
	
	//////////////////////////////// V E N T A N A    F A C I L ///////////////////////////
	private void ventanaFacil() {
		
		frameFacil = new JFrame();
		frameFacil.getContentPane().setBackground(SystemColor.activeCaption);
		frameFacil.setBackground(SystemColor.activeCaption);
		frameFacil.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		frameFacil.setBounds(100, 100, 528, 692);
		frameFacil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameFacil.getContentPane().setLayout(null);
		
		
		JLabel intentosLabel = new JLabel("Intentos: "+intentos);
		intentosLabel.setBounds(200, 10, 136, 28);
		intentosLabel.setBorder(null);
		intentosLabel.setFont(new Font("Unispace", Font.PLAIN, 14));
		frameFacil.getContentPane().add(intentosLabel);
		
		input = new JTextField();
		input.setHorizontalAlignment(SwingConstants.CENTER);
		input.setBounds(75, 612, 149, 28);
		input.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
		input.setBackground(UIManager.getColor("ToolTip.background"));
		input.setForeground(Color.BLACK);
		input.setFont(new Font("Trebuchet MS", Font.PLAIN, 27));
		frameFacil.getContentPane().add(input);
		input.setColumns(10);
		
		
		JButton botonExit = new JButton("Salir");
		botonExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameFacil.setVisible(false);
			}
		});
		botonExit.setVisible(false);
		botonExit.setBackground(new Color(100, 149, 237));
		botonExit.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		botonExit.setBounds(305, 609, 163, 31);
		frameFacil.getContentPane().add(botonExit);
		
		JButton botonMenu = new JButton("Menú principal");
		botonMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameFacil.setVisible(false);
				frameFacil.remove(frameFacil);
				frameInicio.setVisible(true);
				frameInicio.toFront();
				
			}
		});
		botonMenu.setVisible(false);
		botonMenu.setBackground(new Color(100, 149, 237)); 
		botonMenu.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		botonMenu.setBounds(63, 609, 163, 31);
		frameFacil.getContentPane().add(botonMenu);
				
		
		JButton botonArriesgar = new JButton("Arriesgar");
		botonArriesgar.setBounds(286, 609, 130, 31);
		botonArriesgar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botonArriesgar.setEnabled(true);
				
			}
			
		});
		botonArriesgar.setEnabled(false);
	
		botonArriesgar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(intentos!=0) {
					
					String inputUsuario = input.getText().toUpperCase();
					inputUsuario = inputUsuario.replaceAll("\\s","");
				
					
					
					if(inputUsuario.length()!=5) {
					
						intentosLabel.setText("Intentos: "+intentos);
						input.setText("");
						JOptionPane.showMessageDialog(null, "Debe ingresar 5 letras","Vuelva a intentarlo", JOptionPane.INFORMATION_MESSAGE);
					
					}
					
				
				
				
					if(filaMatriz<6 && inputUsuario.length()==5) {
						intentos--;
						List<Color> colores = new ArrayList<>(); 
						colores = Funciones.CompararPalabra(inputUsuario, getPalabraElegida());
				
						
						for(int i=0; i<inputUsuario.length(); i++) {
					
							String letra = String.valueOf(inputUsuario.charAt(i));
							letrasFacil[filaMatriz][i].setText(letra);
							letrasFacil[filaMatriz][i].setBackground(colores.get(i));
							letrasFacil[filaMatriz][i].setVisible(true);
							input.setText(""); 
						
						}
					
					intentosLabel.setText("Intentos: "+intentos);
					if (Funciones.palabraAcertada(colores)){
						intentos=0;
						JOptionPane.showMessageDialog(null, "Ganaste!!!", "Felicidades!!", JOptionPane.INFORMATION_MESSAGE);
						botonArriesgar.setVisible(false);
						input.setVisible(false);
						botonMenu.setVisible(true);
						botonExit.setVisible(true);
						intentosLabel.setVisible(false);
						
					}
					else if (intentos==0 && !Funciones.palabraAcertada(colores)) {
						JOptionPane.showMessageDialog(null, "Perdiste.", "La palabra era:"+palabraElegida, JOptionPane.INFORMATION_MESSAGE);
						botonArriesgar.setVisible(false);
						input.setVisible(false);
						botonMenu.setVisible(true);
						botonExit.setVisible(true);
						intentosLabel.setVisible(false);
						
						
						}
				filaMatriz++;
				intentosLabel.setText("Intentos: "+intentos);
				
					
			}
			
			}
			}});
		botonArriesgar.setBackground(new Color(100, 149, 237));
		botonArriesgar.setForeground(Color.BLACK);
		botonArriesgar.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		frameFacil.getContentPane().add(botonArriesgar);
		
		
		
		
		//Matriz para mostrar las palabras
		
		int x=40;
		int y=48;
		
		for(int f=0; f<6; f++) {
			for(int c=0; c<5; c++) {
				letrasFacil[f][c]= new JLabel(" ");	
				letrasFacil[f][c].setHorizontalAlignment(JLabel.CENTER);
				letrasFacil[f][c].setOpaque(true);
				letrasFacil[f][c].setForeground(Color.BLACK);
				letrasFacil[f][c].setBorder(new LineBorder(new Color(0, 0, 0)));
				letrasFacil[f][c].setVisible(false);
				letrasFacil[f][c].setFont(new Font("Trebuchet MS", Font.BOLD, 90));
				letrasFacil[f][c].setBounds(x, y, 88, 90); //x,y,ancho,alto
				frameFacil.getContentPane().add(letrasFacil[f][c]);
				x+=88;
					
			}
			x=40;
			y+=90;
		}
		
		
	}
	
	/////////////////V E N T A N A   D I F I C I L ///////////////////
	private void ventanaDificil() {
		
		frameDificil = new JFrame();
		frameDificil.getContentPane().setBackground(SystemColor.activeCaption);
		frameDificil.setBackground(SystemColor.activeCaption);
		frameDificil.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		frameDificil.setBounds(100, 100, 721, 692);
		frameDificil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameDificil.getContentPane().setLayout(null);
		
		
		JLabel intentosLabel = new JLabel("Intentos: "+intentos);
		intentosLabel.setBounds(299, 10, 106, 28);
		intentosLabel.setBorder(null);
		intentosLabel.setFont(new Font("Unispace", Font.PLAIN, 14));
		frameDificil.getContentPane().add(intentosLabel);
		
		input = new JTextField();
		input.setBounds(183, 608, 163, 28);
		input.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
		input.setBackground(UIManager.getColor("ToolTip.background"));
		input.setForeground(Color.BLACK);
		input.setHorizontalAlignment(SwingConstants.CENTER);
		input.setFont(new Font("Trebuchet MS", Font.PLAIN, 27));
		frameDificil.getContentPane().add(input);
		input.setColumns(10);
		
		
		JButton botonExit = new JButton("Salir");
		botonExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameDificil.setVisible(false);
			}
		});
		botonExit.setVisible(false);
		botonExit.setBackground(new Color(100, 149, 237));
		botonExit.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		botonExit.setBounds(430, 610, 163, 31);
		frameDificil.getContentPane().add(botonExit);
		
		JButton botonMenu = new JButton("Menú principal");
		botonMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameDificil.setVisible(false);
				frameInicio.setVisible(true);
				frameInicio.toFront();
				
				
			}
		});
		botonMenu.setVisible(false);
		botonMenu.setBackground(new Color(100, 149, 237));
		botonMenu.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		botonMenu.setBounds(131, 608, 163, 31);
		frameDificil.getContentPane().add(botonMenu);
	
		
		
		
		JButton botonArriesgar = new JButton("Arriesgar");
		botonArriesgar.setBounds(382, 605, 130, 31);
		botonArriesgar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botonArriesgar.setEnabled(true);
				
			}
			
		});
		botonArriesgar.setEnabled(false);
	
		botonArriesgar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(intentos!=0) {
					
					String inputUsuario = input.getText().toUpperCase();
					inputUsuario = inputUsuario.replaceAll("\\s","");
					
					if(inputUsuario.length()!=7) {
					
						intentosLabel.setText("Intentos: "+intentos);
						input.setText("");
						JOptionPane.showMessageDialog(null, "Debe ingresar 7 letras","Vuelva a intentarlo", JOptionPane.INFORMATION_MESSAGE);
					
					}
					
				
					if(filaMatriz<6 && inputUsuario.length()==7) {
						intentos--;
						List<Color> colores = new ArrayList<>(); 
						colores = Funciones.CompararPalabra(inputUsuario, getPalabraElegida());
				
						
						for(int i=0; i<inputUsuario.length(); i++) {
					
							String letra = String.valueOf(inputUsuario.charAt(i));
							letrasDificil[filaMatriz][i].setText(letra);
							letrasDificil[filaMatriz][i].setBackground(colores.get(i));
							letrasDificil[filaMatriz][i].setVisible(true);
							input.setText(""); 
							
						}
					
					intentosLabel.setText("Intentos: "+intentos);
					if (Funciones.palabraAcertada(colores)){
						intentos=0;
						JOptionPane.showMessageDialog(null, "Ganaste!!!", "Felicidades!!", JOptionPane.INFORMATION_MESSAGE);
						botonArriesgar.setVisible(false);
						input.setVisible(false);
						botonMenu.setVisible(true);
						botonExit.setVisible(true);
						intentosLabel.setVisible(false);
						
						
					}
					else if (intentos==0 && !Funciones.palabraAcertada(colores)) {
						JOptionPane.showMessageDialog(null, "Perdiste.", "La palabra era:"+palabraElegida, JOptionPane.INFORMATION_MESSAGE);
						botonArriesgar.setVisible(false);
						input.setVisible(false);
						botonMenu.setVisible(true);
						botonExit.setVisible(true);
						intentosLabel.setVisible(false);
						}
				filaMatriz++;
				intentosLabel.setText("Intentos: "+intentos);
				
					
			}
			
			}
			}});
		botonArriesgar.setBackground(new Color(100, 149, 237));
		botonArriesgar.setForeground(Color.BLACK);
		botonArriesgar.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		frameDificil.getContentPane().add(botonArriesgar);
		
		
		
		//Matriz para mostrar las palabras
		
		int x=40;
		int y=48;
		
		for(int f=0; f<6; f++) {
			for(int c=0; c<7; c++) {
				letrasDificil[f][c]= new JLabel(" ");	
				letrasDificil[f][c].setHorizontalAlignment(JLabel.CENTER);
				letrasDificil[f][c].setOpaque(true);
				letrasDificil[f][c].setForeground(Color.BLACK);
				letrasDificil[f][c].setBorder(new LineBorder(new Color(0, 0, 0)));
				letrasDificil[f][c].setVisible(false);
				letrasDificil[f][c].setFont(new Font("Trebuchet MS", Font.BOLD, 90));
				letrasDificil[f][c].setBounds(x, y, 88, 90); //x,y,ancho,alto
				frameDificil.getContentPane().add(letrasDificil[f][c]);
				x+=88;
					
			}
			x=40;
			y+=90;
		}	
		
	}

	
	
	//Metodos auxiliares
	
	// Creamos un ENUM para las dificultades del juego
	public enum Dificultad{
	 	FACIL,DIFICIL;
	 }
	
	private String getPalabraElegida() {
		return palabraElegida;
	}

	
}
