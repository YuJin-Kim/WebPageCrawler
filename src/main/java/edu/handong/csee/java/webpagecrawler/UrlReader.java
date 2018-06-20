package edu.handong.csee.java.webpagecrawler;

import java.net.*;
import java.io.*;

public class UrlReader {

	public void readUrl(String url, String path) throws Exception {
		URL oracle = new URL(url);
		FileWriter file = new FileWriter(path, true);

		BufferedWriter bufferedWriter = new BufferedWriter(file);

		String inputLine;

		BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));


		while ((inputLine = in.readLine()) != null)
			bufferedWriter.write(inputLine);
		bufferedWriter.close();

		in.close();

	}
}
