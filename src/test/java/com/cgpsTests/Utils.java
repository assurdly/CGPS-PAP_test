package com.cgpsTests;

import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.CSVWriter;

public class Utils {

		// TODO Auto-generated method stub
	public static String email;

		public  void write() throws IOException	{
		email = randomString(5);
		//Instantiating the CSVWriter class
	      CSVWriter writer = new CSVWriter(new FileWriter(System.getProperty("user.dir")+"/src/cgps/output.csv"));
	      //Writing data to a csv file
	      String line1[] = {"Firstname","Lastname","Date of Birth","Phone number","Email Address","Street Number","Street Name","City","State","Country","Parent ID"};
	      String line2[] = {email,"Raw", "10/10/1990","7060591341",email+"@vomoto.com","12345","Bethel","Lagos","Lagos","Nigeria","8012"};
	      
	      //Writing data to the csv file
	      writer.writeNext(line1);
	      writer.writeNext(line2);
	      //Flushing data from writer to file
	      writer.flush();
	      System.out.println("Data entered with email: "+email);
	}

	public  String randomString(int n)	{
		// chose a Character random from this String
		String AlphaString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {
			// generate a random number between
			// 0 to AlphaString variable length
			int index = (int)(AlphaString.length() * Math.random());

			// add Character one by one in end of sb
			sb.append(AlphaString.charAt(index));
		}
		return sb.toString();
	}
}


