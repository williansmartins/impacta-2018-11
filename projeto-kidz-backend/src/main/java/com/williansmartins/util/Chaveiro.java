package com.williansmartins.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Chaveiro {
	
	@Autowired
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	public boolean ehIgual(String chave1, String chave2) {
		return chave1 == chave2;
	}
	
	public boolean ehIgualCriptografado(String chave1, String chave2) {
		return passwordEncoder.matches(chave1, chave2);
	}
	
	public String pegarChave(String chave){
		return passwordEncoder.encode(chave);
	}
	
	public static void main(String[] args) {
		System.out.println(new Chaveiro().pegarChave("nova"));
	}
}
