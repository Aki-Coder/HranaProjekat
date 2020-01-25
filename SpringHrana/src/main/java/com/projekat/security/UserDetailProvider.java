package com.projekat.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.projekat.repository.KorisnikRepository;

import model.Korisnik;

@Service("customUserDetail")
public class UserDetailProvider implements UserDetailsService {
	@Autowired
	KorisnikRepository kr;
	
	@Autowired
	HttpServletRequest sr;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Korisnik k = kr.findByUsername(username);
		if (k != null) {
			CustomUserDetail ud = new CustomUserDetail();
			ud.setKorisnickoIme(k.getUsername());
			ud.setSifra(k.getPassword());
			ud.setU(k.getUloga());
			
			sr.getSession().setAttribute("korisnik", k);
			return ud;
		}
		
		return null;
	}
}
