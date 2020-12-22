package br.com.teste.utils;

import br.com.teste.model.Cep;

public class Utils {
	public static Boolean validCep(String cep) {
		if (cep.length() != 8) {
			return false;
		}

		if (cep == "00000000") {
			return false;
		}

		try {
			Integer.parseInt(cep);
		} catch (NumberFormatException e) {
			return false;
		}

		return true;

	}

	public static String alterCep(Cep endereco, String cep) {
		Boolean alter = true;
		String newCep = "";
		if (validCep(cep)) {
			if (endereco.getCep() == null) {
				StringBuffer sb = new StringBuffer(cep);
				sb.reverse();
				for (String character : (sb.toString().split(""))) {
					if (!character.equals("0") && alter) {
						newCep = newCep + "0";
						alter = false;
					} else {
						newCep = character + newCep;
					}
				}
				return newCep;
			}
			return cep;
		} else {
			return "00000000";
		}
	}

}
