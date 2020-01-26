package com.projekat.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/reports")
public class IzvestajController {
	
	public static void main(String[] args) {
		 
        Date now = new Date();
 
       SimpleDateFormat simpleDateformat = new SimpleDateFormat("E"); // the day of the week abbreviated
       //System.out.println(simpleDateformat.format(now));
 
        simpleDateformat = new SimpleDateFormat("EEEE"); // the day of the week spelled out completely
        System.out.println(simpleDateformat.format(now));
 
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK)); // the day of the week in numerical format
 
    }
}

