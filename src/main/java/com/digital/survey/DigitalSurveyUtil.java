package com.digital.survey;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalSurveyUtil {

	public static String getDate(Date theDate) {
		String pattern = "dd-M-yyyy hh:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(theDate);

	}
}
