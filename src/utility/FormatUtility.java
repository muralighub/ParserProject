package utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;
import java.util.regex.Pattern;

public class FormatUtility {

	String resultformat;
	String resultformat1;
	String resultformat2;
	String resultformat3;

	SimpleDateFormat sdf1 = new SimpleDateFormat("E MMM dd yyyy HH:mm:ss z"); //input date is converted to output date
																				

	public String dateFormater(String date) {

		if (date.substring(0, 3).contains("-")) {

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMM-yy");

			try {
				Date inputDate = sdf.parse(date);
				resultformat = sdf1.format(inputDate);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (date.substring(0, 3).contains("/")) {

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMM/yy");

			try {
				Date inputDate = sdf.parse(date);
				resultformat = sdf1.format(inputDate);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yy");

			try {
				Date inputDate = sdf.parse(date);
				resultformat = sdf1.format(inputDate);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return resultformat;

	}

	public String dateFormaterOne(String date) {

		if (date.substring(0, 3).contains("-")) {

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");

			try {
				Date inputDate = sdf.parse(date);
				resultformat1 = sdf1.format(inputDate);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (date.substring(0, 3).contains("/")) {

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");

			try {
				Date inputDate = sdf.parse(date);
				resultformat1 = sdf1.format(inputDate);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("dd MM yy");

			// sdf1.setTimeZone(TimeZone.getTimeZone("GMT"));
			try {
				Date inputDate = sdf.parse(date);
				resultformat1 = sdf1.format(inputDate);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return resultformat1;

	}

	public String dateFormaterTwo(String date) {

		if (date.contains("-")) {

			SimpleDateFormat sdf = new SimpleDateFormat("MMMM-dd-yy");

			try {
				Date inputDate = sdf.parse(date);
				resultformat2 = sdf1.format(inputDate);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (date.contains("/")) {

			SimpleDateFormat sdf = new SimpleDateFormat("MMMM/dd/yy");

			try {
				Date inputDate = sdf.parse(date);
				resultformat2 = sdf1.format(inputDate);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd yy");

			try {
				Date inputDate = sdf.parse(date);
				resultformat2 = sdf1.format(inputDate);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return resultformat2;

	}

	public String dateFormaterThree(String date) {

		if (date.substring(0, 3).contains("-")) {

			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yy");

			try {
				Date inputDate = sdf.parse(date);
				resultformat3 = sdf1.format(inputDate);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (date.substring(0, 3).contains("/")) {

			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");

			try {
				Date inputDate = sdf.parse(date);
				resultformat3 = sdf1.format(inputDate);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("MM dd yy");

			try {
				Date inputDate = sdf.parse(date);
				resultformat3 = sdf1.format(inputDate);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return resultformat3;

	}

}
