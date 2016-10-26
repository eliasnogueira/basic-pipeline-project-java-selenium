package com.eliasnogueira.quickloja;

public class Teste {

	public static void main(String[] args) throws Exception {
		System.out.println(System.getProperty("os.name"));

		String so = GetOS.getOS();
		String exe = "";
		if (so.equals("win"))  {
			exe = ".exe";
		}
		System.out.println("drivers/" + so + "/geckodriver" + exe);
	}

}
