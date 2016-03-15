package org.j2gl.sockets.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private static final Logger log = LoggerFactory.getLogger(Client.class);
    private static final int PORT = 7081;
    private static final String HOST = "localhost";

    private BufferedReader socketIn;
    private PrintWriter socketOut;

    public String receiveData(BufferedReader socketIn) throws IOException {
        String data = socketIn.readLine();
        log.info("Response from server: {}", data);
        return data;
    }

    public void connect() throws IOException {
        Socket socket = new Socket(HOST, PORT);

        socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        socketOut = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        receiveData(socketIn);
        String line;
        String response;
        boolean keepRunning = true;
        while (keepRunning) {
            line = in.readLine();
            socketOut.println(line);
            response = receiveData(socketIn);
            if (response == null || response.equalsIgnoreCase("Bye")) {
                keepRunning = false;
            }
        }
    }

    public static void main(String args[]) {
        Client client = new Client();
        try {
            client.connect();
        } catch (IOException e) {
            log.error("Error running client.", e);
        }
    }
}
