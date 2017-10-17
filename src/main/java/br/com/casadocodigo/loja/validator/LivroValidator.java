package br.com.casadocodigo.loja.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.casadocodigo.models.Livro;

public class LivroValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Livro.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		
		System.out.println(1);
		
		ValidationUtils.rejectIfEmpty(arg1, "titulo", "required");
		System.out.println(2);
		Livro l = (Livro)arg0;
		
		if (l.getPaginas() < 2) {
			arg1.reject("paginas","paginas.min");
		}

	}

}
