package ar.edu.untref.ayp2;

import static org.assertj.core.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;
import static ar.edu.untref.ayp2.BrokenKeyboard.*;

public class BrokenKeyboardTest {

	@Test
	void convertirCaracterAPosicionTest() {

		// Entrada: a[]b
		Character c1 = 'a';
		Character c2 = '[';
		Character c3 = ']';
		Character c4 = 'b';

		assertThat(convertirCaracterANuevaPosicionDelCursor(c1, 0, 1)).isEqualTo(0);
		assertThat(convertirCaracterANuevaPosicionDelCursor(c2, 0, 1)).isEqualTo(0);
		assertThat(convertirCaracterANuevaPosicionDelCursor(c3, 0, 1)).isEqualTo(1);
		assertThat(convertirCaracterANuevaPosicionDelCursor(c4, 1, 2)).isEqualTo(1);
	}

	@Test
	void entrada1Test() {
		String entrada1 = "ab[cd]ef";
		String salida1 = "cdabef";

		LinkedList<Character> lista1Esperada = new LinkedList<>();
		lista1Esperada.addLast('c');
		lista1Esperada.addLast('d');
		lista1Esperada.addLast('a');
		lista1Esperada.addLast('b');
		lista1Esperada.addLast('e');
		lista1Esperada.addLast('f');
		LinkedList<Character> lista1Convertida = convertirEntradaALista(entrada1);
		assertThat(lista1Convertida).isEqualTo(lista1Esperada);

		assertThat(convertirListaASalida(lista1Esperada)).isEqualTo(salida1);

	}

	@Test
	void entrada2Test() {
		String entrada2 = "a[b]c[d]e[f]g";
		String salida2 = "fdbaceg";

		LinkedList<Character> lista2Esperada = new LinkedList<>();
		lista2Esperada.addLast('f');
		lista2Esperada.addLast('d');
		lista2Esperada.addLast('b');
		lista2Esperada.addLast('a');
		lista2Esperada.addLast('c');
		lista2Esperada.addLast('e');
		lista2Esperada.addLast('g');
		LinkedList<Character> lista2Convertida = convertirEntradaALista(entrada2);
		assertThat(lista2Convertida).isEqualTo(lista2Esperada);

		assertThat(convertirListaASalida(lista2Esperada)).isEqualTo(salida2);

	}

}
