package org.j2gl.sockets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.ServerSocket;

public class Server {

    private static final Logger logger = LoggerFactory.getLogger(Server.class);
    private static final int PORT = 7081;

    public static void main(String[] args) throws Exception {

        int client = 0;
        ServerSocket listener = null;
        try {
            listener = new ServerSocket(PORT);
            logger.info("Starting socket server at port: " + PORT);
            while (true) {
                new ServerSocketExample(listener.accept(), ++client).start();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            listener.close();
        }
    }
}
