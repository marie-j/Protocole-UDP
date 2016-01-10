package UDP;
import java.net.*;
import java.io.*;

public class ReceiveUDP {

	public static void main(String[] arg) throws IOException {
		
		int port = Integer.parseInt(arg[0]);
		DatagramSocket socket = new DatagramSocket(port);

		DatagramPacket packet = new DatagramPacket(new byte[1024],1024);
		socket.receive(packet);
			
		String tmp = new String(packet.getData());
		System.out.println(tmp);
		socket.close();
		
	}
}
