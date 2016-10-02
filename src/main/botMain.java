package main;
import java.io.IOException;

import org.jibble.pircbot.*;

public class botMain {

	public static void main(String[] args) {
		bot myBot = new bot();
		//findMeme finder = new findMeme
		
		//Enable debuggin output
		myBot.setVerbose(true);
		
		//Connect to the IRC server.
		try {
			myBot.connect("irc.chat.twitch.tv", 6667, "oauth:4peb3b6284890x1wg0omllyd8lu69m");
		} catch (NickAlreadyInUseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IrcException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		myBot.joinChannel("#shadybunny");
	}

}
