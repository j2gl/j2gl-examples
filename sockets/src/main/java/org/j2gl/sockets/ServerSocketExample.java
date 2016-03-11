package org.j2gl.sockets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerSocketExample extends Thread {

    private static final Logger log = LoggerFactory.getLogger(ServerSocketExample.class);

    private Socket socket;
    private int connectionNumber;

    public ServerSocketExample(Socket socket, int connectionNumber) {
        this.socket = socket;
        this.connectionNumber = connectionNumber;
        log.info("New connection # " + connectionNumber + " at " + socket);
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Send \"quit\" to shutdown.");

            while (true) {
                String line = in.readLine();
                if (line == null || line.equalsIgnoreCase("quit")) {
                    break;
                }
                log.info("Client # {} sent: {}", connectionNumber, line);
                out.println("{ Status: \"OK\" }");
            }
        } catch (IOException e) {
            log.error("Error on connection # {} ", connectionNumber, e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                log.debug("Error closing connection # {}", connectionNumber, e);
            }
            log.info("Connection # {} was closed", connectionNumber);
        }
    }

}
