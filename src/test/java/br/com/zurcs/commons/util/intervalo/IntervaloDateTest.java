package br.com.zurcs.commons.util.intervalo;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.junit.MatcherAssert.assertThat;

import java.time.LocalDate;

import org.hamcrest.core.Is;
import org.junit.Test;

public class IntervaloDateTest {

	@Test
	public void deve_retornar_inicio_eh_fim_informados() {

		// given
		final LocalDate inicio = LocalDate.now();
		final LocalDate fim = LocalDate.now();

		// when
		final IntervaloDate intervalo = IntervaloDate.novoCom(inicio, fim);

		// then
		assertThat(intervalo, Is.is(notNullValue()));
		assertThat(intervalo.getInicio(), Is.is(equalTo(inicio)));
		assertThat(intervalo.getFim(), Is.is(equalTo(fim)));
	}

}
