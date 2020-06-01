package ar.edu.untref.ayp2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ListaSimplementeEnlazadaAssertJTest {

	@Test
	void debo_poder_crear_una_lista_generica_vacia() {
		ListaSimplementeEnlazada<Object> miListaSimplementeEnlazadaVacia = new ListaSimplementeEnlazada<Object>();
		assertThat(miListaSimplementeEnlazadaVacia).isNotNull();
		assertThat(miListaSimplementeEnlazadaVacia.estaVacia()).isTrue();
	}

}
