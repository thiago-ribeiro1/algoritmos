package br.com.unifacisa.binaryTrees;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		int input = 20;
		String result;
		Binary tree = new Binary(50); // // Inicializa a árvore binária com capacidade de 50 elementos

		while(input != 0) {

			result = showMenu();

			if(result.equals("")) {
				JOptionPane.showMessageDialog(null, "Digite um valor numérico!");
				result = showMenu();
			} else {
				input = Integer.parseInt(result);

				switch (input) {
					case 1:
						String item = JOptionPane.showInputDialog("Digite um numero para inserir na arvore!");
						tree.insert(Integer.parseInt(item)); // insere o valor na árvore
						break;
					case 2:
						String vl = JOptionPane.showInputDialog("Digite o valor que você deseja Remover!");
						tree.remove(Integer.parseInt(vl)); // remove o valor da árvore
						break;
					case 3:
						JOptionPane.showMessageDialog(null, "Os valores Serão exibidos no console!");
						tree.showRoot(); // exibe a raiz da árvore
						System.out.println("");
						break;
					case 4:
						JOptionPane.showMessageDialog(null, "Os valores Serão exibidos no console!");
						System.out.println("Ordem simétrica:");
						tree.inOrder(0); // exibe os valores em ordem simétrica (in-order)
						System.out.println("");
						break;
					case 5:
						JOptionPane.showMessageDialog(null, "Os valores Serão exibidos no console!");
						System.out.println("Pré-ordem:");
						tree.preOrder(0); // exibe os valores em pré-ordem
						System.out.println("");
						break;
					case 6:
						JOptionPane.showMessageDialog(null, "Os valores Serão exibidos no console!");
						System.out.println("Pós-ordem:");
						tree.postOrder(0); // exibe os valores em pós-ordem
						System.out.println("");
						break;
					default:
						System.out.println("Opção inválida.");
				}
			}
		}
	}

	public static String showMenu() {
		String result = JOptionPane.showInputDialog("" +
				"Digite:" +
				"\n 1: Para inserir " +
				"\n 2: para Remover" +
				"\n 3: Para Exibir a Raiz " +
				"\n 4: Para Exibir ordem simétrica " +
				"\n 5: Para Exibir pré-ordem " +
				"\n 6: Para Exibir pós-ordem " +
				"\n 0: Para Sair");

		if(result == null) {
			result = "";
		}

		return result;
	}
}
