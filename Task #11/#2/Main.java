package cam.gmail.t.bisyk;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

	public static void main(String[] args) {
		try (ServerSocket serverSocket = new ServerSocket(4005)) {
			System.out.println("Server is run.");
			for (;;) {
				Socket soc = serverSocket.accept();
				Client client = new Client(soc);
				client.run();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
