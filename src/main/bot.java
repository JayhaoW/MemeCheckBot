package main;

import java.io.IOException;

import org.jibble.pircbot.*;

public class bot extends PircBot {
	public bot(){
		this.setName("memecheckbot");
	}
	
	public void sName(String name){
		this.setName(name);
	}
	
	public void onMessage(String channel, String sender, String login,
			String hostname, String message ){
		message = message.toLowerCase();
		if (message.contains("meme check")){
			message = message.substring(11);
			System.out.println(message);
			String segments[] = message.split(" ");
			System.out.println(segments.length);
			StringBuilder builder = new StringBuilder();

			for (String segment:segments) {
			    if (builder.length() > 0) {
			        builder.append(" ");
			    }
			    builder.append(segment);
			}
			
			String keyword = builder.toString();	
			keyword = keyword.replace(" ", "+");
			
			System.out.println("Keyword:" + keyword);
			boolean exists = false;
			try {
				exists = findMeme.memeExist("http://knowyourmeme.com/search?q=" + keyword);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			if(exists == false){
				sendMessage(channel, "Sorry, but there were no results for '"+ 
					keyword + "'");
			}
			if(exists == true){
				String url = "http://knowyourmeme.com/search?q=" + keyword;
				String memeURL = findMeme.getLink(keyword, url);
				System.out.println(memeURL);
				String definition = findMeme.findMeme(memeURL,
						keyword);
				sendMessage(channel, definition);
			}
		}
		
	}
}
