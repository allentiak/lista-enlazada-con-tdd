package ar.edu.untref.ayp2;

import java.util.Scanner;

import java.util.NoSuchElementException;

public class LSEBrokenKeyboard {

	static String problemInput;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		problemInput = s.nextLine();
		s.close();
		solve();
	}

	static void solve() {
		ListaSE<Character> lista = convertirEntradaALista(problemInput);
		String salida = convertirListaASalida(lista);
		System.out.println(salida);
	}

	static ListaSE<Character> convertirEntradaALista(String entrada) {
		ListaSE<Character> lista = new ListaSE<>();
		int posicionActualDelCursor = 0;
		int cantDeLetrasHastaAhora = 0;

		if (entrada.isEmpty())
			return lista;

		for (int pos = 0; pos < entrada.length(); pos++) {
			Character caracterActual = entrada.charAt(pos);
			if ((caracterActual != '[') && (caracterActual != ']')) {
				cantDeLetrasHastaAhora++;
			}

			// posicionActualDelCursor --> ya definida fuera del for
			int nuevaPosicionDelCursor = convertirCaracterANuevaPosicionDelCursor(caracterActual,
					posicionActualDelCursor, cantDeLetrasHastaAhora);

			if ((caracterActual != '[') && (caracterActual != ']')) {
				lista.insertarElementoEnPosicion(caracterActual, nuevaPosicionDelCursor);
				posicionActualDelCursor++;
			} else {
				posicionActualDelCursor = nuevaPosicionDelCursor;
			}

		}
		return lista;

	}

	static String convertirListaASalida(ListaSE<Character> lista) {

		String cadena = "";

		if (lista.estaVacia())
			return cadena;

		for (int i = 0; i < lista.obtTamanio(); i++) {
			cadena = cadena + lista.obtElementoEnPosicion(i).toString();
		}

		return cadena;
	}

	static int convertirCaracterANuevaPosicionDelCursor(Character caracter, int posVieja, int maximaPosicionPosible) {

		switch (caracter) {
		case '[':
			return 0;
		case ']':
			return maximaPosicionPosible;
		default:
			return posVieja;
		}
	}

	static class NodoLSE<CualquierTipo> {

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

	static class IteradorLSE<CualquierTipo> {

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

	static class ListaSE<CualquierTipo> {

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

		private void asigTamanio(int nuevoTamanio) {
			this.tamanio = nuevoTamanio;
		}

		public IteradorLSE<CualquierTipo> obtIterador() {
			if (cabeza.obtSigte() != null) {
				return new IteradorLSE<CualquierTipo>(cabeza.obtSigte());
			}
			return new IteradorLSE<CualquierTipo>(cabeza);
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

		public void insertarElementoAlPrincipio(CualquierTipo miNuevoElemento) {
			NodoLSE<CualquierTipo> miNuevoNodo = new NodoLSE<CualquierTipo>(miNuevoElemento);
			miNuevoNodo.enlazarLuegoDe(cabeza);
			asigTamanio(obtTamanio() + 1);
		}

		public void insertarElementoAlFinal(CualquierTipo miNuevoElemento) {
			// hack
			if (obtTamanio() == 0) {
				insertarElementoAlPrincipio(miNuevoElemento);
			} else {

				NodoLSE<CualquierTipo> miNuevoNodo = new NodoLSE<CualquierTipo>(miNuevoElemento);
				IteradorLSE<CualquierTipo> iterador = obtIterador();
				iterador.avanzarAPosicion(obtTamanio() - 1);
				miNuevoNodo.enlazarLuegoDe(iterador.obtActual());
				asigTamanio(obtTamanio() + 1);
			}
		}

		public void insertarElementoEnPosicion(CualquierTipo miNuevoElemento, int posicionDeseada) {
			// hack
			if (obtTamanio() == 0 || posicionDeseada == 0) {
				insertarElementoAlPrincipio(miNuevoElemento);
			} else {

				NodoLSE<CualquierTipo> miNuevoNodo = new NodoLSE<CualquierTipo>(miNuevoElemento);
				IteradorLSE<CualquierTipo> iterador = obtIterador();
				iterador.avanzarAPosicion(posicionDeseada - 1);
				miNuevoNodo.enlazarLuegoDe(iterador.obtActual());
				asigTamanio(obtTamanio() + 1);
			}
		}

		public void eliminarPrimerElemento() {
			if (cabeza.obtSigte() == null) {
				throw new NoSuchElementException();
			}
			cabeza.desenlazarElSiguienteNodo();
			asigTamanio(obtTamanio() - 1);
		}

		public void eliminarUltimoElemento() {
			IteradorLSE<CualquierTipo> iterador = obtIterador();
			iterador.avanzarAPosicion(obtTamanio() - 2);
			iterador.obtActual().desenlazarElSiguienteNodo();
			asigTamanio(obtTamanio() - 1);
		}

		public void eliminarElementoEnPosicion(int posicionDeseada) {
			if (posicionDeseada < 0 || cabeza.obtSigte() == null) {
				throw new NoSuchElementException();
			}
			if (posicionDeseada == 0) {
				cabeza.desenlazarElSiguienteNodo();
			}
			if (posicionDeseada > 0) {
				IteradorLSE<CualquierTipo> iterador = obtIterador();
				iterador.avanzarAPosicion(posicionDeseada - 1);
				iterador.obtActual().desenlazarElSiguienteNodo();
			}
			asigTamanio(obtTamanio() - 1);
		}

	}

}
