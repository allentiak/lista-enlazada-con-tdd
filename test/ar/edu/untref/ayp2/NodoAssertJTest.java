package ar.edu.untref.ayp2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class NodoAssertJTest {

	@Test
	void debo_poder_crear_un_nodo_generico() {
		Nodo<Object> miNodo = new Nodo<Object>();
		assertThat(miNodo).isNotNull();
	}

}
