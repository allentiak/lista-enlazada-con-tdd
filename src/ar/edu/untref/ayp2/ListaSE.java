package ar.edu.untref.ayp2;

import java.util.NoSuchElementException;

public class ListaSE<CualquierTipo> {

	private NodoLSE<CualquierTipo> cabeza = new NodoLSE<CualquierTipo>(null);
	private int tamanio;

	public ListaSE(CualquierTipo miElemento) {
		cabeza.asigSigte(new NodoLSE<CualquierTipo>(miElemento));
		asigTamanio(1);
	}

	public ListaSE() {
	}

	public int obtTamanio() {
		return tamanio;
	}

	public void asigTamanio(int tamanio) {
		this.tamanio = tamanio;
	}

	public boolean estaVacia() {
		return (cabeza.obtSigte() == null);
	}

	public CualquierTipo obtPrimerElemento() {
		if (estaVacia()) {
			throw new NoSuchElementException();
		}
		return cabeza.obtSigte().obtDato();
	}

	public CualquierTipo obtUltimoElemento() {
		return obtPrimerElemento();
	}

	public CualquierTipo obtElementoEnPosicion(int i) {
		return obtPrimerElemento();
	}

}
