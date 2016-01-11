package Tchat;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Tchat {
	

	public static void main(String[] args) {
		
		InetAddress address = null;
		Receiver receiver = null;
		Sender sender = null;
		
		try {
			address = InetAddress.getByName(args[0]);
		} 
		catch (UnknownHostException e) {
			System.out.println("This address is not correct, please try again with another one");
		}
		
		int port = Integer.parseInt(args[1]);
		
		
		try {
			receiver = new Receiver(address,port);
		} 
		catch (IOException e) {
			System.out.println("Sorry , you cannot receive messages");
		}
		
		try {
			sender = new Sender(address);
		}
		catch (IOException e) {
			System.out.println("Sorry, you cannot send messages");
		}
		
		Scanner scanner = new Scanner(System.in);
		String message = scanner.nextLine();
		
		receiver.start();
		while (!message.equals("echap")) {
			sender.send(message,port);
			message = scanner.nextLine();
		}
		
		scanner.close();
		receiver.close();
		sender.close();
		
	}

}
