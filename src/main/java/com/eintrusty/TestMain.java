package com.eintrusty;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//LocalDateTime currentTime = LocalDateTime.now();
		Date date = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
		SimpleDateFormat sdf = new SimpleDateFormat("YYMM");
		String uiid = sdf.format(date);
		String v = "EC"+uiid;
		String v2 = v.substring(v.indexOf("C") + 1);
		System.out.println(v2);

	}

}
