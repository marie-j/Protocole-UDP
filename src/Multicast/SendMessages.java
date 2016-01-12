package Multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class SendMessages {

	public static void main(String[] args) throws IOException {

		InetAddress destination = InetAddress.getByName("224.0.0.1");
		int port = 7654;
		byte[] msg = args[0].getBytes();

		DatagramPacket packet = new DatagramPacket(msg, msg.length,
				destination, port);
		MulticastSocket socket = new MulticastSocket();

		socket.send(packet);
		socket.close();
	}
}
