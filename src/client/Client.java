package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public Client(String host, int port) {
        connect(host, port);
        String request = "3+3";
        sendRequest(request);
        String response = getResponse();
        System.out.println("Response: " + response);
        close();
    }

    private void connect(String host, int port) {
        try {
            clientSocket = new Socket(host, port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("Connected to server");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private void sendRequest(String request) {
        out.println(request);
    }

    private String getResponse() {
        try {
            String response = in.readLine();

            while (response == null) {
                response = in.readLine();
            }

            return response;
        } catch (IOException ioe) {
            return "error";
        }
    }

    private void close() {
        try {
            clientSocket.close();
            out.close();
            in.close();
        } catch (IOException ioe) {
            System.out.println("Unable to close connection");
        }
    }
}