package br.com.zurcs.commons.util.file;

import static br.com.zurcs.commons.util.validators.IsNullUtil.isNullOrEmpty;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.zurcs.commons.util.date.DateUtil;

public class FileUtil {

	private static Logger logger = LogManager.getLogger(FileUtil.class);

	/**
	 * 
	 * <p>
	 * Recupera arquivo a partir do Resource Name dentro do classloader
	 * </p>
	 * 
	 * @param url
	 * @param classLoader
	 * @return
	 * 
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 */
	public static File getFileFromResourceName(String url, ClassLoader classLoader) {

		if (isNullOrEmpty(url)) {
			return null;
		}

		InputStream inputStream = null;
		OutputStream outputStream = null;
		File fileDynaQuery = null;
		try {
			// Lê recurso para um InputStream
			inputStream = classLoader.getResourceAsStream(url);

			// Escreve o inputStream para um FileOutputStream
			fileDynaQuery = File.createTempFile("infra-file-", null);
			outputStream = new FileOutputStream(fileDynaQuery);

			FileUtils.copyInputStreamToFile(inputStream, fileDynaQuery);

		} catch (IOException e) {
			logger.error("Erro ao recuperar recurso.", e);
		} finally {
			if (!isNullOrEmpty(inputStream)) {
				try {
					inputStream.close();
				} catch (IOException e) {
					logger.error("Erro ao fechar inputStream.", e);
				}
			}
			if (!isNullOrEmpty(outputStream)) {
				try {
					outputStream.close();
				} catch (IOException e) {
					logger.error("Erro ao fechar outputStream.", e);
				}

			}
		}
		return fileDynaQuery;
	}

	public static File getFileFromResourceName(String url, Class<?> clazz) {

		if (isNullOrEmpty(url)) {
			return null;
		}

		InputStream inputStream = null;
		OutputStream outputStream = null;
		File fileDynaQuery = null;
		try {
			// Lê recurso para um InputStream
			inputStream = clazz.getResourceAsStream(url);

			// Escreve o inputStream para um FileOutputStream
			fileDynaQuery = File.createTempFile("infra-file-", null);
			outputStream = new FileOutputStream(fileDynaQuery);

			FileUtils.copyInputStreamToFile(inputStream, fileDynaQuery);

		} catch (IOException e) {
			logger.error("Erro ao recuperar recurso.", e);
		} finally {
			if (!isNullOrEmpty(inputStream)) {
				try {
					inputStream.close();
				} catch (IOException e) {
					logger.error("Erro ao fechar inputStream.", e);
				}
			}
			if (!isNullOrEmpty(outputStream)) {
				try {
					outputStream.close();
				} catch (IOException e) {
					logger.error("Erro ao fechar outputStream.", e);
				}

			}
		}
		return fileDynaQuery;
	}

	public static File getFileFromResourceName(String url, Class<?> clazz, String fileName) {

		if (isNullOrEmpty(url)) {
			return null;
		}

		InputStream inputStream = null;
		OutputStream outputStream = null;
		File fileDynaQuery = null;
		try {
			// Lê recurso para um InputStream
			inputStream = clazz.getResourceAsStream(url);

			// Escreve o inputStream para um FileOutputStream
			fileDynaQuery = new File(fileName);
			outputStream = new FileOutputStream(fileDynaQuery);

			FileUtils.copyInputStreamToFile(inputStream, fileDynaQuery);

		} catch (IOException e) {
			logger.error("Erro ao recuperar recurso.", e);
		} finally {
			if (!isNullOrEmpty(inputStream)) {
				try {
					inputStream.close();
				} catch (IOException e) {
					logger.error("Erro ao fechar inputStream.", e);
				}
			}
			if (!isNullOrEmpty(outputStream)) {
				try {
					outputStream.close();
				} catch (IOException e) {
					logger.error("Erro ao fechar outputStream.", e);
				}

			}
		}
		return fileDynaQuery;
	}

	public static String generateFileName(String prefix, String name, String posfix) {

		if (isNullOrEmpty(prefix)) {
			prefix = RandomStringUtils.randomAlphanumeric(16);
		}

		if (isNullOrEmpty(name)) {
			name = DateUtil.getDateStr(DateUtil.getDateNow(), "yyyyMMdd_HHmmss_S");
		}

		if (isNullOrEmpty(posfix)) {
			posfix = DateUtil.getDateStr(DateUtil.getDateNow(), "yyyyMMdd_HHmmss_S");
		}

		StringBuilder result = new StringBuilder();

		result.append(prefix).append("_");

		if (!isNullOrEmpty(name)) {
			result.append(name).append("_");
		}

		result.append(posfix);

		return result.toString();
	}

}
