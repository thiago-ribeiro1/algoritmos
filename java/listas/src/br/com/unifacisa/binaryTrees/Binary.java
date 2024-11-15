package br.com.unifacisa.binaryTrees;

public class Binary {

	private int[] tree;          // Array para armazenar a árvore
	private int size;            // Tamanho atual da árvore
	private final int CAPACITY;  // Capacidade máxima do array

	// Construtor que define a capacidade máxima da árvore
	public Binary(int capacity) {
		this.CAPACITY = capacity;
		this.tree = new int[CAPACITY];
		this.size = 0;

		// Inicializa todos os elementos com valor especial (-1) indicando ausência de valor
		for (int i = 0; i < CAPACITY; i++) {
			tree[i] = -1;
		}
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void insert(int value) {
		if (size >= CAPACITY) {
			System.out.println("A árvore está cheia!");
			return;
		}

		int index = 0;
		while (index < CAPACITY) {
			if (tree[index] == -1) {
				if (index == 0) {
					System.out.println("Inserindo " + value + " como raiz");
				} else {
					int indicePai = getIndicePai(index);
					if (value < tree[indicePai]) {
						System.out.println("Inserindo " + value + " a esquerda de " + tree[indicePai]);
					} else {
						System.out.println("Inserindo " + value + " a direita de " + tree[indicePai]);
					}
				}
				tree[index] = value;
				size++;
				return;
			} else if (value < tree[index]) {
				index = getEsquerda(index); // Vai para o filho esquerdo
			} else {
				index = getDireita(index); // Vai para o filho direito
			}
		}
		System.out.println("Não foi possível inserir " + value);
	}

	// Métodos para encontrar os índices dos filhos e do pai de um elemento

	// Calcula o índice do filho à esquerda de um elemento no índice 'index'.
	// Exemplo: Se o índice do pai é 1, então o índice do filho à esquerda será 2 * 1 + 1 = 3 (índice 3)
	private int getEsquerda(int index) {
		return 2 * index + 1;
	}


	// Calcula o índice do filho à direita de um elemento no índice 'index'.
	// Exemplo: Se o índice do pai é 1, então o índice do filho à direita será 2 * 1 + 2 = 4 (índice 4)
	private int getDireita(int index) {
		return 2 * index + 2;
	}


	// Calcula o índice do pai de um elemento no índice 'index'.
	// Exemplo: Se o índice atual é 6, o índice do pai será (6 - 1) / 2 = 2 (índice 2)
	private int getIndicePai(int index) {
		return (index - 1) / 2;
	}

	public void inOrder(int index) {
		if (index >= CAPACITY || tree[index] == -1) return;

		inOrder(getEsquerda(index));    // Visita o filho esquerdo
		System.out.print(tree[index] + " ");  // Processa o nó atual
		inOrder(getDireita(index));   // Visita o filho direito
	}

	public void preOrder(int index) {
		if (index >= CAPACITY || tree[index] == -1) return;

		System.out.print(tree[index] + " ");  // Processa o nó atual
		preOrder(getEsquerda(index));   // Visita o filho esquerdo
		preOrder(getDireita(index));  // Visita o filho direito
	}

	public void postOrder(int index) {
		if (index >= CAPACITY || tree[index] == -1) return;

		postOrder(getEsquerda(index));  // Visita o filho esquerdo
		postOrder(getDireita(index)); // Visita o filho direito
		System.out.print(tree[index] + " ");  // Processa o nó atual
	}

	public void showRoot() {
		if (isEmpty()) {
			System.out.println("A Arvore está vazia!");
		} else {
			System.out.println("Raiz " + tree[0]);
		}
	}

	public void remove(int value) {
		int index = find(value, 0); // Busca o índice do valor
		if (index == -1) {
			System.out.println("A Arvore está vazia!");
			return;
		}
		System.out.println("  Percorrendo No " + tree[index]);

		// Remove o nó e reorganiza a árvore
		System.out.println("  Removeu No " + tree[index]);
		tree[index] = -1; // Marca o nó como removido
		size--;
	}

	private int find(int value, int index) {
		if (index >= CAPACITY || tree[index] == -1) return -1;

		if (tree[index] == value) return index;
		else if (value < tree[index]) return find(value, getEsquerda(index));
		else return find(value, getDireita(index));
	}

	public int findMin(int index) {
		while (index < CAPACITY && tree[index] != -1) {
			int leftChild = getEsquerda(index);
			if (leftChild >= CAPACITY || tree[leftChild] == -1) break;
			index = leftChild;
		}
		return (index < CAPACITY) ? tree[index] : -1;
	}
}
