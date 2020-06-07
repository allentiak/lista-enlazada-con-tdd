package ar.edu.untref.ayp2;

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

	CualquierTipo obtActual() {
		return esValido() ? actual.obtDato() : null;
	}

}
