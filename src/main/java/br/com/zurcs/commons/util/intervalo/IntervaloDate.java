package br.com.zurcs.commons.util.intervalo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import br.com.zurcs.commons.util.date.DateUtil;
import br.com.zurcs.commons.util.validators.IsNullUtil;

public class IntervaloDate extends Intervalo<LocalDate> {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 6315471939161947266L;

	private LocalDate inicio;

	private LocalDate fim;

	public IntervaloDate( final LocalDate inicio, final LocalDate fim ) {
		setInicio(inicio);
		setFim(fim);
	}

	public static IntervaloDate novoCom(final LocalDate inicio, final LocalDate fim) {

		return new IntervaloDate(inicio, fim);
	}

	public IntervaloDate() {
	}

	public LocalDate getInicio() {

		return inicio;
	}

	public void setInicio(LocalDate inicio) {

		if (!IsNullUtil.isNullOrEmpty(inicio) && !IsNullUtil.isNullOrEmpty(fim)) {
			if (inicio.isAfter(fim)) {
				throw new IllegalStateException("Inicio não pode ser maior que o Fim");
			}
		}
		this.inicio = inicio;
	}

	public LocalDate getFim() {

		return fim;
	}

	public void setFim(LocalDate fim) {

		if (!IsNullUtil.isNullOrEmpty(fim) && !IsNullUtil.isNullOrEmpty(inicio)) {
			if (fim.isBefore(inicio)) {
				throw new IllegalStateException("Fim não pode ser menor que o Inicio");
			}
		}
		this.fim = fim;
	}

	/**
	 * Método responsável por retornar a data final do intervalo com os valores do horário maximizados.
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @return
	 * 
	 * @see br.com.zurcs.commons.util.date.DateUtil#extractMax(Date)
	 */
	public LocalDateTime getFimMaximizado() {

		return DateUtil.extractMax(this.fim);
	}

	/**
	 * Método responsável por retornar a data inicial do intervalo com os valores do horário minimizados.
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @return
	 * 
	 * @see br.com.zurcs.commons.util.date.DateUtil#extractMin(Date)
	 */
	public LocalDateTime getInicioMinimizado() {

		return DateUtil.extractMin(this.inicio);
	}

	@Override
	public String toString() {

		return "IntervaloNumerico [inicio=" + inicio + ", fim=" + fim + "]";
	}

	@Override
	public Set<LocalDate> getConjuntoDoPeriodo() {

		final Set<LocalDate> diasDoPeriodo = new HashSet<>();

		final Long qtdDias = getInicio().until(getFim(), ChronoUnit.DAYS);

		for (int i = 0; i <= qtdDias; i++) {
			diasDoPeriodo.add(getInicio().plusDays(i));
		}

		return diasDoPeriodo;
	}

}
