package br.com.zurcs.commons.util.password;

/**
 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
 * */
public class GeneratePassword {
	
	private static final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	private GeneratePassword() {
		throw new IllegalStateException("Class Not Instantiable");
	}

	public static String getAleatoryPassword() {
		StringBuilder newPassword = new StringBuilder();
		int random;
		for (int i = 1; i < 6; i++) {
			newPassword.append((int) (Math.random() * 10));
		}
		for (int i = 0; i < 1; i++) {
			random = (int) (Math.random() * 25);
			if (random == 0) {
				random = 1;
			}
			newPassword.append(CHARS.substring(random - 1, random));
		}
		return newPassword.toString();
	}
}
