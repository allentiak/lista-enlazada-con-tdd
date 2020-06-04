package ar.edu.untref.ayp2;

import static org.assertj.core.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

public class ListaSEAssertJTest {

	@Test
	void debo_poder_crear_una_lista_generica_vacia() {
		ListaSE<Object> miListaSimplementeEnlazadaVacia = new ListaSE<Object>();
		assertThat(miListaSimplementeEnlazadaVacia).isNotNull();
		assertThat(miListaSimplementeEnlazadaVacia.estaVacia()).isTrue();
	}

	@Test
	void debo_poder_consultar_una_lista_generica_vacia() {
		ListaSE<Object> miListaSimplementeEnlazadaVacia = new ListaSE<Object>();
		assertThat(miListaSimplementeEnlazadaVacia).isNotNull();
		assertThat(miListaSimplementeEnlazadaVacia.estaVacia()).isTrue();
		assertThat(miListaSimplementeEnlazadaVacia.obtTamanio()).isEqualTo(0);

		// NOTA - USUARIES de JUnit4: Este bloque de código que espera excepciones
		// utiliza una sintaxis muy parecida a la de las assertions de JUnit5 puro,
		// bastante diferente a la de JUnit4 < 4.7.
		//
		// Adicionalmente, en JUnit4, cada uno de los bloques de código que esperames
		// genere la excepción debería ir en un test distinto.
		//
		// Esto es para evitar falsos positivos: a menos que separemos esos bloques de
		// código, con que la excepción se genere en uno de los tres casos alcanzaría
		// para pasar el test - justamente lo que deseamos evitar.
		//
		// Vease un ejemplo de cómo esta porción del test podría reescribirse para
		// trabajar en JUnit4 < 4.7 a continuación
		//
		assertThat(catchThrowableOfType(() -> {
			miListaSimplementeEnlazadaVacia.obtPrimerElemento();
		}, NoSuchElementException.class)).isNotNull();
		assertThat(catchThrowableOfType(() -> {
			miListaSimplementeEnlazadaVacia.obtUltimoElemento();
		}, NoSuchElementException.class)).isNotNull();
		assertThat(catchThrowableOfType(() -> {
			miListaSimplementeEnlazadaVacia.obtElementoEnPosicion(0);
		}, NoSuchElementException.class)).isNotNull();
	}

//	Así se escribiría la sección que espera excepciones del test anterior en
//	JUnit4 < 4.7
//
//	Adicionalmente, como oportunamente se explicó arriba,
//	debería escribirse un test para cada bloque de código que espereramos
//	que produzca la excepción. De esta manera evitamos generar falsos positivos.
//
//	IMPORTANTE: Esta sintaxis ya no es soportada en JUnit5, por lo que se recomienda dejarla.
//
//	@Test(expected = NoSuchElementException.class)
//	void debo_poder_consultar_una_lista_generica_vacia_junit4() {
//		ListaSimplementeEnlazada<Object> miListaSimplementeEnlazadaVacia = new ListaSimplementeEnlazada<Object>();
//		miListaSimplementeEnlazadaVacia.obtPrimerElemento();
//	}

	@Test
	void debo_poder_consultar_una_lista_generica_con_un_elemento() {
		String alfa = "Alfa";
		ListaSE<String> miListaSimplementeEnlazadaConUnElemento = new ListaSE<String>(alfa);
		assertThat(miListaSimplementeEnlazadaConUnElemento).isNotNull();
		assertThat(miListaSimplementeEnlazadaConUnElemento.estaVacia()).isFalse();
		assertThat(miListaSimplementeEnlazadaConUnElemento.obtTamanio()).isEqualTo(1);
		assertThat(miListaSimplementeEnlazadaConUnElemento.obtPrimerElemento()).isEqualTo(alfa);
		assertThat(miListaSimplementeEnlazadaConUnElemento.obtUltimoElemento()).isEqualTo(alfa);
		assertThat(miListaSimplementeEnlazadaConUnElemento.obtElementoEnPosicion(0)).isEqualTo(alfa);
	}

	@Test
	void debo_poder_consultar_una_lista_generica_con_dos_elementos__el_segundo_instertado_al_principio() {
		String miPrimerElemento = "Alfa";
		String miSegundoElemento = "Beta";
		ListaSE<String> miListaSEConDosElementos = new ListaSE<String>(miSegundoElemento);
		assertThat(miListaSEConDosElementos.obtTamanio()).isEqualTo(1);
		miListaSEConDosElementos.insertarAlPrincipio(miPrimerElemento);
		assertThat(miListaSEConDosElementos).isNotNull();
		assertThat(miListaSEConDosElementos.estaVacia()).isFalse();
		assertThat(miListaSEConDosElementos.obtTamanio()).isEqualTo(2);
		assertThat(miListaSEConDosElementos.obtPrimerElemento().equals(miPrimerElemento)).isTrue();
		assertThat(miListaSEConDosElementos.obtUltimoElemento().equals(miSegundoElemento)).isTrue();
		assertThat(miListaSEConDosElementos.obtElementoEnPosicion(0).equals(miPrimerElemento)).isTrue();
		assertThat(miListaSEConDosElementos.obtElementoEnPosicion(1).equals(miPrimerElemento)).isTrue();
	}

}
