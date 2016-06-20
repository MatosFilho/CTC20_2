public class ForcaBruta {
	//numero da permutacao atual
	private static int cont=0; 
	//armazena a permutacao corrente
	private static int[] p;
	//vetor de cidades
	private static int[] cidades;
	//matriz distâncias
	static Grafo gg;
	//distancia mínima
	static int caminhominimo = 1000000;
	//percurso das cidades de caminho minimo
	private static int[] percursominimo;
	
	public ForcaBruta(Grafo g){
		gg = g;
		cidades = new int[g.vertices];
		//Vetor de cidades 0 a n-1
		for(int i =0; i<cidades.length; i++)
			cidades[i] = i;
		//função para achar as permutações
		permuta();
		//Resposta do problema
		System.out.println();
		System.out.println("Caminho minimo: " + caminhominimo );
		if(caminhominimo == 1000000)
			System.out.println("O grafo não é hamiltoniano");
		else {
			System.out.println("Percurso minimo: ");
			for(int j=0; j < percursominimo.length; j++)
				System.out.printf("%2d ", percursominimo[j]);
			System.out.printf("%2d \n", percursominimo[0]);
		}
	}
	
	public static void permuta() {		
		p = new int[cidades.length];
		permuta(cidades,0);
	}
	
	private static void permuta(int []vet, int n) {		
		if (n==vet.length) {
			cont++;
			caminho();							
		} else {					
			for (int i=0; i < vet.length; i++) {			
				boolean achou = false;			
				for (int j = 0; j < n; j++) {				
					if (p[j]==vet[i]) achou = true;
				}			
				if (!achou) {	
					p[n] = vet[i];
					permuta(vet,n+1);
				}	
			}		
		} 
	}
	/** imprime a permutacao corrente */
	private static void caminho() {		
		int min = 0;
		System.out.println();
		for(int j = 1; j < p.length; j++){
			if(gg.distancia[p[j-1]][p[j]] == -1){
				min = 1000000;
				break;
			} else {	
			min = min + gg.distancia[p[j-1]][p[j]];
			}
		}
		if(min != 1000000)
			min = min + gg.distancia[p[p.length - 1]][p[0]];
		if( caminhominimo > min){
			caminhominimo = min;
			percursominimo = p;
		}
	} 
}
