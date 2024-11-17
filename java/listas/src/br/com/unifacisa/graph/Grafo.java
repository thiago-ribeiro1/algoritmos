package br.com.unifacisa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Grafo {

	private int numVertices;
	private List<List<Integer>> adjacencyList;

	public Grafo(int numVertices) {
		this.numVertices = numVertices;
		this.adjacencyList = new ArrayList<>(numVertices);

		for (int i = 0; i < numVertices; i++) {
			this.adjacencyList.add(new LinkedList<>());
		}
	}

	public void addEdge(int v, int w) {
		/*
		 * v = origem
		 * w = destino
		 */
		adjacencyList.get(v).add(w);
		adjacencyList.get(w).add(v); // Como é um grafo não direcionado, adicionamos a ligação inversa também
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < numVertices; i++) {
			sb.append("Vértice: ").append(i).append(":\n");
			for (Integer neighbor : adjacencyList.get(i)) {
				sb.append(" -> ").append(neighbor).append("\n");
			}
			sb.append("\n");
		}

		return sb.toString();
	}

	public void buscaEmLargura(int verticeInicial) {
		boolean[] visitados = new boolean[numVertices]; // Marca os vértices que foram visitados
		Queue<Integer> fila = new LinkedList<>(); // Cria uma fila para controlar a ordem de visita dos vértices

		// Marca o vértice inicial como visitado e o adiciona na fila
		visitados[verticeInicial] = true;
		fila.add(verticeInicial);

		System.out.println("Busca em Largura a partir do vértice " + verticeInicial + ":\n");

		// Enquanto a fila não estiver vazia, continua a busca
		while (!fila.isEmpty()) {
			int verticeAtual = fila.poll(); // Remove o vértice na frente da fila para processá-lo
			System.out.println(verticeAtual); // Exibe o vértice atual

			// Para cada elemento próximo do vértice atual
			for (int proximo : adjacencyList.get(verticeAtual)) {
				// Se o próximo ainda não foi visitado
				if (!visitados[proximo]) {
					visitados[proximo] = true; // Marca o próximo como visitado
					fila.add(proximo); // Adiciona o próximo à fila
				}
			}
		}
	}

	public static void main(String[] args) {
		Grafo grafo = new Grafo(5);

		grafo.addEdge(0, 1);
		grafo.addEdge(0, 4);
		grafo.addEdge(1, 2);
		grafo.addEdge(1, 3);
		grafo.addEdge(1, 4);
		grafo.addEdge(2, 3);
		grafo.addEdge(3, 4);

		System.out.println(grafo.toString());

		grafo.buscaEmLargura(0); // Inicia a busca em largura a partir do vértice 0

		/*
    Visualização do grafo (busca em largura):

            0
  	   / \
     	  1  4
 	 /|\
	2 | 3
	 \_/

    Ordem final: 0, 1, 4, 2, 3

*/


	}
}
