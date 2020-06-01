package ar.edu.untref.ayp2;

public class Nodo<CualquierTipo> {

	private CualquierTipo dato;

	public CualquierTipo obtDato() {
		return dato;
	}

	public boolean esValido() {
		return (obtDato() != null);
	}

}
