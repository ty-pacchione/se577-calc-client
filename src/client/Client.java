package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import model.observer.Observer;

public class Client implements Observer {
    private Socket clientSocket;
    private PrintWriter out;

    public Client(String host, int port) {
        connect(host, port);
    }

    private void connect(String host, int port) {
        try {
            clientSocket = new Socket(host, port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            System.out.println("Connected to server");
        } catch (IOException ioe) {
            System.out.println("Unable to connect to server");
        }
    }

    private void sendMessage(String message) {
        out.println(message);
    }

    @Override
    public void update(String message) {
        sendMessage(message);
    }
}