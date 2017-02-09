package br.com.zurcs.commons.util.hardware;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import br.com.zurcs.commons.util.validators.IsNullUtil;

public class HardwareUtils {

	/**
	 * Retorna o nome do Sistema Operacional
	 * 
	 * @return
	 */
	public static String getNameOS() {

		String nameOS = "os.name";
		return System.getProperty(nameOS);
	}

	/**
	 * Retorna a versão do Sistema operacional
	 * 
	 * @return
	 */
	public static String getOsVersion() {

		String versionOS = "os.version";
		return System.getProperty(versionOS);
	}

	/**
	 * Retorna a arquitetura do Sistema operacional
	 * 
	 * @return
	 */
	public static String getOsArchtecture() {

		String architectureOS = "os.arch";
		return System.getProperty(architectureOS);
	}

	/**
	 * Retorna o número de processadores disponíveis
	 * 
	 * @return
	 */
	public static int getAvailableProcessors() {

		return Runtime.getRuntime().availableProcessors();
	}

	/**
	 * Total amount of free memory available to the JVM
	 * 
	 * @return
	 */
	public static long getFreeMemory() {

		return Runtime.getRuntime().freeMemory();
	}

	/**
	 * This will return Long.MAX_VALUE if there is no preset limit
	 * 
	 * @return
	 */
	public static long getMaxMemory() {

		return Runtime.getRuntime().maxMemory();
	}

	/**
	 * Total memory available to JVM (bytes)
	 * 
	 * @return
	 */
	public static long getTotalMemory() {

		return Runtime.getRuntime().totalMemory();
	}

	public static Map<String, File> getFileRoots() {

		Map<String, File> retorno = new HashMap<String, File>();
		/* Get a list of all filesystem roots on this system */
		File[] roots = File.listRoots();

		if (!IsNullUtil.isNotNull(roots)) {

			/* For each filesystem root, print some info */
			for (File root : roots) {
				retorno.put(root.getAbsolutePath(), root);

			}
		}

		return retorno;
	}

	public static void main(String[] args) {

		/* Get a list of all filesystem roots on this system */
		File[] roots = File.listRoots();

		/* For each filesystem root, print some info */
		for (File root : roots) {
			System.out.println("File system root: " + root.getAbsolutePath());
			System.out.println("Total space (bytes): " + root.getTotalSpace());
			System.out.println("Free space (bytes): " + root.getFreeSpace());
			System.out.println("Usable space (bytes): " + root.getUsableSpace());
		}
	}
}
