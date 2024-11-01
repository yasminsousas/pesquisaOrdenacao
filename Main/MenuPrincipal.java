package Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import dados.Item;
import utils.ConsoleUtils;

public class MenuPrincipal {

	    static Scanner scanner = new Scanner(System.in);
	    private static int[] vetor;;

	public static void main(String[] args) throws IOException {
;
		menu();

	}

	public static void menu() {
		ConsoleUtils.clearConsole();
		int opcao;

		System.out.println("\n--- MENU ----\n");
		System.out.println("1. Criar vetor");
		System.out.println("2. Ler arquivo");
		System.out.println("3. Pesquisa Sequencial");
		System.out.println("4. Pesquisa Binária");
		System.out.println("5. Comparar Algoritmos");
		System.out.println("6. Hashing");
		System.out.println("7. Sair");

		do {
			opcao = scanner.nextInt();
			switch (opcao) {
				case 1:
					criarVetor();
					break;
				case 2:
				System.out.println("\n--- CARREGAR ARQUIVO ---\n");
                String path = selecionarArquivo();
				if (path != null) {
					try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
						int lineCount = 0;
						while (reader.readLine() != null) {
							lineCount++;
						}
						System.out.println("Total de linhas no arquivo: " + lineCount);
					} catch (IOException e) {
						System.out.println("Erro ao carregar o arquivo: " + e.getMessage());
					}
				}

				
					
					break;
				case 3:
					
					break;
				case 4:

					break;
				case 5:

					break;
				case 6:

					Pesquisa_Hashing Hashing = new Pesquisa_Hashing();
					break;
				case 7:

					System.out.println("Finalizando Sistema ...");
					break;

				default:
					System.out.println("Valor invalido, tente novamente!");
					break;
			}

		} while (opcao > 0 && opcao < 8);
	}
	
	private static void criarVetor() {
        System.out.println("\n--- DEFINIR TAMANHO DO VETOR ---\n");
        System.out.print("Defina o tamanho do vetor: ");
        int tamanho = scanner.nextInt();
        vetor = new int[tamanho];

        System.out.print("Deseja preencher o vetor manualmente? (s/n): ");
        char escolha = scanner.next().charAt(0);

        if (escolha == 's' || escolha == 'S') {
            // Preenchimento manual
            System.out.println("Digite os valores do vetor:");
            for (int i = 0; i < tamanho; i++) {
                System.out.print("Valor " + (i + 1) + ": ");
                vetor[i] = scanner.nextInt();
            }
        } else {
            // Preenchimento aleatório
            System.out.println("Preenchendo o vetor com valores aleatórios...");
            for (int i = 0; i < tamanho; i++) {
                vetor[i] = (int) (Math.random() * 10000); // Valores entre 0 e 9999
            }
        }

        System.out.println("Vetor criado com sucesso:");
        for (int valor : vetor) {
            System.out.print(valor + "\n");
        }
        System.out.println();
    }
	
	
	
	public static void leitor10000(String path, Vetor vetor) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String linha = buffRead.readLine();
		Integer vetorLocal[] = new Integer[10000];
		int i = 0;
		while (true) {
			if (linha != null) {
				vetorLocal[i] = Integer.parseInt(linha);
				vetor.inserirDados(new Item(vetorLocal[i]));
				i++;
				// System.out.println(vetorLocal[i-1]);
			} else
				break;
			linha = buffRead.readLine();
		}
		buffRead.close();
	}


	public static String selecionarArquivo() {
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos de Texto", "txt");
		fileChooser.setFileFilter(filter);
		
		int returnValue = fileChooser.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			return selectedFile.getAbsolutePath();
		}
		return null;

	
	}
	 private static void compararAlgoritmos(Scanner scanner) {
	    /* Colocar pesquisas no main, e deixar as variaveis de tempo globais pois os métodos de pesquisas so retornam booleano
	     * não é possivel manipular a vairavel tempo se não estiver no main.
	     */
}


/*
 * • O programa deve incluir tratamento de erros para lidar com entradas
 * inválidas do usuário e
 * arquivos inexistentes.
 * • O programa deve ser capaz de lidar com vetores de grande tamanho (pelo
 * menos 10.000
 * elementos).
 */