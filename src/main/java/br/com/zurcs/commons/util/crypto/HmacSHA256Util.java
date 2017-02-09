package br.com.zurcs.commons.util.crypto;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HmacSHA256Util {
	
	private HmacSHA256Util() {
		throw new IllegalStateException("Class Not Instantiable");
	}

	public static String cipher(String plainText, String keyString) {
		String result = null;
		
		try {
			SecretKeySpec key = new SecretKeySpec((keyString).getBytes("UTF-8"), "HmacSHA256");
			Mac mac = Mac.getInstance("HmacSHA256");
			mac.init(key);

			byte[] bytes = mac.doFinal(plainText.getBytes("ASCII"));

			StringBuffer hash = new StringBuffer();
			for (int i = 0; i < bytes.length; i++) {
				String hex = Integer.toHexString(0xFF & bytes[i]);
				if (hex.length() == 1) {
					hash.append('0');
				}
				hash.append(hex);
			}
			result = hash.toString();
		} catch (UnsupportedEncodingException ignored) {
			
		} catch (InvalidKeyException ignored) {
			
		} catch (NoSuchAlgorithmException ignored) {
			
		}
		return result;
	}
}
