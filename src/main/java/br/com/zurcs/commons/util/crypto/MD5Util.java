package br.com.zurcs.commons.util.crypto;

import static br.com.zurcs.commons.util.validators.IsNullUtil.isNullOrEmpty;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
 * */
public abstract class MD5Util {
	
	private MD5Util() {
		throw new IllegalStateException("Class Not Instantiable");
	}
	
	/**
	 * Retorna o valor informado cifrado em MD5
	 * */
	public static String cifrar(String value){
		if (isNullOrEmpty(value)){
			throw new IllegalArgumentException("value is required!");
		}
		
		return DigestUtils.md5Hex(value);
	}
	
}
