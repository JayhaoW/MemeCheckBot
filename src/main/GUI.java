package main;
import javax.swing.*;

import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;


public class GUI implements ActionListener{	
	private JFrame name;
	private JPanel panel;
	private JLabel label;
	private JTextField text;
	private JButton connectButton;
	private JButton disconnectButton;
	private MouseListener mouse;
	private MouseEvent clicking;
	public String channelName;
	private bot myBot;
	
	public GUI(){
		name = new JFrame("Meme Bot");
		name.setSize(350, 100);
		name.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		panel = new JPanel();
		name.add(panel);
		
		label = new JLabel("Channel");
		label.setBounds(10, 20, 80, 40);
		panel.add(label);
		
		text = new JTextField(20);
		text.setBounds(100, 20, 165, 40);
		panel.add(text);
		
		connectButton = new JButton("Connect Bot");
		connectButton.setBounds(10, 80, 80, 40);
		connectButton.addActionListener(this);
		panel.add(connectButton);
		
		disconnectButton = new JButton("Disconnect Bot");
		disconnectButton.setBounds(10, 80, 80, 40);
		disconnectButton.addActionListener(this);
		panel.add(disconnectButton);
		
		name.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("Connect Bot")){
			channelName = text.getText();
			myBot = new bot();
			//findMeme finder = new findMeme
			
			//Enable debuggin output
			myBot.setVerbose(true);
			
			//Connect to the IRC server.
			try {
				myBot.connect("irc.chat.twitch.tv", 6667, "oauth:4peb3b6284890x1wg0omllyd8lu69m");
			} catch (NickAlreadyInUseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IrcException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			myBot.joinChannel("#"+ channelName);
		}
		else{
			myBot.disconnect();
		}
	}
	
	public static void main(String[] args){
		GUI myBot = new GUI();
		
		
	}

}
