package ar.edu.untref.ayp2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ListaSimplementeEnlazadaAssertJTest {

	@Test
	void debo_poder_crear_una_lista_generica_vacia() {
		ListaSimplementeEnlazada<Object> miListaSimplementeEnlazadaVacia = new ListaSimplementeEnlazada<Object>();
		assertThat(miListaSimplementeEnlazadaVacia).isNotNull();
		assertThat(miListaSimplementeEnlazadaVacia.estaVacia()).isTrue();
	}

	@Test
	void debo_poder_consultar_una_lista_generica_vacia() {
		ListaSimplementeEnlazada<Object> miListaSimplementeEnlazadaVacia = new ListaSimplementeEnlazada<Object>();
		assertThat(miListaSimplementeEnlazadaVacia).isNotNull();
		assertThat(miListaSimplementeEnlazadaVacia.estaVacia()).isTrue();
		assertThat(miListaSimplementeEnlazadaVacia.obtTamanio()).isEqualTo(0);
		assertThat(miListaSimplementeEnlazadaVacia.obtPrimerElemento()).isNull();
		assertThat(miListaSimplementeEnlazadaVacia.obtUltimoElemento()).isNull();
		assertThat(miListaSimplementeEnlazadaVacia.obtElementoEnPosicion(0)).isNull();
	}

	@Test
	void debo_poder_consultar_una_lista_generica_con_un_elemento() {
		String miElemento = "Alfa";
		ListaSimplementeEnlazada<String> miListaSimplementeEnlazadaConUnElemento = new ListaSimplementeEnlazada<String>(miElemento);
		assertThat(miListaSimplementeEnlazadaConUnElemento).isNotNull();
		assertThat(miListaSimplementeEnlazadaConUnElemento.estaVacia()).isFalse();
		assertThat(miListaSimplementeEnlazadaConUnElemento.obtTamanio()).isEqualTo(1);
		assertThat(miListaSimplementeEnlazadaConUnElemento.obtPrimerElemento()).isEqualTo(miElemento);
		assertThat(miListaSimplementeEnlazadaConUnElemento.obtUltimoElemento()).isEqualTo(miElemento);
		assertThat(miListaSimplementeEnlazadaConUnElemento.obtElementoEnPosicion(0)).isEqualTo(miElemento);
	}

}
