package cam.gmail.t.bisyk;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client implements Runnable {

	private Socket socket;
	private Thread thr;

	public Client(Socket soc) {
		super();
		this.socket = soc;
		thr = new Thread(this);
		thr.start();
	}

	@Override
	public void run() {
		try (InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream(); PrintWriter pw = new PrintWriter(os)) {
			byte[] bt = new byte[is.available()];
			is.read(bt);
			String sh = "HTTP/1.1 200 OK\r\n"+"Server: My_Server\r\n"+"Content-Type:text/html\r\n"+"Content-Length: "+
			"\r\n"+"Connection: close\r\n\r\n";
			pw.println(sh);
			pw.println(Runtime.getRuntime().totalMemory());
			pw.println(Runtime.getRuntime().availableProcessors());
			pw.print(Runtime.getRuntime().freeMemory());
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
