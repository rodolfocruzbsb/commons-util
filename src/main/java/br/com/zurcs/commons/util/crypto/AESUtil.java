package br.com.zurcs.commons.util.crypto;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import br.com.zurcs.commons.util.validators.IsNullUtil;

/**
 * <p>
 * <b>Title:</b> AESUtil.java
 * </p>
 * 
 * <p>
 * <b>Description:</b> Classe utilitário para criptografar e descriptografar utilizando AES
 * </p>
 * 
 * <p>
 * <b>Company: </b> Rodolfo Cruz T.I.
 * </p>
 * 
 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
 * 
 * @version 1.0.0
 */
public abstract class AESUtil {

	private AESUtil() {
		throw new IllegalStateException("Class Not Instantiable");
	}

	/**
	 * Método responsável por Criptografar a mensagem
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @param message,
	 *            texto para ser criptografado
	 * @param key,
	 *            chave para criptografia
	 * @return
	 */
	public static String crypt(String strMessage, String strKey) {

		if (IsNullUtil.isNullOrEmptyParameters(strMessage, strKey)) {

			throw new IllegalArgumentException("strMessage and strKey is required!");
		}

		byte[] message = strMessage.getBytes();

		byte[] key = strKey.getBytes();

		return crypt(message, key);
	}

	public static String crypt(byte[] message, byte[] key) {

		String result = null;

		try {

			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

			cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, "AES"));

			byte[] encrypted = cipher.doFinal(message);

			result = new String(encrypted);

		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * Método responsável por Descriptografar a mensagem
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @param strEncrypted,
	 *            mensagem para ser decriptografada
	 * @param strKey,
	 *            chave para descriptografar
	 * @return
	 */
	public static String decrypt(String strEncrypted, String strKey) {

		if (IsNullUtil.isNullOrEmptyParameters(strEncrypted, strKey)) {

			throw new IllegalArgumentException("strEncrypted and strKey is required!");
		}

		byte[] encrypted = strEncrypted.getBytes();

		byte[] key = strKey.getBytes();

		return decrypt(encrypted, key);
	}

	/**
	 * Método responsável por
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @param encrypted,
	 *            mensagem em <code>byte[]</code> para ser decriptografada
	 * @param key,
	 *            chave para descriptografar
	 * @return
	 */
	public static String decrypt(byte[] encrypted, byte[] key) {

		String result = null;
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

			cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"));

			byte[] decrypted = cipher.doFinal(encrypted);

			result = new String(decrypted);

		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return result;
	}

}
