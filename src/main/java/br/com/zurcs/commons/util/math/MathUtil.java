package br.com.zurcs.commons.util.math;

import static br.com.zurcs.commons.util.validators.IsNullUtil.isNull;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
 * */
public class MathUtil {
	
	private MathUtil() {
		throw new IllegalStateException("Class Not Instantiable");
	}
	
	private static MathContext mathContext = new MathContext(16, RoundingMode.HALF_UP);
	
	/**
     * Trunca um java.math.BigDecimal na qtd de casas decimais informada
     *
     * <br/>
     * <table border>
     * <caption top><h3>BigDecimal valor = new BigDecimal("3.017656250000090100019");</h3></caption>
     * <tr><th>Chamada</th><th>Valor Retornado</th></tr>
     * <tr><td>MathUtil.trunc(valor, 1);</td><td>3.0</td>
     * <tr><td>MathUtil.trunc(valor, 2);</td><td>3.01</td>
     * <tr><td>MathUtil.trunc(valor, 3);</td><td>3.017</td>
     * <tr><td>MathUtil.trunc(valor, 4);</td><td>3.0176</td>
     * <tr><td>MathUtil.trunc(valor, 5);</td><td>3.01765</td>
     * <tr><td>MathUtil.trunc(valor, 6);</td><td>3.017656</td>
     * <tr><td>MathUtil.trunc(valor, 7);</td><td>3.0176562</td>
     * <tr><td>MathUtil.trunc(valor, 8);</td><td>3.01765625</td>
     * <tr><td>MathUtil.trunc(valor, 9);</td><td>3.017656250</td>
     * <tr><td>MathUtil.trunc(valor, 10);</td><td>3.0176562500</td>
     * <tr><td>MathUtil.trunc(valor, 11);</td><td>3.01765625000</td>
     * <tr><td>MathUtil.trunc(valor, 12);</td><td>3.017656250000</td>
     * <tr><td>MathUtil.trunc(valor, 13);</td><td>3.0176562500000</td>
     * <tr><td>MathUtil.trunc(valor, 14);</td><td>3.01765625000009</td>
     * <tr><td>MathUtil.trunc(valor, 15);</td><td>3.017656250000090</td>
     * <tr><td>MathUtil.trunc(valor, 16);</td><td>3.0176562500000901</td>
     * <tr><td>MathUtil.trunc(valor, 17);</td><td>3.01765625000009010</td>
     * <tr><td>MathUtil.trunc(valor, 18);</td><td>3.017656250000090100</td>
     * <tr><td>MathUtil.trunc(valor, 19);</td><td>3.0176562500000901000</td>
     * <tr><td>MathUtil.trunc(valor, 20);</td><td>3.01765625000009010001</td>
     * <tr><td>MathUtil.trunc(valor, 21);</td><td>3.017656250000090100019</td>
     * <tr><td>MathUtil.trunc(valor, 22);</td><td>3.0176562500000901000190</td>
     * <tr><td>MathUtil.trunc(valor, 23);</td><td>3.01765625000009010001900</td>
     * </table>
     * <br/>
     * @param value - Valor a ser truncado
     * @param qtdCasasDecimais - Qtd de casas decimais a ser truncada - Default e 0
     * @return Retorna um java.math.BigDecimal truncado na qtd de casas informada
     * 
     * */
    public static BigDecimal trunc(BigDecimal value, Integer qtdCasasDecimais) {
        if (isNull(qtdCasasDecimais)){
            qtdCasasDecimais = 0;
        }               
        return value.setScale(qtdCasasDecimais, BigDecimal.ROUND_DOWN);
    }

    /**
     * Trunca um java.lang.String representando um numero na qtd de casas decimais informada
     *
     * @param value - Valor a ser truncado
     * @param qtdCasasDecimais - Qtd de casas decimais a ser truncada - Default e 2
     * @return Retorna um java.math.BigDecimal truncado na qtd de casas informada
     * */
    public static BigDecimal trunc(String value, Integer qtdCasasDecimais) {
        return trunc(new BigDecimal(value), qtdCasasDecimais);
    }

    /**
     * @see http://download.oracle.com/javase/6/docs/api/java/math/BigDecimal.html#BigDecimal%28double%29
     */
    public static BigDecimal createBigDecimal(Double value) {
    	return isNull(value) ? createZeroBigDecimal() : createBigDecimal(value.toString());
    }

    public static BigDecimal createBigDecimal(String value) {
    	return isNull(value) ? createZeroBigDecimal() : new BigDecimal(value);
    }
    
    public static BigDecimal createBigDecimal(Integer value) {
		return isNull(value) ? createZeroBigDecimal() : new BigDecimal(value);
	}
    
    private static BigDecimal createZeroBigDecimal(){
    	return BigDecimal.ZERO;
    }
    
    /**
     * <pre>
     * MathContext mathContext = MathUtil.getDefaultMathContext();
     * BigDecimal divisor = MathUtil.createBigDecimal("100");
     * BigDecimal vlResidual = vlAtualAcumulado.divide(divisor, mathContext).multiply(nValorResidual);
     * </pre>
     * */
    public static MathContext getDefaultMathContext(){
    	return mathContext;
    }
    
    public static String convertVirgulaEmPonto(String value){
		return isNull(value) ? null : value.replace(",", ".");
		
	}
	
	public static String convertPontoEmVirgual(String value){
		return isNull(value) ? null : value.replace(".", ",");
	}
	
	/**
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 * 
	 * <p>Verifica se o número informado possue parte <b>decimal/fracionária</b></p>
	 * */
	public static boolean hasFractionDigits(double number){
		long integerPart = (long) number;
		return (number - integerPart) > 0;
	}
	
	/**
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 * 
	 * <p>Checa se o valor passada é um valor infinito ou NaN</p>
	 * 
	 * @see java.lang.Double.isInfinite(double)
	 * @see java.lang.Double.isNaN(double)
	 * 
	 * @throws java.lang.IllegalArgumentException.IllegalArgumentException(String)
	 * */
	public static boolean isInfiniteOrNaN(Double value){
		if (isNull(value)){
			throw new IllegalArgumentException("value is null");
		}
		return Double.isInfinite(value) || Double.isNaN(value);
	}
	
	/**
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 * */
	public static Double max(Double value01, Double value02){
		Double aux01 = isNull(value01) ? 0 : value01;
		Double aux02 = isNull(value02) ? 0 : value02;
		return Math.max(aux01, aux02);
	}
	
	/**
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 * 
	 * @param value - Valor a ser arredondado
	 * @param qtdCasas - Qtd de Casas utilizada no arredondamento
	 * @param roundUp - <code>true</code> para arredondar para cima, <code>false</code> para arredondar para baixo
	 * 
	 * @throws IllegalArgumentException - value is null
	 * */
	public static Double round(BigDecimal value, int qtdCasas, boolean roundUp){
		if (isNull(value)){
			throw new IllegalArgumentException("value is null");
		}
		
		int roundMode = (roundUp) ? BigDecimal.ROUND_UP : BigDecimal.ROUND_DOWN;
		return value.setScale(qtdCasas, roundMode).doubleValue();
	}
	
	/**
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 * 
	 * <p>Arredonda para cima na Qtd de Casas informada</p>
	 * 
	 * @param value - Valor a ser arredondado
	 * @param qtdCasas - Qtd de Casas utilizada no arredondamento 
	 * 
	 * @throws IllegalArgumentException - value is null
	 * */
	public static Double round(BigDecimal value, int qtdCasas){
		return round(value, qtdCasas, true);
	}
}
