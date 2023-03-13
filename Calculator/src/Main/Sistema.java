package Main;




import javax.swing.JButton;
import javax.swing.JLabel;

public class Sistema{
	//constantes da classe
	public static int ZERO = 0;
	
	public static int resultadoSumSub ; 
	public static int resultadoMulDiv ;
	public static float result3=0;
	public static String[] sentencaMatematica = new String[20];
	public static String[] s1 = new String[10];
	public static String[] s2 = new String[20];
	public static int[] inteiros = new int[10];
	public static int[] inteiros2 = new int[10];
	public static int[] aux = new int[10];
	public static int indiceOperation=0;
	public static int pos =0;
	public static int controle =0;
	public static int controlaOperacaoMulDiv =0;
	public static int controle3 =0;
	public static int c3 =0;
	public static int c4 =0;
	public static boolean operationSumSub = false;
	public static boolean operationMulDiv = false;
	
	
	
	public static void VerificaResultado(String simboloNoVisor) {
		
		//trecho que trata da ordem de prioridade das operações
		//as operações de soma e subtração tem a mesma prioridade
		if(simboloNoVisor.compareTo("+")== ZERO  || simboloNoVisor.compareTo("-")== ZERO  ) {
			operationSumSub = true;
		}
		
		//as operações de multiplicação e divisão tem a mesma prioridade
		if(simboloNoVisor.compareTo("*")== ZERO || simboloNoVisor.compareTo("/")== ZERO) {
			operationMulDiv = true;
		}
		
		sentencaMatematica[indiceOperation] = simboloNoVisor;
		
		indiceOperation++;
		
		if(simboloNoVisor.compareTo("=")== ZERO) {
			controlaOperacaoMulDiv=0;
			controle3=0;
			c3=0;c4=0;
			SeparaNum();
			
			ConverteNumero(s2,inteiros2,controle3);
			
			if(operationSumSub) {
				opSumSub();
			}else {
				resultadoSumSub = ZERO;
			}
			if(operationMulDiv) {
				opMulDiv();
			}else {
				resultadoMulDiv = ZERO;
			}
			
			resultadoSumSub =resultadoSumSub +resultadoMulDiv ;
			
			indiceOperation=0;
			operationSumSub =false;
			operationMulDiv =false;
		}
		
	}
	
	
	public static void ConverteNumero(String Inter[],int Int[],int num) {
		controle=0;
		
		for(int i=0;i<controlaOperacaoMulDiv;i++) {
			try {
				inteiros[controle]=Integer.parseInt(s1[i]);
				controle++;
			}catch(NumberFormatException e) {
				System.out.println(" Invalido");
			}
		}
		for(int j=0;j<controle3;j++) {
			try {
				inteiros2[c4]=Integer.parseInt(s2[j]);
				
				c4++;
			}catch(NumberFormatException e) {
				System.out.println("Invalido");
			}
		}
		
		c3=0;
		int y=0;
		for(int z=0;z<c4;z++) {
			for(int j=0;j<controle;j++) {
				if(inteiros2[z]!=inteiros[j]) {
					y++;
				}
			}
			if(y==controle) {
				aux[c3]=inteiros2[z];
				c3++;
				
			}
			y=0;
		}
	
	}
	public static void opSumSub() {
		int j=1;
		resultadoSumSub =aux[0];
		
		
		for(int i=0;i<sentencaMatematica.length;i++) {
			if(sentencaMatematica[i].compareTo("+")== ZERO) {
				resultadoSumSub +=aux[j];
				j++;
			}
			if(sentencaMatematica[i].compareTo("-")== ZERO) {
				resultadoSumSub -=aux[j];
				j++;
				
			}
			
		}
		
		
	}
	public static void opMulDiv() {
		resultadoMulDiv =inteiros[0];
		result3=inteiros[0];
		
		int j=1;
		for(int i=0;i<sentencaMatematica.length;i++) {
			if(sentencaMatematica[i].compareTo("*")==0) {
				resultadoMulDiv *=inteiros[j];
				j++;
			}
			if(sentencaMatematica[i].compareTo("/")==0) {
				
				result3=(float)result3/inteiros[j];
				j++;
				
			}
		}
		
	}
	public static void SeparaNum() {
		
		for(int i=0;i<indiceOperation;i++) {
			if(sentencaMatematica[i].compareTo("*")== ZERO) {
				if(controlaOperacaoMulDiv == 0) {
					s1[controlaOperacaoMulDiv] = sentencaMatematica[i-1];
					controlaOperacaoMulDiv++;
					
					s1[controlaOperacaoMulDiv] = sentencaMatematica[i+1];
					controlaOperacaoMulDiv++;
				}else {
					s1[controlaOperacaoMulDiv] = sentencaMatematica[i+1];
					controlaOperacaoMulDiv++;
				}
			}
			if(sentencaMatematica[i].compareTo("/")== ZERO) {
				if(controlaOperacaoMulDiv==0) {
					s1[controlaOperacaoMulDiv]=sentencaMatematica[i-1];
					controlaOperacaoMulDiv++;
					s1[controlaOperacaoMulDiv]=sentencaMatematica[i+1];
					controlaOperacaoMulDiv++;
				}else {
					s1[controlaOperacaoMulDiv]=sentencaMatematica[i+1];
					controlaOperacaoMulDiv++;
				}
			}
		}
		for(int z=0;z<sentencaMatematica.length;z++) {
			s2[controle3]=sentencaMatematica[z];
			controle3++;
		}
	}
	
}
  
	
	

	
	



