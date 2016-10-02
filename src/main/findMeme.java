package main;
import java.io.IOException;
import org.jsoup.select.*;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class findMeme{
	static Document page;
	static String definition;
	
	public static boolean memeExist(String url) throws IOException{
		Element elt;
		try {
			page = Jsoup.connect(url).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		elt = page.select("h3.closed").first();
		if (elt == null){
			System.out.println("true");
			return true;
		}
		else{
			System.out.println("false");
			return false;
		}
	}
	
	public static String findMeme(String url, String keyword){
		try {
			page = Jsoup.connect(url).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Elements tags = page.select("[name=description]");
		Element description = tags.first();
		definition = description.attr("content");
		return definition;
	}
	
	public static String getLink(String keyword, String url){
		try {
			page = Jsoup.connect(url).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(url);
		String link = "http://knowyourmeme.com";
		Element linkE = page.select("a[class=\"photo\"]").first();
		link = link.concat(linkE.attr("href"));
		return link;
		
	}
	
}
