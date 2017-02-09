package br.com.zurcs.commons.util.intervalo;

import java.io.Serializable;
import java.util.Set;

public abstract class Intervalo<T> implements Serializable {

	private static final long serialVersionUID = -5685247068448696482L;

	public abstract T getInicio();
	public abstract T getFim();
	
	/**
	 * 
	 * Retorno conjunto de unidades compreendidas entre o periodo, sendo inicio e fim incluidos no conjunto. 
	 * 
	 * @return
	 */
	public abstract Set<T> getConjuntoDoPeriodo();
	
	@Override
	public String toString() {
		return  getClass().getSimpleName()+" [Inicio=" + getInicio() + ", Fim()="+ getFim() + "]";
	}
	
}
