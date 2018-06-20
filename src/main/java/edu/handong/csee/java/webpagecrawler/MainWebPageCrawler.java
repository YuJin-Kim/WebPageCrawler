package edu.handong.csee.java.webpagecrawler;

import java.net.URL;

public class MainWebPageCrawler {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cli cli = new Cli();
		UrlReader reader = new UrlReader();
		
		String path, url;
		
		cli.run(args);
		path = cli.path;
		url = cli.url;
		
		try {
			reader.readUrl(url, path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
