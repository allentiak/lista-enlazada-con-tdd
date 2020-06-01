package ar.edu.untref.ayp2;

public class Nodo<CualquierTipo> {

	private CualquierTipo dato;
	private Nodo<CualquierTipo> sigte;

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

	public Nodo<CualquierTipo> obtSigte() {
		return sigte;
	}

	public void asigSigte(Nodo<CualquierTipo> otroNodo) {
		this.sigte = otroNodo;
	}

	public boolean esValido() {
		return (obtDato() != null);
	}

}
