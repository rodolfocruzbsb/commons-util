package br.com.zurcs.commons.util.thread;

public class ThreadUtil {

	public static boolean isThreadAlive(String name) {

		for (Thread t : Thread.getAllStackTraces().keySet()) {
			for (String n : name.split("[|]")) {
				if (t.getName().matches(n)) {
					return true;
				}
			}
		}
		return false;
	}

	public static void killThread(String name) {

		for (Thread t : Thread.getAllStackTraces().keySet()) {
			if (t.getName().equals(name)) {
				t.interrupt();
			}
		}
	}
}
