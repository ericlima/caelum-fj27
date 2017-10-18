package br.com.casadocodigo.loja.conf;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeraSenha {

	public static void main(String[] args) {

		BCryptPasswordEncoder encripta = new BCryptPasswordEncoder();
		
		String encodada = encripta.encode("123456");
		
		System.out.println(encodada);
		
		if ( encripta.matches("123456", encodada) ) {
			System.out.println("as senhas coincidem");
		}
		
	}

}
