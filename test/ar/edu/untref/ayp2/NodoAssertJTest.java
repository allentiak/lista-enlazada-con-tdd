package ar.edu.untref.ayp2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class NodoAssertJTest {

	@Test
	void debo_poder_crear_un_nodo_generico_vacio() {
		Nodo<Object> miNodoVacio = new Nodo<Object>();
		assertThat(miNodoVacio).isNotNull();
		assertThat(miNodoVacio.esValido()).isFalse();
		assertThat(miNodoVacio.obtSigte()).isNull();
	}

	@Test
	void debo_poder_crear_un_nodo_generico_no_vacio() {
		Nodo<String> miNodoNoVacio = new Nodo<String>("Alfa");
		assertThat(miNodoNoVacio.esValido()).isTrue();
		assertThat(miNodoNoVacio.obtDato()).isEqualTo("Alfa");
		assertThat(miNodoNoVacio.obtSigte()).isNull();
	}

	@Test
	void debo_poder_encadenar_dos_nodos_no_vacios() {
		Nodo<String> miPrimerNodoNoVacio = new Nodo<String>("Alfa");
		Nodo<String> miSegundoNodoNoVacio = new Nodo<String>("Beta");
		miPrimerNodoNoVacio.asigSigte(miSegundoNodoNoVacio);
		assertThat(miPrimerNodoNoVacio.obtSigte()).isEqualTo(miSegundoNodoNoVacio);
	}

}
