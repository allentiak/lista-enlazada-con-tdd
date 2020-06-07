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

}
