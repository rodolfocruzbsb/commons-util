package br.com.zurcs.commons.util.xml;

import static br.com.zurcs.commons.util.validators.IsNullUtil.isNullOrEmpty;

/**
 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
 * */
public class XMLUtil {
	
	private XMLUtil() {
		throw new IllegalStateException("Class Not Instantiable");
	}

	public static boolean isValidCharacters(String value) {
		boolean result = true;
		char current;

		if (!isNullOrEmpty(value)) {
			for (int i = 0; i < value.length(); i++) {
				current = value.charAt(i);
				if ((current == 0x9) 
						|| (current == 0xA) 
						|| (current == 0xD)
						|| ((current >= 0x20) && (current <= 0xD7FF))
						|| ((current >= 0xE000) && (current <= 0xFFFD))
						|| ((current >= 0x10000) && (current <= 0x10FFFF))) {
				} else {
					result = false;
					break;
				}
			}
		}

		return result;
	}

}
