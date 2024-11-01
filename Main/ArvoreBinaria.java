package Main;

import dados.No;

public class ArvoreBinaria {
	private No raiz;
	private int nElem;
	//construtor
	public ArvoreBinaria(){
	this.nElem=0;
	this.raiz = null;
	}
	
	public boolean pesquisa(int elem) {
		No temp;
		temp = pesquisa(elem, this.raiz);
		if (temp != null)
			return true;
		else
			return false;
	}

	private No pesquisa(int elem, No no) {
		No temp;
		temp = no;
		if (temp != null) {
			if (elem < temp.getInfo())
				temp = pesquisa(elem, temp.getEsq());
			else {
				if (elem > temp.getInfo())
					temp = pesquisa(elem, temp.getDir());
			}
		}
		return temp;
	}

	public boolean insere(int elem) {
		boolean existe;
		existe = pesquisa(elem);
		if (existe)
			return false;
		else {
			this.raiz = insere(elem, this.raiz);
			this.nElem++;
			return true;
		}
	}
	
	public No insere(int elem, No no) {
		No novoNo;
		if (no == null) {
			novoNo = new No(elem);
			return novoNo;
		} else {
			if (elem < no.getInfo()) {
				no.setEsq(insere(elem, no.getEsq()));
				return no;
			} else {
				no.setDir(insere(elem, no.getDir()));
				return no;
			}
		}
	}
	
	public boolean remove(int chave) {
		No temp;
		temp = pesquisa(chave, this.raiz);
		if (temp != null) {
			this.raiz = remove(chave, this.raiz);
			this.nElem--;
			return true;
		} else
			return false;
	}
	
	private No remove(int chave, No no) {
		if (no == null)
			return no;
		else if (chave < no.getInfo())
			no.setEsq(remove(chave, no.getEsq()));
		else if (chave > no.getInfo())
			no.setDir(remove(chave, no.getDir()));
		else if (no.getDir() == null)
			return no.getEsq();
		else if (no.getEsq() == null)
			return no.getDir();
		else
			no.setEsq(arruma(no, no.getEsq()));
		return no;
	}
	
	private No arruma(No Q, No R) {
		if (R.getDir() != null)
			R.setDir(arruma(Q, R.getDir()));
		else {
			Q.setInfo(R.getInfo());
			R = R.getEsq();
		}
		return R;
	}
	
	public int[] CamCentral (int [] vetOrdenado){
		return (this.FazCamCentral (this.raiz, vetOrdenado));
	}

	private int contador = 0;

	private int[] FazCamCentral(No no, int[] vetOrdenado) {
	    if (no != null) {
	        FazCamCentral(no.getEsq(), vetOrdenado); // Percorre o filho esquerdo
	        vetOrdenado[contador++] = no.getInfo(); // Visita o nó atual e adiciona ao vetor
	        FazCamCentral(no.getDir(), vetOrdenado); // Percorre o filho direito
	    }
	    return vetOrdenado;
	}
	

}
