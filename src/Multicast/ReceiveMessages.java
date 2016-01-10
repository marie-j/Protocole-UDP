package Multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ReceiveMessages {
	
	public static void main(String[] arg) throws IOException {
		
		int port = 7654;
		InetAddress address = InetAddress.getByName("244.0.0.1");
		MulticastSocket socket = new MulticastSocket(port);
		socket.joinGroup(address);
		
		DatagramPacket packet = new DatagramPacket(new byte[1024],1024);
		socket.receive(packet);
			
		String tmp = new String(packet.getData());
		System.out.println(tmp);
		socket.close();
		
	}
}
