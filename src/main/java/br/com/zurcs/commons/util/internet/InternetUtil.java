package br.com.zurcs.commons.util.internet;

import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

/**
 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
 * */
public class InternetUtil {
	
	public static final String HTTP_METHOD_HEAD = "HEAD";
	
	private InternetUtil() {
		throw new IllegalStateException("Class Not Instantiable");
	}

	public static String getHostName(){
		String result = null;
		
		try {
			InetAddress addr = InetAddress.getLocalHost();
			result = addr.getHostName();
		} catch (UnknownHostException ignore) {
			result = ignore.getMessage();
		}
			
		return result;
	}
	
	/**
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 * 
	 * <p>Verifica se existe conexão com a Internet</p>
	 * @param url - Url a ser verificada. Ex: <code>http://www.google.com.br</code>
	 * */
	public static boolean temConexaoInternet(String url){
        try {
        	HttpURLConnection urlConnection = (HttpURLConnection) new URL(url).openConnection(); 
        	urlConnection.setRequestMethod(HTTP_METHOD_HEAD);
        	urlConnection.setConnectTimeout(3000);
        	urlConnection.setReadTimeout(3000); 
            return (urlConnection.getResponseCode() != -1);
        } catch (Exception e) {
            return false;
        }
	}
}
