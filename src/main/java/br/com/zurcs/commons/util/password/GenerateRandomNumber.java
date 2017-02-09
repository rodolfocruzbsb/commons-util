package br.com.zurcs.commons.util.password;

import java.util.Random;

/**
 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
 * */
public class GenerateRandomNumber {
	
	private GenerateRandomNumber() {
		throw new IllegalStateException("Class Not Instantiable");
	}
	
	public static synchronized int nextInt(){
		return Math.abs(new Random().nextInt());
	}
	
	public static synchronized long nextLong(){
		return Math.abs(new Random().nextLong());
	}
	
	public static synchronized long nextNegativeLong(){
        return nextLong() * -1;
    }
	
	public static synchronized long nextNegativeInt(){
        return nextInt() * -1;
    }
}
