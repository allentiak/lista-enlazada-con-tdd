package ar.edu.untref.ayp2;

public class NodoLSE<CualquierTipo> {

	private CualquierTipo dato;
	private NodoLSE<CualquierTipo> sigte;

	public NodoLSE() {
		this.asigDato(null);
	}

	public NodoLSE(CualquierTipo miDato) {
		this.asigDato(miDato);
	}

	public CualquierTipo obtDato() {
		return dato;
	}

	public void asigDato(CualquierTipo nuevoDato) {
		this.dato = nuevoDato;
	}

	public NodoLSE<CualquierTipo> obtSigte() {
		return sigte;
	}

	public void asigSigte(NodoLSE<CualquierTipo> otroNodo) {
		this.sigte = otroNodo;
	}

	public boolean esValido() {
		return (obtDato() != null);
	}

	public void enlazarLuegoDe(NodoLSE<CualquierTipo> nodoAnterior) {
		this.asigSigte(nodoAnterior.obtSigte());
		nodoAnterior.asigSigte(this);
	}

	public void desenlazarElSiguienteNodo() {
		this.asigSigte(this.obtSigte().obtSigte());
	}

}
