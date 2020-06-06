package ar.edu.untref.ayp2;

import java.util.NoSuchElementException;

public class IteradorLSE<CualquierTipo> {

	private NodoLSE<CualquierTipo> actual;

	IteradorLSE(NodoLSE<CualquierTipo> miNodo) {
		this.actual = miNodo;
	}

	IteradorLSE(CualquierTipo miElemento) {
		this.actual = new NodoLSE<CualquierTipo>(miElemento);
	}

	boolean esValido() {
		return (actual != null) ? actual.esValido() : false;
	}

	NodoLSE<CualquierTipo> obtActual() {
		return esValido() ? actual : null;
	}

	boolean esUltimoElemento() {
		return (esValido() && (obtActual().obtSigte() == null));
	}

	void avanzar() {
		if (!obtActual().esValido()) {
			throw new NoSuchElementException();
		}
		this.actual = actual.obtSigte();
	}

	void avanzarAlFinal() {
		while (!esUltimoElemento()) {
			this.avanzar();
		}
	}

	void avanzarAPosicion(int posicionDeseada) {
		for (int i = 0; i < posicionDeseada; i++) {
			this.avanzar();
		}
	}

}
