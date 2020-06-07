package ar.edu.untref.ayp2;

import java.util.NoSuchElementException;

public class IteradorLSE<CualquierTipo> {

	private NodoLSE<CualquierTipo> actual;

	public IteradorLSE(NodoLSE<CualquierTipo> miNodo) {
		this.actual = miNodo;
	}

	public boolean esValido() {
		return (actual != null) ? actual.esValido() : false;
	}

	public NodoLSE<CualquierTipo> obtActual() {
		return esValido() ? actual : null;
	}

	public boolean esUltimoElemento() {
		return (esValido() && (obtActual().obtSigte() == null));
	}

	public void avanzar() {
		if (!obtActual().esValido()) {
			throw new NoSuchElementException();
		}
		this.actual = actual.obtSigte();
	}

	public void avanzarAlFinal() {
		while (!esUltimoElemento()) {
			this.avanzar();
		}
	}

	public void avanzarAPosicion(int posicionDeseada) {
		if (posicionDeseada < 0) {
			throw new NoSuchElementException();
		}

		for (int i = 0; i < posicionDeseada; i++) {
			this.avanzar();
		}
	}

}
