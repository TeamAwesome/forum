package com.forum.jetty;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.webapp.WebAppContext;

public class WebServer {

    private final Server jetty;

    public WebServer(int port) {
        jetty = new Server(port);
        jetty.addHandler(new WebAppContext("src/main/webapp", "/app"));
    }

    public WebServer start() throws Exception {
        jetty.start();
        return this;
    }

    public void stop() {
        try {
            jetty.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        final WebServer server = new WebServer(8080);
        server.start();
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                server.stop();
            }
        }));
    }
}
