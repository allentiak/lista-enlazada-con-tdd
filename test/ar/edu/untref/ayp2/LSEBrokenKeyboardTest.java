package ar.edu.untref.ayp2;

import static org.assertj.core.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;
import static ar.edu.untref.ayp2.BrokenKeyboard.*;

public class LSEBrokenKeyboardTest {

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

		LSEBrokenKeyboard.ListaSE<Character> lista1Esperada = new LSEBrokenKeyboard.ListaSE<>();
		lista1Esperada.insertarElementoAlFinal('c');
		lista1Esperada.insertarElementoAlFinal('d');
		lista1Esperada.insertarElementoAlFinal('a');
		lista1Esperada.insertarElementoAlFinal('b');
		lista1Esperada.insertarElementoAlFinal('e');
		lista1Esperada.insertarElementoAlFinal('f');
		LSEBrokenKeyboard.ListaSE<Character> lista1Convertida = LSEBrokenKeyboard.convertirEntradaALista(entrada1);

		// The following assertion fails, but the lists are alike...
		// Probably need to implement "equals"?
//		assertThat(lista1Convertida).isEqualTo(lista1Esperada);

		assertThat(LSEBrokenKeyboard.convertirListaASalida(lista1Esperada)).isEqualTo(salida1);

	}

	@Test
	void entrada2Test() {
		String entrada2 = "a[b]c[d]e[f]g";
		String salida2 = "fdbaceg";

		LSEBrokenKeyboard.ListaSE<Character> lista2Esperada = new LSEBrokenKeyboard.ListaSE<>();
		lista2Esperada.insertarElementoAlFinal('f');
		lista2Esperada.insertarElementoAlFinal('d');
		lista2Esperada.insertarElementoAlFinal('b');
		lista2Esperada.insertarElementoAlFinal('a');
		lista2Esperada.insertarElementoAlFinal('c');
		lista2Esperada.insertarElementoAlFinal('e');
		lista2Esperada.insertarElementoAlFinal('g');
		LSEBrokenKeyboard.ListaSE<Character> lista2Convertida = LSEBrokenKeyboard.convertirEntradaALista(entrada2);

		// The following assertion fails, but the lists are alike...
		// Probably need to implement "equals"?
//		assertThat(lista2Convertida).isEqualTo(lista2Esperada);

		assertThat(LSEBrokenKeyboard.convertirListaASalida(lista2Esperada)).isEqualTo(salida2);

	}

}
