package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import obsrv.Observer;

public class CalculatorClient implements Observer {
    public static final String HOST = "localhost";
    public static final int PORT = 3000;

    private Socket clientSocket;
    private PrintWriter outputWriter;
    private boolean connected;

    public CalculatorClient() {
        connectToServer();
    }

    private void connectToServer() {
        try {
            clientSocket = new Socket(HOST, PORT);
            outputWriter = new PrintWriter(clientSocket.getOutputStream(), true);
            connected = true;
            System.out.println("Connected to server");
        } catch (IOException ioe) {
            System.out.println("Unable to connect to server");
        }
    }

    private void sendMessage(String message) {
        outputWriter.println(message);
    }

    @Override
    public void update(String message) {
        if (connected) {
            sendMessage(message);
        }
    }
}