package br.com.zurcs.commons.util.crypto;

import static br.com.zurcs.commons.util.validators.IsNullUtil.isNullOrEmpty;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
 */
public class SHAUtil {

	private SHAUtil() {
		throw new IllegalStateException("Class Not Instantiable");
	}

	public static String cifrarSHA256Hex(String value) {

		if (isNullOrEmpty(value)) {
			throw new IllegalArgumentException("value is required!");
		}
		return new String(DigestUtils.sha256Hex(value.getBytes()));
	}

	public static String cifrarSHA1Hex(String value) {

		if (isNullOrEmpty(value)) {
			throw new IllegalArgumentException("value is required!");
		}
		return new String(DigestUtils.sha1Hex(value.getBytes()));
	}

}
