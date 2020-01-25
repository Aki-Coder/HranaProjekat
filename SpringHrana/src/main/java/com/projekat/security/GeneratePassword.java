package com.projekat.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeneratePassword {
	public static void main(String[] args) {

		String comi = "boki33";
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.println(passwordEncoder.encode(comi));
	}
}
