package Tchat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Receiver extends Thread {

		MulticastSocket socket;
		DatagramPacket packet;
		
		public Receiver(InetAddress address,int port) throws IOException {
			super();
			
			this.socket = new MulticastSocket(port);
			this.packet = new DatagramPacket(new byte[512],512);
			
			this.socket.joinGroup(address);
		}
		
		public void run() {
			
			try {
				this.socket.receive(this.packet);
			} 
			catch (IOException e) {
				System.out.println("Sorry, you cannot receive anything for the moment");
			}

			
			String message = new String(this.packet.getData());
			System.out.println(message);
		}
		
		public void close() {
			this.socket.close();
		}
		
}
