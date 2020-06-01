package ar.edu.untref.ayp2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class NodoAssertJTest {

	@Test
	void debo_poder_crear_un_nodo_generico_vacio() {
		Nodo<Object> miNodoVacio = new Nodo<Object>();
		assertThat(miNodoVacio).isNotNull();
		assertThat(miNodoVacio.esValido()).isFalse();
	}

	@Test
	void debo_poder_crear_un_nodo_generico_no_vacio() {
		Nodo<String> miNodoNoVacio = new Nodo<String>("Alfa");
		assertThat(miNodoNoVacio.esValido()).isTrue();
		assertThat(miNodoNoVacio.obtDato()).isEqualTo("Alfa");
	}

}
