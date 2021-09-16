package ar.edu.untref.ayp2;

import java.util.Scanner;
import java.util.LinkedList;

public class BrokenKeyboard {

	static String problemInput;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		problemInput = s.nextLine();
		s.close();
		solve();
	}

	static void solve() {
		LinkedList<Character> lista = convertirEntradaALista(problemInput);
		String salida = convertirListaASalida(lista);
		System.out.println(salida);
	}

	static LinkedList<Character> convertirEntradaALista(String entrada) {
		LinkedList<Character> lista = new LinkedList<>();
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
				lista.add(nuevaPosicionDelCursor, caracterActual);
				posicionActualDelCursor++;
			} else {
				posicionActualDelCursor = nuevaPosicionDelCursor;
			}

		}
		return lista;

	}

	static String convertirListaASalida(LinkedList<Character> lista) {

		String cadena = "";

		if (lista.isEmpty())
			return cadena;

		for (int i = 0; i < lista.size(); i++) {
			cadena = cadena + lista.get(i).toString();
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

}
