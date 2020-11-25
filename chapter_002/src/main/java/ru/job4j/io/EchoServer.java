package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

	public static void main(String[] args) {
		try (ServerSocket server = new ServerSocket(9000)) {
			boolean exit = false;
			while (!exit) {
				Socket socket = server.accept();
				try (OutputStream out = socket.getOutputStream();
						BufferedReader in = new BufferedReader(
								new InputStreamReader(socket.getInputStream()))) {

					String str = in.readLine();
					String msg = "What";

					while (!str.isEmpty()) {
						if (str.contains("?msg=Exit")) {
							exit = true;
							msg = "Goodbye";
						} else if (str.contains("?msg=Hello")) {
							msg = "Hello";
						}
						System.out.println(str);
						str = in.readLine();
					}
					out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
					out.write(msg.getBytes());
				}
			}
		} catch (IOException e) {
			LOG.error("Exception in log example", e);
		}
	}
}
