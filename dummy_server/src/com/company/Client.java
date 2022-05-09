package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.ServerSocket;
import java.net.Socket;

public class Client extends Thread {
    public static void main(String[] args) throws IOException {
        new Client(8000).start();
    }

    Client(int port) throws IOException {
        this.socket = new Socket("localhost", port);
    }

    private final Socket socket;

    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    public void run() {
        while (true) {
            final var packet = new DatagramPacket(new byte[1024], 1024);

            if (inputStream == null) {
                try {
                    inputStream = new DataInputStream(socket.getInputStream());
                    outputStream = new DataOutputStream(socket.getOutputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
            } else {
                try {
                    outputStream.writeChars("Hello by Arish!\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}