package com.forum.web.page;

import com.forum.jetty.WebServer;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;

import java.net.ServerSocket;

public class Application {

    private static Application instance;

    private WebServer server;
    private Browser browser;

    public static Browser open(String url) {
        return browser().open(url);
    }

    public static Browser browser() {
        Browser browser = instance().browser;
        Validate.notNull(browser, "Application has not started succesfully. Please check earlier failed tests.");
        return browser;
    }

    private static Application instance() {
        if (instance != null) {
            return instance;
        }
        try {
            int port = findFreePort();
            instance = new Application();
            registerShutdownHook();
            instance.start(port);
            return instance;

        } catch (Exception e) {
            throw new RuntimeException("Application startup failed", e);
        }
    }

    private static int findFreePort() throws Exception {
        ServerSocket socket = new ServerSocket(0);
        int port = socket.getLocalPort();
        socket.close();
        return port;
    }

    private static void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(new ShutdownHook()));
    }

    private void start(int port) throws Exception {
        boolean testWithFirefox = Boolean.getBoolean("test.with.firefox");
        String hostAddress = System.getProperty("test.with.host.address");

        setSystemProperty("controlm.queue.provider", "none");
        setSystemProperty("icc.service.provider", "local");

        if (StringUtils.isBlank(hostAddress)) {
            server = new WebServer(port).start();
            hostAddress = "http://localhost:" + port;
            browser = new Browser(hostAddress, testWithFirefox);
        } else {
            browser = new Browser(hostAddress, testWithFirefox);
        }
    }

    private void setSystemProperty(String key, String value) {
        if (System.getProperty(key) == null) {
            System.setProperty(key, value);
        }
    }

    private void stop() {
        if (browser != null) {
            browser.stop();
        }
        if (server != null) {
            server.stop();
        }
    }

    private static class ShutdownHook implements Runnable {
        public void run() {
            instance.stop();
        }
    }
}
