package br.com.zurcs.commons.util.crypto;

import org.apache.commons.codec.binary.Base64;

import static br.com.zurcs.commons.util.validators.IsNullUtil.isNullOrEmpty;

/**
 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
 * */
public class Base64Util {
	
	private Base64Util() {
		throw new IllegalStateException("Class Not Instantiable");
	}
	
	/**
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 * 
	 * <p>Codifica o valor passado para a Base 64</p>
	 * 
	 * @param value - PlainText
	 * */
	public static String encode(String value){
		if (isNullOrEmpty(value)){
			throw new IllegalArgumentException("value is null for Base 64 encode");
		}
		
		byte[] encoded = Base64.encodeBase64(value.getBytes());
		return new String(encoded);
	}
	
	/**
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 * 
	 * <p>Decodifica o valor passado em Base 64 para plainText</p>
	 * 
	 * @param value - Based 64 value
	 * */
	public static String decode(String value){
		if (isNullOrEmpty(value)){
			throw new IllegalArgumentException("value is null for Base 64 decode");
		}		
		byte[] decoded = Base64.decodeBase64(value.getBytes());
		return new String(decoded);
	}
}
