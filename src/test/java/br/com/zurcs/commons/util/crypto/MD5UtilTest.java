package br.com.zurcs.commons.util.crypto;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

import org.junit.Test;

public class MD5UtilTest {
	
	@Test
	public void deve_retornar_32_digitos() {
		
		assertThat(MD5Util.cifrar("123").length(), equalTo(32));
	}

	@Test
	public void deve_retornar_hash_123() {
		
		assertThat(MD5Util.cifrar("123"), equalTo("202cb962ac59075b964b07152d234b70"));
	}
}
