package br.com.zurcs.commons.util.validators;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 *
 * <p>
 * Test for {@link EmailValidator}.
 * </p>
 *
 *
 */
public final class EmailValidatorTest {

	@Test
	public void deve_retornar_true_para_um_unico_email_valido() {

		// given
		final String email = "albert.einsten@phisics.com";

		// when
		final boolean emailEhValido = EmailValidator.isValid(email);

		// then
		assertThat(emailEhValido, equalTo(Boolean.TRUE));
	}

	@Test
	public void deve_retornar_false_para_um_unico_email_invalido() {

		// given
		final String email = "albert.einsten_phisics.com";

		// when
		final boolean emailEhValido = EmailValidator.isValid(email);

		// then
		assertThat(emailEhValido, equalTo(Boolean.FALSE));
	}

	@Test
	public void deve_retornar_true_para_multiplos_emails_validos() {

		// given
		final String emailAlbert = "albert.einsten@phisics.com";
		final String emailThomas = "thomas.alva@innovation.com";

		// when
		final boolean emailsValidos = EmailValidator.isValid(emailAlbert, emailThomas);

		// then
		assertThat(emailsValidos, equalTo(Boolean.TRUE));
	}

	@Test
	public void deve_retornar_true_para_multiplos_emails_validos_separados_por_virgula() {

		// given
		final String emails = "albert.einsten@phisics.com,thomas.alva@innovation.com";

		// when
		final boolean emailsValidos = EmailValidator.isMultiplosEmailsSeparadosPorVirgulaValidos(emails);

		// then
		assertThat(emailsValidos, equalTo(Boolean.TRUE));
	}

	@Test
	public void deve_retornar_true_para_multiplos_emails_validos_separados_por_ponto_virgula() {

		// given
		final String emails = "albert.einsten@phisics.com;thomas.alva@innovation.com";
		final String pontoVirgula = ";";

		// when
		final boolean emailsValidos = EmailValidator.isMultipleEmailsValid(emails, pontoVirgula);

		// then
		assertThat(emailsValidos, equalTo(Boolean.TRUE));
	}

}
