package br.com.zurcs.commons.util.intervalo;

import java.util.HashSet;
import java.util.Set;

import br.com.zurcs.commons.util.number.CompareNumberUtil;
import br.com.zurcs.commons.util.validators.IsNullUtil;

public class IntervaloNumber<T extends Number> extends Intervalo<Number>{

	private static final long serialVersionUID = -7516908845487496999L;
	
	private T inicio;
	private T fim;
	
	public IntervaloNumber(T inicio, T fim) {
		setInicio(inicio);
		setFim(fim);
	}
	
	public IntervaloNumber() {
	}

	public T getInicio() {
		return inicio;
	}

	public void setInicio(T inicio) {
		if(!IsNullUtil.isNullOrEmpty(inicio) && !IsNullUtil.isNullOrEmpty(fim)){
			if(CompareNumberUtil.compare(inicio, fim) > 0){
				throw new IllegalStateException("Inicio não pode ser maior que o Fim");
			}
		}
		this.inicio = inicio;
	}

	public T getFim() {
		return fim;
	}

	public void setFim(T fim) {
		if(!IsNullUtil.isNullOrEmpty(inicio) && !IsNullUtil.isNullOrEmpty(fim)){
			if(CompareNumberUtil.compare(fim, inicio) < 0){
				throw new IllegalStateException("Fim não pode ser menor que o Inicio");
			}
		}
		this.fim = fim;
	}
	
	@Override
	public String toString() {
		return "IntervaloNumerico [inicio=" + inicio + ", fim=" + fim + "]";
	}

	@Override
	public Set<Number> getConjuntoDoPeriodo() {
		final Set<Number> conjunto = new HashSet<>();
		
		final long quantidade = (getFim().longValue() - getInicio().longValue());
		
		for (int i = 0; i <= quantidade; i++) {
			conjunto.add(getInicio().longValue() + i);		
		}
		
		return conjunto;
	}
}
