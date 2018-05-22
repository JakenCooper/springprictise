package com.jaken.sp.util;

import java.util.UUID;

public class CommonUtil {

	public static String getUUID(){
		UUID uuid=UUID.randomUUID();
		return uuid.toString();
	}
}

