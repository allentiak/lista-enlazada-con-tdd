package ar.edu.untref.ayp2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class NodoAssertJTest {

	@Test
	void debo_poder_crear_un_nodo() {
		Nodo miNodo = new Nodo();
		assertThat(miNodo).isNotNull();
	}

}
