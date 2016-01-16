package Tchat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Sender {

	MulticastSocket socket;
	DatagramPacket packet;
	InetAddress address;

	public Sender(String address) throws IOException {
		super();

		this.socket = new MulticastSocket();
		this.address = InetAddress.getByName(address);
	}

	public void send(String message, int port) {

		byte[] tmp = message.getBytes();
		this.packet = new DatagramPacket(tmp, tmp.length, this.address, port);

		try {
			this.socket.send(this.packet);
		} catch (IOException e) {
			System.out.println("Sorry , you cannot send things");
		}
	}

	public void close() {
		this.socket.close();
	}
}
