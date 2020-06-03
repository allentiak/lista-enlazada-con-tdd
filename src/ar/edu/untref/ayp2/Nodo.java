package ar.edu.untref.ayp2;

public class Nodo<CualquierTipo> {

	private CualquierTipo dato;

	public Nodo() {
		this.asigDato(null);
	}

	public Nodo(CualquierTipo miDato) {
		this.asigDato(miDato);
	}

	public CualquierTipo obtDato() {
		return dato;
	}

	public void asigDato(CualquierTipo nuevoDato) {
		this.dato = nuevoDato;
	}

	public boolean esValido() {
		return (obtDato() != null);
	}

}
