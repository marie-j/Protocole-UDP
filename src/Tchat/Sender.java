package Tchat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Sender extends Thread {
	
	MulticastSocket socket;
	DatagramPacket packet;
	
	public Sender(InetAddress address) throws IOException {
		super();
		
		this.socket = new MulticastSocket();
		
	}

	public void send(String message, int port) {
		
		byte[] tmp = message.getBytes();
		this.packet = new DatagramPacket(tmp,tmp.length,this.socket.getInetAddress(),port);
		
		try {
			this.socket.send(this.packet);
		} 
		catch (IOException e) {
			System.out.println("Sorry , you cannot send things");
		}
	}
	
	public void close() {
		this.socket.close();
	}
}
