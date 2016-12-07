package org.j2gl.sockets.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ServerSocketExample extends Thread {

    private static final Logger log = LoggerFactory.getLogger(ServerSocketExample.class);

    private final Socket socket;
    private final int connectionNumber;

    ServerSocketExample(final Socket socket, final int connectionNumber) {
        this.socket = socket;
        this.connectionNumber = connectionNumber;
        log.info("New connection # " + connectionNumber + " at " + socket);
    }

    public void run() {
        try (final BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             final PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            out.println("Send \"quit\" to shutdown.");
            while (true) {
                final String line = in.readLine();
                if (line == null || line.equalsIgnoreCase("quit")) {
                    out.println("Bye");
                    break;
                }
                log.info("Client # {} sent: {}", connectionNumber, line);
                out.println("You just send me: " + line);
            }

        } catch (final IOException e) {
            log.error("Error on connection # {} ", connectionNumber, e);
        } finally {
            try {
                socket.close();
            } catch (final IOException e) {
                log.debug("Error closing connection # {}", connectionNumber, e);
            }
            log.info("Connection # {} was closed", connectionNumber);
        }
    }

}
