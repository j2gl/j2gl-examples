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

    public static void main(final String[] args) {
        final Client client = new Client();
        try {
            client.connect();
        } catch (IOException e) {
            log.error("Error running client.", e);
        }
    }

    private String receiveData(final BufferedReader socketIn) throws IOException {
        final String data = socketIn.readLine();
        log.info("Response from server: {}", data);
        return data;
    }

    private void connect() throws IOException {
        final Socket socket = new Socket(HOST, PORT);

        final BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        final PrintWriter socketOut = new PrintWriter(socket.getOutputStream(), true);

        receiveData(socketIn);
        boolean keepRunning = true;
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (keepRunning) {
            final String line = in.readLine();
            socketOut.println(line);
            final String response = receiveData(socketIn);
            if (response == null) {
                keepRunning = false;
            }
        }
    }

}
