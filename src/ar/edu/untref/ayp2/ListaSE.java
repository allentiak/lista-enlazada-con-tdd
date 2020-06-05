package ar.edu.untref.ayp2;

import java.util.NoSuchElementException;

public class ListaSE<CualquierTipo> {

	private NodoLSE<CualquierTipo> cabeza;
	private int tamanio;

	public ListaSE(CualquierTipo miElemento) {
		this.cabeza = new NodoLSE<CualquierTipo>(null);
		cabeza.asigSigte(new NodoLSE<CualquierTipo>(miElemento));
		asigTamanio(1);
	}

	public ListaSE() {
		this.cabeza = new NodoLSE<CualquierTipo>(null);
		cabeza.asigSigte(null);
		asigTamanio(0);
	}

	public int obtTamanio() {
		return tamanio;
	}

	public IteradorLSE<CualquierTipo> obtIterador() {
		return new IteradorLSE<CualquierTipo>(cabeza.obtSigte());
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

		if (estaVacia()) {
			throw new NoSuchElementException();
		}

		IteradorLSE<CualquierTipo> iterador = this.obtIterador();

		while (iterador.esValido() && (iterador.obtActual().obtSigte() != null)) {
			iterador.avanzar();
		}

		return iterador.obtActual().obtDato();
	}

	public CualquierTipo obtElementoEnPosicion(int i) {
		return obtPrimerElemento();
	}

	public void insertarAlPrincipio(CualquierTipo miNuevoElemento) {
		NodoLSE<CualquierTipo> miNuevoNodo = new NodoLSE<CualquierTipo>(miNuevoElemento);
		miNuevoNodo.asigSigte(cabeza.obtSigte());
		this.cabeza.asigSigte(miNuevoNodo);
		asigTamanio(obtTamanio() + 1);
	}

}
