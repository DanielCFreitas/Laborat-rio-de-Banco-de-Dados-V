package br.gov.sp.fatec.service;

import org.springframework.stereotype.Service;

@Service("validaCampos")
public class ValidaCamposImpl implements ValidaCampos {

	/**
	 * Valida campo numero de parcelas, compras devem ser parceladas entre 1 e
	 * 12
	 * 
	 * @return
	 */
	public boolean validaNumeroDeParcelas(Integer numeroParcelas) {
		if (numeroParcelas < 1 || numeroParcelas > 12) {
			return false;
		}
		return true;
	}
}
