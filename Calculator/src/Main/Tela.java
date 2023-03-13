package Main;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//classe que instancia e adiciona os elementos interativos da calculadora na tela
public class Tela implements ActionListener {
	
	public static int ZERO = 0;
	
	public static JPanel painelDoVisor = new JPanel();
	public static JPanel painelDosBotoes = new JPanel();
	
	//String que receberá todos os números e símbolos da sentença matemática
	public static String[] sentencaMatematica = new String[25];
	
	//variável que funcionará como índice para percorrer a sentença matemática
	public static int indiceOperacao = 0;
	public static String stringSimboloVisor  = new String();
	
	Font fonteVisor = new Font("Serif",Font.BOLD,30);
	
	//botões da calculadora 
	JButton NUMBER_ONE = new JButton ( "1" );  
    JButton NUMBER_TWO = new  JButton ( "2" );  
    JButton NUMBER_THREE = new  JButton ( "3" ); 
    JButton SUM = new JButton ( "+" ); 
    JButton NUMBER_FOUR = new  JButton ( "4" );  
    JButton NUMBER_FIVE = new  JButton ( "5" );  
	JButton NUMBER_SIX = new JButton ( "6" );
	JButton SUB = new JButton ( "-" ); 
	JButton NUMBER_SEVEN = new  JButton ( "7" );  
    JButton NUMBER_EIGHT = new  JButton ( "8" );
    JButton NUMBER_NINE = new JButton ( "9" ); 
    JButton MUL = new JButton ( "*" ); 
    public static JButton CLEAN = new JButton ( "Clean" ); 
    JButton NUMBER_ZERO = new JButton ( "0" ); 
    JButton EQUALS = new JButton ( "=" ); 
    JButton DIV = new JButton ( "/" ); 
    
    //elementos para a manipulação do visor da calculadora
    public static JLabel visorCalculadora = new JLabel(" ");
    public static String  stringVisor  = new String();
    public static boolean id_div=false;
   
