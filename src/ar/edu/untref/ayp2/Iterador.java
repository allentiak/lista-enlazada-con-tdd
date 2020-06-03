package ar.edu.untref.ayp2;

public class Iterador<CualquierTipo> {

	private Nodo<CualquierTipo> actual;

	Iterador(Nodo<CualquierTipo> miNodo) {
		this.actual = miNodo;
	}

	Iterador(CualquierTipo miElemento) {
		this.actual = new Nodo<CualquierTipo>(miElemento);
	}

	boolean esValido() {
		return (actual != null) ? actual.esValido() : false;
	}

	CualquierTipo obtActual() {
		return actual.esValido() ? actual.obtDato() : null;
	}

}
