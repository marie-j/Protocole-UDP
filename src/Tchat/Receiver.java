package Tchat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.util.concurrent.atomic.AtomicBoolean;

public class Receiver extends Thread {

	MulticastSocket socket;
	DatagramPacket packet;
	AtomicBoolean run;

	public Receiver(InetAddress address, int port, AtomicBoolean run) throws IOException {
		super();

		this.socket = new MulticastSocket(port);
		this.packet = new DatagramPacket(new byte[512], 512);

		this.socket.joinGroup(address);
		this.run = run;
	}

	public void run() {
		
		while (run.get()){

			try {
				this.socket.receive(this.packet);
			} catch (IOException e) {
				System.out
						.println("Sorry, you cannot receive anything for the moment");
			}
	
			String message = new String(this.packet.getData());
	
			InetSocketAddress userAddress = (InetSocketAddress) this.packet
					.getSocketAddress();
			String user = userAddress.getHostName();
	
			System.out.println(user + " : " + message);
			
			this.packet.setData(new byte[512]);
		}
		
		this.close();
	}

	public void close() {
		this.socket.close();
		System.out.println("Fermeture du canal de reception");
	}

}
