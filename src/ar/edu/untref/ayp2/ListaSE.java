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

		iterador.avanzarAlFinal();

		return iterador.obtActual().obtDato();
	}

	public CualquierTipo obtElementoEnPosicion(int posicionDeseada) {

		if (estaVacia() || (obtTamanio() < posicionDeseada + 1)) {
			throw new NoSuchElementException();
		}

		IteradorLSE<CualquierTipo> iterador = this.obtIterador();

		iterador.avanzarAPosicion(posicionDeseada);

		return iterador.obtActual().obtDato();
	}

	public void insertarAlPrincipio(CualquierTipo miNuevoElemento) {
		NodoLSE<CualquierTipo> miNuevoNodo = new NodoLSE<CualquierTipo>(miNuevoElemento);
		miNuevoNodo.enlazarLuegoDe(cabeza);
		asigTamanio(obtTamanio() + 1);
	}

	public void insertarAlFinal(CualquierTipo miNuevoElemento) {
		NodoLSE<CualquierTipo> miNuevoNodo = new NodoLSE<CualquierTipo>(miNuevoElemento);
		IteradorLSE<CualquierTipo> iterador = obtIterador();
		iterador.avanzarAPosicion(obtTamanio() - 2);
		miNuevoNodo.enlazarLuegoDe(iterador.obtActual());
		asigTamanio(obtTamanio() + 1);
	}

	public void insertarEnPosicion(CualquierTipo miNuevoElemento, int posicionDeseada) {
		NodoLSE<CualquierTipo> miNuevoNodo = new NodoLSE<CualquierTipo>(miNuevoElemento);
		IteradorLSE<CualquierTipo> iterador = obtIterador();
		iterador.avanzarAPosicion(posicionDeseada - 1);
		miNuevoNodo.enlazarLuegoDe(iterador.obtActual());
		asigTamanio(obtTamanio() + 1);
	}

}
