package com.eliasnogueira.quickloja;

public class GetOS {

	private static String OS = System.getProperty("os.name").toLowerCase();

	public static String getOS() throws Exception {

		String retorno = null;

		if (isWindows()) {
			retorno = "win";
		} else if (isMac()) {
			retorno = "mac";
		} else if (isUnix()) {
			retorno = "linux";
		} else {
			throw new Exception("Sistema operacional [" + OS + "]nao suportado!");
		}
		
		return retorno;
	}

	private static boolean isWindows() {
		return (OS.indexOf("win") >= 0);
	}

	private static boolean isMac() {
		return (OS.indexOf("mac") >= 0);
	}

	private static boolean isUnix() {
		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
	}
	
}
