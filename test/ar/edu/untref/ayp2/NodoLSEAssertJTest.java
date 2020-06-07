package ar.edu.untref.ayp2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class NodoLSEAssertJTest {

	@Test
	void debo_poder_crear_un_nodo_generico_vacio() {
		NodoLSE<Object> miNodoVacio = new NodoLSE<Object>();
		assertThat(miNodoVacio).isNotNull();
		assertThat(miNodoVacio.esValido()).isFalse();
		assertThat(miNodoVacio.obtSigte()).isNull();
	}

	@Test
	void debo_poder_crear_un_nodo_generico_no_vacio() {
		NodoLSE<String> miNodoNoVacio = new NodoLSE<String>("Alfa");
		assertThat(miNodoNoVacio.esValido()).isTrue();
		assertThat(miNodoNoVacio.obtDato()).isEqualTo("Alfa");
		assertThat(miNodoNoVacio.obtSigte()).isNull();
	}

	@Test
	void debo_poder_encadenar_dos_nodos_no_vacios() {
		NodoLSE<String> miPrimerNodoNoVacio = new NodoLSE<String>("Alfa");
		NodoLSE<String> miSegundoNodoNoVacio = new NodoLSE<String>("Beta");
		miPrimerNodoNoVacio.asigSigte(miSegundoNodoNoVacio);
		assertThat(miPrimerNodoNoVacio.obtSigte()).isEqualTo(miSegundoNodoNoVacio);
	}

	@Test
	void debo_poder_enlazar_un_nodo_no_vacio_luego_de_otro_nodo_no_vacio() {
		NodoLSE<String> miPrimerNodoNoVacio = new NodoLSE<String>("Alfa");
		NodoLSE<String> miSegundoNodoNoVacio = new NodoLSE<String>("Beta");
		NodoLSE<String> miTercerNodoNoVacio = new NodoLSE<String>("Gama");
		miSegundoNodoNoVacio.enlazarLuegoDe(miPrimerNodoNoVacio);
		miTercerNodoNoVacio.enlazarLuegoDe(miSegundoNodoNoVacio);
		assertThat(miPrimerNodoNoVacio.obtSigte()).isEqualTo(miSegundoNodoNoVacio);
		assertThat(miSegundoNodoNoVacio.obtSigte()).isEqualTo(miTercerNodoNoVacio);
		assertThat(miTercerNodoNoVacio.obtSigte()).isNull();
	}

	@Test
	void debo_poder_desenlazar_el_nodo_siguiente_al_actual() {
		NodoLSE<String> miPrimerNodoNoVacio = new NodoLSE<String>("Alfa");
		NodoLSE<String> miSegundoNodoNoVacio = new NodoLSE<String>("Beta");
		NodoLSE<String> miTercerNodoNoVacio = new NodoLSE<String>("Gama");
		miSegundoNodoNoVacio.enlazarLuegoDe(miPrimerNodoNoVacio);
		miTercerNodoNoVacio.enlazarLuegoDe(miSegundoNodoNoVacio);
		miPrimerNodoNoVacio.desenlazarElSiguienteNodo();
		assertThat(miPrimerNodoNoVacio.obtSigte()).isEqualTo(miTercerNodoNoVacio);
		assertThat(miTercerNodoNoVacio.obtSigte()).isNull();
	}

}