    public Tela() {
    	//inicialização das Strings de manipulação do visor
    	stringSimboloVisor =" ";
    	stringVisor  = " ";
    	
    	//configurando Jpanel para os botões da calculadora e os adicionando
    	painelDosBotoes.add(NUMBER_ONE);painelDosBotoes.add(NUMBER_TWO);painelDosBotoes.add(NUMBER_THREE);
    	painelDosBotoes.add(SUM);painelDosBotoes.add(NUMBER_FOUR);painelDosBotoes.add(NUMBER_FIVE);
    	painelDosBotoes.add(NUMBER_SIX);painelDosBotoes.add(SUB);painelDosBotoes.add(NUMBER_SEVEN);
    	painelDosBotoes.add(NUMBER_EIGHT);painelDosBotoes.add(NUMBER_NINE);painelDosBotoes.add(MUL);
    	painelDosBotoes.add(CLEAN);painelDosBotoes.add(NUMBER_ZERO);painelDosBotoes.add(EQUALS);
    	painelDosBotoes.add(DIV);
    	
    	painelDosBotoes.setLayout(new GridLayout(4,4));
    	
    	//consigurando Jpanel para abrigar o visor da calculadora
    	painelDoVisor.setBackground(Color.green);
    	visorCalculadora.setFont(fonteVisor);
    	painelDoVisor.add(visorCalculadora);
    	
    	//adicionando a função de ação aos elementos JButton da calculadora
    	NUMBER_ONE.addActionListener(this);NUMBER_TWO.addActionListener(this);NUMBER_THREE.addActionListener(this);
    	NUMBER_FOUR.addActionListener(this);NUMBER_FIVE.addActionListener(this);
    	NUMBER_SIX.addActionListener(this);NUMBER_SEVEN.addActionListener(this);
    	NUMBER_EIGHT.addActionListener(this);NUMBER_NINE.addActionListener(this);
    	CLEAN.addActionListener(this);NUMBER_ZERO.addActionListener(this);
    	EQUALS.addActionListener(this);SUM.addActionListener(this);SUB.addActionListener(this);
    	MUL.addActionListener(this);DIV.addActionListener(this);
    	
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== Tela.CLEAN) {
			//lógica para limpar o visor da calculadora
			indiceOperacao = 0;
			Tela.visorCalculadora.setText(" ");
			stringVisor  =" ";
			stringSimboloVisor = " ";
			sentencaMatematica = new String [10];
		}
		if(e.getSource() == NUMBER_EIGHT) {
			EscreveTela("8");
		}
		if(e.getSource()== NUMBER_SEVEN) {
			EscreveTela("7");
		}
		if(e.getSource()== NUMBER_SIX) {
			EscreveTela("6");
		}
		if(e.getSource()== NUMBER_FIVE) {
			EscreveTela("5");
		}
		if(e.getSource()== NUMBER_FOUR) {
			EscreveTela("4");
		}
		if(e.getSource()== NUMBER_THREE) {
			EscreveTela("3");
		}
		if(e.getSource()== NUMBER_TWO) {
			EscreveTela("2");
		}
		if(e.getSource()== NUMBER_ONE) {
			
			EscreveTela("1");
		}
		if(e.getSource()== NUMBER_ZERO) {
			EscreveTela("0");
		}
		if(e.getSource()== NUMBER_NINE) {
			EscreveTela("9");
		}
		if(e.getSource()== EQUALS) {
			EscreveTela("=");
		}
		if(e.getSource()== SUM) {
			EscreveTela("+");
		}
		if(e.getSource()== SUB) {
			EscreveTela("-");
		}
		if(e.getSource()== MUL) {
			EscreveTela("*");
		}
		if(e.getSource()== DIV) {
			EscreveTela("/");
		}
		
		
	}
	//função que pega as strings referentes a cada botão e aplica ao visor
	//formando a sentença matemática completa
	public static void EscreveTela(String stringBotoes) {
		
		if(stringBotoes.compareTo("/")!= ZERO) { //inicio compare "/"
			if(stringBotoes.compareTo("+")!= ZERO) { //inicio compare "+"
				if(stringBotoes.compareTo("-")!= ZERO) { //início compare "-"
					if(stringBotoes.compareTo("*")!= ZERO) { //início compare "*"
						if(stringBotoes.compareTo("=")!= ZERO) { // início compare "="
							
							// Se o visor ainda estiver vazio entra nessa condição
							if(stringSimboloVisor .compareTo(" ")== ZERO) { // início compare " "
								//guarda o número vindo dos botões
								stringSimboloVisor  = stringBotoes;
								visorCalculadora.setText( stringVisor +stringSimboloVisor );
							
							}else { //fim compare " "
								//para números com mais de 1 dígito
								stringSimboloVisor = stringSimboloVisor +stringBotoes;
								stringVisor =  stringVisor  + stringSimboloVisor ;
								System.out.println("Auxiliar2 "+stringVisor);
								visorCalculadora.setText(stringVisor);
							}
						}else { // fim compare "="
							
							sentencaMatematica[indiceOperacao]= stringSimboloVisor ;
							indiceOperacao++;
							Sistema.VerificaResultado(stringSimboloVisor );
							sentencaMatematica[indiceOperacao]=stringBotoes;
							indiceOperacao++;
							Sistema.VerificaResultado(stringBotoes);
							
							 stringVisor =  stringVisor +stringSimboloVisor +stringBotoes;
							
							if(stringBotoes.compareTo("=")==0) {
								if(id_div==true) {
									float res=Sistema.result3;
									visorCalculadora.setText( stringVisor =" "+res);
									id_div=false;
								}else {
									int rresultadoVisor = Sistema.resultadoSumSub;
									visorCalculadora.setText( stringVisor +" "+rresultadoVisor );
								}
								
								return;
							}
							
							//aplica a setença matemática completa ao visor da calculadora
							visorCalculadora.setText( stringVisor );
							
							//stringVisor recebe um espaço em branco para que possa receber depois um novo número ou símbolo
							stringSimboloVisor =" ";
						}
					}else { // fim compare "*"
						sentencaMatematica[indiceOperacao]= stringSimboloVisor ;
						indiceOperacao++;
						System.out.println(stringSimboloVisor )	;
						Sistema.VerificaResultado(stringSimboloVisor );
						
						//para formar a sentença matemática com números e símbolos de operação		
						sentencaMatematica[indiceOperacao]=stringBotoes;
						System.out.println(stringBotoes)	;
						Sistema.VerificaResultado(stringBotoes);
						indiceOperacao++;
						
						stringVisor =" ";
						for(int i=0;i<indiceOperacao;i++) {
							 stringVisor = stringVisor +sentencaMatematica[i];
						}
						
						//aplica a setença matemática completa ao visor da calculadora
						visorCalculadora.setText( stringVisor );
						
						//stringVisor recebe um espaço em branco para que possa receber depois um novo número ou símbolo
						stringSimboloVisor =" ";
						
					}
					
				}else { // fim compare "-"
					if(stringSimboloVisor .compareTo(" ")==0) {
						stringSimboloVisor =stringBotoes;
						visorCalculadora.setText( stringVisor +stringSimboloVisor );
						return;
					}
					sentencaMatematica[indiceOperacao]= stringSimboloVisor ;
					indiceOperacao++;
					System.out.println(stringSimboloVisor )	;
					Sistema.VerificaResultado(stringSimboloVisor );
					
					//para formar a sentença matemática com números e símbolos de operação		
					sentencaMatematica[indiceOperacao]=stringBotoes;
					Sistema.VerificaResultado(stringBotoes);
					indiceOperacao++;
					
					stringVisor =" ";
					for(int i=0;i<indiceOperacao;i++) {
						 stringVisor = stringVisor + sentencaMatematica[i];
					}
					
					//aplica a setença matemática completa ao visor da calculadora
					visorCalculadora.setText( stringVisor );
					//stringVisor recebe um espaço em branco para que possa receber depois um novo número ou símbolo
					stringSimboloVisor =" ";
					
				}
				
			}else { //fim compare "+"
				
				sentencaMatematica[indiceOperacao]= stringSimboloVisor ;
				indiceOperacao++;
				System.out.println(stringSimboloVisor);
				Sistema.VerificaResultado(stringSimboloVisor );
				
				//para formar a sentença matemática com números e símbolos de operação
				sentencaMatematica[indiceOperacao]=stringBotoes;
				System.out.println(stringBotoes)	;
				Sistema.VerificaResultado(stringBotoes);
				indiceOperacao++;
				
				
				stringVisor =" ";
				for(int i=0;i<indiceOperacao;i++) {
					 stringVisor = stringVisor +sentencaMatematica[i];
				}
				//aplica a setença matemática completa ao visor da calculadora
				visorCalculadora.setText( stringVisor );
				
				//stringVisor recebe um espaço em branco para que possa receber depois um novo número ou símbolo
				stringSimboloVisor =" ";
				
			}
			
		}else { // fim compare "/"
			id_div =true;
			sentencaMatematica[indiceOperacao]= stringSimboloVisor ;
			indiceOperacao++;
			System.out.println(stringSimboloVisor )	;
			Sistema.VerificaResultado(stringSimboloVisor );
			
			//para formar a sentença matemática com números e símbolos de operação		
			sentencaMatematica[indiceOperacao]=stringBotoes;
			System.out.println(stringBotoes)	;
			Sistema.VerificaResultado(stringBotoes);
			indiceOperacao++;
			
			stringVisor =" ";
			for(int i = 0; i < indiceOperacao; i++) {
				 stringVisor = stringVisor +sentencaMatematica[i];
			}
			
			//aplica a setença matemática completa ao visor da calculadora
			visorCalculadora.setText( stringVisor );
			
			//stringVisor recebe um espaço em branco para que possa receber depois um novo número ou símbolo
			stringSimboloVisor =" ";
			
		}
		
		
		
	}
}

