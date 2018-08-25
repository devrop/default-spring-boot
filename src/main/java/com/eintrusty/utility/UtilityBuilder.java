package com.eintrusty.utility;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class UtilityBuilder {
	
	public static String notNull(String s) {
		if(s !=null) {
			return s.trim();
		}
		return "";
	}
	public static String sorroundPercent(String s) {
		if(s !=null) {
			
			return "%"+s.trim()+"%";
		}
		return "%%";
		
	}
	public static Date getLocalDate() {
		try{
			Date date = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
		 return date;
		}catch (Exception e) {
			
			return null;
		}
	}

}
