package org.j2gl.sockets.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.ServerSocket;

public final class Server {

    private static final Logger logger = LoggerFactory.getLogger(Server.class);
    private static final int PORT = 7081;

    public static void main(final String[] args) throws Exception {

        try (ServerSocket listener = new ServerSocket(PORT)) {
            logger.info("Starting socket server at port: " + PORT);
            int client = 0;
            //noinspection InfiniteLoopStatement
            while (true) {
                new ServerSocketExample(listener.accept(), ++client).start();
            }
        } catch (final Exception ex) {
            logger.error("Error with server: ", ex);
        }
    }
}
