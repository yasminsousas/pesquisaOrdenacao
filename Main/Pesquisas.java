package Main;

import dados.No;

public class Pesquisas {

	public static boolean pesquisaSeqOrdenado(int x, int numeros[]) {
		double inicioSeq = System.nanoTime();
		for (int i = 0; i < numeros.length && x <= numeros[i]; i++) {
			if (x == numeros[i]) {
				double tempoSeq = System.nanoTime() - inicioSeq;
				return true;
			}
		}
		return false;
	}

	public static boolean pesquisaBinaria(int x, int numeros[]) {
		int inicio = 0, fim = numeros.length - 1;
		int meio;
		double inicioBin = System.nanoTime();
		while (inicio <= fim) {
			meio = (inicio + fim) / 2;
			if (x == numeros[meio]) {
				double tempoBin = System.nanoTime() - inicioBin;
				return true;
			}
			if (x < numeros[meio]) {
				fim = meio - 1;
			}
			else {
				inicio = meio + 1;
			}
		}
		return false;
	}

}
