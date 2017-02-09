package br.com.zurcs.commons.util.number;

import java.math.BigDecimal;

import br.com.zurcs.commons.util.validators.IsNullUtil;

public class CompareNumberUtil {
	
	/**
	 * Compara dois Numbers
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @throws IllegalArgumentException
	 *             , os parametros não podem ser nulos
	 */
	public static int compare(Number a, Number b) throws IllegalArgumentException {
		if (IsNullUtil.isNullOrEmpty(a) || IsNullUtil.isNullOrEmpty(b)) {
			throw new IllegalArgumentException("Parametros não podem ser nulos.");
		}
		return new BigDecimal(a.toString()).compareTo(new BigDecimal(b.toString()));
	}
}
