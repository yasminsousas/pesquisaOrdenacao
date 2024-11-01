package Main;

import dados.Item;

public class Vetor {

	private Item[] vetor;
	private int nElem;
	
	public Vetor(int tamanho) {
		this.vetor = new Item[tamanho];
		this.nElem = 0;
	}
	
	public boolean inserirDados(Item novo) {
		if (this.nElem == this.vetor.length) { 
			return false;
		} else {
			this.vetor[this.nElem] = novo;
			this.nElem++;
			return true;
		}
	}

}
