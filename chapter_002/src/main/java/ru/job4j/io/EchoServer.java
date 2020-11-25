package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	public static void main(String[] args) throws IOException {
		try (ServerSocket server = new ServerSocket(9000)) {
			boolean exit = false;
			while (!exit) {
				Socket socket = server.accept();
				try (OutputStream out = socket.getOutputStream();
						BufferedReader in = new BufferedReader(
								new InputStreamReader(socket.getInputStream()))) {
					String str;
					String msg = "What";
					while (!(str = in.readLine()).isEmpty()) {
						if (str.contains("?msg=Exit")) {
							exit = true;
							msg = "Goodbye";
						} else if (str.contains("?msg=Hello")) {
							msg = "Hello";
						}
						System.out.println(str);
					}
					out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
					out.write(msg.getBytes());
				}
			}
		}
	}
}
