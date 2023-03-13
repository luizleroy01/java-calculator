package Main;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

//classe responsável por instanciar a calculadora
public class Menu {
	Tela n = new Tela();
	
	public Menu(){
		
		//configuração da janela da calculadora
		JFrame janelaCalculadora = new JFrame("Calculadora");
		janelaCalculadora.setSize(300,450);
		janelaCalculadora.setLocationRelativeTo(null);
		janelaCalculadora.add(BorderLayout.NORTH,Tela.painelDoVisor);
	    janelaCalculadora.add(Tela.painelDosBotoes);
	    janelaCalculadora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janelaCalculadora.setVisible(true);
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 new Menu(); 

	}

}

