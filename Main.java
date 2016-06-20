import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Grafo g = new Grafo();
		Scanner entrada = new Scanner(System.in);
		int num_vertices,
			num_arestas;
		
		System.out.printf("Escolha o número de vértices do grafo: ");
		num_vertices = entrada.nextInt();
		System.out.printf("Escolha o número de arestas do grafo: ");
		num_arestas = entrada.nextInt();
		
		//Criação do grafo
		g.geradorGrafos(num_vertices, num_arestas);
		
		ForcaBruta FC = new ForcaBruta(g);
		//Inicio do algoritmo HeldKarp
		//HeldKarp HK = new HeldKarp(num_vertices, g);
		
		//Impressão na tela da matriz de distâncias
				for(int i=0; i < num_vertices; i++){
					for(int j=0; j < num_vertices; j++)
						System.out.printf("%2d  ", g.distancia[i][j]);
					System.out.println();
				}
				
		entrada.close();
	}
}
