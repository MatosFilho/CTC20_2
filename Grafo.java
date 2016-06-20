import java.util.Random;

public class Grafo {
	int[][] distancia;
	int vertices;
	
	//Recebe um numero de vertices n e arestas m e cria um grafo
	public void geradorGrafos(int n, int m){
		Random num = new Random(); 
		int i,
			j,
			k;
		//criação do grafo com n vértices
		this.distancia = new int[n][n];
		this.vertices = n;
		//Inicialmente, coloca zero na diagonal proncipal para indicar a ausência de loops
		//e -1 em todos os outros para indicar que não há ligação
		for(i = 0; i < n; i++)
			for(j = 0; j < n; j++)
					this.distancia[i][j]=-1;
		//Sorteio das m arestas
		for(k = 1; k <= m; ){
			i = num.nextInt(n);
			j = num.nextInt(n);
			if(i != j && this.distancia[i][j]==-1 ){
				this.distancia[i][j]=this.distancia[j][i]= num.nextInt(10) + 1;
				k++;
			}
		}
	}
}
