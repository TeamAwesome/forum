package com.forum.jetty;

import org.mortbay.jetty.Connector;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.bio.SocketConnector;
import org.mortbay.jetty.security.SslSocketConnector;
import org.mortbay.jetty.webapp.WebAppContext;

public class WebServer {

    private final Server jetty;


    public WebServer(int port, int sslPort) {

        jetty = new Server();

        SocketConnector socketConnector = new SocketConnector();
        socketConnector.setPort(port);

        SslSocketConnector sslSocketConnector = new SslSocketConnector();
        String keystorePath = this.getClass().getClassLoader().getResource("keystore").getPath();
        sslSocketConnector.setPassword("password");
        sslSocketConnector.setPort(sslPort);
        sslSocketConnector.setKeystore(keystorePath);
        sslSocketConnector.setKeyPassword("password");
        sslSocketConnector.setTruststore(keystorePath);
        sslSocketConnector.setTrustPassword("password");

        jetty.setConnectors(new Connector[]{socketConnector, sslSocketConnector});

        jetty.addHandler(new WebAppContext("src/main/webapp", "/forum"));

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
        final WebServer server = new WebServer(8080, 8443);
        server.start();
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                server.stop();
            }
        }));
    }
}
