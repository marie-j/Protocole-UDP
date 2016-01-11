package UDP;

import java.io.IOException;
import java.net.*;

public class SendUDP {
	
	public static void main(String[] args) throws IOException  {
		
		InetAddress destination = null;
		try {
			destination = InetAddress.getByName(args[0]);
		} catch (UnknownHostException e) {
			System.out.println("Sorry, this address is not correct");
		}
		
		int port = Integer.parseInt(args[1]);
		byte[] msg = args[2].getBytes();
		
		DatagramPacket packet = new DatagramPacket(msg,msg.length,destination,port);
		DatagramSocket socket = new DatagramSocket();
		
		socket.send(packet);
		socket.close();
	}
}
